import java.util.*;


public class recursionWork
{
	public static void main(String[] args)
	{
	System.out.println("Enter number of iterations");
	Scanner keyboard = new Scanner(System.in);
	int j = keyboard.nextInt();
	int q = factorial(j);
	System.out.println(q);
	}
	
	public static int factorial(int i)
	{
		if(i == 1)
		{
		return 1;
		}
		else
		{
		return i * factorial(i-1);
		}
		
	}
	
}
	