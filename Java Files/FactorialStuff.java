
public class FactorialStuff
{

	public static void main(String[] args)
	{
	int [] myArray = new int[10];
	for(int i = 0; i < myArray.length; i++)
	{
	myArray[i] = (i*8) % 5;
	System.out.print(myArray[i]);
	}
	Sort(myArray);
	System.out.print("\n");
	for(int i = 0; i < myArray.length; i++)
	{
	System.out.print(myArray[i]);
	}
	}
	
	public static void Sort(int[] thisArray)
	{
	for(int i = thisArray.length - 1; i >= 0; i--)
	{
		for(int j = 1;j <= i; j++)
		{
			if(thisArray[j-1] > thisArray[j])
			{
			int temp = thisArray[j];
			thisArray[j] = thisArray[j-1];
			thisArray[j-1] = temp;
			}
		}
	}
	
	}
}
	
