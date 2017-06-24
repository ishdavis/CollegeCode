import java.util.Scanner;

public class VolumeCalculator
{

	public static int getDimension()
	{
		int dim;
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Enter a dimension: ");
		dim = keyboard.nextInt();
		
		return dim;
	}
	
	public static int calculateVolume(int d1, int d2, int d3)
	{
		
		
		return d1 * d2 * d3;
		
	}
	
	public static void displayVolume(int d1, int d2, int d3, int volume)
	{
	
		System.out.println("The volume of the solid is ");
		System.out.printf("%d units x %d units x %d unites = %d units^3",
		+ d1, d2, d3, volume);
		
	}	
	
	public static void main(String[] args)
	{
		int dim1, dim2, dim3, volume;
		
		//Get input
		System.out.print("Enter a dimension: ");
		dim1 = getDimension();
		
		System.out.print("Enter a dimension: ");
		dim2 = getDimension();
		
		System.out.print("Enter a dimension: ");
		dim3 = getDimension();
		
		volume = calculateVolume(dim1, dim2, dim3);
		
		displayVolume(dim1, dim2, dim3, volume);
		
	}
	
}
		