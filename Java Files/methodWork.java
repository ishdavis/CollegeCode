import java.util.Scanner;
import java.util.Random;

public class methodWork
{

	static double income;
	public static void main(String[] args)
	{
	Scanner keyboard = new Scanner(System.in);
	System.out.println("How many times would you like to roll the die");
	int j = keyboard.nextInt();
	Random randomGenerator = new Random();
	int randomNum = randomGenerator.nextInt(11) + 2;
	int diceRolls = RollDice(j);
	System.out.println("The dice rolls equal" + diceRolls);
	System.out.println("How much do you make per year");
	income = keyboard.nextInt();
	double taxRate1 = Taxes(income);
	System.out.println("The tax rate is " + taxRate1);
	boolean k = false;
	boolean h = isitTrue(k);
		if(h == true){
			System.out.println("Yes");
			}
			
		if(h == false){
			System.out.println("No");
			}
	
	writeIt();
	int yeah = 10;
	doSomething(yeah);
	
	}
	
	public static int RollDice(int n)
	{
	
	int answer = 5 * n;
	
	return answer;
	}
	
	public static double Taxes(double k)
	{
	
	double taxRate = k * .2;
	
	return taxRate;
	
	}
	
	public static boolean isitTrue(boolean i)
	{
		double l = Taxes(income);
		
		if(l > 3000) {
			
			i = true;
			
		}
		
		if(l < 3000) {
		
			i = false;
			
		}
	
	boolean j = i;
	
	return j;
	}
	
	public static void writeIt()
	{
		System.out.print("This is really cool");
		int j = 5, h = 8, i = 25;
		int answer = j * 5;
		System.out.println("answer is " + answer);
	}
	
	public static void doSomething(int l)
	{
	
	System.out.println("This is going to do something");
	int right = l * 5;
	System.out.println("does this work? " + right);
	
	}
}
