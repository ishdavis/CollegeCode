import java.util.Scanner;
import java.util.Random;

public class NewLab4
{
	
	
	public static void main(String[] args)
	{
	
	int continueSim = 0;			//User Controlled
	do
	{
	System.out.println("How many times would you like to roll the die");
	
	Scanner keyboard = new Scanner(System.in);
	
	int diceRoll = 0;				
	
	diceRoll = keyboard.nextInt();
	
	Random randomGenerator = new Random();

	RollDice(diceRoll, randomGenerator);
	
	System.out.println("Would you like to run the simulator again? Press 1 to Redo");
	
	continueSim = keyboard.nextInt();
	}while(continueSim == 1);		//Continue Running
	}
	
	public static void RollDice(int j, Random Q)
	{
		Random randomGenerator = new Random();
		double twos = 0, threes = 0, fours = 0, fives = 0, sixes = 0, sevens = 0, eights = 0, nines = 0, tens = 0, elevens = 0, twelves = 0;
		for(int z = 1; z <= j; z++) 				//loop through as many times as user wants
		{
			j = Q.nextInt(11) + 2;
			System.out.println("Dice roll is " + j);
			
			if(j == 2){
				twos++;
				}
				
			if(j == 3){
				threes++;
				}
			
			if(j == 4){
				fours++;
				}
				
			if(j == 5){
				fives++;
				}
				
			if(j == 6){
				sixes++;
				}
			
			if(j == 7){
				sevens++;
				}
				
			if(j == 8){
				eights++;
				}
				
			if(j == 9){
				nines++;
				}
				
			if(j == 10){
				tens++;
				}
				
			if(j == 11){
				elevens++;
				}
				
			if(j == 12){
				twelves++;
				}
		}
	
		System.out.println("Twos: " + twos + "\nThrees: " + threes + "\nFours: " + fours + "\nFives: " + fives + "\nSixes: " + sixes + "\nSevens: "
		+ sevens + "\nEights: " + eights + "\nNines: " + nines + "\nTens: " + tens + "\nElevens: " + elevens + "\nTwelves: " + twelves + "");
		
		double fracTwos = twos / j * 100, fracThrees = threes / j * 100, fracFours = fours / j * 100, fracFives = fives / j * 100, fracSixes = sixes / j * 100, fracSevens = sevens / j * 100;
		double fracEights = eights / j * 100, fracNines = nines / j * 100, fracTens = tens / j * 100, fracElevens = elevens / j * 100, fracTwelves = twelves / j * 100;
		
		
		System.out.println("Percent of Twos: " + fracTwos + "%\nPercent of Threes: " + fracThrees + "%\nPercent of Fours: " + fracFours + "%\nPercent of Fives: " + fracFives + "%\nPercent of Sixes: " + fracSixes + "%\nPercent of Sevens: "
		+ fracSevens + "%\nPercent of Eights: " + fracEights + "%\nPercent of Nines: " + fracNines + "%\nPercent of Tens: " + fracTens + "%\nPercent of Elevens: " + fracElevens + "%\nPercent of Twelves: " + fracTwelves + "%");
		}
}
	