package J.interface1;

public class Rabbit implements Animal, Baby {

	@Override
	public void move() {
		// TODO Auto-generated method stub
		System.out.println("깡총깡총");
	}

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("뇸뇸 먹습니다.");
	}

	@Override
	public void makeSound() {
		// TODO Auto-generated method stub
		System.out.println("꿀꿀 부르릉");
	}

}
