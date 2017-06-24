

public class DisplayableStack<T> extends ArrayStack<T>
{

	private StringBuilder b;
	
	public DisplayableStack()
	{
	
	}
	
	
	public String toString()
	{
	b = new StringBuilder();
	for(int i = topIndex; i >= 0; i--)
	{
	b.append(stack[i].toString());
	b.append("\n");
	}
	return b.toString();
	}
	

}
	
	