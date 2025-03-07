package B.Operator;

public class Operator3 {

	/*
	 * 산술연산자
	 * + - * / %
	 * 
	 *  * / % > + -
	 *  
	 *  복합대입연산자
	 *  산술연산자와 대입연산자를 결항해서 사용할 수 있다.
	 *  
	 *  += /= *= %=
	 *  
	 *  a = a + 3 -> a += 3; 
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 5;
		int b = 10;
		int c = (++a) + b; // a = 6, b= 10; c = 16
		int d = 16 / 6;  // d = 2
		int e = c % a; // e = 4 (16 % 6 = 4)
		int f = e++; // e = 5, f=4
		int g = (--b) + (d--); // b = 9, d = 1, g = 11 
		int h = 2; 
		
		int i = (a++) + b / (--c / f ) * (g-- - d) % (++e + h); // a = 7, b = 9, c = 15, f = 4, g = 10, d = 1, e = 6, h = 2
		// 6 + 9 / (15/4) * (11 - 1) % (6 + 2) = 6 + 9 / 3 * 10 % 8 =  6 + 3 * 10 % 8 = 6 + 30 % 8 = 6 + 6 = 12
		//최종적으로 각 변수에 값이 얼마나 들어있는지 예측해보기 
		System.out.println(i);
		
		int j = ((a--) + (++c)) * (++d) + (i--) / (e++) % (--b) - (f++) * (++g) % (--h); // a = 6, b = 8, c = 16, d = 2, e = 7, f = 5, g = 11, h = 1, i = 11
		      // 7 + 16 * 2 + 12 / 6 % 8 - 4 * 11 % 1  = 23 * 2 + 12 / 6 % 8 - 4 * 11 % 1 = 46 + 12 / 6 % 8 - 44 % 1 = 46 + 2 % 8 - 0 = 46 + 2 = 48 
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		System.out.println(e);
		System.out.println(f);
		System.out.println(g);
		System.out.println(h);
		System.out.println(i);
		System.out.println(j);
	}

}
