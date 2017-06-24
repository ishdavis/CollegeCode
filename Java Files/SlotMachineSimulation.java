/*Ishvaraus Davis
CS 0007
Assignment Two*/
import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.Random;
import java.io.*;
public class SlotMachineSimulation
{
	//Get the Customer Name
	static String CustomerName;
	
	public static void main (String[] args) throws IOException
	{
	Scanner keyboard = new Scanner(System.in);
	DecimalFormat formatter = new DecimalFormat("####.00");
	
	//The Menu
	displayMenu();
	
	int actionChoice, betAmount;
	double currentAmount = 100;
	// Slot Machine
	do
	{
	System.out.println("Please select an action:");
	actionChoice = keyboard.nextInt();
	
	if(actionChoice == 1){
		//Customer Name
		System.out.println("Please enter your name: ");
		String CustomerName = customerName();
		
		System.out.println("Game start! You will begin with $100.00. Enter a negative" +
		" value to quit the game. Good luck, " + CustomerName);
		
		do
		{
		//Slot Variables
		String machineNumber1;
		
		String machineNumber2;
		
		String machineNumber3;
		
		machineNumber1 = Item1();
		
		machineNumber2 = Item2();
		
		machineNumber3 = Item3();
		
		//Getting the bet amount
		System.out.println("How much would you like to bet?");
		
		betAmount = keyboard.nextInt();
		
		//Checks input
		if(betAmount > currentAmount){
			System.out.println("Please enter a bet amount that is lower than the amount you have");
			betAmount = keyboard.nextInt();
			}
		
		//Prize Amounts
		double prizeAmount = betAmount * 2;
		double perfectAmount = betAmount * 3;
		
		if(betAmount > 0){
		lines();
		
		System.out.println(machineNumber1 + "\t" + machineNumber2 + "\t" + machineNumber3);
		
		lines();
			//Matches
			if(machineNumber1 == machineNumber2){
			System.out.println("Number of matches: 1. You win $" + formatter.format(prizeAmount) );
			currentAmount += prizeAmount;
			}
			
			if(machineNumber1 == machineNumber3){
			System.out.println("Number of matches: 1. You win $" + formatter.format(prizeAmount) );
			currentAmount += prizeAmount;
			}
			
			if(machineNumber2 == machineNumber3){
			System.out.println("Number of matches: 1. You win $" + formatter.format(prizeAmount));
			currentAmount += prizeAmount;
			}
			
			if(machineNumber1 != machineNumber2){
				
				if(machineNumber1 != machineNumber3){
					
					if(machineNumber3 != machineNumber2){
						currentAmount -= betAmount;
			}
			}
			}
			}
		
		//Checking input
		if(betAmount < 0){
			System.out.println("Game over! Your score has been written to scores.txt, " + CustomerName);
			}
		
		System.out.println(" You have $" + currentAmount + " left\n");
		}while ((currentAmount > 0) & (betAmount > 0));
		}
		
		//Printing the text to the file
		if(actionChoice == 2){
			
			FileWriter fwriter = new FileWriter("scores.txt", true);
			
			PrintWriter outputFile = new PrintWriter(fwriter);
						
			outputFile.println("Name\t\tScores");
			
			outputFile.println("");
			
			outputFile.println(CustomerName + "\t\t" + currentAmount);
			
			outputFile.close();
			
			File myFile = new File("scores.txt");
			
			Scanner inputFile = new Scanner(myFile);
			
			//reading the text from the file
			if(myFile.exists() & (currentAmount > 100 || currentAmount < 100) )
			{
				
				while (inputFile.hasNext())
				{
				
					String CustomerName = inputFile.nextLine();
					System.out.println(CustomerName);
					
				}
				inputFile.close();
			}
			
			//If the file doesn't exist
			if(myFile.exists() & currentAmount == 100)
			{
				System.out.println("No scores to display at this time");
			}
			
			}
			// End of the Program
			if(actionChoice == 3){
				System.out.print("Goodbye");
				System.exit(0);
			}
			//Checking the User's input
			if(actionChoice > 3){
				System.out.println("Invalid option, please pick a number between 1-3");
			}
			//Checking the User's input
			if(actionChoice < 0){
				System.out.println("Invalid option, please pick a number between 1-3");
			}
	}while(actionChoice < 100);
	}
	
	//Menu
	public static void displayMenu()
	{
	
	System.out.print("Welcome to the Slot Machine Simulator!");
	System.out.println("\n\nActions:\n1. Start a new game\n2. View scores\n3. Exit");

	}
	
	//Get the customer name
	public static String customerName()
	{
	
	Scanner keyboard = new Scanner(System.in);
	CustomerName = keyboard.nextLine();
	return CustomerName;
	}

	//Item 1
	public static String Item1()
	{
	
	Random randomGenerator = new Random();
	int firstItem;
	String Value1 = null;
	if(firstItem == 0){
		 Value1 = "Cherries";
	}
	if(firstItem == 1){
		 Value1 = "Oranges";
	}
	if(firstItem == 2){
		 Value1 = "Plums";
	}
	if(firstItem == 3){
		 Value1 = "Bells";
	}
	if(firstItem == 4){
		 Value1 = "Melons";
	}
	if(firstItem == 5){
		 Value1 = "Bars";
	}
	return Value1;
	}
	
	//Item 2
	public static String Item2()
	{
	
	Random randomGenerator = new Random();
	int firstItem;
	String Value2 = null;
	firstItem = randomGenerator.nextInt(6);
	if(firstItem == 0){
		 Value2 = "Cherries";
	}
	if(firstItem == 1){
		 Value2 = "Oranges";
	}
	if(firstItem == 2){
		 Value2 = "Plums";
	}
	if(firstItem == 3){
		 Value2 = "Bells";
	}
	if(firstItem == 4){
		 Value2 = "Melons";
	}
	if(firstItem == 5){
		 Value2 = "Bars";
	}
	return Value2;
	}
	
	//item 3
	public static String Item3()
	{
	
	Random randomGenerator = new Random();
	int firstItem;
	String Value3 = null;
	firstItem = randomGenerator.nextInt(6);
	if(firstItem == 0){
		 Value3 = "Cherries";
	}
	if(firstItem == 1){
		 Value3 = "Oranges";
	}
	if(firstItem == 2){
		 Value3 = "Plums";
	}
	if(firstItem == 3){
		 Value3 = "Bells";
	}
	if(firstItem == 4){
		 Value3 = "Melons";
	}
	if(firstItem == 5){
		 Value3 = "Bars";
	}
	return Value3;
	}
	
	//lines for output
	public static void lines()
	{
	
	String lines = "-----------------------------";
	System.out.println(lines);
	
	}
	
	
	}
	


	