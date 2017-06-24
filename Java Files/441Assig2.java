/*Ishvaraus Davis
CS 0401
Assignment Two*/
//Extra Credit: Case doesn't matter in answers to game

import java.io.*;
import java.util.*;


public class Assig2
{

	public static void main(String [] args) throws IOException
	{
	
	boolean findName, gameOn = true;
	
	String results;
	
	Scanner inScan = new Scanner(System.in);
		
	System.out.println("Welcome to the Show!!\nPlease enter your name:");
	String playerName = inScan.nextLine();
	
	//construct objects
	Player user = new Player(playerName);
	
	Quiz question = new Quiz("questions.txt");
	
	boolean hasQuestion = question.hasAQuestion();
	
	Question quest;
		
	findName = user.findName();
	
	
	if(findName == true)
	{
	System.out.println("You already took the quiz\n Here are your results:\n");
	//Print out individual and group results
	Player userResults = new Player(playerName);
	
	String oldResults = userResults.nameResults();
	
	System.out.println(oldResults);
	
	String r = userResults.totalOutput();
	
	System.out.println(r);
	}
	
	if(findName == false)
	{
	System.out.println("Ready to take the quiz?\nPlease answer each question exactly");
	System.out.println("You will have two guesses for each question\n(If the answer is a number, please enter the digits, not words");
	
	//Ask the user Questions
	for(int i = 0; i < 5; i++){
	quest = question.getQuestion();

	String Q = quest.getQ();
	String A = quest.getA();
	System.out.println(Q);
	int guesses = 0; 

	do
	{

	String playerAnswer = inScan.nextLine();
	
	if(A.equalsIgnoreCase(playerAnswer))
	{
	System.out.println("Well done!");
	user.right();
	gameOn = false;
	}
	
	if((!A.equalsIgnoreCase(playerAnswer)) && (gameOn = true))//Fix this
	{
	System.out.println("Sorry, that is not right.\nPlease try again");
	guesses++;
	gameOn = true;
	}
	
	if(guesses == 2)
	{
	System.out.println("Sorry you missed this one");
	gameOn = false;
	user.wrong();
	}
	
	}while(gameOn == true);
	
	}
	
	//Print out individual and group results for a player that just played
	results = user.toString();
	
	System.out.println(results);
	
	user.toFile();

	String k = user.totalOutput();
	System.out.println(k);
	}
	}
}	
	
	