package me.mattgd.saywhat;

/**
 * @author Steve Greene and mattgd
 */

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class GameRunner {

	private static int difficulty = 0;

	public static void setDifficulty(int value) {
		difficulty = value;
	}

	public static int getDifficulty() {
		return difficulty;
	}

	public static void main(String[] args) {
		String inputFile = "phrases.txt";
		ArrayList<Phrase> easy = new ArrayList<Phrase>();
		ArrayList<Phrase> medium = new ArrayList<Phrase>();
		ArrayList<Phrase> hard = new ArrayList<Phrase>();

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
			System.out.println("Error located " + e.getMessage());
		}

		new Frame(); // This brings up the window
	}

}
