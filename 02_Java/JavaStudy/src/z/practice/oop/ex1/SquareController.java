package z.practice.oop.ex1;

public class SquareController {
	
	private Shape s = new Shape();
	
	public double calcPerimeter(double height, double width) {
		s = new Shape(2, height, width);
		return (s.getWidth() * 2) + (s.getHeight() * 2);
	}
	
	public double calcArea(double height, double width) {
		s = new Shape(2, height, width);
		return s.getWidth() * s.getHeight();
	}
	
	public void paintColor(String color) {
		s.setColor(color);
	}
	public String print() {
		return "삼각형 " + s.information();
	}

}
