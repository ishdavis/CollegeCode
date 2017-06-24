// CS 401 Fall 2013
// Test file for Scramble class.  This program should run as is with your Scramble
// class.  The scrambled versions of the words do not have to exactly match the ones
// shown in the test execution.

import java.io.*;
import java.util.*;
public class resultsTest
{
    public static void main(String[] args) throws IOException
    {
		Scanner keyboard = new Scanner(System.in);
		String first = keyboard.nextLine();
		String last = keyboard.nextLine();
    	Results theResults = new Results("Results.txt");
		Batter theBatter = new Batter(first, last);
		theBatter.setBats(5);
		theBatter.setHits(3);
		theBatter.setSingles(9);
		theBatter.setDoubles(2);
		theBatter.setTriples(4);
		theBatter.setHR(25);
		String right = theBatter.toString();
		System.out.println(right);

	}
	
}