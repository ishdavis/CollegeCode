// CS 0401 Fall 2014
// Outline of the Quiz class to be used with Assignment 2
// Complete this class as specified so that it can be used as indicated.
// To test your Quiz class prior to integrating it with Assignment 2,
// use the QuizTest.java program.  Compare your output with the
// output shown in QuizTest-out.txt file -- it should match exactly.
 
/* The Quiz will read data from an arbitrary file formatted as follows:
question1
answer1
question2
answer2
...
*/
// Be sure to format your questions file correctly (note: make sure you do not have
// an extra empty line at the end of your file -- this will cause an error)

import java.io.*;
import java.util.*;

public class Quiz
{
	private String fName;     // Name of the file you will be reading from
	private Scanner theFile;  // Scanner use to read from the file
	public int status = 0;
	
	// Create a new Quiz object by opening the associated file.  Note that this
	// method throws an IOException, so in the method that calls it you must also
	// have in the header "throws IOException".  We will discuss how to handle
	// these exceptions later.
	public Quiz(String f) throws IOException
	{
	File textFile = new File(f);
			
	theFile = new Scanner(textFile);
	}
	
	// First check the status.  If it is 1 or 2 simply return false.
	// If it is 0, check the file:
	//		If there is a line in the file, return true
	//		If there is no line in the file, set status to 1 and
	//			return false.
	public boolean hasAQuestion()
	{
	
	boolean check = false;
	if(status == 0){
		
		if(theFile.hasNext()){
			
			check = true;
		}
		else
		{
		check = false;
		status = 1;
		}
	}
	if(status == 2 || status == 1){
		check = false;
	}
			
	return check;
	}
	
	// Return that status of the Quiz object:
	// Status = 0: everything ok
	// Status = 1: end of file reached
	// Status = 2: error has occurred
	public int getStatus()
	{
	return status;
	}
			
	// Get the next question and set the status appropriately:
	//		If status is not 0, return null, otherwise:
	//		If no lines are left before anything is read, set status
	//			to 1 and return null
	//		If the question is read but no answer left, set status to
	//			to 2 and return null
	//		If both the question and answer are read, return them in
	//			a new Question object.
	public Question getQuestion()
	{
	Question j = null;
	String question = null;
	String Answer = null;
	boolean runIt = false;
	
	if(status != 0)
	{
	j = null;
	}
	
	else{
	
	
	
	if(theFile.hasNext()){
		question = theFile.nextLine();
		if(theFile.hasNext()){
		Answer = theFile.nextLine();
		j = new Question(question,Answer);
		}
		else
		{
		status = 2;
		j = null;
		}
	}
	
	else
	{
	status = 1;
	j = null;
	}
	}
	
	return j;
	}
}

