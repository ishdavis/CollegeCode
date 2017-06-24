/*Ishvaraus Davis
CS 0401
Assignment One
Gas Store that allows the user to buy an arbitrary amount of burritos, propane, or gasoline
For extra credit there is an array search that determines if the user has a valid credit card*/
import java.util.Scanner;
import java.util.Random;
import java.text.DecimalFormat;


public class Gas
{

	public static void main(String[] args)
	{
	
	double runOption = 0;
	do
	{
	//Variables
	double burritos = 0, gasChoice = 0, gallons = 0, propane = 0, tanksReturned = 0;
	boolean discount = false;
	double burritoAmount = 0, newBurrito = 0, burritoDiscount = 0, propaneAmount = 0, propaneTotal = 0, gasPrice = 0;
	int cardMember = 0, cardBalance = 0, gasDiscount = 0;
	double gasCost = 0, burritoCost = 0, burritoConstant = 0, burritoTotal = 0, paymentAmount = 0;
	double realgasDiscount = 0, burritoCosts = 0, newGasCost = 0, realBurrito = 0, savings = 0, savings1 = 0, savings2 = 0;
	
	//Imports
	DecimalFormat formatter = new DecimalFormat("$####.00");

	Scanner keyboard = new Scanner(System.in);
	
	
	System.out.println("Welcome to GAS GAS and GAS! \nIs there a customer in line? (1 = yes, !1 = no)");
	//Structure Control
	runOption = keyboard.nextInt();
	
	if(runOption != 1){
		
		System.exit(0);
	}
	
	if(runOption == 1){
		
		do
		{
		System.out.println("Are you a GasVantage card member? (1 = yes, 2 = no)");
		
		cardMember = keyboard.nextInt();
		}while(cardMember != 1 && cardMember != 2);
		
		//Check cardMember Status
		
		if(cardMember == 1){
		
		discount = true;
		
		System.out.println("Welcome Back, GasVantage Customer!\nWhat is your current GasVantage balance?");
		cardBalance = keyboard.nextInt();
		
		gasDiscount = cardBalance / 50;
		
		realgasDiscount = gasDiscount * .1;
		
		System.out.println("You will recieve:\n\t" + formatter.format(realgasDiscount) + "/gal. discount on gasoline\n\t" 
		+ "10.0% off your propane tanks\n\t$0.10/ea discount on burritos");
		}
		
		int itemChoice = 0;
		
		//Menu
		do
		{
		System.out.println("Here are your options:\n\t1) Buy Gasoline: $3.75/gal. reg.,"
		+ "$4.00/gal. plus \n\t2) Buy Propane:\n\t\t(with return tank): $20.00/20 lb tank"
		+ "\n\t\t(no tank): $35.00/20 lb tank\n\t3) Buy Burritos: $1.00/ each [with volume discounts]"
		+ "\n\t4)Check out\nNote: For options 1-3, selecting more than once will overwrite previous selections");		
		
		System.out.println("What is your choice?");
		
		itemChoice = keyboard.nextInt();
		
		if(itemChoice == 1){
		
		System.out.println("Do you want:\n\t1) Regular gasoline\n\t2) Plus gasoline");
		
		gasChoice = keyboard.nextDouble();
		
		System.out.println("How many gallons do you want?");
		
		gallons = keyboard.nextDouble();
		//Gas option 1
		if(gasChoice == 1){
		
		gasPrice = 3.75 * gallons;
		
		gasCost = 3.75;
		
		savings = (3.75 - newGasCost) * gallons;

				
		}
		//Gas option 2
		if(gasChoice == 2){
		
		gasPrice = 4 * gallons;
		
		gasCost = 4;
				
		savings = (4 - newGasCost) * gallons;
		
		}
		
		}
		
		if(itemChoice == 2){
		
		System.out.println("How many propane tanks do you want?");
		
		propane = keyboard.nextDouble();
		
		
		do
		{
		System.out.println("How many tanks are you returning? (<= " + propane + ")");
		
		tanksReturned = keyboard.nextDouble();
		
		
		}while(tanksReturned > propane);
		
		propaneTotal = tanksReturned * 20;
		
		propaneAmount = (propane - tanksReturned) * 35 + propaneTotal;
				
		}
		
		if(itemChoice == 3){
		
		System.out.println("How many burritos do you want?");
		
		burritos = keyboard.nextDouble();
		
		//Burrito Amounts
		if(burritos <= 5)
		{
		
		burritoAmount = burritos;
		
		realBurrito = burritos;
		
		if(discount == true){
		burritoAmount = burritos * .9;
		}
		
		}
		
		if(burritos > 5 && burritos <=10)
		{
		
		newBurrito = burritos - 5;
		
		burritoConstant = 5;
		
		burritoDiscount = newBurrito * .9;
		
		if(discount == true)
		{
		burritoDiscount = newBurrito * .8;
		}
		
		burritoAmount = 5 + burritoDiscount;
		
				
		}
		
		if(burritos > 10)
		{
		burritoConstant = 5;
		
		burritoCosts = 5 * .9;
		
		newBurrito = burritos - 10;
		
		burritoDiscount = newBurrito * .8;
		
		if(discount == true)
		{
		burritoDiscount = newBurrito * .7;
		}
		
		burritoAmount = 9.5 + burritoDiscount;
		
		}
		
		}
		
		}while(itemChoice != 4);
		
		if(burritoAmount == 0 && propaneAmount == 0 && gasPrice == 0){
		
		System.out.println("No items Purchased! Thanks anyway for shopping.");
		
		}
		
		//Output for non card-holders
		else
		{
		if(discount == false)
		{
		System.out.print("Here is your subtotal:\n\t");
		if(propaneAmount > 0){
		System.out.println("Propane (w return) " + tanksReturned + " tanks at $20.00 per tank:\t " + formatter.format(propaneTotal));
		System.out.println("\tPropane (no return) " + (propane - tanksReturned) + " at $35.00 per tank:\t\t" + formatter.format(propaneAmount - propaneTotal));
		}
		if(gasPrice > 0){
		System.out.println("\tGasoline: " + gallons + " gallons at " + formatter.format(gasCost) + " per gallon:\t\t" + formatter.format(gasPrice));
		}
		if(burritoAmount > 0){
		
			if(burritos <= 5)
			{
			System.out.println("\tBurritos: " + realBurrito + " at $1.00 per burrito:\t\t\t" + formatter.format(burritoAmount));
			burritoTotal = burritoAmount;
			}
			
			if(burritos> 5 && burritos <= 10)
			{
			System.out.println("\tBurritos: " + burritoConstant + " at $1.00 per burrito:\t\t\t" + formatter.format(burritoConstant));
			System.out.println("\tBurritos: " + newBurrito + " at $0.90 per burrito:\t\t\t" + formatter.format(burritoDiscount));
			burritoTotal = burritoConstant + burritoDiscount;
			}
			
			if(burritos > 10)
			{
			System.out.println("\tBurritos: " + burritoConstant + " at $1.00 per burrito:\t\t\t" + formatter.format(burritoConstant));
			System.out.println("\tBurritos: " + burritoConstant + " at $0.90 per burrito:\t\t\t" + formatter.format(burritoCosts));
			System.out.println("\tBurritos: " + newBurrito + " at $0.80 per burrito:\t\t\t" + formatter.format(burritoDiscount));
			burritoTotal = burritoConstant + burritoCosts + burritoDiscount;
			}
		}
		}
		
		newGasCost = gasCost - realgasDiscount;
		
		double propaneTotal1 = propaneTotal - (propaneTotal * .1), propaneTotal2 = (propaneAmount - propaneTotal) - (propaneAmount - propaneTotal) * .1;
		if(discount == true) //Output for card-holders
		{
		System.out.print("Here is your subtotal:\n\t");
		if(propaneAmount > 0){
		System.out.println("Propane (w return) " + tanksReturned + " tanks at $18.00 per tank:\t " + formatter.format(propaneTotal1));
		System.out.println("\tPropane (no return) " + (propane - tanksReturned) + " at $31.50 per tank:\t\t" + formatter.format(propaneTotal2));
		savings2 = (propaneTotal + propaneTotal2) * .1;
		}
		if(gasPrice > 0){
		System.out.println("\tGasoline: " + gallons + " gallons at " + formatter.format(newGasCost) + " per gallon:\t\t" + formatter.format(gallons * newGasCost));
		}
		if(burritoAmount > 0){
		
			
			if(burritos <= 5)
			{
			System.out.println("\tBurritos: " + realBurrito + " at $.90 per burrito:\t\t\t" + formatter.format(realBurrito * .9));
			burritoTotal = realBurrito * .9;
			savings1 = realBurrito * .1;
			}
			
			if(burritos> 5 && burritos <= 10)
			{
			System.out.println("\tBurritos: " + burritoConstant + " at $.90 per burrito:\t\t\t" + formatter.format(burritoConstant * .9));
			System.out.println("\tBurritos: " + newBurrito + " at $.80 per burrito:\t\t\t" + formatter.format(newBurrito * .8));
			burritoTotal = (burritoConstant * .9) + (newBurrito * .8);
			savings1 = (burritoConstant + newBurrito) * .1;
			}
			
			if(burritos > 10)
			{
			System.out.println("\tBurritos: " + burritoConstant + " at $.90 per burrito:\t\t\t" + formatter.format(burritoConstant * .9));
			System.out.println("\tBurritos: " + burritoConstant + " at $.80 per burrito:\t\t\t" + formatter.format(burritoConstant * .8));
			System.out.println("\tBurritos: " + newBurrito + " at $.70 per burrito:\t\t\t" + formatter.format(newBurrito * .7));
			burritoTotal = (burritoConstant * .9) + (burritoConstant * .8) + (newBurrito * .7);
			savings1 = (burritoConstant * 2 + newBurrito) * .1;
			}
		}
		}
		
		double propaneCosts = propaneTotal + (propaneAmount - propaneTotal);
		double subTotal = propaneCosts + gasPrice + burritoTotal, priceAfterDiscount = subTotal - (subTotal * .1);
		double newSubTotal = priceAfterDiscount * .07;
		if(discount == false)
		{
		System.out.println("\tSubtotal:\t\t\t\t\t\t" + formatter.format(subTotal));
		System.out.println("\tBonus discount of 10%:\t\t\t\t\t" + formatter.format(subTotal * .1));
		System.out.println("\tNew Subtotal:\t\t\t\t\t\t" + formatter.format(priceAfterDiscount));
		System.out.println("\tTax:\t\t\t\t\t\t\t" + formatter.format(newSubTotal));
		System.out.println("\tTotal:\t\t\t\t\t\t\t" + formatter.format(newSubTotal + priceAfterDiscount));
		do
		{
		
		System.out.print("Please enter your payment amount: ");
		paymentAmount = keyboard.nextDouble();
		System.out.println("\t\t " + formatter.format(paymentAmount));
		}while(paymentAmount < (newSubTotal + priceAfterDiscount));
		System.out.println("Your change:\n" + formatter.format((paymentAmount - (newSubTotal + priceAfterDiscount))));
		}
		
		double subTotal1 = burritoTotal + (gallons * newGasCost) + propaneTotal1 + propaneTotal2;
		double priceAfterDiscount2 = subTotal1 - (subTotal1 * .1), newSubTotal2 = priceAfterDiscount2 * .07;
		
		if(discount == true)
		{
		System.out.println("\tSubtotal:\t\t\t\t\t\t" + formatter.format(subTotal1));
		System.out.println("\tBonus discount of 10%:\t\t\t\t\t" + formatter.format(subTotal1 * .1));
		System.out.println("\tNew Subtotal:\t\t\t\t\t\t" + formatter.format(priceAfterDiscount2));
		System.out.println("\tTax:\t\t\t\t\t\t\t" + formatter.format(newSubTotal2));
		System.out.println("\tTotal:\t\t\t\t\t\t\t" + formatter.format(newSubTotal2 + priceAfterDiscount2));
		if(gasChoice == 1)
		{
		savings = (3.75 - newGasCost) * gallons;
		}
		if(gasChoice == 2)
		{
		savings = (4 - newGasCost)* gallons;
		}

		System.out.println("As a GasVantage customer, you saved: " + formatter.format(savings + savings1 + savings2));
		do
		{
		
		System.out.print("Please enter your payment amount: ");
		paymentAmount = keyboard.nextDouble();
		System.out.println("" + formatter.format(paymentAmount));
		}while(paymentAmount < (newSubTotal2 + priceAfterDiscount2));
		System.out.println("Your change:\n" + formatter.format((paymentAmount - (newSubTotal2 + priceAfterDiscount2))));
		}
		
		
		
		
		//Extra Credit
		//Check for credit card number matches
		boolean accountNumberIsValid = false;
		String[] accountNumbers = {"5658945", "4528125", "7805122", "8777521", "8751277", "1202850", "1005331", "6542231", "3812085", "7576631", "7981200", "4281002"};
		System.out.println("Would you like to pay by credit card? (1 = yes, !1 = no)");
		int userOption = keyboard.nextInt();
		
		if(userOption == 1)
		{
		
		System.out.println("Please enter your 7 digit card number");//Valid Numbers: 5658945, 4528125, 7805122, 8777521, 8751277, 1202850, 1005331, 6542231, 3812085, 7576631, 7981200, 4281002
		String accountOption = keyboard.next();
		for (int i = 0; i < accountNumbers.length; i++)
		{
			if (accountNumbers[i].equals(accountOption))
				{
				accountNumberIsValid = true;

				}
		}
				
		if(accountNumberIsValid == true)
		{
		System.out.println("Card Accepted");
		}
		
		else
		{
		System.out.println("Sorry, your card wasn't accepted");
		}
		
		}
		
		System.out.println("Thanks for shopping at GG&G!");
		
		}
		
		}
	
	}while(runOption == 1);
	
	}
}