import java.util.Scanner;
public class Lab3

	{public static void main(String[] args){
	
	//Variables for books and points
	int numBooks = -1, points = -1;
	
	//Welcome message
	System.out.println("Welcome! How many books did you buy this month?");
	
	Scanner scan = new Scanner(System.in);
	
	//Get user input
	numBooks = scan.nextInt();
	
	if(numBooks ==0 ){
		points = 0 ;
	
	}
	else if(numBooks == 1){
		points = 5;
	
	}
	else if(numBooks == 2){
		points = 15;
	}
	else if(numBooks == 3){
		points = 30;
	}
	else if(numBooks > 4){
		points = 60;
	}
	
	
System.out.println("You have earned " + points + " points!");}

}
	
	
	
	
	
	


