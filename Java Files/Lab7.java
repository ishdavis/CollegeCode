import java.util.Scanner;
import java.io.*;
import java.in.File;
public class Lab7
{
	public static void main(String[] args) 
	{

		Scanner scan = new Scanner(System.in);
		String filename;
		double salesGoal;
		System.out.println("Enter the filename:");
		filename = scan.next();
		System.out.println("Enter your sales goal: ");
		salesGoal = scan.next();
		
		File file = new File(filename);
		int total = 0;
		
		try{
		
			Scanner scan = new Scanner(file);
			
			while (scanner.hasNextLine()){
				String line = scanner.nextLine();
				total = total + Integer.valueOf(line)
				
			}
		}
		System.out.println("The total is " + total);
		
		if(total => salesGoal){
			System.out.println("You reached the sales goal ");
			}
		if(total <= salesGoal){
			System.out.println("You didn't reach the sales goal ");
			}
			
	catch (FileNotFoundException e) {
		System.out.println("File not found");
		}
		
	}
}
	