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
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Would you like a gui? y/n");
		if(scan.nextLine() == "y")
		{
			new Frame(); // This brings up the window
		}
		else
		{
			ArrayList<Phrase> phrases = new ArrayList<Phrase>();
			System.out.println("Enter difficulty: e/m/h");
			String check = scan.nextLine().trim();
			if(check.equals("e"))
			{
				phrases = easy;
			}
			else if(check.equals("m"))
			{
				phrases = medium;
			}
			else
			{
				phrases = hard;
			}
		
			for(int i = 0; i < phrases.size(); i ++)
			{	
				ArrayList<Word> mixed = phrases.get(i).randomize();
				for(int x = 0; x  < mixed.size(); x++)
				{
					System.out.print(mixed.get(x) + " ");
				}
				System.out.println("\nEnter the phrase in the correct order\n");
				Phrase phrase = new Phrase(scan.nextLine().trim());
				if(phrases.get(i).compareTo(phrase) == 0)
				{
					System.out.println("\nnice work!");
				}
				else
				{
					System.out.println("\nwrong");
				}
			}
		}

	}

}
