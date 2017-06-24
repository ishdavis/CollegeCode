import java.io.*;
import java.util.*;
public class ArrayMethodDemo
{
	public static void main(String[] args)
	{
	double seconds, milliseconds;
	double [] timeArray = new double [5];
	double [] timeArray2 = new double [5];
	fillArray(timeArray, timeArray2);
	for(int i = 0; i < timeArray.length; i++)
	{
	System.out.println(timeArray[i] + "\n" + timeArray2[i]);
	}
	}
	
	public static void fillArray(double [] one, double [] two)
	{
	for(int i = 0; i < one.length; i++)
	{
	one[i] = i + 6;
	two[i] = i + 20;
	}
	}
}