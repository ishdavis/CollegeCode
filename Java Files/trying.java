import java.util.Random;


public class trying
{

	public static void main(String[] args)
	{
	MyRectangle R1, R2, R3, R4, R5;

		R1 = new MyRectangle(100, 50, 80, 20);
		R2 = new MyRectangle(25,50,75,100);
		R3 = new MyRectangle(60, 60, 100, 100);
		R4 = new MyRectangle(30, 180, 200, 400);
		R5 = new MyRectangle(1160, 1160, 1100, 1100);


		
		MyRectangle [] ish = new MyRectangle[5];
		ish[0] = R1;
		ish[1] = R2;
		ish[2] = R3;
		ish[3] = R4;
		ish[4] = R5;
		for(int j = 0; j < ish.length; j++)
		{
		System.out.println(ish[j].toString());
		}
	Random rnd = new Random();
    for (int i = ish.length - 1; i > 0; i--)
    {
      int index = rnd.nextInt(i + 1);
      MyRectangle a = ish[index];
      ish[index] = ish[i];
      ish[i] = a;
    }

	for(int j = 0; j < ish.length; j++)
		{
		System.out.println(ish[j].toString());
		}
	
	
	
		
	}
	
}
		