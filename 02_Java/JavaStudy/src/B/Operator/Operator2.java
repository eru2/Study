package B.Operator;

public class Operator2 {
	
	/*
	 * 증강연산자
	 * ++ : 변수에 담긴 값을 1증가시켜주는 연산자
	 * 
	 * -- : 변수에 담긴 값을 1감소시켜주는 연산자
	 * 
	 * (증감연산)변수 : 전위연산 -> "선증감" 후 처리
	 * 변수(증감연산) : 후위연산 -> 선처리 "후증감"
	 * 
	 */
	public static void main(String[] ags) {
		int num1 = 0;
		
		System.out.println(num1++); // 0 (0 + 1) 
		System.out.println(++num1); // (1 + 1) 2
		System.out.println(num1--); // 2 (2 - 1)
		System.out.println(++num1); // (1 + 1) 2
		System.out.println(++num1); // (2 + 1) 3
		System.out.println(num1++); // 3 (3 + 1)
		System.out.println(num1--); // 4 (4 - 1)
		System.out.println(--num1); // (3 - 1) 2
		System.out.println(--num1); // (2 - 1) 1
		System.out.println(num1++); // 1 (1 + 1)
		System.out.println(num1--); // 2 (2 - 1)
		System.out.println(++num1); // (1 + 1) 2
		System.out.println(num1--); // 2 (2 - 1)
		System.out.println(num1++); // 1 (1 + 1)
		System.out.println(--num1); // (2 - 1) 1
	}

}
