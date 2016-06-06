package me.mattgd.saywhat;

/**
 * @(#)Phrase.java
 *
 * @author Steve G and Matty D
 * @version 1.00 2016/5/19
 */

import java.util.*;

class Phrase implements Comparable<Phrase> {
	ArrayList<Word> words = new ArrayList<Word>();

	public Phrase(String phrase) {
		String[] cut = phrase.split(" ");
		for (int i = 0; i < cut.length; i++) {
			words.add(new Word(cut[i]));
		}
	}

	public ArrayList<Word> randomize() 
	{
		ArrayList<Word> newOrder = words;
		long seed = System.nanoTime();
		Collections.shuffle(newOrder, new Random(seed));
		return newOrder;
	}

	public String toString() {
		String r = "";
		for (int i = 0; i < words.size(); i++) {
			r += words.get(i).toString();
			r += " ";
		}

		return r;
	}

	public int compareTo(Phrase phrase) {
		return toString().compareTo(phrase.toString()); // will return 0 when
														// the phrases are
														// exactly equal
	}

	public ArrayList<Word> getPhrase() // passes arrayList to the game
	{
		return words;
	}

	public int getNumWords() {
		return words.size();
	}
}