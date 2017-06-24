/*Ishvaraus Davis
CS 0401
Lab3*/

import java.util.Scanner;

public class NewLab3
{

	public static void main(String[] args)
	{
		
		int continuesim = 0;
		
		do{
		
		System.out.println("Please enter an integer base that is greater than 1");
		
		int base, equality;
		
		Scanner keyboard = new Scanner(System.in);
		
		base = keyboard.nextInt();
		
		if (base <= 1) {
		
			System.exit(0);
			
			}
			
		if (base > 1) {
		
			System.out.println("Please enter a positive integer X");
			
			equality = keyboard.nextInt();
			
				while(equality < 0){
				
					System.out.println("Please inter a valid integer");
					
					equality = keyboard.nextInt();
						
						}
				int j = 0;					
					if(equality >= base) {
					int i;
								
				do
				{
								
				equality /= base;
								
				j++;
								

				}while(equality >= base);
																
				}
								
				System.out.println("The answer is " + j);

			} 
								
			System.out.println("If you would like to run again press 1");
					
			continuesim = keyboard.nextInt();
						
			
		}while (continuesim == 1);
	}

}