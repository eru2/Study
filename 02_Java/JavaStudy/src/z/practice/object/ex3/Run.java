package z.practice.object.ex3;

import java.util.Scanner;

public class Run {
	public static void main(String[] args) {
		//choi 객체 생성 최지원, 15살, 수학 : 80,  영어 : 60, 국어 : 90
		//kim 객체 생성 김민수, 17살,  수학 : 60, 영어 : 75, 국어 : 70
		//park 객체 생성 박지민, 19살,  수학 : 90, 영어 : 45, 국어 : 85
		
		Student choi = new Student("최지민", 15, 80, 60, 90);
		Student kim = new Student("김민수", 17, 60, 75, 70);
		Student park = new Student("박지민", 19, 90, 45, 85);
		
		//각 학생의 평균을 구하세요
		double choiAvg = (choi.enScore + choi.koScore + choi.mathScore)/3.0;
		double kimAvg = (kim.enScore + kim.koScore + kim.mathScore)/3.0;
		double parkAvg = (park.enScore + park.koScore + park.mathScore)/3.0;
		

		double choiAvg2 = choi.getAvg();
		double kimAvg2 = kim.getAvg();
		double parkAvg2 = park.getAvg();
		
		choi.myInfo();
		kim.myInfo();
		park.myInfo();
		
		System.out.println(choi.name + "의 평균 : " + choiAvg);
		System.out.println(kim.name + "의 평균 : " + kimAvg);
		System.out.println(park.name + "의 평균 : " + parkAvg);
		System.out.println("=========================================");
		System.out.println(choi.name + "의 평균 : " + choiAvg2);
		System.out.println(kim.name + "의 평균 : " + kimAvg2);
		System.out.println(park.name + "의 평균 : " + parkAvg2);
		System.out.println("=========================================");

		
		//lee라는 객체를 만들 것이다.
		//사용자로부터 이름, 나이, 영어점수, 수학점수, 국어점수를 입력받아
		//평균을 구해서 출력하는 프로그램
		Scanner sc = new Scanner(System.in);
		
		
		String name;
		int age;
		double mathScore, koScore, enScore;
		
		System.out.print("이름 : ");
		name = sc.next();
		System.out.print("나이 : ");
		age = sc.nextInt();
		System.out.print("수학 점수 : ");
		mathScore = sc.nextDouble();
		System.out.print("영어 점수 : ");
		enScore = sc.nextDouble();
		System.out.print("국어 점수 : ");
		koScore = sc.nextDouble();
		
//		Student lee = new Student();
//		System.out.print("이름 : ");
//		lee.name = sc.next();
//		System.out.print("나이 : ");
//		lee.age = sc.nextInt();
//		System.out.print("수학 점수 : ");
//		lee.mathScore = sc.nextInt();
//		System.out.print("영어 점수 : ");
//		lee.enScore = sc.nextInt();
//		System.out.print("국어 점수 : ");
//		lee.koScore = sc.nextInt();
		
		
		Student lee = new Student(name, age, mathScore, enScore, koScore);
		
		double leeAvg = (lee.mathScore + lee.koScore + lee.enScore)/3.0;
		System.out.println(lee.name + "의 평균 : " + leeAvg);
		System.out.println("=========================================");

		
		//kh대학교 evgcut : 75, encut : 60, kocut : 60
		University kh = new University("kh대학교", 75, 60, 60);
		
		kh.apply(lee);
		kh.apply(park);
		kh.apply(kim);
		kh.apply(choi);
		
		System.out.println("=========================================");
		kh.apply(lee.name, lee.getAvg(), lee.enScore, lee.koScore);
		kh.apply(park.name, park.getAvg(), park.enScore, park.koScore);
		kh.apply(kim.name, kim.getAvg(), kim.enScore, kim.koScore);
		kh.apply(choi.name, choi.getAvg(), choi.enScore, choi.koScore);
		
		
		
	}

}
