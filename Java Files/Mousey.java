/* CS 0401 Fall 2014
   Demonstration of mouse abilities in Java, plus a simple use of a
   TextArea.
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// Note that in this program, rather than having a JFrame object within the main class,
// I am making the main class a subclass of JFrame.  This is also how the text sets up
// most of its graphical examples.
public class Mousey extends JFrame
{
     JTextArea info;
     JScrollPane scroller;

     public Mousey()
     {
            super("Java Mouse Example");
            setLayout(new FlowLayout());
            info = new JTextArea("Beginning Mouse Demo\n",15,30);
                                 // integer arguments are rows and columns
            // Add the JTextArea to a JScrollPane so that we can see new
            // rows past the size of the JTextArea
            scroller = new JScrollPane(info);
            add(scroller);

			// Add a MouseListener and a MouseMotionListener
            addMouseListener(new MyMouseListener());
            addMouseMotionListener(new MyMotionListener());

			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(640, 480);
            setVisible(true);
     }

     public static void main(String [] args)
     {
            Mousey win = new Mousey();
     }

	 // Add new String to JTextArea, then move to the bottom of the text
	 // so you can see the new String without scrolling
     public void appendToText(String t)
     {
     		info.append(t);
     		info.setCaretPosition(info.getDocument().getLength());
     }	
     		
     // Note the various methods in the MouseListener.  Experiment with this
     // to see when each fires.
     private class MyMouseListener implements MouseListener
     {
            public void mousePressed(MouseEvent e)
            {
                 if (e.getButton() == 1)
                      appendToText("Left Mouse Button Pressed at (" + 
                      				e.getX() + "," + e.getY() + ") \n");
                 else if (e.getButton() == 3)
                 	  appendToText("Right Mouse Button Pressed at (" + 
                      				e.getX() + "," + e.getY() + ") \n");
			}

            public void mouseReleased(MouseEvent e)
            {
                 if (e.getButton() == 1)
                      appendToText("Left Mouse Button Released at (" + 
                      				e.getX() + "," + e.getY() + ") \n");
                 else if (e.getButton() == 3)
                 	  appendToText("Right Mouse Button Released at (" + 
                      				e.getX() + "," + e.getY() + ") \n");
            }

            public void mouseClicked(MouseEvent e)
            {
                 appendToText("Mouse Clicked for the " + e.getClickCount() +
                              " time\n");
            }

            public void mouseEntered(MouseEvent e)
            {
                 appendToText("Mouse Entering Window\n");
                 setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR)); // other cursors
            }                                               // are also available

            public void mouseExited(MouseEvent e)
            {
                 info.append("Mouse Exiting Window\n");
            }
     }

     private class MyMotionListener implements MouseMotionListener
     {
            public void mouseMoved(MouseEvent e)
            {
                 appendToText("Moving Through (" +
                               e.getX() + "," + e.getY() + ")\n");  
            }

            public void mouseDragged(MouseEvent e)
            {
                 appendToText("Dragging Through (" +
                               e.getX() + "," + e.getY() + ")\n");

                 // Experiment with this method to see how it works when a
                 // component is exited and/or entered
            }

     }
}


