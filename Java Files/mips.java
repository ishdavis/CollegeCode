

public class mips
{

	public static void main(String [] args)
	{
	System.out.println(choose(5,2));
	
	
	}
	
	private static int choose(int n, int k)
	{
	if(k == 0)
	{
		System.out.println("ok");
		return 1;
		}
	else if(n == k)
	{
		System.out.println("what");
		return 1;
		}
	else if(n < k)
	{
		System.out.println("fine");
		return 0;
		}
	else
	{
		System.out.println("Wow");
		return choose(n-1, k-1) + choose(n-1, k);
		}
	}
	
}