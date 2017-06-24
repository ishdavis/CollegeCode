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
					totalCost = coffee* quantity;
					break;
				case 2:
					//latte
					itemName = "Latte";
					totalCost = latte * quantity;
					break;
				case 3:
					//cappuccino
					itemName = "Cappuccino";
					totalCost = cappuccino* quantity;
					break;
				case 4:
					//espresso
					itemName = "Espresso";
					totalCost = espresso * quantity;
					break;
				default:
					itemName = null;
					totalCost = 0.0;
			}
				System.out.println("Customer # " + i + "\n with order" + itemName + "bought " + totalCost);
		
		}
		
		System.out.print("Please enter \"1\" to simulate again or \"0\" to exit: ");
		continueSim = keyboard.nextInt();
		
		}while (continueSim == 1);
		
	