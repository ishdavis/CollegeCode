/*Ishvaraus Davis
CS 0007
Assignment Two*/
import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.Random;

public class CoffeeShopSalesSimulator
{

	public static void main (String[] args)
	{
		//Runs the loop
		int continuesim;
		//sales of products
		double coffeeSales = 0, latteSales = 0, cappuccinoSales = 0, espressoSales = 0;
		
			do
			{
			int numHours, salesGoal, numCustomers, itemChoice, itemQuantity;
			int simulator = 0, drinkChoice;
			
			//decimal class
			DecimalFormat formatter = new DecimalFormat("$####.00");
			
			//User input
			Scanner keyboard = new Scanner(System.in);
			
			//Strings
			double drinkPrice = 0;
			String coffeesales = "Coffee Sales";
			String lattesales = "Latte Sales";
			String cappuccinosales = "Cappuccino Sales";
			String espressosales = "Espresso Sales";
			String totalsales = "Total Sales";
			
			//Product costs
			final double coffeeprice = 1.50;
			final double latteprice = 3.50;
			final double cappuccinoprice = 3.25;
			final double espressoprice = 2.00;
			
			String itemName = null;
			
			System.out.println("Welcome to the Coffee-Shop-Sales Simulator!");
			
			//User input
			System.out.println("Please enter the number of hours: ");
			numHours = keyboard.nextInt();
			
			System.out.println("Please enter the sales goal without dollar " 
			+ "sign (e.g. 250.00):");
			salesGoal = keyboard.nextInt();
			
			//Customers per Hour
			numCustomers = numHours * 4;
			
			//Beginning of simulation
			System.out.println("---Simulation Start---");
			
			
				while (simulator < numCustomers)
				{
				
				//Random Number Generators
				Random randomGenerator = new Random();
				itemQuantity = randomGenerator.nextInt(5) + 1;
				itemChoice = randomGenerator.nextInt(4) + 1;
				drinkChoice = randomGenerator.nextInt(4) + 1;
				
				//Drink Choices
				if(drinkChoice == 1) {
					itemName = "Coffee";
					drinkPrice = 1.50;
					coffeeSales += coffeeprice * itemQuantity;}
				if(drinkChoice == 2) {
					itemName = "Latte";
					drinkPrice = 3.50;
					latteSales += latteprice * itemQuantity;}
				if(drinkChoice == 3) {
					itemName = "Cappuccino";
					drinkPrice = 3.25;
					cappuccinoSales += cappuccinoprice * itemQuantity;}
				if(drinkChoice == 4) {
					itemName = "Espresso";
					drinkPrice = 2.00;
					espressoSales += espressoprice * itemQuantity;}
					
				double totalCost = drinkPrice * itemQuantity;
				
					//Increment
					simulator++;
					
					System.out.println("Customer " + simulator + "\nItem Purchased:" + itemName + "\nQuantity Purchased:" + itemQuantity + "\nTotal Cost: " + formatter.format(totalCost));
					
					
					}
					//End of Simulation
					System.out.println("---Simulation End---\n");
					
					//Sales Report, f method
					System.out.printf("Aggregate Sales Report\n\n");
					String lines = "------------";
					System.out.printf("%15s %15s %15s %15s %15s", coffeesales, lattesales, cappuccinosales, espressosales, totalsales);
					System.out.printf("%15s %15s %15s %15s %15s\n\n", lines, lines, lines, lines, lines);
					double allsales = coffeeSales + latteSales + cappuccinoSales + espressoSales;
					System.out.printf("%15.2f  %15.2f %15.2f %15.2f %15.2f\n\n", coffeeSales, latteSales, cappuccinoSales, espressoSales, allsales);
					
					//User control of iterations
					if(allsales > salesGoal){
						System.out.println("The sales goal of " + formatter.format(salesGoal) + " was achieved");
					}
					
					if(allsales < salesGoal){
						System.out.println("The sales goal of " + formatter.format(salesGoal) + " wasn't achieved");
					}
					System.out.println("\nPlease enter 1 to simulate again or 0 to exit");
					continuesim = keyboard.nextInt();
					
					if(continuesim == 0) {
						System.out.println("\nGoodbye!");}
					
					if(continuesim > 2) {
						System.out.println("Invalid input \nPlease enter 1 to simulate again or 0 to exit");
						continuesim = keyboard.nextInt();}
					}while (continuesim == 1);
		
		
		}
		}
	
	
	
			
			
		
		
		

		

		