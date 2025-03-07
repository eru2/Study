package z.practice.Exception.ex1;

public class NumberController {

	public void menu() {
		
	}

	public boolean checkDouble(int num1, int num2) throws NumRangeException {
		if (num1 > 100 || num1 < 1 || num2 > 100 || num2 < 1) {
			throw new NumRangeException("1부터 100 사이의 값이 아닙니다.");
		} else {
			boolean check;
			check = (num1 % num2 == 0 ? true : false);
			return check;
		}
	}
}
