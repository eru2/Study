package z.practice.inherit.ex1;

public class CircleController {
	
	private Circle c = new Circle();
	
	public String calcArea(int x, int y, int radius) {
		double PI = 3.14;
		c.setX(x);
		c.setY(y);
		c.setRadius(radius);
		
		double Area = c.getRadius() * c.getRadius() * PI;
		return "면적 : " + c.toString() +  " / " + Area;
	}
	
	public String calcCircum(int x, int y, int radius) {
		double PI = 3.14;
		c.setX(x);
		c.setY(y);
		c.setRadius(radius);
		
		double circum = PI * 2 * c.getRadius();
		return "둘레 : " + c.toString() +  " / " + circum;
	}

}
