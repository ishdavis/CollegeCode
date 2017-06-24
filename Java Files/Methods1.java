import java.util.Random;
import java.util.Scanner;

public class Methods1
{
	public static void main(String[] args)
	{
		int randomNumber, guess;
		
		Random randomNumbers = new Random();
		Scanner keyboard = new Scanner(System.in);
		
		randomNumber = randomNumbers.nextInt(20) + 1;
		
		System.out.print("Enter a guess: ");
		guess = keyboard.nextInt();
		
		if (guess < randomNumber)
			lessThanAnswer();
		else if (guess > randomNumber)
			greaterThanAnswer();
		else
			youWin();
			
		System.out.println("The random number is: " + randomNumber);
	}
	
	public static void lessThanAnswer()
	{
		System.out.println("Your guess is too low.");
	}
	
	public static void greaterThanAnswer()
	{
		System.out.println("Your guess is too high.");
	}
	
	public static void youWin()
	{
		System.out.println("You win!");
	}
}	