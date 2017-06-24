//class

public class man
{
		
		private int height, weight;
		private boolean man;
		
		public man(int h, int w)
		{
		height = h;
		weight = w;
		}
		
		public man(man one)
		{
		this.man = one.man;
		}
		
		public void setHeight(int l)
		{
		height = l;
		}
		
		public void setWeight(int m)
		{
		weight = m;
		}
		
		public void setBoole(boolean gender)
		{
		man = gender;
		}
		
		public String toString()
		{
		StringBuilder b = new StringBuilder();
		b.append(height + "\n");
		b.append(weight + "\n");
		b.append(man + "\n");
		return b.toString();
		}
		
}