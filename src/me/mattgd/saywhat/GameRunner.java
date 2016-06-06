package me.mattgd.saywhat;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameRunner {

	public static void main(String[] args) {
		running = true;

		String inputFile = "phrases.txt";
		ArrayList<Phrase> easy = new ArrayList<Phrase>();
		ArrayList<Phrase> medium = new ArrayList<Phrase>();
		ArrayList<Phrase> hard = new ArrayList<Phrase>();

		new DifficultyOptionPane(); // This brings up the GUI

		try {
			Scanner reader = new Scanner(new File(inputFile));
			while (reader.hasNext()) {
				Phrase phrase = new Phrase(reader.nextLine());
				if (phrase.getNumWords() == 5) {
					easy.add(phrase);
				} else if (phrase.getNumWords() == 7) {
					medium.add(phrase);
				} else if (phrase.getNumWords() == 10) {
					hard.add(phrase);
				}
			}
			reader.close();
		} catch (Exception e) {
			System.out.println("Error located: " + e.getMessage());
		}
		
		Scanner sc = new Scanner(System.in);
		ArrayList<Phrase> phrases = new ArrayList<Phrase>();
		
		System.out.println("Press Enter to submit input.");
		
		acceptingInput = true;

		switch (difficulty) {
		case 0:
			System.out.println("Easy difficulty selected.");
			phrases = easy;
			break;
		case 1:
			System.out.println("Medium difficulty selected.");
			phrases = medium;
			break;
		case 2:
			System.out.println("Hard difficulty selected.");
			phrases = hard;
			break;
		default:
			System.out.println("Did not select difficulty. Easy difficulty automatically selected.");
		}

		String input = "";
		
		for (Phrase p : phrases) {
			System.out.println();
			
			List<Word> mixed = p.randomize();
			for (int x = 0; x < mixed.size(); x++) {
				System.out.print(mixed.get(x) + " ");
			}

			System.out.println("\nEnter the phrase in the correct order:");
			
			input = sc.nextLine().trim();
			
			Phrase phrase = new Phrase(input);
			
			System.out.println("You entered: \"" + input + "\"");

			if (p.equalsIgnoreCase(phrase)) {
				System.out.println("\nCorrect! Nice work.");
			} else {
				System.out.println("\nYour answer is incorrect.");
			}
		}
		
		sc.close();
	}

	public static void parseInput(final String input) {
		if (input.equalsIgnoreCase("quit") || input.equalsIgnoreCase("q")) {
			GameRunner.setRunning(false);
			return;
		} else if (input.equalsIgnoreCase("help")) {
			
		} else {
			if (GameRunner.isAcceptingInput()) {
				System.out.println(input);
			} else {
				System.out.println("There is no phrase to check with.");
			}
		}
	}

	private static int difficulty = 0;
	private static boolean running = false, acceptingInput = false;

	public static void setDifficulty(int value) {
		difficulty = value;
	}

	public static int getDifficulty() {
		return difficulty;
	}

	public static void setRunning(boolean value) {
		running = value;
	}

	public static boolean isRunning() {
		return running;
	}

	public static boolean isAcceptingInput() {
		return acceptingInput;
	}

}
