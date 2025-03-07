package z.practice.set.ex1;

import java.util.Objects;

public class Lottery {
	
	private String name;
	private String phone;
	
	
	public Lottery() {
		super();
	}


	public Lottery(String name, String phone) {
		super();
		this.name = name;
		this.phone = phone;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	@Override
	public String toString() {
		return name + " (" + phone + ")";
	}


	@Override
	public int hashCode() {
		return Objects.hash(name, phone);
//		return ("" + name + phone).hashCode();
	}


	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Lottery) {
			Lottery lottery = (Lottery)obj;
			if(lottery.getName().equals(this.name) &&
					lottery.getPhone().equals(this.phone)) {
				return true;
			}
//			if(this.name.equals(lottery)) {
//				
//			}
		}
		return false;
	}
	
	
}
