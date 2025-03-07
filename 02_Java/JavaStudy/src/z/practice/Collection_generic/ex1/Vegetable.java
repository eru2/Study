package z.practice.Collection_generic.ex1;

import java.util.Objects;

public class Vegetable extends Farm {

	private String name;

	public Vegetable() {
		super();
	}

	public Vegetable(String kind, String name) {
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
		if(obj instanceof Vegetable) {
			Vegetable vg = (Vegetable)obj;
			if(this.getKind().equals(vg.getKind()) && this.name.equals(vg.getName())) {
				return true;
			}
		}
		return false;
	}

}
