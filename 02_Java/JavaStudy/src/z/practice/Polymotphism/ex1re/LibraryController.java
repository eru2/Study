package z.practice.Polymotphism.ex1re;

public class LibraryController {

	private Member mem = null;
	private Book[] bList = new Book[5];
	
	
	
	
	public LibraryController() {
		super();
		bList[0] = new CookBook("백종원의 집밥", "백종원", "tvN", true);
		bList[1] = new AniBook("한번 더 해요", "미티", "원모어", 19);
		bList[2] = new AniBook("루피의 원피스", "루피", "japan", 12);
		bList[3] = new CookBook("이혜정의 얼마나 맛있게요", "이혜정", "문학", false);
		bList[4] = new CookBook("최현석 날 따라해봐", "최현석", "소금책", true);

	}

	public void insertMember(Member mem) {
		this.mem = mem;
	}
	
	public Member myInfo() {
		return mem;
	}
	
	public Book[] selectAll() {
		return null;
	}
	
	public Book[] searchBook(String keyword) {
		return null;
	}
	
	public int rentBook(int index) {
		return 0;
	}
	
}
