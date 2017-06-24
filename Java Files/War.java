/*Ish Davis
CS 0445
Assignment 1*/
import java.util.*;
import java.io.*;

public class War
{
	public static void main(String[] args)
	{
	
	Scanner keyboard = new Scanner(System.in);
	
	//MultiDS structures
	MultiDS<Card> cardDeck = loadData();
	cardDeck.shuffle();
	MultiDS<Card> player1Discard = new MultiDS<Card>(52);
	MultiDS<Card> player1Hand = new MultiDS<Card>(52);
	MultiDS<Card> player2Discard = new MultiDS<Card>(52);
	MultiDS<Card> player2Hand = new MultiDS<Card>(52);
	int keeper = 1;
	int i;
	for(i = 0; i < 52; i++) //Fill the hands
	{
	player1Hand.addItem(cardDeck.getItem(i));
	player2Hand.addItem(cardDeck.getItem(keeper));
	keeper++;
	keeper++;
	i++;
	}
	
	System.out.println("Welcome to the Game of War! \n Now dealing cards to the players...");
	System.out.println("Here is Player 1's Hand:\n");
	System.out.println(player1Hand.toString());
	System.out.println("Here is Player 2's Hand:\n");
	System.out.println(player2Hand.toString());
	System.out.println("Starting the WAR!");
	//Command Line input
	System.out.println("How many rounds would you like to play?");
	int rounds = Integer.parseInt(args[0]);
	int cardPlayed = 0;
	boolean player1Out = false, player2Out = false;
	do{
		if((player1Hand.empty() == true) && (player1Discard.empty() == false))
		{
			for(int k = 0; k < player1Discard.size(); k++)
			{
			player1Hand.addItem(player1Discard.removeItem());
			}
			player1Hand.shuffle();
			System.out.println("Getting and Shuffling player 1's hand");
		}	
		if((player2Hand.empty() == true) && (player2Discard.empty() == false))
		{
			for(int k = 0; k < player2Discard.size(); k++)
			{
			player2Hand.addItem(player2Discard.removeItem());
			}
			player2Hand.shuffle();
			System.out.println("Getting and Shuffling player 2's hand");

		}	
		player1Out = false;
		if((player1Hand.empty() == true) && (player1Discard.empty() == true))
		{
		player1Out = true;
		}
		else if((player2Hand.empty() == true) && (player2Discard.empty() == true))
		{
		player2Out = true;
		}
		else
		{
		int result = player1Hand.getItem(0).compareTo(player2Hand.getItem(0));
		if (result > 0)
		{
			System.out.println("Player 1 Wins:" + player1Hand.getItem(0) + " beats " + player2Hand.getItem(0));
			Card winCard = player1Hand.removeItem();
			Card loseCard = player2Hand.removeItem();
			player1Discard.addItem(winCard);
			player1Discard.addItem(loseCard);
		}
		else if (result < 0)
		{
			System.out.println("Player 2 Wins:" + player1Hand.getItem(0) + " loses to " + player2Hand.getItem(0));
			Card winCard = player1Hand.removeItem();
			Card loseCard = player2Hand.removeItem();
			player2Discard.addItem(winCard);
			player2Discard.addItem(loseCard);
		}
		else
		{
			//War
			boolean runAgain = false;
			
			do
			{
			if((player1Hand.size() >= 3) && (player2Hand.size() >=3))
			{
			System.out.println("WAR! " + player1Hand.getItem(0) + " ties " + player2Hand.getItem(0));
			Card firstCard = player1Hand.removeItem();
			Card secondCard = player1Hand.removeItem();
			Card firstCard2 = player2Hand.removeItem();
			Card secondCard2 = player2Hand.removeItem();
			System.out.println("Player 1: " + secondCard + " and Player 2: " + secondCard2 + " are at risk");
			int result1 = player1Hand.getItem(0).compareTo(player2Hand.getItem(0));
				if(result1 > 0)
				{
				System.out.println("Player 1 Wins:" + player1Hand.getItem(0) + " beats " + player2Hand.getItem(0));
				Card winCard = player1Hand.removeItem();
				Card loseCard = player2Hand.removeItem();
				player1Discard.addItem(winCard);
				player1Discard.addItem(loseCard);
				player1Discard.addItem(firstCard);
				player1Discard.addItem(secondCard);
				player1Discard.addItem(firstCard2);
				player1Discard.addItem(secondCard2);
				runAgain = false;
				}
				else if(result1 < 0)
				{
				System.out.println("Player 2 Wins:" + player1Hand.getItem(0) + " loses to " + player2Hand.getItem(0));
				Card winCard = player1Hand.removeItem();
				Card loseCard = player2Hand.removeItem();
				player2Discard.addItem(winCard);
				player2Discard.addItem(loseCard);
				player2Discard.addItem(firstCard);
				player2Discard.addItem(secondCard);
				player2Discard.addItem(firstCard2);
				player2Discard.addItem(secondCard2);
				runAgain = false;
				}
				else
				{
				runAgain = true;
				}
				}
				
				//Reshuffle if not enough cards for war
				else
				{
				System.out.println("Not enough cards to war, reshuffling");
				for(int k = 0; k < player1Discard.size(); k++)
				{
				player1Hand.addItem(player1Discard.removeItem());
				}
				player1Hand.shuffle();			
				for(int k = 0; k < player2Discard.size(); k++)
				{
				player2Hand.addItem(player2Discard.removeItem());
				}
				player2Hand.shuffle();
				}
				}while(runAgain == true);
				
		}
		}
	rounds--;	
	}while((rounds != 0) && (player1Out == false) && (player2Out == false));
	//Results
	System.out.println("After " + Integer.parseInt(args[0]) + " rounds here is the status:");
	int end = (player1Hand.size()) + (player1Discard.size());
	int end1 = (player2Hand.size()) + (player2Discard.size());
	System.out.println("\tPlayer 1 has " + end + " cards");
	System.out.println("\tPlayer 2 has " + end1 + " cards");
	if(end > end1)
	{
	System.out.println("Player 1 is the WINNER!");
	}
	else if(end < end1)
	{	
	System.out.println("Player 2 is the WINNER!");
	}
	else
	{
	System.out.println("Player 1 and 2 both have " + end + " cards, it's a DRAW!");
	}
	
	}
	
	public static MultiDS<Card> loadData()
	{
	MultiDS<Card> myCards = new MultiDS<Card>(52);
	int k = 4;
	for(int i = 0; i < 52; i++)
	{
	int j = k % 4;
	k++;
	int l = i % 13;
	Card myCard = new Card(Card.Suits.values()[j], Card.Ranks.values()[l]);
	myCards.addItem(myCard);
	}
	return myCards;
	}
	
	
}