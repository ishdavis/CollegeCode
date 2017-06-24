// CS 401 Fall 2013 Lab 7 Main Program
// Your job is to complete this program so that it runs correctly.
// The Movie class and MovieDB class have already been completed for you.
// You just need to write the correct code in the 3 passages below.  Some
// comments indicate what you need to do in each case.
import java.util.*;
import java.io.*;
public class NewLab7
{
	public static void main(String [] args) throws IOException
	{
		MovieDB movies = new MovieDB(10); // Create MovieDB object.  The
					// size is set at 10, meaning it can hold up to 10
					// movies.  If we wanted (as discussed in lecture) we
					// could allow for it to be resized so it could hold
					// an arbitrary number of movies.
		loadData(movies);		// input movie data from file
		getCommands(movies);	// interact with user 
		saveData(movies);		// save movie data back to file
	}

	public static void loadData(MovieDB movies) throws IOException
	{
		// Note the syntax below for creating a Scanner to a file
		File myFile = new File("movieFile.txt");
			
		Scanner inputFile = new Scanner(myFile);	
		
		
		String noClue;
		noClue = inputFile.nextLine();
		Double numMovies = Double.valueOf(noClue);
				
		for(int j = 0; j <= numMovies; j++)
		{
		
		if(inputFile.hasNext())
		{
		String Movie = inputFile.nextLine();
		String Title = inputFile.nextLine();
		String producer = inputFile.nextLine();
		String amount = inputFile.nextLine();	
		
		Double movieGross = Double.valueOf(amount);

		Movie NewMovie = new Movie(Movie, Title, producer, movieGross);
		movies.addMovie(NewMovie);
		}
		}
		inputFile.close();

		
		// *** CODE SEGMENT 1 *** //
		// Complete this method in the following way:
		// Read in the number of movies from the file
		// For each movie read the data from the file and create a Movie
		// object
		// Add the Movie to the MoviesDB object (movies) using the appropriate
		// method (see MovieDB class)
	}

	public static void getCommands(MovieDB movies)
	{
		Scanner inScan = new Scanner(System.in);
		System.out.println("Enter your choice:");
		System.out.println("1. List movies");
		System.out.println("2. Add new movie");
		System.out.println("3. Find movie");
		System.out.println("4. Quit");
		String choice = inScan.nextLine();
		while (true)
		{
			Movie temp;
			if (choice.equals("1"))
			{
				System.out.println(movies.toString());
				
			}
			else if (choice.equals("2"))
			{
				Scanner keyboard = new Scanner(System.in);
				String movieName, director, studio;
				double gross;
				
				System.out.println("Movie name?");
				movieName = keyboard.nextLine();
				
				System.out.println("Director?");
				director = keyboard.nextLine();

				System.out.println("Studio?");
				studio = keyboard.nextLine();

				System.out.println("Gross?");
				gross = keyboard.nextDouble();
				
				Movie addedMovie = new Movie(movieName, director, studio, gross);
				movies.addMovie(addedMovie);

				// *** CODE SEGMENT 2 *** //
				// Complete this choice in the following way:
				// Prompt for and read in each of the values needed
				// for the new Movie object (3 strings, 1 double)
				// Create a new Movie object and then add it to the
				// MovieDB object (movies) using the correct method.
			}
			else if (choice.equals("3"))
			{
			
				Scanner keyboard = new Scanner(System.in);
				String searchName;
				
				System.out.println("Movie Name?");
				searchName = keyboard.nextLine();
				
				String foundMovie;
				
				if(movies.findMovie(searchName) == null)
				{
				System.out.println("The movie doesn't exist");
				}
				
				
				else
				{
				System.out.println(movies.findMovie(searchName));				
				}
				

				// *** CODE SEGMENT 3 *** //
				// Complete this choice in the following way:
				// Ask the user for the movie name and read it in
				// Call the appropriate method in the MovieDB object
				// (movies) to find the Movie and return it
				// Show the movie's info (or indicate it is not found)
			}
			else
			{
				System.out.println("Good-bye");
				break;  // any other value -- quit
			}
			System.out.println("Enter your choice:");
			System.out.println("1. List movies");
			System.out.println("2. Add new movie");
			System.out.println("3. Find movie");
			System.out.println("4. Quit");
			choice = inScan.nextLine();

		}
		
	}

	public static void saveData(MovieDB movies) throws IOException
	{
		PrintWriter P = new PrintWriter("movieFile.txt");
		// Note that we are printing the entire DB to the file with
		// one statement.  This is because the toStringFile() method
		// of the MovieDB class calls the toStringFile() method of
		// each Movie within the DB.
		P.print(movies.toStringFile());
		P.close();
	}
}





