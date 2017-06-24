/*Ishvaraus Davis
CS 0401
Assignment Five
Extra Credit: Menu option to save program as JPEG and also an extra MyShape object called ornament*/

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import java.awt.print.*;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;

import javax.imageio.ImageIO;



// Create enum types that will be useful in the program
enum Figures {TREE,SNOWFLAKE,GREETING,CLOUD,CABIN,PRESENT,ORNAMENT};
enum Mode {NONE,DRAW,SELECTED,MOVING};

// Code extracted from Oracle Java Example programs.  See link below for full code:
// http://docs.oracle.com/javase/tutorial/2d/printing/examples/PrintUIWindow.java
class thePrintPanel implements Printable
{
	JPanel panelToPrint;
	
	public int print(Graphics g, PageFormat pf, int page) throws
                                                        PrinterException
    {
        if (page > 0) { /* We have only one page, and 'page' is zero-based */
            return NO_SUCH_PAGE;
        }

        /* User (0,0) is typically outside the imageable area, so we must
         * translate by the X and Y values in the PageFormat to avoid clipping
         */
        Graphics2D g2d = (Graphics2D)g;
        AffineTransform t = new AffineTransform();
        t.scale(0.9, 0.9);
        g2d.transform(t);
        g2d.translate(pf.getImageableX(), pf.getImageableY());

        /* Now print the window and its visible contents */
        panelToPrint.printAll(g);

        /* tell the caller that this page is part of the printed document */
        return PAGE_EXISTS;
    }
    
    public thePrintPanel(JPanel p)
    {
    	panelToPrint = p;
    }
}

public class oldAssig5
{	
	private ShapePanel drawPanel;
	private JPanel buttonPanel;
	private JButton makeShape;
	private JRadioButton makeTree, makeFlake, makeGreet, makeCloud, makeCabin, makePresent, makeOrnament;
	private ButtonGroup shapeGroup;
	private Figures currShape;
	private JLabel msg;
	private JMenuBar theBar;
	private JMenu fileMenu, editMenu;
	private JMenuItem endProgram, printScene, new1, open, save, saveAs, saveAsJPEG;
	private JPopupMenu popper;
	private JMenuItem delete, cut, copy, paste, resize;
	private JFrame theWindow;
	private String fileName, tempName;
	private int selindex;
	private int x1, y1, x2, y2, k, z;
	private boolean wasSaved = false, sceneSaved = false, copied = false;


	
	// This ArrayList is used to store the shapes in the program.
	// It is specified to be of type MyShape, so objects of any class
	// that implements the MyShape interface can be stored in here.
	// See Section 7.13 in your text for more info on ArrayList.
	private ArrayList<MyShape> shapeList;	
	private MyShape newShape, temp, temp1, temp2;

	public Assig5()
	{
		drawPanel = new ShapePanel(640, 480);
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(3, 2));

		makeShape = new JButton("Click to Draw");

		ButtonHandler bhandler = new ButtonHandler();
		makeShape.addActionListener(bhandler);

		buttonPanel.add(makeShape);
		msg = new JLabel("");
		buttonPanel.add(msg);
		
		//radio buttons
		makeTree = new JRadioButton("Tree", false);
		makeFlake = new JRadioButton("Snowflake", true);
		makeGreet = new JRadioButton("Greeting", false);
		makeCloud = new JRadioButton("Cloud", false);
		makeCabin = new JRadioButton("Cabin", false);
		makePresent = new JRadioButton("Present", false);
		makeOrnament = new JRadioButton("Ornament", false);
		

		RadioHandler rhandler = new RadioHandler();
		makeTree.addItemListener(rhandler);
		makeFlake.addItemListener(rhandler);
		makeGreet.addItemListener(rhandler);
		makeCloud.addItemListener(rhandler);
		makeCabin.addItemListener(rhandler);
		makePresent.addItemListener(rhandler);
		makeOrnament.addItemListener(rhandler);

		buttonPanel.add(makeFlake);
		buttonPanel.add(makeTree);
		buttonPanel.add(makeGreet);
		buttonPanel.add(makeCloud);
		buttonPanel.add(makeCabin);
		buttonPanel.add(makePresent);
		buttonPanel.add(makeOrnament);
		
		// A ButtonGroup allows a set of JRadioButtons to be associated
		// together such that only one can be selected at a time
		shapeGroup = new ButtonGroup();
		shapeGroup.add(makeFlake);
		shapeGroup.add(makeTree);
		shapeGroup.add(makeGreet);
		shapeGroup.add(makeCloud);
		shapeGroup.add(makeCabin);
		shapeGroup.add(makePresent);
		shapeGroup.add(makeOrnament);
		
		currShape = Figures.SNOWFLAKE;
		drawPanel.setMode(Mode.NONE);

		theWindow = new JFrame("CS 401 Assig5 Help Program");
		Container c = theWindow.getContentPane();
		drawPanel.setBackground(Color.lightGray);
		c.add(drawPanel, BorderLayout.NORTH);
		c.add(buttonPanel, BorderLayout.SOUTH);

		// Note how the menu is created.  First we make a JMenuBar, then
		// we put a JMenu in it, then we put JMenuItems in the JMenu.  We
		// can have multiple JMenus if we like.  JMenuItems generate
		// ActionEvents, just like JButtons, so we just have to link an
		// ActionListener to them.
		theBar = new JMenuBar();
		theWindow.setJMenuBar(theBar);
		fileMenu = new JMenu("File");
		editMenu = new JMenu("Edit");
		theBar.add(fileMenu);
		theBar.add(editMenu);
		cut = new JMenuItem("Cut");
		copy = new JMenuItem("Copy");
		paste = new JMenuItem("Paste");
		printScene = new JMenuItem("Print");
		endProgram = new JMenuItem("Exit");
		save = new JMenuItem("Save");
		new1 = new JMenuItem("New");
		open = new JMenuItem("Open");
		saveAs = new JMenuItem("Save As");
		saveAsJPEG = new JMenuItem("Save As JPEG");
		fileMenu.add(saveAsJPEG);
		editMenu.add(cut);
		editMenu.add(copy);
		editMenu.add(paste);
		fileMenu.add(save);
		fileMenu.add(new1);
		fileMenu.add(open);
		fileMenu.add(saveAs);
		fileMenu.add(printScene);
		fileMenu.add(endProgram);
		printScene.addActionListener(bhandler);
		endProgram.addActionListener(bhandler);
		save.addActionListener(bhandler);
		new1.addActionListener(bhandler);
		open.addActionListener(bhandler);
		saveAs.addActionListener(bhandler);
		cut.addActionListener(bhandler);
		copy.addActionListener(bhandler);
		paste.addActionListener(bhandler);
		saveAsJPEG.addActionListener(bhandler);
		paste.setEnabled(false);


		// JPopupMenu() also holds JMenuItems.  To see how it is actually
		// brought out, see the mouseReleased() method in the ShapePanel class
		// below.
		popper = new JPopupMenu();
		resize = new JMenuItem("resize");
		delete = new JMenuItem("Delete");
		resize.addActionListener(bhandler);
		delete.addActionListener(bhandler);
		popper.add(delete);
		popper.add(resize);
		
		theWindow.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		theWindow.pack();
		theWindow.setVisible(true);
	}

	public static void main(String [] args)
	{
		new oldAssig5();
	}

	
	private class RadioHandler implements ItemListener
	{
		public void itemStateChanged(ItemEvent e)
		{
			if (e.getSource() == makeTree)
			{
				currShape = Figures.TREE;
				}
			else if (e.getSource() == makeFlake)
			{
				currShape = Figures.SNOWFLAKE;
				}
			else if (e.getSource() == makeGreet)
			{	
				currShape = Figures.GREETING;
				}
			else if(e.getSource() == makeCloud)
			{
				currShape = Figures.CLOUD;
				}
			else if(e.getSource() == makeCabin)
			{
				currShape = Figures.CABIN;
				}
			else if(e.getSource() == makePresent)
			{
				currShape = Figures.PRESENT;
				}
			else if(e.getSource() == makeOrnament)
			{
				currShape = Figures.ORNAMENT;
				}
		}
	}


	private class ButtonHandler implements ActionListener 
	{
		public void actionPerformed(ActionEvent e)
		{
			if (e.getSource() == makeShape)
			{
				if (makeShape.getText().equals("Click to Draw"))
				{
					drawPanel.setMode(Mode.DRAW);
					msg.setText("Position new shapes with mouse");
					makeShape.setText("Click to Edit");
				}
				else
				{
					drawPanel.setMode(Mode.NONE);
					msg.setText("Edit shapes with mouse");
					makeShape.setText("Click to Draw");
				}
			}
			else if (e.getSource() == delete)
			{
				boolean ans = drawPanel.deleteSelected();
				if (ans)
				{
					msg.setText("Shape deleted");
					drawPanel.repaint();
				}
			}
			
			//save image as JPEG
			else if(e.getSource() == saveAsJPEG)
			{
				
				
				BufferedImage bufferedImage = new BufferedImage(640, 480, BufferedImage.TYPE_INT_RGB);
				Graphics2D g2d = bufferedImage.createGraphics();
				drawPanel.paint(g2d);
				RenderedImage rendImage = bufferedImage;
				fileName = JOptionPane.showInputDialog("What would you like to name your JPEG");
				try
				{
				File file;
				file = new File(fileName + ".jpg");
				ImageIO.write(rendImage, "jpg", file);
				}
				catch(IOException b)
				{}
			}

			
			else if (e.getSource() == printScene)
			{
				Printable thePPanel = new thePrintPanel(drawPanel); 
			    PrinterJob job = PrinterJob.getPrinterJob();
         		job.setPrintable(thePPanel);
         		boolean ok = job.printDialog();
         		if (ok) 
         		{
             	 	try {
                  		job.print();
             		} 
             		catch (PrinterException ex) {
              		/* The job did not successfully complete */
             		}
             	}
            }
			
			//closing the program
			else if (e.getSource() == endProgram)
			{
			fileName = null;
			fileName = JOptionPane.showInputDialog("Input file name if you want to save");
			if(fileName == null)
			{
			System.exit(0);
			}
			else
			{
			try
			{
			StringBuffer print = new StringBuffer();
			print.append(shapeList.size());
			print.append("\n");
			for(int q = 0; q < shapeList.size(); q++)
			{
			print.append(shapeList.get(q).saveData());	
			print.append("\n");
			}
			FileWriter fwriter = new FileWriter(fileName, false);
						
			PrintWriter outputFile = new PrintWriter(fwriter);
										
			outputFile.print(print.toString());
						
			outputFile.close();
			}
			catch(IOException c)
			{}
				System.exit(0);
			}
			}
			
			else if (e.getSource() == save)
			{
			if(wasSaved == false)
			{
			try
			{
			fileName = JOptionPane.showInputDialog("Text file name?");
			StringBuffer print = new StringBuffer();
			print.append(shapeList.size());
			print.append("\n");
			for(int q = 0; q < shapeList.size(); q++)
			{
			print.append(shapeList.get(q).saveData());	
			print.append("\n");
			}
			FileWriter fwriter = new FileWriter(fileName, false);
						
			PrintWriter outputFile = new PrintWriter(fwriter);
										
			outputFile.print(print.toString());
						
			outputFile.close();

			}
			catch(IOException b)
			{
			}
			wasSaved = true;

			}
			else
			{
			try
			{
			StringBuffer print = new StringBuffer();
			print.append(shapeList.size());
			print.append("\n");
			for(int q = 0; q < shapeList.size(); q++)
			{
			print.append(shapeList.get(q).saveData());	
			print.append("\n");
			}
			FileWriter fwriter = new FileWriter(fileName, false);
						
			PrintWriter outputFile = new PrintWriter(fwriter);
										
			outputFile.print(print.toString());
						
			outputFile.close();
			}
			catch(IOException b)
			{
			}
			}
			sceneSaved = true;
			}
			else if (e.getSource() == copy)
			{
			k =	drawPanel.getSelected(x1,y1); 
			temp1 = shapeList.get(k);
			copied = true;
			paste.setEnabled(true);
			}
			else if (e.getSource() == paste)
			{
				if(copied == false)
				{
				shapeList.add(shapeList.size(),temp);
				temp.highlight(false);
				drawPanel.repaint();
				}
				else
				{
				temp1.highlight(false);

				shapeList.add(shapeList.size(),temp1);
				temp1.move(50,50);
				drawPanel.repaint();
				}
			}
			else if (e.getSource() == cut)
			{
				k = drawPanel.getSelected(x1,y1);
				temp = shapeList.get(k);
				boolean done= drawPanel.deleteSelected();
				if (done)
				{
					msg.setText("Shape cut");
					drawPanel.repaint();
					paste.setEnabled(true);
				}
				
			}
			else if (e.getSource() == new1) 
			{
			if(fileName != null)
			{
			if(JOptionPane.showConfirmDialog(null, "Save File " + fileName, "choose one", JOptionPane.YES_NO_OPTION) == 1)
			{
			shapeList.clear();
			drawPanel.repaint();
			}
			else
			{
			try
			{
			StringBuffer print = new StringBuffer();
			print.append(shapeList.size());
			print.append("\n");
			for(int q = 0; q < shapeList.size(); q++)
			{
			print.append(shapeList.get(q).saveData());	
			print.append("\n");
			}
			FileWriter fwriter = new FileWriter(fileName, false);
						
			PrintWriter outputFile = new PrintWriter(fwriter);
										
			outputFile.print(print.toString());
						
			outputFile.close();
			}
			catch(IOException c)
			{}
			shapeList.clear();
			drawPanel.repaint();
			}
			}
			
			else
			{
			fileName = JOptionPane.showInputDialog("Input file name if you want to save");
			if(fileName == null)
			{
			shapeList.clear();
			drawPanel.repaint();
			}
			else
			{
			try
			{
			StringBuffer print = new StringBuffer();
			print.append(shapeList.size());
			print.append("\n");
			for(int q = 0; q < shapeList.size(); q++)
			{
			print.append(shapeList.get(q).saveData());	
			print.append("\n");
			}
			FileWriter fwriter = new FileWriter(fileName, false);
						
			PrintWriter outputFile = new PrintWriter(fwriter);
										
			outputFile.print(print.toString());
						
			outputFile.close();
			}
			catch(IOException c)
			{}
			shapeList.clear();
			drawPanel.repaint();
			}
			}
			
			}
			else if (e.getSource() == saveAs)
			{
				try
			{
			fileName = JOptionPane.showInputDialog("Text file name?");
			StringBuffer print = new StringBuffer();
			print.append(shapeList.size());
			print.append("\n");
			for(int q = 0; q < shapeList.size(); q++)
			{
			print.append(shapeList.get(q).saveData());	
			print.append("\n");
			}
			FileWriter fwriter = new FileWriter(fileName, false);
						
			PrintWriter outputFile = new PrintWriter(fwriter);
										
			outputFile.print(print.toString());
						
			outputFile.close();

			}
			catch(IOException b)
			{
			}
			}
		
			else if (e.getSource() == open)
			{
			try
			{
			tempName = JOptionPane.showInputDialog("Input file name you want to open");
			if(tempName == null)
			{
			JOptionPane.showMessageDialog(null, "You didn't input a file");
			}
			else
			{
			fileName = tempName;
			}
			
			File textFile = new File(fileName);
			
			Scanner newFile = new Scanner(textFile);
			
			int q = newFile.nextInt();
			shapeList.clear();
			drawPanel.repaint();
			String m, Type, newX, newY, sizer, greeter;
			int realX, realY, realSize;
			for(int k = 0; k < q; k++)
			{
			m = newFile.next();
			if(!m.startsWith("Greeting"))
			{
			Type = m.split(":")[0];
			newX = m.split(":")[1];
			newY = m.split(":")[2];
			sizer= m.split(":")[3];
			realX = Integer.parseInt(newX);
			realY = Integer.parseInt(newY);
			realSize = Integer.parseInt(sizer);

			if(Type.equals("Cabin"))
			{
			newShape = new Cabin(realX,realY, 75, 60, 30);
			shapeList.add(k, newShape);
			}
			
			if(Type.equals("Cloud"))
			{
			newShape = new Cloud(realX,realY,20, 15, 20);
			shapeList.add(k, newShape);
			}
			
			if(Type.equals("Tree"))
			{
			newShape = new Tree(realX,realY,50);
			shapeList.add(k, newShape);
			}
			
			if(Type.equals("Snowflake"))
			{
			newShape = new Snowflake(realX,realY,10);
			shapeList.add(k, newShape);
			}
			
			if(Type.equals("Present"))
			{
			newShape = new Present(realX,realY,75,75,30);
			shapeList.add(k, newShape);
			}
			if(Type.equals("Ornament"))
			{
			newShape = new Ornament(realX,realY,15,15,20);
			shapeList.add(k, newShape);
			}
			}
			else
			{
			
			StringBuilder b = new StringBuilder();
			Type = m.split(":")[0];
			newX = m.split(":")[1];
			newY = m.split(":")[2];
			sizer= m.split(":")[3];
			realX = Integer.parseInt(newX);
			realY = Integer.parseInt(newY);
			realSize = Integer.parseInt(sizer);
			b.append(m.split(":")[4]);
				if(b.toString().equals("Edit"))
				{
				newShape = new Greeting(realX,realY,30);
				shapeList.add(k, newShape);
				String p = newFile.next();
				}
				else
				{					
				newShape = new Greeting(realX,realY,30,b.toString());
				shapeList.add(k, newShape);
				}
			}
			
			}
			drawPanel.repaint();
			
			}
			
			catch(FileNotFoundException j)
			{}
						
			}
			else if (e.getSource() == resize)
			{
			String newSize = JOptionPane.showInputDialog("Enter the new size");
			int sized = Integer.parseInt(newSize);
			k =	drawPanel.getSelected(x1,y1); 
			shapeList.get(k).resize(sized);
			drawPanel.repaint();
			
			}

		}
	}

	
	private class ShapePanel extends JPanel
	{
		
		// These instance variables are used to store the desired size
		// of the panel.  See method getPreferredSize() below.
		private int prefwid, prefht;

		// Store index of the selected MyShape.  This allows the Shape
		// to be moved and updated.

		// Keep track of positions where mouse is moved on the display.
		// This is used by mouse event handlers when moving the shapes.
		
		private boolean popped; // has popup menu been activated?

		private Mode mode;   // Keep track of the current Mode

		public ShapePanel (int pwid, int pht)
		{
			shapeList = new ArrayList<MyShape>(); // create empty ArrayList
			selindex = -1;
		
			prefwid = pwid;	// values used by getPreferredSize method below
			prefht = pht;   // (which is called implicitly).  This enables
			// the JPanel to request the room that it needs.
			// However, the JFrame is not required to honor
			// that request.

			setOpaque(true);// Paint all pixels here (See API)

			setBackground(Color.lightGray);

			addMouseListener(new MyMouseListener());
			addMouseMotionListener(new MyMover());
			popped = false;
		}  // end of constructor


		
		private class MyMouseListener extends MouseAdapter
		{
			public void mousePressed(MouseEvent e)
			{
				x1 = e.getX();  // store where mouse is when clicked
				y1 = e.getY();

				if (!e.isPopupTrigger() && (mode == Mode.NONE ||
										    mode == Mode.SELECTED)) // left click and
				{												    // either NONE or
					if (selindex >= 0)								// SELECTED mode
					{
						unSelect();			// unselect previous shape
						mode = Mode.NONE;
					}
					selindex = getSelected(x1, y1);  // find shape mouse is
													 // clicked on
					if (selindex >= 0)
					{
						mode = Mode.SELECTED;  	// Now in SELECTED mode for shape
						
					// Check for double-click.  If so, show dialog to update text of
					// the current text shape (will do nothing if shape is not a MyText)
						MyShape curr = shapeList.get(selindex);
						if (curr instanceof MyText && e.getClickCount() == 2)
						{
							String newText = JOptionPane.showInputDialog(theWindow, 
							                  "Enter new text [Cancel for no change]");
							if (newText != null)
								((MyText) curr).setText(newText);
						}
					}
					repaint();	//  Make sure updates are redrawn
				}
				else if (e.isPopupTrigger() && selindex >= 0)  // if button is
				{								               // the popup menu
					popper.show(ShapePanel.this, x1, y1);      // trigger, show
					popped = true;							   // popup menu
				}											  
			}
			
			public void mouseReleased(MouseEvent e)
			{
				if (mode == Mode.DRAW) // in DRAW mode, create the new Shape
				{					   // and add it to the list of Shapes.  In this
					   // case we need to distinguish between the
									   // shapes since we are calling constructors
					if (currShape == Figures.TREE)
					{
						newShape = new Tree(x1,y1,50);
					}
					else if (currShape == Figures.SNOWFLAKE)
					{
						newShape = new Snowflake(x1,y1,10);
					}
					else if (currShape == Figures.GREETING)
					{
						newShape = new Greeting(x1,y1,30);
					}
					else if (currShape == Figures.CLOUD)
					{
						newShape = new Cloud(x1,y1,20, 15, 20);
					}
					else if (currShape == Figures.CABIN)
					{
						newShape = new Cabin(x1,y1, 75, 60, 30);
						}
					else if (currShape == Figures.PRESENT)
					{
						newShape = new Present(x1,y1,75,75,30);
						}
					else if (currShape == Figures.ORNAMENT)
					{
						newShape = new Ornament(x1,y1,15,15,20);
						}
					addShape(newShape);
					sceneSaved = false;
				}
				// In MOVING mode, set mode back to NONE and unselect shape (since 
				// the move is finished when we release the mouse).
				else if (mode == Mode.MOVING) 
				{
					mode = Mode.NONE;
					unSelect();  
					makeShape.setEnabled(true);
					repaint();
					sceneSaved = false;
				}
				else if (e.isPopupTrigger() && selindex >= 0) // if button is
				{							// the popup menu trigger, show the
					popper.show(ShapePanel.this, x1, y1); // popup menu
				}
				popped = false;  // unset popped since mouse is being released
			}
		}

		private class MyMover extends MouseMotionAdapter
		{
			public void mouseDragged(MouseEvent e)
			{
				x2 = e.getX();   // store where mouse is now
				y2 = e.getY();

				// Note how easy moving the shapes is, since the "work"
				// is done within the various shape classes.  All we do
				// here is call the appropriate method.  However, we don't 
				// want to accidentally move the selected shape with a right click
				// so we make sure the popup menu has not been activated.
				if ((mode == Mode.SELECTED || mode == Mode.MOVING) && !popped)
				{
					MyShape s = shapeList.get(selindex);
					mode = Mode.MOVING;
					s.move(x2, y2);
				}
				repaint();	// Repaint screen to show updates
				sceneSaved = false;
			}
		}

	
		private int getSelected(double x, double y)
		{                                             
			for (int i = 0; i < shapeList.size(); i++)
			{
				if (z > shapeList.size() - 1)
				{
				z = 0;
				}
				if (shapeList.get(z).contains(x, y))
				{
					shapeList.get(z).highlight(true); 
					z++;
					return z-1;
				}
			z++;
			}
			return -1;
			
		}

		public void unSelect()
		{
			if (selindex >= 0)
			{
				shapeList.get(selindex).highlight(false);
				selindex = -1;
			}
		}
		
		public boolean deleteSelected()
		{
			if (selindex >= 0)
			{
				shapeList.remove(selindex);
				selindex = -1;
				return true;
			}
			else return false;
		}

		public void setMode(Mode newMode)            // set Mode
		{
			mode = newMode;
		}

		private void addShape(MyShape newshape)      // Add shape
		{
			shapeList.add(newshape);
			repaint();	// repaint so we can see new shape
		}

		public Dimension getPreferredSize()
		{
			return new Dimension(prefwid, prefht);
		}

		
		public void paintComponent (Graphics g)    
		{
			super.paintComponent(g);         // don't forget this line!
			Graphics2D g2d = (Graphics2D) g;
			for (int i = 0; i < shapeList.size(); i++)
			{
				shapeList.get(i).draw(g2d);
			}
		}
	} // end of ShapePanel
}
