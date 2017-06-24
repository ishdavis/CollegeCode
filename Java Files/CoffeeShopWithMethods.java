/*Ishvaraus Davis
CS 0007
Assignment One*/
import java.util.Scanner;
import java.text.DecimalFormat;
public class CoffeeShopWithMethods
{

	public static void main(String[] args)
{
	
	DecimalFormat formatter = new DecimalFormat("####.00");
	
	//customer input
	String CustomerName;
	Scanner keyboard = new Scanner(System.in);
	System.out.print("Please enter your name: ");//enter the name
	CustomerName = keyboard.nextLine();
	
	//customer input
	System.out.println("Welcome to The Java Byte Code Coffee Shop," //menu
	+ CustomerName + "!\n Here is our menu:\n\n"
	+"1. Coffee\t\t $1.50\n"
	+"2. Latte\t\t $3.50\n"
	+"3. Cappuccino\t\t $3.25\n"
	+"4. Espresso\t\t $2.00\n");
	
	
	
	//variables
	final int drinkChoice, drinkQuantity;
	double drinkPrice, discounts = .1;
	final double tax=.07;
	
	
	System.out.println("Please enter the item number: "); //drink choice
	drinkChoice = keyboard.nextInt();
	
	System.out.println("Please enter the quantity: "); //drink quantity
	drinkQuantity = keyboard.nextInt();
	
	//Drink Choice 1
	if(drinkChoice ==1) {
		drinkPrice = 1.50;
		System.out.println("Total before discount and tax is: $" + drinkPrice * drinkQuantity);
		final double drinkTotal= drinkPrice * drinkQuantity;
			if(drinkTotal >= 10){
				final double newdiscount= drinkTotal * discounts, finalamount = (drinkTotal - newdiscount) * tax;
				System.out.println("Discount is:$" + formatter.format(newdiscount));
				System.out.println("Price after discount is:$" + formatter.format(drinkTotal-newdiscount));
				System.out.println("Tax:$" + formatter.format((drinkTotal - newdiscount) * tax));
				System.out.println("Total:$" + formatter.format((drinkTotal-newdiscount) + finalamount));
				System.out.println("Thank you, " + CustomerName + "! Please stop by again!");
				}
			if(drinkTotal < 10){
				final double finalamounts = drinkTotal * tax;
				System.out.println("Discount is:$0");
				System.out.println("Price after discount is:$" + formatter.format(drinkTotal));
				System.out.println("Tax:$" + formatter.format(drinkTotal * tax));
				System.out.println("Total:$" + formatter.format((drinkTotal + finalamounts)));
				System.out.println("Thank you," + CustomerName + "! Please stop by again!");
				}
				}
		
		
	
	//Drink Choice 2
	if(drinkChoice ==2) {
		drinkPrice = 3.50;
		System.out.println("Total before discount and tax is: $" + drinkPrice * drinkQuantity);
		final double drinkTotal= drinkPrice * drinkQuantity;
			if(drinkTotal >= 10){
				final double newdiscount= drinkTotal * discounts, finalamount = (drinkTotal - newdiscount) * tax;
				System.out.println("Discount is:$" + formatter.format(newdiscount));
				System.out.println("Price after discount is:$" + formatter.format(drinkTotal-newdiscount));
				System.out.println("Tax:$" + formatter.format((drinkTotal - newdiscount) * tax));
				System.out.println("Total: $" + formatter.format((drinkTotal-newdiscount) + finalamount));
				System.out.println("Thank you," + CustomerName + "! Please stop by again!");
				}
			if(drinkTotal < 10){
				final double finalamounts = drinkTotal * tax;
				System.out.println("Discount is:$0");
				System.out.println("Price after discount is:$" + formatter.format(drinkTotal));
				System.out.println("Tax:$" + formatter.format(drinkTotal * tax));
				System.out.println("Total:$" + formatter.format((drinkTotal + finalamounts)));
				System.out.println("Thank you, " + CustomerName + "! Please stop by again!");
				}
				}
	
	//Drink Choice 3
	if(drinkChoice ==3) {
		drinkPrice = 3.25;
		System.out.println("Total before discount and tax is: $" + drinkPrice * drinkQuantity);
		final double drinkTotal= drinkPrice * drinkQuantity;
			if(drinkTotal >= 10){
				final double newdiscount= drinkTotal * discounts, finalamount = (drinkTotal - newdiscount) * tax;
				System.out.println("Discount is:$ " + formatter.format(newdiscount));
				System.out.println("Price after discount is:$ " + formatter.format(drinkTotal-newdiscount));
				System.out.println("Tax:$ " + formatter.format((drinkTotal - newdiscount) * tax));
				System.out.println("Total: $ " + formatter.format((drinkTotal-newdiscount) + finalamount));
				System.out.println("Thank you, " + CustomerName + "! Please stop by again!");
				}
			if(drinkTotal < 10){
				final double finalamounts = drinkTotal * tax;
				System.out.println("Discount is:$0");
				System.out.println("Price after discount is:$ " + formatter.format(drinkTotal));
				System.out.println("Tax:$" + formatter.format(drinkTotal * tax));
				System.out.println("Total:$" + formatter.format((drinkTotal + finalamounts)));
				System.out.println("Thank you, " + CustomerName + "! Please stop by again!");
				}
				}
	
	
	//Drink Choice 4
	if(drinkChoice ==4) {
		drinkPrice = 2.00;
		System.out.println("Total before discount and tax is: $" + drinkPrice * drinkQuantity);
		final double drinkTotal= drinkPrice * drinkQuantity;
			if(drinkTotal >= 10){
				final double newdiscount= drinkTotal * discounts, finalamount = (drinkTotal - newdiscount) * tax;
				System.out.println("Discount is:$" + formatter.format(newdiscount));
				System.out.println("Price after discount is:$" + formatter.format(drinkTotal-newdiscount));
				System.out.println("Tax:$" + formatter.format((drinkTotal - newdiscount) * tax));
				System.out.println("Total:$" + formatter.format((drinkTotal-newdiscount) + finalamount));
				System.out.println("Thank you, " + CustomerName + "! Please stop by again!");
				}
			if(drinkTotal < 10){
				final double finalamounts = drinkTotal * tax;
				System.out.println("Discount is:$0");
				System.out.println("Price after discount is:$" + formatter.format(drinkTotal));
				System.out.println("Tax:$" + formatter.format(drinkTotal * tax));
				System.out.println("Total:$" + formatter.format((drinkTotal + finalamounts)));
				System.out.println("Thank you, " + CustomerName + "! Please stop by again!");
				}
				}
	
	
	
	
	
	
}


	
	}
