package J.interface1;

public class Dog implements Animal{

	@Override
	public void move() {
		System.out.println("깡총깡총 움직인다.");
	}

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("먹는다.");
		
	}

	@Override
	public void makeSound() {
		// TODO Auto-generated method stub
		System.out.println("멍멍~ 왈왈!!");
	}
	
	
}
