package z.practice.list.ex1.re;

public class Music {
	
	private String title;
	private String Singer;
	
	
	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getSinger() {
		return Singer;
	}


	public void setSinger(String singer) {
		Singer = singer;
	}


	public Music(String title, String singer) {
		super();
		this.title = title;
		Singer = singer;
	}


	@Override
	public String toString() {
		return "Music [title=" + title + ", Singer=" + Singer + "]";
	}


	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}


	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	
	
	public void compareTo() {
		
	}
	

}
