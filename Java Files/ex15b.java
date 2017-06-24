// CS 401 Fall 2014
// Compare to ex15a.  Instead of a JLabel we are now using a JButton.
// This allows us to respond to the user's clicks by changing the color
// of the text within the button.

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;  // This package is needed for the ActionEvent
                          // class and ActionListener interface

public class ex15b
{
	public static void main(String [] args)
	{
		JFrame theWindow = new JFrame("Example 15b");
		theWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton theButton = new JButton("Change Color");
		theButton.setFont(new Font("Serif", Font.ITALIC + Font.BOLD, 60));

		// In order for the event-driven programming to work, we must
		// be sure to register an ActionListener with the button.  An
		// ActionListener is any object that implements the ActionListener
		// interface, which has the single method actionPerformed().
		ActionListener listen = new MyListener();
		theButton.addActionListener(listen);
	
		theWindow.setLayout(new FlowLayout());
		theWindow.add(theButton);

		// Note that the button fills the JFrame even it we resize it.
		// Later we will see how to manage components with regard to
		// position and size.
		//theWindow.setSize(600, 2000);
		theWindow.pack();
		theWindow.setVisible(true);
	}
}

// This class is the ActionLister for this program.  There are a lot of
// different ways that this can be set up.  Note that in this case we do
// not even have a constructor for the class.  Any Java class with no
// explicit constructor always has an implicit constructor (with no
// parameters), so objects can still be created.
class MyListener implements ActionListener
{
	// To keep things simple here we will just use some static data.  We
	// have an array of colors plus an index (int) variable.  Recall from
	// previous lectures our discussion of static data.
	static Color [] theColors = {Color.RED, Color.BLUE, Color.CYAN, Color.YELLOW,
								 Color.ORANGE, Color.MAGENTA, Color.GREEN};
	int index = 0;

	// Each time the button is clicked, this actionPerformed method gets
	// called, and the generated ActionEvent is passed into it.  From the
	// ActionEvent we can get a reference to the object that generated the
	// ActionEvent.  This reference allows us (in this case) to manipulate
	// the JButton by changing its color (in a circular fashion -- using
	// % we skip around to color 0 after the last color).  However, the 
	// reference being returned is to the superclass Object, and we need to
	// cast it to our desired JButton class.  We will talk more about subclasses,
	// superclasses, and casting soon.
	public void actionPerformed(ActionEvent e)
	{
		JButton theEventer = (JButton) e.getSource();
		theEventer.setForeground(theColors[index]);
		index = (index + 1) % theColors.length;
		theEventer.setBackground(theColors[index]);
	}
}
