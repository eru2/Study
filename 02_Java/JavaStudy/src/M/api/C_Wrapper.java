package M.api;

public class C_Wrapper {
	
	/*
	 * Wrapper 클래스
	 * -> 기본 자료형을 객체로 포장해줄 수 있는 크랠스가 래퍼클레스이다.
	 * 
	 * boolean(Boolean)
	 * char(Character)
	 * byte(Byte)
	 * short(Short)
	 * int(Integer)
	 * long(Long)
	 * float(Float)
	 * double(Double)
	 * 
	 * => 웥시타입을 객체로 표현할 경우
	 *    - 메서드를 호출해야할 때
	 *      - 메서드의 메ㅔ변수가 기본가료형이 아닌 객체타입만 요구될 때
	 *    - 다형성을 적용시키고 싶을 때
	 *    
	 */
	
	public void method01() {
		//Boxing : 기본자료형 -> Wrapper클래스 자료형
		int num1 = 10;
		int num2 = 20;
		int num1_2 = 10;
		
//		System.out.println(num1.equals(num2));
		
		// 1. 객체생성구문을 통해서 변경
		Integer i1 = new Integer(num1);
		Integer i2 = new Integer(num2);
		Integer i1_2 = new Integer(num1_2);
		
		System.out.println(i1);
		System.out.println(i2);
		
		System.out.println(i1.equals(i2));
		System.out.println(i1.equals(i1_2));
		System.out.println(i1.compareTo(i2));//두 값을 비교해서 앞쪽이 크면 1반환, 뒤쪽이 더 크면 -1 반환, 같으면 0 반환
		
		// 2. 객체생성 하지않고 곧바로 대입(AutoBoxing)
		Integer i3 = num1;
		System.out.println(i3);
		
		//문자열을 Integer타입으로 변환하고 싶을 때 -> 객체생성을 통해서 가능
		Integer i4 = Integer.parseInt("123");
		Integer i5 = new Integer("123");
//		Integer i6 = "456"; 이건 안됨
		
		System.out.println(i4);
		System.out.println(i5);
		
		
		// Unboxing : Wrapper클래스 자료형 -> 기본자료형
		
		// 1. 해당 그 Wrapper클래스에서 제공하는 xxxValue()메서드를 통해서 가능
		int num3 = i3.intValue();
		int num4 = i4.intValue();
		
		// 2. 메서드를 사용하지않고 바로대입(AutoUnboxing)
		int num5 = i3;
		
		//기본자료형 < -- > String
		String str1 = "10";
		String str2 = "15.5";
		
		System.out.println(str1 + str2);
		
		//String -> 기본자료형
		//해당 Wrapper클래스.parsexxx()사용
		int i = Integer.parseInt(str1);
		double d = Double.parseDouble(str2);
		System.out.println(i + d);
	}

}
