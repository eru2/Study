package B.Operator;

import java.util.Scanner;

public class Practice1 {
	/*
	  키보드로 가로, 세로값을 실수형으로 입력받아 사각형의 면적과 둘레를 계산하여 출력
	  면적 : 가로 * 세로
	  둘레 : (가로 + 세로) * 2
	  
	  [출력창]
	  가로 : (키보드로 입력)
	  세로 : (키보드로 입력)
	  
	  면적 : ~
	  둘레 : ~
	  + 소수점 2번째 자리까지 출력
	  
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		float width, height;
		Scanner sc = new Scanner(System.in);
		System.out.print("사각형의 가로 길이 : ");
		width = sc.nextFloat();
		System.out.print("사각형의 세로 길이 : ");
		height = sc.nextFloat();
		
		float rou = (width + height) * 2;
		float area = (width * height);
		
		System.out.printf("사각형의 둘레는 : %.2f \n", rou);
		System.out.printf("사각형의 면적은 : %.2f \n", area);
	}

}
