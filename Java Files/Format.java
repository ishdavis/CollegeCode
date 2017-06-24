import java.text.DecimalFormat;
public class Format
{
	public static void main(String[] args){
	
	double uno = 12.9323, dos = 15.9432, sis = 82233.23, dix = 411.23232;
	
	DecimalFormat formatter = new DecimalFormat("#.000");
	
	System.out.println(formatter.format(uno));
	System.out.println(formatter.format(dos));
	
	double okay = 12.334943343;
	System.out.printf("I worked %.3f hours this week.", okay);
	
	}
}