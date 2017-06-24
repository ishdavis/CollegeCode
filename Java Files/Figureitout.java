/*Ishvaraus Davis
CS 0007
Assignment One*/
import java.util.Scanner;
import java.text.DecimalFormat;
public class Figureitout
{

	public static void main(String[] args)
	{
	
	DecimalFormat formatter = new DecimalFormat("####.00");
	Scanner keyboard = new Scanner(System.in);
	final int drinkChoice = getItemNumber(), drinkQuantity;
	double subTotal, drinkPrice;
	
	
	
	System.out.print("Item # is " + drinkChoice);
	}
	
	public static int getItemNumber()
	{
	Scanner keyboard = new Scanner(System.in);
	final int drinkChoice;
	System.out.println("Please enter the item number: "); //drink choice
	drinkChoice = keyboard.nextInt();
	return drinkChoice;
	}
	
	}