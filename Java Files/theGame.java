import java.util.*;
import java.io.*;
import java.util.Random;

public class theGame
{

	public static void main(String[] args) throws IOException
	{
	
	Scanner keyboard = new Scanner(System.in);
	
	int userInput;

	do
	{
	System.out.println("The game begins\n");
	
	String precursor = getPrecursor();
	String action = getAction();
	String additions = getAddition();
	
	System.out.println(precursor);
	System.out.println(action);
	System.out.println(additions);
	
	System.out.println("To try again press 1");
	userInput = keyboard.nextInt();
	}while(userInput == 1);
	}
	
	public static String getPrecursor() throws IOException
	{
		
	Random randomGenerator = new Random();

	String [] precursors = new String[10];
	
	File myFile = new File("Precursers.txt");
			
	Scanner inputFile = new Scanner(myFile);
	
	int i;
	
	for(i = 0; i < precursors.length; i++)
	{
	
	precursors[i] = inputFile.nextLine();
	
	}
	
	int x = randomGenerator.nextInt(i);
	
	return precursors[x];
	
	}
	
	public static String getAction() throws IOException
	{
		
	Random randomGenerator = new Random();
	
	String [] Actions = new String[10];
	
	File myFile = new File("Action.txt");
			
	Scanner inputFile = new Scanner(myFile);
	
	int i;
	
	for(i = 0; i < Actions.length; i++)
	{
	
	Actions[i] = inputFile.nextLine();
	
	}
	
	int x = randomGenerator.nextInt(i);

	return Actions[x];
	
	}
	
	public static String getAddition() throws IOException
	{
		
	Random randomGenerator = new Random();

	String [] additions = new String[10];
		
	File myFile = new File("Additions.txt");
			
	Scanner inputFile = new Scanner(myFile);
	
	int i;
	
	for(i = 0; i < additions.length; i++)
	{
	
	additions[i] = inputFile.nextLine();
	
	}
	
	int x = randomGenerator.nextInt(i);

	return additions[x];
	
	}
	
	
}