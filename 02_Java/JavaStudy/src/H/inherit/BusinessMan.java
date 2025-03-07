package H.inherit;

public class BusinessMan extends Man{
	
	private String company;
	private String position;
	
	
	public BusinessMan(String name, String company, String position) {
		super(name);
		this.company = company;
		this.position = position;
		System.out.println("company : " + company);
	}
	
	
	public void tellYourInfo() {
		System.out.println("my compay is " + this.company);
		System.out.println("my position is " + this.position);
	}

}
