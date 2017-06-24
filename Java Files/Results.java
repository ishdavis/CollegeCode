/*Ish Davis
CS 0401
Results Class*/
import java.io.*;
import java.util.Scanner;

public class Results
{

	//Instance Variables
	private FileWriter fwriter;
	private PrintWriter outputFile;
	private int wins = 0, losses = 0, rounds;
	private String output;
	
	public Results(String j) throws IOException
	{
	fwriter = new FileWriter(j, true);
			
	outputFile = new PrintWriter(fwriter);
	}
	
	public void won()
	{
	wins++;
	}
	
	public void lost()
	{
	losses++;
	}
	
	public void save()
	{
	rounds = wins + losses;
	
	outputFile.println(rounds);
			
	outputFile.println(wins);
			
	outputFile.println(losses);
			
	outputFile.close();
		
	}	
	
	public String toString()
	{
	output = "Here are the results:\n\tRounds tried: " + rounds + "\n\tRounds won: " + wins + "\n\tRounds lost: " + losses;
	
	return output;
	}
	
}
	