package G.Option.ex1;

public class Product {
	String pName;
	int price;
	String brand;
	
	
	public Product(String pName, int price, String brand) {
		super();
	}
	
	
	

	public void information(String pName, int price, String brand) {
		System.out.println("이름 : " + pName);
		System.out.println("가격 : " + price);
		System.out.println("브랜드 : " + brand);
	}

}
