/*Ish Davis
CS 0401
*/
import java.util.Scanner;

public class NewLab6
{
	static double maxNumber, minNumber, average, total;
	
	public static void main(String[] args)
	{
	Scanner keyboard = new Scanner(System.in);

	int number1;
	System.out.println("How many Items would you like to enter?");
	number1 = keyboard.nextInt();
	
	double [] myArray = new double [number1]; //The array
	double arrayOption; //User Input
	
	for(int i = 0; i < myArray.length; i++){
	System.out.println("Please enter a number for spot number " + i);
	arrayOption = keyboard.nextDouble();
	myArray[i] = arrayOption;
	}
	
	maxNumber = myArray[0];
	minNumber = myArray[0];
	total = myArray[0];
	average = myArray[0];
	double theMaximum = max(myArray, 0);
	double theMinimum = min(myArray, 0);
	double totals = sum(myArray, 0);
	double theAverage = ave(myArray, 0);
	
	System.out.println("The maximum number is: " + theMaximum);
	System.out.println("The minimum number is: " + theMinimum);
	System.out.println("The sum is: " + totals);
	System.out.println("The average is: " + theAverage);

	
	}
	
	public static double max(double [] data, int k) 
	{
	if(k == (data.length - 1))
	{
	return maxNumber;
	}
	else
	{
	if(data[k + 1] > maxNumber){
			maxNumber = data[k + 1];
		}
	return max(data, k + 1);
	}
	
	}
	
	public static double min(double [] data, int k)
	{
	if(k == (data.length - 1))
	{
	return minNumber;
	}
	else
	{
	if(data[k + 1] < minNumber){
			minNumber = data[k + 1];
		}
	return min(data, k + 1);
	}
	}
	
	public static double sum(double [] data, int k)
	{
	if(k == (data.length - 1))
	{
	return total;
	}
	else
	{
	total += data[k + 1];
	return sum(data, k + 1);
	}
	}
	
	public static double ave(double [] data, int l)
	{
	if(l == (data.length - 1))
	{
	return (average / data.length);
	}
	else
	{
	average += data[l + 1];
	return ave(data, l + 1);
	}
	}
	
}


