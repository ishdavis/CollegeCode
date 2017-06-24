//driver

public class Ish
{

	public static void main(String[] args)
	{
	int h = 25, k = 50;
	man Ish = new man(h,k);
	Ish.setHeight(100);
	Ish.setWeight(300);
	System.out.print(Ish.toString());
	Ish.setHeight(25);
	man man2 = Ish;
	man2.setHeight(10000);
	System.out.println(man2.toString());
	Ish.setHeight(90000);
	System.out.print(Ish.toString());


	}
}
	