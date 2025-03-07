package z.practice.oop.ex3;

public class Human {

	private String name;
	private int money;
	
	public Human() {
		super();
	}


	public Human(String name, int money) {
		super();
		this.name = name;
		this.money = money;

	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getMoney() {
		return money;
	}


	public void setMoney(int money) {
		this.money = money;
	}

	
	public void buy(TV tv) {
		if(tv.getPrice() <= this.money) {
			System.out.println(this.name + "님의 구매내역");
			tv.show();
			this.money -= tv.getPrice();
			System.out.println("남은 잔액 : " + this.money);
		}else {
			System.out.println(this.name + "님 잔액이 부족하여 구매하실 수 없습니다.");//구매불가
		}
			
	}
		
		
	
}
