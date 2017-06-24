//Ish
import java.util.Scanner;
public class arrayWork
{

	public static void main (String[] args)
	{
	
		double [] numberArray;
		numberArray = new double[20];
		
		numberArray[5] = 25;
		
		System.out.println("Number 5 is " + numberArray[5]);
		
		int i;
		
		int [] myArray = new int [4];
		Scanner keyboard = new Scanner(System.in);
		int userInput;
		
		
			for(i = 0; i < myArray.length; i++)
			{
			System.out.println("Please enter a value for item number: " + (i + 1));
			userInput = keyboard.nextInt();
			myArray[i] = userInput;
			}

			for(int j = 0; j < myArray.length; j++)
			{
			System.out.println("The number you chose for item " + (j + 1) + " was " + myArray[j]);
			}
		
		
		
		
	}
	
}