import java.awt.*;
import java.awt.geom.*;
import java.util.*;

//cloud class
class Cloud implements MyShape
{

	private Ellipse2D.Double ellipse1, ellipse2, ellipse3, ellipse4, ellipse5;
	private int x, y, w, h, size;
	private boolean isHighlighted;
	
	public Cloud(int startX, int startY, int width, int height, int sz)
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
	
	ellipse1 = new Ellipse2D.Double(x-10, y, w+20, h);
	ellipse2 = new Ellipse2D.Double(x+3, y-6, w+13, h);
	ellipse3 = new Ellipse2D.Double(x+2, y-3, w+8, h);
	ellipse4 = new Ellipse2D.Double(x+8, y+3, w+7, h);
	ellipse5 = new Ellipse2D.Double(x+4, y+5, w+5, h);

	}
	
	public void highlight(boolean b)
	{
		isHighlighted = b;
	}
	
	public void draw(Graphics2D g)
	{
	
	if (!isHighlighted)
	{
			g.setColor(Color.white);
			g.fill(ellipse1);
			g.fill(ellipse2);
			g.fill(ellipse3);
			g.fill(ellipse4);
			g.fill(ellipse5);
	}
	else
		{
		g.setColor(Color.blue);
		g.fill(ellipse1);
		g.fill(ellipse2);
		g.fill(ellipse3);
		g.fill(ellipse4);
		g.fill(ellipse5);
		}
		
	}
	
	public void move(int X, int Y)
	{
	x = X;
	y = Y;
	
	ellipse1 = new Ellipse2D.Double(x-10, y, w+20, h);
	ellipse2 = new Ellipse2D.Double(x+3, y-6, w+13, h);
	ellipse3 = new Ellipse2D.Double(x+2, y-3, w+8, h);
	ellipse4 = new Ellipse2D.Double(x+8, y+3, w+7, h);
	ellipse5 = new Ellipse2D.Double(x+4, y+5, w+5, h);

	
	}
	
	public void resize(int newsize)
	{
		w = newsize;
		h = newsize;
		setUp();
	}
	
	public boolean contains(double x, double y)
	{
	if((ellipse1.contains(x,y)) || (ellipse2.contains(x,y)) || (ellipse3.contains(x,y)) || (ellipse4.contains(x,y)) || (ellipse5.contains(x,y)))
	{
	return true;
	}
	else
	{
	return false;
	}
	
	}
	
	public String saveData()
	{
		return ("Cloud:" + x + ":" + y + ":" + size);
	}
	
}



	