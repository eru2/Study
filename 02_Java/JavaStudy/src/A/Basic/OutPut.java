package A.Basic;

public class OutPut {
	public static void main(String[] args) {
		//코드를 사용하는 영역
		
		//출력문
		//println() -> 개행문자를 포함
		System.out.println("안녕하세요");

		//print() -> 일반 출력문
		// \n -> 개행문자(줄바꾸기)
		System.out.print("저는 최지원입니다. \n");
		
		//printf() -> 문자열 포멧을 이용한 출력문 C에서 출력하는 것처럼 출력이 가능해진다.
		//System.out.printf(문자열포멧, 값1, 값2, 값3);
		String name = "최지원";
		int age = 20;
		System.out.println("저는 " + name + "이고 나이는 " + age + "입니다.");
		System.out.printf("저는 %s이고 나이는 %d입니다. \n", name, age);
		
		/*
		 * 포멧안에서 쓸 수 있는 키워드
		 * %d : 정수
		 * %c : 문자(한글자)
		 * %s : 문자열
		 * %f : 실수
		 */
		
		/*
		 주석 : 컴퓨터는 인식하지 않고 사람이 필요에 따라 설명 등을 저어두는 용도
		 */
	}

}
