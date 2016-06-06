package me.mattgd.saywhat;

import java.util.*;

public class Phrase implements Comparable<Phrase> {

	private final String phrase;
	private ArrayList<Word> words = new ArrayList<Word>();

	public Phrase(final String phrase) {
		this.phrase = phrase;

		String[] cut = phrase.split(" ");
		for (int i = 0; i < cut.length; i++) {
			words.add(new Word(cut[i]));
		}
	}

	public String getCorrectPhrase() {
		return phrase;
	}

	public ArrayList<Word> randomize() {
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

		return r.trim();
	}

	public int compareTo(Phrase phrase) {
		return toString().compareTo(phrase.toString()); // will return 0 when
														// the phrases are
														// exactly equal
	}

	// Passes ArrayList to the game
	public ArrayList<Word> getPhrase() {
		return words;
	}

	public int getNumWords() {
		return words.size();
	}

	public boolean equalsIgnoreCase(Phrase phrase) {
		return getCorrectPhrase().equalsIgnoreCase(phrase.getCorrectPhrase());
	}

}