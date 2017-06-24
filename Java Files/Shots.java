import java.util.Scanner;
public class Then
{
	public static void main(String[] args){
	
	int attempts = 10, makes = 15;
	
	System.out.println("Hello, how many shots did you take?");
	
	Scanner scan = new Scanner(System.in);
	
	attempts = scan.nextInt();
	
	if(attempts == 0 ){
		makes = 0;
		
	}
	
	else if(attempts ==2 ){
		makes = 2;
	
	}
	
	else if(attempts >=8){
		makes = 5;
	
	}
	
	System.out.print("You made " + makes + "shots");
	}
}