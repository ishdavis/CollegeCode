import java.util.Scanner;

public class learningMethods
{

	public static void main (String[] args) 
	{
	System.out.println("Input an integer");
	Scanner keyboard = new Scanner(System.in);
	int creative;
	creative = keyboard.nextInt();
	System.out.println("What's happening");
	
	if(creative > 10){
		catchAll();
	}
	System.out.println("Nothing");
	if(creative < 10){
		doitRight();
	}
	int nice = 0;
	crazyStuff(nice);
	crazyStuff(10);
	}
	
	public static void catchAll()
	{
	
	System.out.println("No");
	newMethod();
	
	}
	
	public static void doitRight()
	{
	int day = 15, night = 25;
	int evening = day * night;
	System.out.println("30 days and nights " + evening);
	}
	
	public static void newMethod()
	{
	System.out.print("something new i guess");
	}
	public static void crazyStuff(int nice)
	{
	System.out.println("The value is " + nice);
	}
	}
	
