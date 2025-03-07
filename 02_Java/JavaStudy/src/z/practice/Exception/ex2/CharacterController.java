package z.practice.Exception.ex2;

public class CharacterController {

	public CharacterController() {
		super();
	}

	public int countAlpha(String s) throws CharCheckException {
		int count = 0;
		if(s.contains(" ")) {
			throw new CharCheckException(" 체크할 문자열 안에 공백이 포함되어 있습니다.");
		} else {
			for(int i = 0; i < s.length(); i++) {
//				if((int)s.charAt(i) > 64 && (int)s.charAt(i) < 91 || (int)s.charAt(i)>96 && (int)s.charAt(i)<123)
				char ch = s.charAt(i);
				if((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <='Z'))
					count++;
			}
		}
		return count;
	}

}
