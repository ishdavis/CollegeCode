import java.util.Scanner;
import java.io.*;
public class Lab77
{
	public static void main(String[] args) throws IOException
	{
	
	double sum = 0.0;
	File file = new File("week1salesData.txt");
	Scanner inputFile = new Scanner(file);
	String line = inputReader.nextLine();
	System.out.println(line);
	
	inputReader.close();
	
	
	System.out.println("Welcome to the Weekly Sales Goal Program!");
	int salesGoal = 0;
	Scanner keyboard = new Scanner(System.in);
	System.out.println("Enter the input file name");
	
	System.out.println("Enter your sales goal (in dollars): ");
	salesGoal = keyboard.nextInt();
	
	}
}