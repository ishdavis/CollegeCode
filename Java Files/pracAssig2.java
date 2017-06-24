/*Ishvaraus Davis
CS 0445
Assignment 2*/
import java.util.*;
import java.io.*;

public class pracAssig2
{
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
	private boolean used = false;
	
		public pracAssig2(String fstring) throws IOException
		{
		tempStack = new DisplayableStack<Crate>();
		mainStack = new DisplayableStack<Crate>();
		fName = fstring;
		inFile = new File(fName);
			
		inscan = new Scanner(inFile);
		
		do
		{
		String startString = inscan.nextLine();
		
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
		int crateNumber = 0, crateMoves = 0;
		double bananaCost = 0, laborCost = 0, total = 0;

		
		
		int numRecieved = inscan.nextInt();
		
		System.out.println("Recieving " + numRecieved + " crates of bananas\n");
		crateNumber = numRecieved;
		for(int i = 0; i < numRecieved; i++)
		{
		System.out.println(mainStack.toString());

		int firstInt = inscan.nextInt();
		int secondInt = inscan.nextInt();
		double firstDouble = inscan.nextDouble();
		
		bananaCost += firstDouble;
		
		Crate newCrate = new Crate(firstInt,secondInt,firstDouble);
			if(mainStack.isEmpty() == true && tempStack.isEmpty() == true)
			{
			mainStack.push(newCrate);
			crateMoves++;
			}
			else
			{	
				boolean success = false;
				boolean jump = false;
				boolean done = false;
				boolean gotIt = false;
				int moveBack = 0;
				do
				{
				
				if(tempStack.isEmpty() == true && mainStack.isEmpty() == false) //just temp is empty
				{
				int result = mainStack.peek().compareTo(newCrate);
				
				if(result > 0)//if main stack crate is < than new crate
				{
				tempStack.push(mainStack.pop());
				crateMoves++;
				}
				else if(result < 0)//if main stack crate is > than new crate
				{
				mainStack.push(newCrate);
				crateMoves++;
				success = true;
				}
				else//if equal
				{
				mainStack.push(newCrate);
				crateMoves++;				
				success = true;

				}
				}
				
				else if(tempStack.isEmpty() == false && mainStack.isEmpty() == false) //both aren't empty
				{
				int result = mainStack.peek().compareTo(tempStack.peek()); 
				if(result == 0)//if next item in stacks are equal
				{
				tempStack.push(mainStack.pop());
				crateMoves++;
				done = true;
				}
				
				if(done == false)
				{
				int result1 = newCrate.compareTo(mainStack.peek()); 
				int result2 = newCrate.compareTo(tempStack.peek());
				
				if(result1 == 0)//if equal to main stack push it
				{
				mainStack.push(newCrate);
				crateMoves++;
				success = true;
				jump = true;
				}
				if(result2 == 0 && jump == false)//if equal to temp stack push it
				{
				tempStack.push(newCrate);
				crateMoves++;
				success = true;
				}
				
				if((result1 > 0) && (result2 > 0))//if new crate is < than main stack && < than temp stack
				{
				mainStack.push(tempStack.pop());
				crateMoves++;
				}
				
				if((result1 < 0) && (result2 < 0))//if new crate is > than main stack && > than temp stack
				{
				tempStack.push(mainStack.pop());
				crateMoves++;
				}
				
				if((result1 > 0) && (result2 < 0))//if new crate is < than main stack && > than temp stack
				{
				mainStack.push(newCrate);
				crateMoves++;

				success = true;
				}
				
				if((result1 < 0) && (result2 > 0))//if new crate is > then main stack && < than temp stack
				{
				
				}
				}
				success = true;
				}
				
				else //just main is empty
				{
				mainStack.push(newCrate);
				crateMoves++;

				success = true;
				}
				
			
				}while(success == false);
				
			
			}

		}
		while(tempStack.isEmpty() == false)
		{
		mainStack.push(tempStack.pop());
		crateMoves++;
		}
		

		totalCrateMoves+= crateMoves;
		
		
		totalCrateNumber+= crateNumber;
		
		totalBananaCost += bananaCost;
		
		laborCost = crateMoves;
		totalLaborCost += laborCost;
		
		total = bananaCost + laborCost;
		cumTotal+= total;
		
		
		currentCrate = new StringBuilder();
		currentCrate.append("\tMost Recent Shipment:");
		currentCrate.append("\n\t\tCrates: " + crateNumber);
		currentCrate.append("\n\t\tBanana cost: " + bananaCost);
		currentCrate.append("\n\t\tLabor (moves): " + crateMoves);
		currentCrate.append("\n\t\tLabor cost: " + laborCost);
		currentCrate.append("\n\t\t-----------------");
		currentCrate.append("\n\t\tTotal: " + total + "\n");
		
		}
		
		public void use()
		{
		int bananasNeeded = inscan.nextInt();
		
		System.out.println(bananasNeeded + " bananas needed for order");
		
		boolean fulfilled = false;	
		
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
				{
				System.out.println(counterCrate.currentCount() + " bananas used from current crate");
				bananasNeeded-=counterCrate.currentCount();
				counterCrate = mainStack.pop();
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
				}while(fulfilled == false);
			}
		}
		
		public void skip()
		{
		incCounter();
		System.out.println("The current day is now Day " + universalCounter);
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
		
		public void display()
		{
		if(used == true)
		{
		System.out.println("Current crate: " + counterCrate.toString());
		}
		System.out.println("Stack crates (top to bottom):");
		System.out.print(mainStack.toString());
		System.out.print("\n");

		}
		
		public void report()
		{
		System.out.println("\nLickety Splits Financial Statement:\n\t");
		System.out.println(currentCrate.toString());
		currentCrate.setLength(0);
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
		pracAssig2 A2 = new pracAssig2(args[0]);
		}
}
		
		
