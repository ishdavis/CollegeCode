import java.io.*;
import java.util.*;

public class HangPlayer
{
	private String userName;
	private int wins = 0, losses = 0;
	
	
	public HangPlayer(String name)
	{
	userName = name;
	}
	
	public String getUserName()
	{
	return userName;
	}
	
	public int equals(String k, ArrayList<HangPlayer> list)
	{
	int i;
	for (i = 0; i < list.size(); i++)
		{
		String b = list.get(i).getUserName();
			if (b.equalsIgnoreCase(k))
			{
				return i;
				}
		}
		return -1;
	}
	
	
	public void wins(int j)
	{
	wins = j;
	}
	
	public void won()
	{
	wins++;
	}
	
	public void lost()
	{
	losses++;
	}
	
	public void losses(int k)
	{
	losses = k;
	}
	
	public String toString()
	{

		StringBuffer B = new StringBuffer();
		B.append("Username: " + userName + "\n");
		B.append("Wins: " + wins + "\n");
		B.append("losses: " + losses + "\n");
		return B.toString();
	}
	
	public String toStringFile()
	{
		StringBuffer B = new StringBuffer();
		B.append(userName + "\n");
		B.append(wins + "\n");
		B.append(losses + "\n");
		return B.toString();
	}
	
	
	
}