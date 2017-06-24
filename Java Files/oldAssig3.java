import java.util.*;
import java.io.*;

// CS 0401 Fall 2013.  Assignment 3 main program class.  Note how this class is set up
// with instance variables and methods.  The idea is that the main program is itself an
// object and the methods being called are parts of the object that implement the various
// requirements.  I have implemented the initial reading of the data from the file to
// get you started.  You must add the menu and all of its required functionality.

// Note that this program WILL NOT COMPILE until you have completed the Batter and BatterDB
// classes to some extent.  They do not have to be totally working but all of the methods
// used here must be implemented in order for this code to compile.

public class oldAssig3
{
	private BatterDB theDB;
	private Batter currBatter;
	private Scanner inScan;
	private String fName;

	// Note how this method is working.  It first reads the number of Batters from the
	// file, then for each Batter it gets the names, creates the object, and mutates it
	// with the instance methods shown.  Finally, it adds the new object to the BatterDB
	// object.
	public void getBatters(String fName) throws IOException
	{
		Batter currB;
		File inFile = new File(fName);
		Scanner inScan = new Scanner(inFile);
		int numBatters = inScan.nextInt();
		inScan.nextLine();
		for (int i = 0; i < numBatters; i++)
		{
			String first = inScan.nextLine();
			String last = inScan.nextLine();
			currB = new Batter(first, last);

			int ab, h, d, t, hr;	
			ab = inScan.nextInt();  inScan.nextLine();
			currB.setBats(ab);
			h = inScan.nextInt();	inScan.nextLine();
			currB.setHits(h);
			d = inScan.nextInt();	inScan.nextLine();
			currB.setDoubles(d);
			t = inScan.nextInt();	inScan.nextLine();
			currB.setTriples(t);
			hr = inScan.nextInt();	inScan.nextLine();
			currB.setHR(hr);
			theDB.addBatter(currB);
		}
	}
	
	// Constructor is really where the execution begins.  Initialize the
	// database (done for you) and then go into the main interactive loop (you
	// must add this code).
	public Assig3(String fstring) throws IOException
	{
		fName = fstring;
		theDB = new BatterDB(2);
		getBatters(fName);
		System.out.println("The database has been loaded");
		System.out.println(theDB.toString());
	}	
	

	
	// Note that the main method here is simply creating an Assig3 object.  The
	// rest of the execution is done via the constructor and other instance methods
	// in the Assig3 class.  Note also that this is using a command line argument for
	// the name of the file.  All of our programs so far have had the "String [] args"
	// list in the header -- we are finally using it here to read the file name from the
	// command line.  That name is then passed into the Assig3 constructor.
	public static void main(String [] args) throws IOException
	{
		Assig3 A3 = new Assig3(args[0]);
		A3.getBatters("Batters.txt");
	}
}
		
	