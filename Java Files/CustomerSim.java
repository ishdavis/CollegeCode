/*Prompt the user to enter the number of customers to simulate
Begin the Simulation
Print the simulation in formatted columns
Prompt the user to run another simulation by entering 1 or exit by 0*/

import java.util.Scanner;
import java.util.Random;

public class CustomerSim
{
	public static void main(String[] args)
	{
		//make doubles all uppercase, for Style
			final double coffee = 1.50;
			final double latte = 3.50;
			final double cappuccino = 3.25;
			final double espresso = 2.00;
			
			int item, quantity, numCustomers, continueSim = 0;
			double totalCost = 0.0;
			String itemName = null;
			
			Random randomGenerator = new Random();
			Scanner keyboard = new Scanner(System.in);
			
			do
			{
			System.out.println("Enter the number of customers: ");
			numCustomers = keyboard.nextInt();
			
			System.out.printf("%15s%15s%15s%15s\n", "Customer", "Selection", "Quantity", "Total Cost");
			System.out.printf("%15s%15s%15s%15s\n", "__________", "__________", "__________", "__________");

			
			for (int i = 0; i <= numCustomers; i++)
			{
			
				item = randomGenerator.nextInt(4) + 1;
				quantity = randomGenerator.nextInt(5) + 1;
			}
			switch(item)
			{
				case 1:
					//coffee
					itemName = "Coffee";
					totalCost = coffeeprice * quantity;
					break;
				case 2:
					//latte
					itemName = "Latte";
					totalCost = latteprice * quantity;
					break;
				case 3:
					//cappuccino
					itemName = "Cappuccino";
					totalCost = cappuccinoprice * quantity;
					break;
				case 4:
					//espresso
					itemName = "Espresso";
					totalCost = espressoprice * quantity;
					break;
				default:
					itemName = null;
					totalCost = 0.0;
			}
				System.out.printf("%-15s%-20s%20d$%15.2f\n", "Customer " + i, itemName, quantity, totalCost);
		
		}
		
		System.out.print("Please enter \"1\" to simulate again or \"0\" to exit: ");
		continueSim = keyboard.nextInt();
		
		}while (continueSim == 1);
		
	
		
	
}
		
		
		
		
		
		