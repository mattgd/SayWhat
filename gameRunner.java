/**
 * @(#)gameRunner.java
 *
 *
 * @author Steve Greene and Matty D
 * @version 1.00 2016/5/23
 */
import java.util.*;
import java.io.*;

public class gameRunner 
{
    public static void main(String[] args) 
    {
    	
    	String inputFile = "Phrases.txt";
    	ArrayList<Phrase> phrases = new ArrayList<Phrase>();
    	
    	try
		{
			Scanner reader = new Scanner(new File(inputFile));
			while(reader.hasNext())
			{
				phrases.add(new Phrase(reader.nextLine()));
			}
		}
		catch(Exception e)
		{
			System.out.println("Error located " + e.getMessage());
		}
    	
    	for(int i = 0; i < phrases.size(); i++)
    	{
    		System.out.println(phrases.get(i).toString());
    	}
    }
}
