//Class for Player
import java.io.*;
import java.util.*;


public class Player
{
	//Instance Variables
	private String name;
	private int numRight = 0, numWrong = 0, totalRight = 0, totalWrong = 0;
	private boolean gamePlayed;
	private Scanner theFile;
	private StringBuilder printFile;
	private FileWriter fwriter;
	private PrintWriter outputFile;
	private boolean found;
	private double percent, totalPercent;
	private Scanner newFile;

	//Constructor
	public Player(String s) throws IOException
	{
	File textFile = new File("players.txt");
			
	theFile = new Scanner(textFile);
	
	name = s;
	}
	
	public void toFile() throws IOException//Print the name and number of wins and losses to a file, use Stringbuilder
	{
	
	printFile = new StringBuilder();
	
	fwriter = new FileWriter("players.txt", true);
	
	outputFile = new PrintWriter(fwriter);
	

	printFile.append(name + "\n");
	printFile.append(numRight + "\n");
	printFile.append(numWrong + "\n");
	
	outputFile.print(printFile.toString());
	
	outputFile.close();
	
	}
	
	//Check if the user has played before
	public boolean findName() throws IOException
	{
	found = false;
	do
	{
	String game = theFile.nextLine();
	
	if(game.equalsIgnoreCase(name))
	{
	found = true;
	return found;
	}
	else
	{
	found = false;
	}
	}while((theFile.hasNext()) && (found == false));
	theFile.close();
	return found;
	//Make a loop that parses through until the name is found
	}
	
	//Prints the results
	public String nameResults() throws IOException
	{
	StringBuilder output = new StringBuilder();
	found = false;

	do
	{
	String game = theFile.nextLine();
	if(game.equalsIgnoreCase(name))
	{
	found = true;
	int right = theFile.nextInt();
	int wrong = theFile.nextInt();
	percent =((double)right / (right + wrong)) * 100;

	output.append("Name: " + game + "\n");
	output.append("Number Correct: " + right + "\n");
	output.append("Number Incorrect: " + wrong + "\n");
	output.append("Percentage Correct: " + percent);
	}
	
	}while((theFile.hasNext()) && (found == false));
	String k = output.toString();
	return k;
	}
	
	public void right()
	{
	numRight++;
	}
	
	public void wrong()
	{
	numWrong++;
	}
	
	public String toString()
	{
	percent =((double)numRight / (numRight + numWrong)) * 100;
	StringBuilder j = new StringBuilder();
	j.append("Here are your results:\n Name: " + name);
	j.append("\nNumber Right: " + numRight);
	j.append("\nNumber Wrong: " + numWrong);
	j.append("\nPct: " + percent);
	String k = j.toString();
	return k;
	
	}
	
	public String totalOutput() throws IOException//Reads through the text file and gets data
	{
	File textFile = new File("players.txt");
			
	newFile = new Scanner(textFile);
	int total1 = 0, total2 = 0, users = 0;
	String j;
	do
	{
	j = newFile.nextLine();
	int i = newFile.nextInt();
	int k = newFile.nextInt();
	total1+= i;
	total2+= k;
	String u = newFile.nextLine();
	users++;
	}while(newFile.hasNext());
	
	double NewPercent =((double)total1 / total2) * 100;

	StringBuilder finalResults = new StringBuilder();
	finalResults.append("Overall, " + users + " people have taken the quiz\n");
	finalResults.append("Overall stats:\n\tRight:" + total1);
	finalResults.append("\n\tWrong: " + total2);
	finalResults.append("\n\tPct: " + NewPercent);
	String no = finalResults.toString();
	return no;
	}
	
}
	
	
