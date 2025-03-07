package z.practice.Collection_generic.ex1;

import java.util.Objects;

public class Fruit extends Farm {
	
	private String name;

	public Fruit() {
		super();
	}

	public Fruit(String kind, String name) {
		super(kind);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return Objects.hash(super.hashCode(), name);
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Fruit) {
			Fruit fu = (Fruit)obj;
			if(this.getKind().equals(fu.getKind()) && this.name.equals(fu.getName())) {
				return true;
			}
		}
		return false;
	}
	
	
	
	

}
