//MultiDS Class
import java.util.Random;


public class MultiDS<T> implements Reorder, PrimQ<T>
{
	private T [] MultiDS;
	private int count = 0;
	private int sizer = 0;
	
	public MultiDS(int size)
	{
	MultiDS = (T[]) new Object[size];
	sizer = size;
	}
	
	public T getItem(int l)
	{
	return MultiDS[l];
	}
	
	public boolean addItem(T item)
	{
	if(count < MultiDS.length)
	{
	MultiDS[count] = item;
	count++;
	return true;
	}
	else
	{
	return false;
	}
	}
	
	public T removeItem()
	{
	if(count == 0)
	{
	return null;
	}
	else
	{
	T copy = MultiDS[0];
	MultiDS[0] = null;

	int changer = count - 1;
	for (int i = 0; i < changer; i++)
	{
	MultiDS[i] = MultiDS[i+1];
	}
	count--;
	return copy;
	}
	}
	
	// Return true if the PrimQ is full, and false otherwise
	public boolean full()
	{
	if(count < MultiDS.length)
	{
	return false;
	}
	else
	{
	return true;
	}
	}
	// Return true if the PrimQ is empty, and false otherwise
	public boolean empty()
	{
	if(count > 0)
	{
	return false;
	}
	else
	{
	return true;
	}
	}
	
	// Return the number of items currently in the PrimQ
	public int size()
	{
	return count;
	}

	// Reset the PrimQ to empty status by reinitializing the variables
	// appropriately
	public void clear()
	{
	for (int i = 0; i < count; i++)
	{
	MultiDS[i] = null;
	}
	count = 0;
	}	
	
	// Logically reverse the data in the Reorder object so that the item
	// that was logically first will now be logically last and vice
	// versa.  The physical implementation of this can be done in 
	// many different ways, depending upon how you actually implemented
	// your physical MultiDS class
	public void reverse()
	{
	int runAmount = 0;
	if(count % 2 != 0)
	{
	runAmount = (count / 2) + 1;
	}
	else
	{
	runAmount = (count / 2);
	}
	int runCounter = count - 1;
	for(int i = 0; i < runAmount; i++)
	{
	T copy1 = MultiDS[i];
	T copy2 = MultiDS[runCounter];
	MultiDS[runCounter] = copy1;
	MultiDS[i] = copy2;
	runCounter--;
	}
	
	}
	
	// Remove the logical last item of the DS and put it at the 
	// front.  As with reverse(), this can be done physically in
	// different ways depending on the underlying implementation.  
	public void shiftRight()
	{
	int changer = count - 1;
	T copyLast = MultiDS[changer];
	for(int i = changer; i > 0; i--)
	{
	MultiDS[i] = MultiDS[i-1];
	}
	MultiDS[0] = copyLast;
	}
	
	// Remove the logical first item of the DS and put it at the
	// end.  As above, this can be done in different ways.
	public void shiftLeft()
	{
	int changer = count - 1;
	T copyFirst = MultiDS[0];
	for (int i = 0; i < changer; i++)
	{
	MultiDS[i] = MultiDS[i+1];
	}
	MultiDS[changer] = copyFirst;
	}
	
	public void shuffle()
	{
	Random myRandom = new Random();
	for (int i=0; i < count; i++) 
	{
	int randomPosition = myRandom.nextInt(count);
	T temp = MultiDS[i];
	MultiDS[i] = MultiDS[randomPosition];
	MultiDS[randomPosition] = temp;
	}
    }
	
	
	public String toString()
	{
	StringBuilder b = new StringBuilder();
	b.append("Contents:\n");
	for(int i = 0; i < count; i++)
	{
	b.append(MultiDS[i] +" ");
	}
	return b.toString();
	}
	// Reorganize the items in the object in a pseudo-random way.  The exact
	// way is up to you but it should utilize a Random object (see Random in 
	// the Java API)
	
}	