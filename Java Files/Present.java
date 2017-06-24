import java.awt.*;
import java.awt.geom.*;
import java.util.*;

//Present Class
class Present implements MyShape
{

	private Rectangle2D rect1, rect2, rect3;
	private int x, y, w, h, size;
	private boolean isHighlighted;

	public Present(int startX, int startY, int width, int height, int sz)
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
	rect2 = new Rectangle2D.Double();
	rect3 = new Rectangle2D.Double();
	rect1.setRect(x,y,w,h);
	rect2.setRect(((2*x+w)/2),y,.2*(w),h);
	rect3.setRect(x,((2*y+h)/2),w,.2*(h));
	
	}
	
	public void highlight(boolean b)
	{
		isHighlighted = b;
	}
	
	public void draw(Graphics2D g)
	{
		g.setColor(Color.green);
		if (isHighlighted)
		{
		g.draw(rect1);
		g.draw(rect2);
		g.draw(rect3);
		}
		else
		{
		g.setColor(Color.red);
		g.fill(rect1);
		g.setColor(Color.green);
		g.fill(rect2);
		g.fill(rect3);
		}
	}
	
	public void move(int X, int Y)
	{
	
	x = X;
	y = Y;
	
	rect1 = new Rectangle2D.Double();
	rect2 = new Rectangle2D.Double();
	rect3 = new Rectangle2D.Double();//
	rect1.setRect(x,y,w,h);
	rect2.setRect(((2*x+w)/2),y,.2*(w),h);
	rect3.setRect(x,((2*y+h)/2),w,.2*(h));
	
	}
	
	public void resize(int newsize)
	{
		w = newsize;
		h = newsize;
		setUp();
	}
	
	public boolean contains(double x, double y)
	{
	
	if(rect1.contains(x,y))
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
		return("Present:" + x + ":" + y + ":" + size);
	}

}
		
		
		
		
		
		
		
		

