package z.practice.Collection_generic.ex1;

import java.util.Objects;

public class Nut extends Farm{
	
	private String name;

	public Nut() {
		super();
	}

	public Nut(String kind, String name) {
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
		if(obj instanceof Nut) {
			Nut nu = (Nut)obj;
			if(this.getKind().equals(nu.getKind()) && this.name.equals(nu.getName())) {
				return true;
			}
		}
		return false;
	}
	
	

}
