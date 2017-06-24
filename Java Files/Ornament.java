import java.awt.*;
import java.awt.geom.*;
import java.util.*;

//Ornament class
//Extra Credit
class Ornament implements MyShape
{

	private Rectangle2D rect1;
	private Ellipse2D.Double ellipse1;
	private int x, y, w, h, size;
	private boolean isHighlighted;

	public Ornament(int startX, int startY, int width, int height, int sz)
	{
	
	x = startX;
	y = startY;
	w = width;
	h = height;
	size = sz;
	setUp();
	
	}
	
	private void setUp()
	{
	rect1 = new Rectangle2D.Double();
	ellipse1 = new Ellipse2D.Double(x,y,2*w,2*h);
	rect1.setRect((2*x+w)/2,y,w*.5,h*.5);
	}
	
	public void draw(Graphics2D g)
	{
		g.setColor(Color.green);
		if (isHighlighted)
		{
		g.draw(rect1);
		g.draw(ellipse1);
		}
		else
		{
		g.setColor(Color.red);
		g.fill(rect1);
		g.setColor(Color.white);
		g.fill(ellipse1);
		}
	}
	
	public boolean contains(double x, double y)
	{
	
	if((rect1.contains(x,y)) || ellipse1.contains(x,y))
	{
	return true;
	}
	else
	{
	return false;
	}
	
	}
	
	public void move(int X, int Y)
	{
	
	x = X;
	y = Y;
	
	rect1 = new Rectangle2D.Double();
	ellipse1 = new Ellipse2D.Double(x,y,2*w,2*h);
	rect1.setRect((2*x+w)/2,y,w*.5,h*.5);
	
	}
	
	public void highlight(boolean b)
	{
		isHighlighted = b;
	}
	
	public void resize(int newsize)
	{
		w = newsize;
		h = newsize;
		setUp();
	}
	
	public String saveData()
	{
		return("Ornament:" + x + ":" + y + ":" + size);
	}
	
}
