import java.util.Scanner;

public class Lab6
{
	public static void main(String[] args)
	{
		
		int num1, num2, sum, product;
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Please enter an integer: ");
		num1 = keyboard.nextInt();
		
		System.out.println("Please enter another integer: ");
		num2 = keyboard.nextInt();
		
		computeSum(num1, num2);
		computeProduct(num1, num2);
		
		
		
	}
	public static void computeSum(int one, int two)
	{
	int sum = 0;
	sum = one + two;
	System.out.println("sum = " + sum);
	}
	public static void computeProduct(int one, int two)
	{
	int product = 0;
	product = one * two;
	System.out.println("product = " + product);
	}
	}
	
