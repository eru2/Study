package z.practice.oop.ex6.re;

public class MemberController {

	Member[] m = new Member[SIZE];
	public static int SIZE = 10;

	public int existMembrNum() {
		int count = 0;
		for(int i = 0; i < m.length; i++) {
			if(m[i] == null)
				break;
			count++;
		}
		return count;

	}

	public Boolean checkId(String inputId) {
		return false;
	}

	public void insertMember(String id, String name, String password, String email, char gender, int age) {
		
	}

	public String searchId(String id) {
		return null;
	}

	public Member[] searchName(String name) {
		return null;
	}

	public Member[] searchEmail(String email) {
		return null;
	}

	public Boolean updatePassword(String id, String password) {
		return false;
	}

	public Boolean updateName(String id, String name) {
		return false;
	}

	public Boolean updateEmail(String id, String email) {
		return false;
	}

	public Boolean delete(String id) {
		return false;
	}

	public void delete() {

	}

	public Member[] printAll() {
		return m;
	}

}
