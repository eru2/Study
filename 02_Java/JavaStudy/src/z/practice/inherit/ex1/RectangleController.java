package z.practice.inherit.ex1;

public class RectangleController {
	
	Rectangle r = new Rectangle();
	
	public String calcArea(int x, int y, int height, int width) {
		r.setX(x);
		r.setY(y);
		r.setHeight(height);
		r.setWidth(width);
		
		int Area = r.getHeight() * r.getWidth();
		return "면적 : " + r.toString() + " / " + Area;
	}
	
	
	public String calcPerimeter(int x, int y, int height, int width) {
		
		r.setX(x);
		r.setY(y);
		r.setHeight(height);
		r.setWidth(width);
		int Perimeter = (r.getHeight() + r.getWidth()) * 2;
		return "둘레 : " +  r.toString() +  " / " + Perimeter;
	}

}
