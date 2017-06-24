/*Ishvaraus Davis
CS 0007
Assignment One*/
import java.util.Scanner;
import java.text.DecimalFormat;
public class CoffeeShopWithMethods2
{

	static int drinkChoice, drinkQuantity, j;
	static double h;
	
	public static void main(String[] args)
{
	//Menu
	displayMenu();
	
	//User Input
	Scanner keyboard = new Scanner(System.in);
	System.out.println("Please enter the item number: ");
	int j = keyboard.nextInt();
	int drinkChoice = getItemNumber(j);
	System.out.println("Please enter the quantity: ");
	double h = keyboard.nextInt();
	int drinkQuantity = getQuantity(h);
	double e;
	double SubTotal = computeSubTotal(e);

	//Output
	displayOutput();
	
}
	//Menu
	public static void displayMenu()
	{
	
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
	
	}
	
	//Item Choice
	public static int getItemNumber(int n)
	{
	 //drink choice
	drinkChoice = n;
	return drinkChoice;
	}
	
	//Quantity Choice
	public static int getQuantity(int k)
	{
	
	 //drink quantity
	drinkQuantity = k;
	return drinkQuantity;
	}
	
	//SubTotal
	public static double computeSubTotal(double h)
	{
	
	double drinkPrice = 0;
	int drinkChoice = getItemNumber(j);
	double drinkQuantity = getQuantity(h);
	if(drinkChoice ==1) {
		drinkPrice = 1.50;
	}
	
	if(drinkChoice ==2) {
		drinkPrice = 3.50;
	}
	
	if(drinkChoice ==3) {
		drinkPrice = 3.25;
	}
	
	if(drinkChoice ==4) {
		drinkPrice = 2.00;
	}
	
	double subTotal = drinkQuantity * drinkPrice;
	return subTotal;
	}
	
	//Check to see if user gets discount
	public static boolean discountCheck()
	{
	double subTotal = computeSubTotal();
	boolean discountCheck = false;
	if(subTotal > 10){
		discountCheck = true;
		}
	if(subTotal < 10){
		discountCheck = false;
		}
	return discountCheck;
	}
	
	//Compute the actual discount
	public static double computeDiscount()
	{
	boolean discountCheck = discountCheck();
	double subTotal = computeSubTotal(), tenth = .1, discount = 0;
	if(discountCheck == true){
		discount = subTotal * tenth;
		}
	if(discountCheck == false){
		discount = 0;
		}
	return discount;
	}
	
	//Subtract discount from subtotal
	public static double computePriceAfterDiscount()
	{
	double subTotal = computeSubTotal(), discount = computeDiscount(), newTotal = subTotal - discount;
	return newTotal;
	}
	
	//Determine the tax amount
	public static double computeTax()
	{
	final double tax = .07;
	double newTotal = computePriceAfterDiscount(), taxAmount = tax * newTotal;
	return taxAmount;
	}
	
	//Compute the final total
	public static double computeTotal()
	{
	double taxAmount = computeTax(), subTotal = computeSubTotal(), discount = computeDiscount(), lastTotal = subTotal - discount + taxAmount;
	return lastTotal;
	}
	
	//Output to the User
	public static void displayOutput()
	{
	DecimalFormat formatter = new DecimalFormat("####.00");
	double subTotal = computeSubTotal(), discount = computeDiscount(), priceAfterDiscount = computePriceAfterDiscount();
	double tax = computeTax(), finalTotal = computeTotal();
	
	System.out.println("The subtotal is: $" + formatter.format(subTotal));
	System.out.println("The discount amount is: $" + formatter.format(discount));
	System.out.println("The price after discount is: $" + formatter.format(priceAfterDiscount));
	System.out.println("The tax amount is: $" + formatter.format(tax));
	System.out.println("The final total is: $" + formatter.format(finalTotal));
	}
	
	}