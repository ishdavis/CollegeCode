import java.util.Scanner;
import java.util.Random;

public class Lab5
{
	public static void main(String[] args)
	{	
		int answer;			//used to store the random number
		int guess;			//used to store the user's guess
		int diffLevel;		//used to store the user's difficulty level
		int numGuesses = -1;		//used to store the number of guesses remaining
		boolean userWon;	//used to indicate if the user won the game
		
		Scanner keyboard = new Scanner(System.in);
		Random randomGenerator = new Random();
		
		
		
		//Write a statement below to generate a random number in [0-9] and store it
		//in the variable 'answer'
		int answer = randomGenerator.nextInt(10);
		
		//Write some statements below to prompt the user for a difficulty level and
		//store it in the variable 'diffLevel'
		
		System.out.println("Please enter a difficulty level (1-3): ");
		diffLevel = keyboard.nextInt;
		
		//Now that you have the difficulty level, you can use it to determine the number
		//of guesses that the user gets and store this value in 'numGuesses'; to do this,
		//complete the switch block below.
		switch (diffLevel)
		{
			case 1:
				numGuesses = 8;
				System.out.println("You've selected an easy difficulty");
				break;
				
			case 2:
				numGuesses = 5;
				System.out.println("You've selected a medium difficulty");
				break;
				
			case 3:
				numGuesses = 3;
				System.out.println("You've selected a hard difficulty");
				break;
				
		
		}
		
		//At this point, we have the random number stored in 'answer' and we have the number
		//of guesses stored in 'numGuesses', so we are ready to start prompting the user to
		//guess the answer.
		//We will need a loop for this.  Let's use a do-while loop.  The loop should iterate
		//as long as the user has some guesses remaining AND the user did NOT win.
		
		//Initialize the flag variable 'userWon' before we start the game.
		userWon = false;
		
		do
		{
			System.out.println("Number of Guesses remaining is" + numGuesses);
			System.out.println("Guess a number");
			guess = keyboard.nextInt();
			numGuesses--;
			if(guess > answer){
			System.out.println("Too high, please try again");
			}
			//Inside of this loop, you need to:
			else if(guess < answer){
			System.out.println("Too low, please try again");
			}
			else if(guess == answer){
				System.out.println("You win! Thanks for playing.");
				userWon=true;
			}	
			
			//0. display the number of guesses remaining;
			//1. prompt the user to enter a guess;
			//2. store the guess in the variable 'guess';
			//3. decrement the counter 'numGuesses';
			//4. check the user's guess:
			//   (a) if the guess is too high, diplay appropriate message;
			//   (b) if the guess is too low, display appropriate message;
			//   (c) if the guess is correct, set 'userWon' to *true* and
			//       display appropriate message.
		
		
		
		} while(numGuesses > 0 && userWon == false);	//loop while the user has guesses remaining AND the user did NOT win
		
		if(userWon == false){
			System.out.println("You lost. Thanks for playing.");
			}
	}
	
}
