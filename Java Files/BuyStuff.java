/*Ishvaraus Davis
CS 0401
Assignment One*/
import java.util.Scanner;
import java.util.Random;
import java.text.DecimalFormat;


public class BuyStuff
{

	public static void main(String[] args)
	{
		//classes
		Scanner keyboard = new Scanner(System.in);
		DecimalFormat formatter = new DecimalFormat("$####.00");

		int Customers = 0;
		
		System.out.println("\nWelcome to Buy Stuff (or Buy it Not)\n" 
		+ "This IS the store you're looking for...");

		do
		{
		//variables
		int itemChoice = 0, actionFigure = 0, movie = 0, legoSet= 0;
		int newOrder1 = 0, newOrder2 = 0, newOrder3 = 0;
		int questionNumber = 0, shippingAmount = 0, finalAnswer = 0;
		String answer1 = "Sith";
		int answer2 = 1977;
		String userInput1;
		int userInput2 = 0;
		boolean discount = true;
		double discountAmount = 0;
		String shippingType = null;
		
		System.out.println("Is there a customer in line? (1 = yes, 2 = no)");
		
		Customers = keyboard.nextInt();
		
		if(Customers == 2) {
		
		System.exit(0);
		
		}
		
		if(Customers == 1) {
		
		
		System.out.println("Welcome new Customer!");
		
		do
		{
		//menu
		System.out.println("Please update your order");
		
		System.out.println("\t1) Yoda Action Figure: $10.00 each\n"
		+ "\n\t2) Star Wars Movie Blue Ray: $15.00 each\n"
		+ "\n\t3) Death Star Lego Set: $350.00 each\n"
		+ "or any other number to check out");
		
		itemChoice = keyboard.nextInt();
		
			if(itemChoice == 1){
			
			System.out.println("Current order: " + actionFigure + " Yoda Action Figures at $10.00 each");
			System.out.println("Please enter your new order (negative number to leave unchanged)");
			
			newOrder1 = keyboard.nextInt();
			
				if(newOrder1 > 0) {
				
				actionFigure += newOrder1;
				System.out.println("Order updated to " + actionFigure + " Yoda Action Figures");
				
				}
				
				if(newOrder1 < 0) {
				
				System.out.println("Order left unchanged");
				
				}
				
			}
			
			if(itemChoice == 2){
			
			System.out.println("Current order: " + movie + " Star Wars Blue Rays at $15.00 each");
			System.out.println("Please enter your new order (negative number to leave unchanged)");
			
			newOrder2 = keyboard.nextInt();
			
				if(newOrder2 > 0) {
				
				movie += newOrder2;
				System.out.println("Order updated to " + movie + " Star Wars Blue Rays");
				
				}
				
				if(newOrder2 < 0) {
				
				System.out.println("Order left unchanged");
				
				}
			
			}
			
			if(itemChoice == 3){
			
			//Make sure the variables are in scope

			
			System.out.println("Current order: " + legoSet + " Star Wars Blue Rays at $350.00 each");
			System.out.println("Please enter your new order (negative number to leave unchanged)");
			
			newOrder3 = keyboard.nextInt();
			
				if(newOrder3 > 0) {
				
				legoSet += newOrder3;
				System.out.println("Order updated to " + legoSet + " Star Wars Blue Rays");
				
				}
				
				if(newOrder3 < 0) {
				
				System.out.println("Order left unchanged");
				
				}
			}	

			}while (itemChoice == 1 || itemChoice == 2 || itemChoice == 3);
			//End of shopping loop
			System.out.println("Answer the Star Wars Trivia Question to recieve a 10%"
			+ "discount on your order");
			
			Random randomGenerator = new Random();
			questionNumber = randomGenerator.nextInt(2) + 1;
			
				if(questionNumber == 1) {
				//correct answer is "Sith"
				System.out.println("Who were the evil characters in the star wars series?");
				
				userInput1 = keyboard.next();
				
					if(userInput1.equals(answer1)){
					
					System.out.println("You are correct -- you get a 10% discount");
					discount = true;
					}
					
					if(userInput1.equals(answer1) == false){
					
					System.out.println("Sorry that's incorrect");
					discount = false;
					
					}
					
					}
					
				if(questionNumber == 2) {
				//correct answer is 1977
				System.out.println("What year was the first Star Wars film released?");
				userInput2 = keyboard.nextInt();
				
					if(userInput2 == answer2){
					
					System.out.println("You are correct -- you get a 10% discount");
					discount = true;
					
					}
					
					if(userInput2 != answer2){
					
					System.out.println("Sorry that's incorrect");
					discount = false;
					
					}
				
					}
				
				int shippingOption = 0;
				do{
					//Shipping Options
					System.out.println("Please choose your shipping option:");
					System.out.println("1) Regular shipping [$5.00 per $50.00 of merchandise (rounded up)]");
					System.out.println("2) Express shipping [$10.00 per $50.00 of merchandise (rounded up)]");
					System.out.println("3) Super saver shipping [free]");
					
					shippingOption = keyboard.nextInt();
				}while(shippingOption != 1 && shippingOption != 2 && shippingOption != 3);
						
						
				System.out.println("Here are your order details:");
				int total1 =  actionFigure * 10;
				int total2 = movie * 15;
				int total3 = legoSet * 350;
				
				//Output
				System.out.println("" + actionFigure + " Yodas at $10.00 each:\t\t\t\t\t\t " + formatter.format(total1));
				System.out.println("" + movie + " Star Wars Blue Rays at $15.00 each:\t\t\t\t " + formatter.format(total2));
				System.out.println("" + legoSet + " Death Star Legos at $350.00 each:\t\t\t\t " + formatter.format(total3));
				System.out.println("\t\t\t\t\t\t\t\t-------");
				int cumTotal = total1 + total2 + total3;
				System.out.println("Subtotal:\t\t\t\t\t\t\t " + formatter.format(cumTotal));					
						
					if(discount == true){
						
						discountAmount = cumTotal * .1;
						
					}
					
					if(discount == false){
					
						discountAmount = 0;
						
					}
				
				System.out.println("10% discount:\t\t\t\t\t\t\t " + formatter.format(discountAmount));
				if(shippingOption == 1) {
					
					shippingType = "Regular shipping";
							
					finalAnswer = cumTotal / 50;
					}
					
				if(shippingOption == 2) {
				
					shippingType = "Express shipping";
					
					finalAnswer = cumTotal / 25;
				}
				
				if(shippingOption == 3) {
				
					shippingType = "Super Saver Shipping";
					
					finalAnswer = cumTotal * 0;
					
				}
					
				System.out.println("" + shippingType + "\t\t\t\t\t\t " + formatter.format((finalAnswer * 5)));
				double grandTotal = cumTotal - discountAmount + (finalAnswer * 5);
				
				System.out.println("Total:\t\t\t\t\t\t\t\t " + formatter.format(grandTotal));
				System.out.println("Please enter your credit card number: ");
				
				int cardNumber = 0;
				cardNumber = keyboard.nextInt();
				
				System.out.println("Thank you for your order!\n"
				+ "Were this a real order, you would be sent an email confirmation!\n"
				+ "Please come again (or come not)!");
				
		}
		
		}while(Customers != 2);
	}
}
		