import java.io.*;
import java.util.*;


public class fixing
{
	public static void main(String[] args)throws IOException
	{


		String fileName = "lol.txt";
		File textFile = new File(fileName);
		Scanner newFile = new Scanner(textFile);
		int q = newFile.nextInt();
		StringBuilder m = new StringBuilder();

		for(int k = 0; k < q + 1; k++)
			{
			m.append(newFile.next());
			System.out.println(m.toString());
			}
		

	}
	
}