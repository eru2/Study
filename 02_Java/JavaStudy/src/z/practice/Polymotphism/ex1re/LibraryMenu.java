package z.practice.Polymotphism.ex1re;

import java.util.Scanner;

public class LibraryMenu {
	
	private LibraryController lc;
	private Scanner sc = new Scanner(System.in);
	
	
	public void mainMenu() {
		
		
		System.out.print("이름 : ");
		String name = sc.next();
		System.out.print("나이 : ");
		int age = sc.nextInt();
		System.out.print("성별 : ");
		char gender = sc.next().charAt(0);
		Member mem = new Member(name, age, gender);
		lc.insertMember(mem);
		
		while(true) {
			System.out.println();
			System.out.println(" ==== 메뉴 ====");
			System.out.println("1. 마이페이지");
			System.out.println("2. 도서 전체 조회");
			System.out.println("3. 도서 검색");
			System.out.println("4. 도서 대여");
			System.out.println("5. 도서 추가");
			System.out.println("6. 도서 삭제");
			System.out.println("9. 프로그램 종료");
			System.out.print("메뉴 번호 : ");
			int ch = sc.nextInt();
			sc.nextLine();
			
			switch(ch) {
			case 1:
				lc.myInfo();
				break;
			case 2:
				this.selectAll();
				break;
			}
		}

//		 // 무한 반복 실행
//		1. 마이페이지 // LibraryController의 myInfo() 호출하여 출력
//		2. 도서 전체 조회 // LibraryMenu의 selectAll() 호출
//		3. 도서 검색 // LibraryMenu의 searchBook() 호출
//		4. 도서 대여하기 // LibraryMenu의 rentBook() 호출
//		9. 프로그램 종료하기
//		메뉴 번호 : 
		
	}
	
	public void selectAll() {
		
		Book[] bList = lc.selectAll();
		for(int i = 0; i < bList.length && bList[i] != null; i++) {
			System.out.println(i + "번도서 " + bList[i]);
			i++;
		}
	}
	
	public void searchBook() {
		
	}
	
	public void rentBook() {
		
	}

}
