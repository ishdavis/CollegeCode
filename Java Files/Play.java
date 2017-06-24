import java.util.Scanner;
public class Play

{
	public static void main(String[] args)
	{
	Scanner keyboard = new Scanner(System.in);
	int cool, cooler;
	System.out.print("Please input an integer");
	cool = keyboard.nextInt();
	
	System.out.print("Please input another integer?");
	cooler = keyboard.nextInt();
	
	System.out.print("The product is " + cool * cooler);
	
	boolean highScore;
	int cold = cool * cooler;
	
	if(cold > 100)
		highScore = true;
		
	if(highScore)
		System.out.println("Great score!");
	
	}
	}