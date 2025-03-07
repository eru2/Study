package z.practice.object;


public class Run{

	public static void main(String[] args) {
		Member st1 = new Member("abc", "abc", "name1");
		Member st2 = new Member("bcd", "bcd", "name2");
		Member st3 = new Member("cde", "cde", "name3");
		
		st1.setInfo("01011112222", "aaa@naver.com", 20, "남");
		st2.setInfo("01022223333", "bbb@naver.com", 30, "여");
		st3.setInfo("01033334444", "ccc@naver.com", 25, "여");
		
		st1.toInfo();
		st2.toInfo();
		st3.toInfo();
	}
}
