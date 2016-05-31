package me.mattgd.saywhat;

/**
 * @(#)Word.java
 * @author Steve Greene and Matty D
 * @version 1.00 2016/5/19
 */

public class Word {
	private String word;

	public Word(String word) {
		this.word = word;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String toString() {
		return word.toLowerCase();
	}

}