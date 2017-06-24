import javax.swing.*;

public class SimpleWindow extends JFrame
{
	public SimpleWindow()
	{
		final int windowWidth = 500;
		final int windowHeight = 300;
				
		setTitle("This is yours");
		
		setSize(windowWidth, windowHeight);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setVisible(true);
		
	}
}