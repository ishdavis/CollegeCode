/*Ishvaraus Davis
CS 0007
Assignment One*/
import java.util.Scanner;
import java.text.DecimalFormat;
public class Bull
{

	public static void main(String[] args)
{
	
	DecimalFormat formatter = new DecimalFormat("####.00");
	Scanner keyboard = new Scanner(System.in);
	displayMenu();
	final int drinkChoice, drinkQuantity;
	double subTotal, drinkPrice;
	
	computeSubTotal();
	
}
	
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
	
	public static int getItemNumber()
	{
	Scanner keyboard = new Scanner(System.in);
	final int drinkChoice;
	System.out.println("Please enter the item number: "); //drink choice
	drinkChoice = keyboard.nextInt();
	return drinkChoice;
	}
	
	public static int getQuantity()
	{
	
	Scanner keyboard = new Scanner(System.in);
	final int drinkQuantity;
	System.out.println("Please enter the quantity: "); //drink quantity
	drinkQuantity = keyboard.nextInt();
	return drinkQuantity;
	}
	
	public static void computeSubTotal(double subTotal)
	{
	
	final int drinkChoice = getItemNumber(), drinkQuantity = getQuantity();
	double drinkPrice = 0;
	
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
	System.out.println("The subtotal is " + subTotal);
	}
	
	
	
	
	
	}