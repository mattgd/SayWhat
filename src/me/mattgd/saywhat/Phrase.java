package me.mattgd.saywhat;

/**
 * @(#)Phrase.java
 *
 * @author Steve G and Matty D
 * @version 1.00 2016/5/19
 */

import java.util.*;

class Phrase implements Comparable<Phrase>
{
	ArrayList<Word> words = new ArrayList<Word>();
		
    public Phrase(String phrase) 
    {
    	String[] cut = phrase.split(" ");
    	for(int i = 0 ; i < cut.length; i++)
    	{
    		words.add(new Word(cut[i]));
    	}
    }
    
    public ArrayList<Word> randomize()
    {
    	ArrayList<Word> newOrder = words;
    	for(int i = 0; i < newOrder.size(); i++)
    	{
    		newOrder.set(i, newOrder.get((int)(Math.random() * newOrder.size())));
    	}

		int count = 0;
    	
    	for(int i = 0; i < newOrder.size(); i++)
    	{
    		if(newOrder.get(i).getWord().equals((words.get(i).getWord())));
    		{
    			count++;
    		}
    	}
    	
    	if(count == newOrder.size())
    	{
    		return randomize();
    	}
    	
    	return newOrder;
    }
    
    public String toString()
    {
    	String r = "";
    	for(int i = 0; i < words.size(); i++)
    	{
    		r += words.get(i).toString();
    		r += " ";
    	}
    	
    	return r;	
    }    
    	
    public int compareTo(Phrase phrase)
    {
    	return toString().compareTo(phrase.toString());
    }
}