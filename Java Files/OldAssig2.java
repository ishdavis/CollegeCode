/*Ishvaraus Davis
CS 0401
Assignment Two*/
import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.Random;
import java.io.*;

public class OldAssig2
{

	public static void main(String[] args) throws IOException
	{
	
	//Results Object
	
	Results theResults = new Results("Results.txt");
	
	//Scramble Object
	Scramble theScramble = new Scramble("words.txt"); 
	
	Scanner keyboard = new Scanner(System.in);

	//Intro
	String playerName;
	String continueGame;
	String userGuess;
	String word;
	String words;
	String Results;
		
	System.out.println("Welcome to The Scrambler!\nPlease enter your name:");
	
	playerName = keyboard.nextLine();
	
	boolean gameOn; //Game Control
	
	do
	{
		word = theScramble.getRealWord(); //Real Word

		words = theScramble.getScrambledWord(); //Scrambled Word
		
		int guessesLeft = 3;

		do
		{

		System.out.println("\n" + playerName + ", you have " + guessesLeft + " guesses to get the Scramble");
		
		guessesLeft--;
		
		System.out.println("Good Luck"); 
		
		System.out.println("Scramble: " + words); 
		
		System.out.println("Your guess:");
		
		userGuess= keyboard.nextLine();
		
		if(userGuess.equalsIgnoreCase(word)) //Check to see if they're equal
		{
		gameOn = true;
		System.out.println("Great job " + playerName + "! You got it!");
		theResults.won(); //Results
		theResults.save(); //Results
		}
		
		else
		{
		gameOn = false;
		System.out.println("Sorry, " + playerName + " that is not correct");
		}
		
		if(guessesLeft == 0)
		{
		System.out.println("Round over! Better luck next time " + playerName);
		System.out.println("The actual word is: " + word);
		theResults.lost();
		theResults.save();
		}
		
		
		
		}while((guessesLeft > 0) && (gameOn == false)); //Keep the loop in control
	
	System.out.println("Would you like to play another round (Y/N)?");
		
	continueGame = keyboard.nextLine();
	
	}while(continueGame.equalsIgnoreCase("y"));
	
	System.out.println("Thanks for playing " + playerName);
	
	Results = theResults.toString(); //Print the Results
	
	System.out.println(Results);
	
	
	
	
	
	}
}