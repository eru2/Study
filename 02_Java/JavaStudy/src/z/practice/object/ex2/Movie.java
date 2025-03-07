package z.practice.object.ex2;

public class Movie {
	String title;
	String director;
	double rating;
	String member;
	boolean isPlaying;
	int price;
	
	
	public void myMovie(String title, String director, double rating, String member, boolean isPlaying, int price) {
		this.director = director;
		this.isPlaying = isPlaying;
		this.member = member;
		this.price = price;
		this.rating = rating;
		this.title = title;
	}

}
