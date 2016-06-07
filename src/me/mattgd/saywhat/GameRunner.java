package me.mattgd.saywhat;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GameRunner {

	public static void main(String[] args) {
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

		long seed = System.nanoTime();
		Collections.shuffle(phrases, new Random(seed));
		String input = "";
		int count = 0;
		
		for (Phrase p : phrases) {
			System.out.println();
			
			List<Word> mixed = p.randomize();
			for (int x = 0; x < mixed.size(); x++) {
				System.out.print(mixed.get(x) + " ");
			}

			System.out.println("\nEnter the phrase in the correct order:");
			
			input = sc.nextLine().trim();
			
			if (input.equalsIgnoreCase("quit") || input.equalsIgnoreCase("q")) {
				System.exit(0);
			} else if (input.equalsIgnoreCase("help") || input.equalsIgnoreCase("?")) {
				help();
			} else {
				Phrase phrase = new Phrase(input);
				
				System.out.println("You entered: \"" + input + "\"");

				if (p.equalsIgnoreCase(phrase)) {
					System.out.println("\nCorrect! Nice work.");
					count++;
				} else {
					System.out.println("\nYour answer is incorrect. The correct answer is: \n" + p.getCorrectPhrase());
				}
				
				System.out.println(count + "/" + phrases.size() + " correct so far.");
			}
		}
		
		System.out.println("Thanks for playing!");
		sc.close();
	}

	private static int difficulty = 0;

	public static void setDifficulty(int value) {
		difficulty = value;
	}

	public static int getDifficulty() {
		return difficulty;
	}
	
	private static void help() {
		System.out.println("\nWelcome to Say What!\nScrambled phrases will be displayed and your job is to unscramble them.\n"
				+ "Type your answer in the box and press Enter to check it.");
	}

}
