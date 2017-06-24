
import java.util.*;

public class moreArrays
{

	public static void main(String[] args)
	{
	
	int [][] myArray = new int[4][8];
	input(myArray);
	output(myArray);
	
	}
	
	public static void input(int [][] g)
	{
	for(int i = 0; i < g.length; i++)
	{
		for(int j = 0; j < g[i].length; j++)
		{
			g[i][j] = i + j;
			}
		}
	}
	
	public static void output(int [][] p)
	{
	for(int i = 0; i < p.length; i++)
	{
		for(int j = 0; j < p[i].length; j++)
		{
			System.out.print(p[i][j] + "");
			}
			System.out.println();
		}
	}
	
	
}