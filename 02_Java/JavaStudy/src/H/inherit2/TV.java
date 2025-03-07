package H.inherit2;

public class TV extends Product {

	private int inch;

	public TV() {
		super();
		System.out.println("TV()");
	}

	public TV(String brand, String pCode, String pName, int price, int inch) {
		super(brand, pCode, pName, price);
		this.inch = inch;
	}

	public int getInch() {
		return inch;
	}

	public void setInch(int inch) {
		this.inch = inch;
	}
	
	
	public String information() {
		return super.information() + " / inch : " + this.inch;
	}
	
}
