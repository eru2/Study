package z.practice.Polymotphism.ex1;

public class LibraryController {

	Member mem;
	Book[] bList = new Book[10];

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

		return bList;
	}

	public Book[] searchBook(String keyword) {
		/*
		 * 문자열에 특정 문자가 포함되어있는지 검사하는 방법 문자열.index('찾고자하는 문자열") -> index값 반환 / 못찾으면 -1 반환
		 * int num = "안녕하세요 최지원입니다.".indexOf("세요"); -> 3 int num =
		 * "안녕하세요 최지원입니다.".indexOf("횽"); -> -1 ->문자열에서 찾고자하는 문자열이 몇번째 index에 포함되어 있는지
		 * 찾고싶을 때 사용
		 * 
		 * 문자열.contains("찾고자하는 문자열") -> 찾고자하는 문자열이 포함되어있는지 찾고자하는 문자열이 포함되어 있다면 true반환
		 * 없다면 false반환
		 */
		int count = 0;
		Book[] Book = new Book[bList.length];

		for (int i = 0; i < bList.length; i++) {
			if (bList[i] == null) {
				break;
			}
			if (bList[i].getTitle().indexOf(keyword) != -1) {
				Book[count++] = bList[i];
			}
			/*
			 * if(bList[i].getTitle.contains(keyword)) { Book[count] = bList[i]; count++; }
			 */
		}
		return Book;
	}

	public int rentBook(int index) {
		int result = 0;
		Book bk = bList[index];

		if (bk instanceof AniBook) {
			int accessAge = ((AniBook) bk).getAccessAge();
			int memberAge = mem.getAge();
			if (accessAge > memberAge) {
				result = 1;
			}
		} else if (bk instanceof CookBook) {
			if (((CookBook) bk).isCoupon()) {
				mem.setCouponCount(mem.getCouponCount() + 1);
				result = 2;
			}
		}
		return result;
	}

	public Boolean deleteBook(String title) {
		Book[] Book = new Book[bList.length];
		for (int i = 0; i < bList.length; i++) {
			if (bList[i] == null) {
				return false;
			} else if (bList[i].getTitle().equals(title)) {
				for (int j = i; j < bList.length; j++) {
					if (j == bList.length - 1) {
						bList[j] = null;
						break;
					} else if (bList[j] == null) {
						break;
					}
					bList[j] = bList[j + 1];
				}
				return true;
			}
		}
		return false;
	}

	public boolean isInsertBook() {
		for (Book b : bList) {
			if (b == null) {
				return true;
			}
		}
		return false;
	}

	public int addBook(Book add) {
//		for(Book b : bList) {
//			if(b == null){
//				b = add;
//		        return;
//			}
//	}
		for (int i = 0; i < bList.length; i++) {
			if (bList[i] == null) {
				bList[i] = add;
				return i;
			}
		}
		return -1;
	}
}
