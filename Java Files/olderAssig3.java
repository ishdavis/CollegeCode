/*Ishvaraus Davis
CS 0401
Assignment Three*/
//Extra Credit: Allow user one try to guess the entire word at any point during the round
import java.io.*;
import java.util.*;
import java.util.ArrayList;

public class olderAssig3
{

	public static void main(String[] args)throws IOException
	{
	
	ArrayList<HangPlayer> players = loadData();
	
	Scanner keyboard = new Scanner(System.in);
	
	//input data
	System.out.println("Welcome to the HangMan Game!!");
	System.out.println("What is your name? (Enter 'q' to quit)");
	String userName = keyboard.nextLine();
	String endGame = "q";
	HangPlayer p = new HangPlayer(userName);
	int output = 0;
	if(userName.equalsIgnoreCase(endGame))
	{
	System.exit(0);
	}
	
	//Check if user has already played
	int userPlayed = p.equals(userName, players);
	if(userPlayed == -1)
	{
	HangPlayer currentPlayer = new HangPlayer(userName);
	players.add(currentPlayer);
	output = players.size() - 1;
	System.out.println("Welcome " + userName + ". Glad you could join us!!"
	+ "\nGuess letters so that you can figure out the secret word.\nYou have 7 guesses for each word.\nGood luck!!");
	}
	else
	{
	System.out.println("\nWelcome back " + userName + "\n\nHere are your results so far\n");
	
	System.out.print(players.get(userPlayed));
	}
	//Get data from a file
	WordServer server = new WordServer();
	System.out.println("Please input the name of the text file. (Remember to include the .txt)");
	String fName = keyboard.nextLine();
	Scanner fScan = new Scanner(new FileInputStream(fName));
	server.loadWords(fScan);
	String word;
	Character loop;
	do{ //beginning of the game
	System.out.println("*New Word*\n");
	int i = 0;
	char line = "_".charAt(0);
	char no = "_".charAt(0);
	word = server.getNextWord();
	StringBuilder guessedWords = new StringBuilder(word.length());
	StringBuilder guessedLetters = new StringBuilder();
	loop = new Character(no);
	for(int k = 0; k < word.length(); k++)
	{
	guessedWords.append(line);
	}
	int timesLeft = 7;
	do
	{
	System.out.println("\nYour word is: " + guessedWords);
	
	System.out.println("You have " + timesLeft + " misses left");
	System.out.println("So far you have guessed: " + guessedLetters);
	System.out.println("Please make a guess:\n(enter 0 to quit this word)\n(enter 1 to quit the game)\n(enter 2 to guess the full word)");
	
	char guess = keyboard.next().charAt(0);
	loop = guess;
	int y = 0;
	boolean stop = false;
	for(int r = 0; r < guessedLetters.length(); r++)
	{
		if(loop == guessedLetters.charAt(r))
		{
		stop = true;
		System.out.println("You've already guessed this letter");
		}
	}

		guessedLetters.append(guess);

		boolean guessedWord = false;

		for(int j = 0; j < word.length(); j++)
		{
		if((guess == (word.charAt(j))))
		{
		guessedWords.setCharAt(j, guess);
		guessedWord = true;
		int check = 0;
		check++;
		if(check < 1)
		{
		System.out.println("Good job, see where " + guess + " is printed below");
		}
		}
		}
		if(guessedWord == false)
		{
		i++;
		if((!loop.toString().equals("1")) && (!loop.toString().equals("0")) && (!loop.toString().equals("2")))
		{
		System.out.println("Sorry but " + guess + " is not in the word");
		}
		if(stop == false)
		{
		timesLeft--;
		}
		}
		if(i >= 7)
		{
		System.out.println("The correct word is " + word);
		System.out.println("Better luck next time");
			if(userPlayed == -1)
			{
			players.get(output).lost();
			}
			else
			{
			players.get(userPlayed).lost();
			}
		}
		if(guessedWords.toString().equalsIgnoreCase(word))
		{
		System.out.println("Congratulations! You got it!");
		i = 7;
			if(userPlayed == -1)
			{
			players.get(output).won();
			}
			else
			{
			players.get(userPlayed).won();
			}
		}
		
		if(loop.toString().equals("0"))
		{
			if(userPlayed == -1)
			{
			players.get(output).lost();
			}
			else
			{
			players.get(userPlayed).lost();
			}
		}
		
		if(loop.toString().equals("1"))
		{
			if(guessedLetters.length() == 1)
			{
			}
			else{
			if(userPlayed == -1)
			{
			players.get(output).lost();
			}
			else
			{
			players.get(userPlayed).lost();
			}
			}
		}
		
		if(loop.toString().equals("2"))
		{
			System.out.println("Please guess the entire word, you get only one chance");
			String guesser = keyboard.next();
			
				if(guesser.equals(word))
				{
				System.out.println("That is correct");
				if(userPlayed == -1)
				{
				players.get(output).won();
				}
				else
				{
				players.get(userPlayed).won();
				}	
				}
				else
				{
				System.out.println("Sorry that is incorrect");
				if(userPlayed == -1)
				{
				players.get(output).lost();
				}
				else
				{
				players.get(userPlayed).lost();
				}
				}
		}
	}while((i < 7) && (!loop.toString().equals("1")) && (!loop.toString().equals("0")) && (!loop.toString().equals("2")));
	
	}while((word != "") && (!loop.toString().equals("1")));
	//end of the game
	System.out.println("Final Results for " + userName);
	if(userPlayed == -1)
	{
	System.out.println(players.get(output));
	}
	else
	{
	System.out.print(players.get(userPlayed));
	}
	//print out the scores
	
	StringBuffer print = new StringBuffer();
	for(int q = 0; q < players.size(); q++)
	{
	print.append(players.get(q).toStringFile());	
	}

	FileWriter fwriter = new FileWriter("players.txt", false);
			
	PrintWriter outputFile = new PrintWriter(fwriter);
						
	outputFile.print(print.toString());
	
	outputFile.close();
	//add scores to file
	
}
	// fill the array
	public static ArrayList<HangPlayer> loadData()throws IOException
	{
	ArrayList<HangPlayer> players = new ArrayList<HangPlayer>();
	
	File textFile = new File("players.txt");
			
	Scanner newFile = new Scanner(textFile);
	
	do
	{
	String j = newFile.next();
	int i = newFile.nextInt();
	int k = newFile.nextInt();
	
	HangPlayer newPlayer = new HangPlayer(j);
	newPlayer.wins(i);
	newPlayer.losses(k);
	int l = 0;
	
	players.add(l, newPlayer);
	l++;
	}while(newFile.hasNext());
	newFile.close();
	return players;
	}
	
}