// CS 0401 Fall 2014
// Lab 10
// You must modify this file so that it works as described in the lab handout.
import java.util.*;
import java.io.*;
public class lab10
{
	public static void main(String [] args)
	{
		Scanner inScan, fScan = null;
		int [] A = new int[5];
		inScan = new Scanner(System.in);
		boolean bool;
		do
		{
			bool = true;
			System.out.println("Please enter the file to read from: ");
			
			try
			{
			String fName = inScan.nextLine();
			fScan = new Scanner(new File(fName));
			}
			
			catch(IOException l)
			{
			bool = false;
			}
			
		}while(bool == false);
		
		String nextItem = "";
		int nextInt = 0;
		int i = 0;
		boolean tryIt = false;
		
		while (fScan.hasNextLine())
		{	
			try
			{
				boolean runIt = false;
				try
				{
				nextItem = fScan.nextLine();
				nextInt = Integer.parseInt(nextItem);
				}
				catch(NumberFormatException m)
				{
				System.out.println(nextItem + " is not an integer -- ignored");
				runIt = true;
				}
				if(runIt != true)
				{
				A[i] = nextInt;
				i++;
				}
				}
				catch(ArrayIndexOutOfBoundsException p)
				{
				if(tryIt == false)
				{
				int k = A.length * 2;
				int [] temp = new int[k];
				for (int g = 0; g < A.length; g++)
				{
				temp[g] = A[g];		
				}
				System.out.println("Resizing Array from 5 to " + k);
				A = temp;
				A[5] = nextInt;
				i++;
				tryIt = true;
				}
				else
				{
				int l = 20;
				int [] temp2 = new int[l];
				for (int r = 0; r < A.length; r++)
				{
				temp2[r] = A[r];
				}
				A = temp2;
				System.out.println("Resizing Array from 10 to " + l);
				A[10] = nextInt;
				i++;
			}
			}	
			
		}
		

		System.out.println("Here are your " + i + " items:");
		for (int j = 0; j < i; j++)
		{
			System.out.println(A[j] + " ");
		}
	}
}


