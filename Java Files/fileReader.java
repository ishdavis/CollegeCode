import java.util.Scanner;
import java.io.*;
public class fileReader
{

	public static void main (String[] args) throws IOException
	{
	
	File myFile = new File("words.txt");
			
			Scanner inputFile = new Scanner(myFile);
			
			//reading the text from the file
			if(myFile.exists())
			{
				
				while (inputFile.hasNext())
				{
				
					String CustomerName = inputFile.nextLine();
					System.out.println(CustomerName);
					
				}
				inputFile.close();
	}
			
	}
	
}

{
	textFile = new File(j);
			
	inputFile = new Scanner(textFile);
	}
	
	public String getRealWord() throws IllegalStateException                                 
	{
	
	if(textFile.exists()){
	if(inputFile.hasNext()){
		
				
		words = inputFile.nextLine();

		}
	
	else
	{
	words = null;
	}

	}

	return words;
	}
	
	public String getScrambledWord() 
	{
	scrambledWords = words;
	Random randomGenerator = new Random();
	wordScramble = randomGenerator.nextInt(6);
	int
	return scrambledWords;
	}