package me.mattgd.saywhat;

/**
 * @author Steve Greene and mattgd
 */

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class GameRunner {
	
	public static void main(String[] args) {
		String inputFile = "phrases.txt";
		ArrayList<Phrase> phrases = new ArrayList<Phrase>();

		try {
			Scanner reader = new Scanner(new File(inputFile));
			while (reader.hasNext()) {
				phrases.add(new Phrase(reader.nextLine()));
			}

			reader.close();
		} catch (Exception e) {
			System.out.println("Error located " + e.getMessage());
		}

		//TODO Temporary to test phrases
		for (int i = 0; i < phrases.size(); i++) {
			System.out.println(phrases.get(i).toString());
		}
		
		System.out.println(phrases.get(0).compareTo(phrases.get(0))); //TODO Temporary - test the compareTo method
		
		new Frame(); // This brings up the window
	}
	
}
