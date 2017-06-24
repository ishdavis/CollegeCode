/*Ish Davis
Batter Class*/
import java.util.*;
public class Batter
{

	private String firstName;
	private String lastName;
	private int atBats, hits, singles, doubles, triples, homeRuns;
	
	
	public Batter(String fname, String lname)
	{
	firstName = fname;
	lastName = lname;
	}
	
	public void setBats(int b)
	{
	atBats = b;
	}
	
	public void setHits(int h)
	{
	hits = h;
	}
	
	public void setSingles(int s)
	{
	singles = s;
	}
	
	public void setDoubles(int d)
	{
	doubles = d;
	}
	
	public void setTriples(int t)
	{
	triples = t;
	}
	
	public void setHR(int hr)
	{
	homeRuns = hr;
	}
	
	public double getAve()
	{
	double average =(double) hits / atBats;
	return average;
	}
	
	public String getName()
	{
	StringBuffer B = new StringBuffer();
	B.append(lastName + ", " + firstName);
	return B.toString();
	}
	
	public boolean equals(Batter current)
	{
	String playerName = current.getName();
	boolean right;
	if(playerName.equals(firstName) && playerName.equals(lastName))
	{
	right = true;
	}
	else
	{
	right = false;
	}
	return right;
	}
	
	
	public String toString()
	{
	StringBuffer B = new StringBuffer();
		B.append("Player: " + firstName + " " + lastName +"\n");
		B.append("At Bats: " + atBats + "\n");
		B.append("Hits: " + hits + "\n");
		B.append("\tSingles: " + singles + "\n");
		B.append("\tDoubles: " + doubles + "\n");
		B.append("\tTriples: " + triples + "\n");
		B.append("\tHR: " + homeRuns + "\n");
		B.append("Average: " + getAve() + "\n");
		
		return B.toString();
	}
	
	public String toStringFile()
	{
	StringBuffer B = new StringBuffer();
		B.append(firstName + "\n");
		B.append(lastName + "\n");
		B.append(atBats + "\n");
		B.append(hits + "\n");
		B.append(singles + "\n");
		B.append(doubles + "\n");
		B.append(triples + "\n");
		B.append(homeRuns + "\n");
		return B.toString();
	}
}
	