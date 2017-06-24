/*Ishvaraus Davis
CS 0445
Assignment 2*/
import java.util.*;
import java.io.*;

public class Assig2
{
	//instance variables
	private DisplayableStack<Crate> tempStack; 
	private DisplayableStack<Crate> mainStack;
	private DisplayableStack<Crate> myStack = new DisplayableStack<Crate>();
	private int universalCounter = 0;
	private Scanner inscan;
	private String fName;
	private File inFile;
	private Crate counterCrate;
	private StringBuilder totalCrate, currentCrate;
	private int totalCrateNumber = 0, totalCrateMoves = 0;
	private double totalBananaCost = 0, totalLaborCost = 0, cumTotal = 0;
	private boolean used = false, currentCrateUsed = false;
	private int crateNumber = 0, crateMoves = 0;
	private double bananaCost = 0, laborCost = 0, total = 0;
	
		public Assig2(String fstring) throws IOException
		{
		tempStack = new DisplayableStack<Crate>();
		mainStack = new DisplayableStack<Crate>();
		fName = fstring;
		inFile = new File(fName); //file input
				
		inscan = new Scanner(inFile);
		
		do
		{
		String startString = inscan.nextLine();
		//methods for file input
		if(startString.equals("receive"))
		{
			recieve();
		}
		
		else if(startString.equals("report"))
		{
			report();
		}
		
		else if(startString.equals("display"))
		{
			display();
		}
		
		else if(startString.equals("skip"))
		{
			skip();
		}
		else if(startString.equals("use"))
		{
			use();
		}
		}while(inscan.hasNext());
		System.out.println("End of Simulation");
		}
		
		public void recieve()
		{
		crateNumber = 0; crateMoves = 0;
		bananaCost = 0; laborCost = 0; total = 0;

		//recieve operation
		
		int numRecieved = inscan.nextInt();
		
		System.out.println("Recieving " + numRecieved + " crates of bananas\n");
		crateNumber = numRecieved;
		for(int i = 0; i < numRecieved; i++)
		{
		int firstInt = inscan.nextInt();
		int secondInt = inscan.nextInt();
		double firstDouble = inscan.nextDouble();
		
		bananaCost += firstDouble;
		
		Crate newCrate = new Crate(firstInt,secondInt,firstDouble);
			if(mainStack.isEmpty() == true)
			{
			mainStack.push(newCrate);
			crateMoves++;

			}
			else
			{	
				boolean success = false;
				int moveBack = 0;
				do
				{
				//merge stacks
				if(mainStack.isEmpty() == false)
				{

				int result = mainStack.peek().compareTo(newCrate);
				if(result > 0)//if main stack crate is < than new crate
				{
				tempStack.push(mainStack.pop());
				moveBack++;
				crateMoves++;
				}
				else if(result < 0)//if main stack crate is > than new crate
				{
				mainStack.push(newCrate);
				crateMoves++;
				for(int q = 0; q < moveBack; q++)
				{
				Crate temp = tempStack.pop();
				mainStack.push(temp);
				crateMoves++;
				}
				success = true;
				}
				else//if equal
				{
				mainStack.push(newCrate);
				crateMoves++;
				for(int q = 0; q < moveBack; q++)
				{
				Crate temp = tempStack.pop();
				mainStack.push(temp);
				crateMoves++;
				}
				success = true;
				}
				}
				else
				{
				mainStack.push(newCrate);
				

				crateMoves++;
				for(int q = 0; q < moveBack; q++)
				{
				Crate temp = tempStack.pop();
				mainStack.push(temp);
				crateMoves++;
				}
				success = true;

				}
				}while(success == false);
				
			
			}

		}
		
		//calculations
		totalCrateMoves+= crateMoves;
		
		
		totalCrateNumber+= crateNumber;
		
		totalBananaCost += bananaCost;
		
		laborCost = crateMoves;
		totalLaborCost += laborCost;
		
		total = bananaCost + laborCost;
		cumTotal+= total;
		
		//current statistics
		currentCrate = new StringBuilder();
		currentCrate.append("\tMost Recent Shipment:");
		currentCrate.append("\n\t\tCrates: " + crateNumber);
		currentCrate.append("\n\t\tBanana cost: " + bananaCost);
		currentCrate.append("\n\t\tLabor (moves): " + crateMoves);
		currentCrate.append("\n\t\tLabor cost: " + laborCost);
		currentCrate.append("\n\t\t-----------------");
		currentCrate.append("\n\t\tTotal: " + total + "\n");
		currentCrateUsed = true;
		}
		
		public void use()
		{
		int bananasNeeded = inscan.nextInt();
		//using bananas
		System.out.println(bananasNeeded + " bananas needed for order");
		boolean jump = false;
		boolean fulfilled = false;	
		
		if(mainStack.isEmpty() == true)
		{
		System.out.print("Store is out of bananas!\n");
		jump = true;
		}
		
		if(jump == false)
		{
		
		if(used == false)
		{
		counterCrate = mainStack.pop();
		}
		used = true;
			
			if(counterCrate.useBanana(bananasNeeded) == 1)
			{
			System.out.println("Getting Crate: " + counterCrate.toString());
			counterCrate.deleteBanana(bananasNeeded);
			System.out.println(bananasNeeded + " bananas used from current crate\n");
			}
			else if(counterCrate.useBanana(bananasNeeded) == 0)
			{
			System.out.println("Getting Crate: " + counterCrate.toString());

			counterCrate.deleteBanana(bananasNeeded);
			counterCrate = mainStack.pop();
			}
			else //more bananas were needed
			{
				do
				{	//if crate didn't have enough bananas
				System.out.println(counterCrate.currentCount() + " bananas used from current crate");
				bananasNeeded-=counterCrate.currentCount();
				counterCrate = mainStack.pop();
				if((fulfilled == false) && (mainStack.isEmpty() == true ))
				{
				System.out.println("Sorry, store is out of bananas");
				}
				else
				{
				System.out.println("Getting Crate: " + counterCrate.toString());

				if(counterCrate.useBanana(bananasNeeded) == 1)
				{
				counterCrate.deleteBanana(bananasNeeded);
				fulfilled = true;
				System.out.println(bananasNeeded + " bananas used from current crate\n");

				}
				else if(counterCrate.useBanana(bananasNeeded) == 0)
				{
				counterCrate.deleteBanana(bananasNeeded);
				counterCrate = mainStack.pop();
				fulfilled = true;
				}
				}
				}while(fulfilled == false);
			}
			}
		}
		
		public void skip()
		{	//skip days
		incCounter();
		System.out.println("The current day is now Day " + universalCounter);
		if(mainStack.isEmpty() == false)
		{
		boolean bool = false;
		do
		{
		Crate temp = mainStack.peek();
			if(temp.getDate() < universalCounter)
			{
			temp = mainStack.pop();//delete it
			System.out.println("Top crate: " + temp.toString() + " is expired!");
			}
			else
			{
			bool = true;
			}
		}while(bool == false);
		}
		}
		
		public void display()
		{	//display stack
		if(mainStack.isEmpty() == false)
		{
		if(used == true)
		{
		System.out.println("Current crate: " + counterCrate.toString());
		}
		System.out.println("Stack crates (top to bottom):");
		System.out.print(mainStack.toString());
		System.out.print("\n");
		}
		else
		{
		System.out.println("No crates in the stack - please reorder!");
		}

		}
		
		public void report()
		{	//display main stack
		System.out.println("\nLickety Splits Financial Statement:\n\t");
		if(currentCrateUsed == true)
		{
		System.out.println(currentCrate.toString());
		currentCrate.setLength(0);
		}
		else
		{
		currentCrate = new StringBuilder();
		currentCrate.append("\tMost Recent Shipment:");
		currentCrate.append("\n\t\tCrates: " + crateNumber);
		currentCrate.append("\n\t\tBanana cost: " + bananaCost);
		currentCrate.append("\n\t\tLabor (moves): " + crateMoves);
		currentCrate.append("\n\t\tLabor cost: " + laborCost);
		currentCrate.append("\n\t\t-----------------");
		currentCrate.append("\n\t\tTotal: " + total + "\n");
		System.out.println(currentCrate.toString());
		currentCrate.setLength(0);
		}
		
		totalCrate = new StringBuilder();
		totalCrate.append("\tOverall Expenses:");
		totalCrate.append("\n\t\tCrates: " + totalCrateNumber);
		totalCrate.append("\n\t\tBanana cost: " + totalBananaCost);
		totalCrate.append("\n\t\tLabor (moves): " + totalCrateMoves);
		totalCrate.append("\n\t\tLabor cost: " + totalLaborCost);
		totalCrate.append("\n\t\t-----------------");
		totalCrate.append("\n\t\tTotal cost: " + cumTotal + "\n");
		System.out.println(totalCrate.toString());
		totalCrate.setLength(0);
		
		}
			
		
		public void incCounter()
		{
		universalCounter++;
		}
		
		public static void main(String [] args) throws IOException
		{
		Assig2 A2 = new Assig2(args[0]);
		}
}
		
		
