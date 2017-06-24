

public class Crate implements Comparable<Crate>
{
	private int expDate, initialCount, currentCount;
	private double cost;
	
	public Crate(int date, int firstCount, double costs)
	{
	expDate = date;
	initialCount = firstCount;
	cost = costs;
	currentCount = firstCount;
	}
	
	public int getDate()
	{
	return expDate;
	}
	
	public int initCount()
	{
	return initialCount;
	}
	
	public int currentCount()
	{
	return currentCount;
	}
	
	public double getCost()
	{
	return cost;
	}
	
	public int useBanana(int k)
	{
		if(currentCount > k)
		{
		return 1;
		}
		else if(currentCount == k)
		{
		return 0;
		}
		else
		{
		return -1;
		}
	}
	
	public void deleteBanana(int j)
	{
	currentCount -= j;
	}
	
	public String toString()
	{
	StringBuilder s = new StringBuilder();
	s.append("Expires:" + expDate);
	s.append(" Start Count:" + initialCount);
	s.append(" Remain:" + currentCount);
	s.append(" Cost:" + cost);
	return s.toString();
	}
	
	public int compareTo(Crate otherCrate)
	{
		if(expDate < otherCrate.getDate())
		{
		return 1;
		}
		else if(expDate > otherCrate.getDate())
		{
		return -1;
		}
		else
		{
		return 0;
		}
	}

}
	
	
	
	
	