// CS 0401 BatterDB class
// This class is a simple database of Batter objects.  Note the
// instance variables and methods and read the comments carefully.  You minimally
// must implement the methods shown.  You may also need to add some private methods.
// To get you started I have implemented the constructor and the addBatter method for you.

public class BatterDB
{
	private Batter [] theBatters; 	// Array of Batters to store the objects
	private int num;				// int to store logical size of DB

	// Initialize this BatterDB
	public BatterDB(int size)
	{
		theBatters = new Batter[size];
		num = 0;
	}

	// Take already created Batter and add it to the DB.  This is simply putting
	// the new Batter at the end of the array, and incrementing the int to
	// indicate that a new movie has been added.  If no room is left in the 
	// array, resize to double the previous size, then add at the end.  Note that
	// the user never knows that resizing has even occurred, and the resize()
	// method is private so it cannot be called by the user.
	public void addBatter(Batter b)
	{
		if (num == theBatters.length)
			resize(2 * theBatters.length);
		theBatters[num] = b;
		num++;
	}
	
	// Remove and return the Batter that equals() the argument Batter, or
	// return null if the Batter is not found.  You should not leave a gap in
	// the array, so elements after the removed Batter should be shifted over.
	public Batter removeBatter(Batter b)
	{
	for(int i = 0; i < num; i++)
	{
		if(theBatters[i].getName().equalsIgnoreCase(b.getName()))
		{
		b = theBatters[i];
		for(int j = i + 1; j < num; j++)
		{
		theBatters[j-1] = theBatters[j];
		theBatters[num-1] = null;
		}
		}
		else
		{
		b = null;
		}
	}
		return b;
	}
	
	// Return logical size of the DB
	public int numBatters()
	{
	return num;
	}
	
	// Resize the Batter array to that specified by the argument
	private void resize(int newsize)
	{
	
	}

	// Find and return the Batter in the DB matching the first and last
	// names provided.  Return null if not found.
	public Batter findBatter(String fName, String lName)
	{
	for (int i = 0; i < num; i++)
		{
			if (theBatters[i].getName().equalsIgnoreCase(fName))
				return theBatters[i];
		}
		return null;
	}
	
	// Sort the DB alphabetically using the getName() method of Batters for
	// comparison
	public void sortName()
	{
	}
	
	// Sort the DB from high to low using the getAve() method of Batters for
	// comparison
	public void sortAve()
	{
	
	}

	// Return a formatted string containing all of the Batters' info.  Note
	// that to do this you should call the toString() method for each Batter in
	// the DB.
	public String toString()
	{
	StringBuffer B = new StringBuffer();
	B.append("Batter List: \n\n");
	for (int i = 0; i < num; i++)
	B.append(theBatters[i].toString() + "\n");
	return B.toString();
	}

	// Similar to the method above, but now we are not formatting the
	// string, so we can write the data to the file.
	public String toStringFile()
	{
	StringBuffer B = new StringBuffer();
	B.append(num + "\n");
	for (int i = 0; i < num; i++)
	B.append(theBatters[i].toStringFile());
	return B.toString();
	}

}




