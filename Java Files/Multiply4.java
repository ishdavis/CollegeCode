import java.util.Scanner;
public class Multiply4
{
	
	
	public static void main(String[] args){
	
	int number, name;
	Scanner keyboard = new Scanner(System.in);
	System.out.println("Enter an integer value: ");
	number = keyboard.nextInt();
	

	System.out.println("Enter an integer value: ");
	name = keyboard.nextInt();
	
	int product = number * name;
	
	System.out.print("The product is " + product + "\n");
	
	if(product <=100){
		System.out.println("Your product is in the range 0-100");
		
	}
	
	if(product <=0){
		System.out.println("Your product is not in the range 0-100");
		
	}
	
	if(product >100){
		System.out.println("Your product is not in the range 0-100");
		
	}
}
}