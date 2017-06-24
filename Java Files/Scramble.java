/*Ish Davis
CS 0401
Scramble Class*/
import java.util.Random;
import java.io.*;
import java.util.Scanner;

public class Scramble
{
	//needs to be a stringbuilder
	private String words;
	private File textFile;
	private Scanner inputFile;
	private StringBuilder realWord;
	private StringBuilder scrambledWord;
	private String scrambledWords;
	
	public Scramble(String j) throws FileNotFoundException
	{
	textFile = new File(j);
			
	inputFile = new Scanner(textFile);
	}
	
	public String getRealWord() throws IllegalStateException                                 
	{
	
	realWord = new StringBuilder();
	
	if(textFile.exists()){
	if(inputFile.hasNext()){
		
		
		realWord.append(inputFile.nextLine());
		words = realWord.toString();
		}
	
	else
	{
	realWord = null;
		if(realWord == null){
		words = null;
		}
	inputFile.close();

	}

	}

	return words;
	}
	
	public String getScrambledWord() 
	{
	scrambledWord = new StringBuilder();
	Random randomGenerator = new Random();
	while(realWord.length() != 0)
	{
	int index = randomGenerator.nextInt(realWord.length());
	char c = realWord.charAt(index);
	scrambledWord.append(c);
	realWord.deleteCharAt(index);
	}
	scrambledWords = scrambledWord.toString();
	return scrambledWords;
	}
}
	
	
