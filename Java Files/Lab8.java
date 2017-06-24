import java.util.Scanner;
import java.util.Random;

public class Lab8
{
	public static void main(String[] args)
	{
		int numCoinTosses;
		
		System.out.println("Welcome to the Coin-Toss Simulator!");
		System.out.println();
		
		numCoinTosses = getNumTosses();
		simulateNTosses(numCoinTosses);
		// TODO: Call simulateNTosses, passing
		// numCoinTosses as the argument.
		
		System.out.println("Goodbye!");
	}
	
	public static int getNumTosses()
	{
		Scanner keyboard = new Scanner(System.in);
		int numCoinTosses;
		
		System.out.println("How many tosses would you like to perform ");
		numCoinTosses = keyboard.nextInt();
		return numCoinTosses;
		// TODO: Prompt user for number of tosses,
		// store this value in numTosses, and then
		// return numTosses.

	}
	
	public static void simulateNTosses(int n)
	{
		int tossResult;
		
		tossResult = simulateToss();
		for (int i = 1; i <= n; i++)
		{
			System.out.println("Toss " + i + ": " + tossResult);
			
			// TODO: Call simulateToss() and store its
			// return value in the tossResult.  Then
			// print the toss number and toss result.
		}
	}
	
	public static int simulateToss()
	{
		int tossSimulate;
		Random randomGenerator = new Random();
		tossSimulate = randomGenerator.nextInt(2);
		if(tossSimulate == 0) {
			System.out.println("Heads");
			}
		if(tossSimulate == 1) {
			System.out.println("Tails");
			}
		return tossSimulate;

	}
}
