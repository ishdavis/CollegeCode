// CS 401 Fall 2014
// MyDeque class to implement a simple deque
// Complete the methods indicated.  Be careful about the
// special cases indicated.  See lab for details on how
// to implement the methods.

public class MyDeque implements SimpleDeque
{
	Object [] theData;
	int numItems;

	public MyDeque(int maxItems)
	{
		theData = new Object[maxItems];
		numItems = 0;
	}
	
	public boolean isEmpty()
	{
		return (numItems == 0);
	}
	
	public void addFront(Object X)
	{
		if(numItems < 10)
		{
		for(int i = 1; i > 0; i--)
		{
		theData[i + 1] = theData[i];
		System.out.print("This worx");
		}
		theData[0] = X;
		numItems++;
		}
		// Add new item at front of list (shifting old items
		// to right first).  If the list is full, do not add
		// the item (just do nothing).
	}

	public void addRear(Object X)
	{
		if(numItems < 10)
		{
		theData[numItems] = X;
		numItems++;
		}
		// Add new item at rear of list.  If the list is full,
		// do not add the item (just do nothing).
	}

	public Object removeFront()
	{
		if(numItems != 0)
		{
		Object L = new Object();
		L = theData[0];
		int k = (numItems - 1);
		for(int j = 0; j < k; j++)
		{
		theData[j] = theData[j + 1];
		//System.out.print("I have no clue");
		}
		theData[k] = null;
		numItems--;
		return L;
		}
		else
		{
		return null;
		}
		
		
		// Remove and return front item from list, shifting remaining
		// items to the left to fill the spot.  If list is empty,
		// return null.
	}

	public Object removeRear()
	{
		if(numItems != 0)
		{
		int arrayNumber = numItems - 1;
		Object k = new Object(); 
		k = theData[arrayNumber];
		theData[arrayNumber] = null;
		numItems--;
		return k;
		}
		else
		{
		return null;
		}
		
		// Remove and return rear item from list.  If list is empty,
		// return null.
	}
}

