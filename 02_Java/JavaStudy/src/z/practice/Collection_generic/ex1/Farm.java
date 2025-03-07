package z.practice.Collection_generic.ex1;

import java.util.Objects;

public class Farm {
	
	private String kind;

	public Farm() {
		super();
	}

	public Farm(String kind) {
		super();
		this.kind = kind;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}
	

	@Override
	public String toString() {
		return "[kind=" + kind ;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return Objects.hash(kind);
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Farm) {
			Farm fa = (Farm)obj;
			if(this.kind.equals(fa.getKind())) {
				return true;
			}
		}
		return false;
	}
	
	

}
