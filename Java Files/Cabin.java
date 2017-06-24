import java.awt.*;
import java.awt.geom.*;
import java.util.*;

//Cabin class
class Cabin implements MyShape
{

	private Rectangle2D rect1, rect2, rect3;
	private Polygon poly;
	private Line2D line1, line2, line3, line4, line5, line6, line7;
	private int x, y, w, h, size;
	private double work = 1/8, work1 = 7/8;
	private boolean isHighlighted;

	public Cabin(int startX, int startY, int width, int height, int sz)
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
	rect3.setRect(x+.2*w,y-(.4*h),.2*w,.4*h);
	rect2.setRect(((2*x+w)/2),(y+h)-(.4*h),.2*w,.4*h);
	rect1.setRect(x, y, w, h);
	line1 = new Line2D.Double(x,(h*1/7)+y,x+w,(h*1/7)+y);
	line2 = new Line2D.Double(x,(h*2/7)+y ,x+w,(h*2/7)+y);
	line3 = new Line2D.Double(x,(h*3/7)+y ,x+w,(h*3/7)+y);
	line4 = new Line2D.Double(x,(h*4/7)+y ,x+w,(h*4/7)+y);
	line5 = new Line2D.Double(x,(h*5/7)+y ,x+w,(h*5/7)+y);
	line6 = new Line2D.Double(x,(h*6/7)+y ,x+w,(h*6/7)+y);
	line7 = new Line2D.Double(x,(h*7/7)+y,x+w,(h*7/7)+y);
	poly = new Polygon();
	int x1 = (int)(x);
	int y1 = (int)(y);
	int w1 = (int)(w);
	int h1 = (int)(h);
	int workx = (int)(work);
	int work2 = (int)(work1);
	poly.addPoint(x1,y1);
	poly.addPoint(x1+w1,y1);
	poly.addPoint(workx*w1+x1,y1-h1); 
	poly.addPoint(work2*w1+x1,y1-h1);
	
	}
	
	public void highlight(boolean b)
	{
		isHighlighted = b;
	}
	
	public void draw(Graphics2D g)
	{
		g.setColor(new Color(156, 93, 82));
		if (isHighlighted)
		{
			g.draw(rect1);
			g.draw(rect2);
			g.setColor(Color.gray);  
			g.draw(poly);
			g.setColor(Color.red);   
			g.draw(rect3);
		}
		else
		{
			g.fill(rect1);
			g.setColor(Color.black);
			g.draw(line1);
			g.draw(line2);
			g.draw(line3);
			g.draw(line4);
			g.draw(line5);
			g.draw(line6);
			g.draw(line7);
			g.fill(rect2);
			g.setColor(Color.gray);
			g.fill(poly);
			g.setColor(Color.red);
			g.fill(rect3);

		}
		
	}
	
	public void move(int X, int Y)
	{
	
	x = X;
	y = Y;
	
	rect1 = new Rectangle2D.Double();
	rect1.setRect(x, y, w, h);
	rect2 = new Rectangle2D.Double();
	rect2.setRect(((2*x+w)/2),(y+h)-(.4*h),.2*w,.4*h);
	line1 = new Line2D.Double(x,(h*1/7)+y,x+w,(h*1/7)+y);
	line2 = new Line2D.Double(x,(h*2/7)+y ,x+w,(h*2/7)+y);
	line3 = new Line2D.Double(x,(h*3/7)+y ,x+w,(h*3/7)+y);
	line4 = new Line2D.Double(x,(h*4/7)+y ,x+w,(h*4/7)+y);
	line5 = new Line2D.Double(x,(h*5/7)+y ,x+w,(h*5/7)+y);
	line6 = new Line2D.Double(x,(h*6/7)+y ,x+w,(h*6/7)+y);
	line7 = new Line2D.Double(x,(h*7/7)+y,x+w,(h*7/7)+y);
	poly = new Polygon();
	int x1 = (int)(x);
	int y1 = (int)(y);
	int w1 = (int)(w);
	int h1 = (int)(h);
	int workx = (int)(work);
	int work2 = (int)(work1);
	poly.addPoint(x1,y1);
	poly.addPoint(x1+w1,y1);
	poly.addPoint(workx*w1+x1,y1-h1); 
	poly.addPoint(work2*w1+x1,y1-h1);
	
	rect3 = new Rectangle2D.Double();
	rect3.setRect(x+.2*w,y-(.4*h),.2*w,.4*h);
	
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
		return ("Cabin:" + x + ":" + y + ":" + size);
	}
	
}
	
	
	
	
	
	
	
	

