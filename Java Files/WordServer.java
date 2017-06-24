//Word class
import java.io.*;
import java.util.*;
import java.util.Random;


public class WordServer{
	
	private String [] words;
	private int [] chosenWords;
	private int numPlayers = 0, prevNumber = 0;
	private Random randomGenerator;
	private String newWord;
	private int loopControl = 0;
	private boolean statement = true;
	
	public WordServer()
	{
	}
	
	//Finished
	public void loadWords(Scanner S)throws IOException
	{
	numPlayers = S.nextInt();
	words = new String[numPlayers];
	chosenWords = new int[numPlayers];
	for(int i = 0; i < words.length; i++)
	{
	String newWord = S.next();
	words[i] = newWord;
	}
	
	}
	
	//Finish this
	public String getNextWord()
	{
	
	boolean found = false;
	String s = "";
	if(loopControl < chosenWords.length)
	{
	randomGenerator = new Random();
	int wordChoice = randomGenerator.nextInt(numPlayers);
	int i = 0;
	do
	{
	if(wordChoice == chosenWords[i])
	{
	i = 0;
	wordChoice = randomGenerator.nextInt(numPlayers);
	}
	i++;
	}while(i < words.length);
	
	s = words[wordChoice];
	chosenWords[loopControl] = wordChoice;
	loopControl++;
	}
	if(loopControl > (chosenWords.length))
	{
	s = "";
	}
	
	return s;
	
	}
	
	}
	
	
	
	
	
