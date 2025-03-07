package z.practice.Polymotphism.ex1;

import java.util.Scanner;

public class LibraryMenu {
	
	private LibraryController lc = new LibraryController();
	private Scanner sc = new Scanner(System.in);

	public void mainMenu() {
		
		System.out.print("이름 : ");
		String name = sc.next();
		System.out.print("나이 : ");
		int age = sc.nextInt();
		System.out.print("성별 : ");
		char gender = sc.next().charAt(0);
		
		
		Member member = new Member(name, age, gender);
		
		lc.insertMember(member);
		
		while(true) {
			System.out.println();
			System.out.println(" ==== 메뉴 ==== ");
			System.out.println("1. 마이페이지");
			System.out.println("2. 도서 전체 조회");
			System.out.println("3. 도서 검색");
			System.out.println("4. 도서 대여하기");
			System.out.println("5. 도서 추가");
			System.out.println("6. 도서 삭제");
			System.out.println("9. 프로그램 종료하기");
			System.out.print("메뉴 번호 : ");
			int ch0 = sc.nextInt();
			sc.nextLine();
			
			
			switch(ch0) {
			case 1:
				lc.myInfo();
			    System.out.println("회원 정보: " + lc.myInfo());
				break;
			case 2:
				this.selectAll();
				break;
			case 3:
				this.searchBook();
				break;
			case 4:
				this.rentBook();
				break;
			case 5:
				if(lc.isInsertBook()) {
					this.addBook();
				} else {
					System.out.println("추가가능한 도서의 수를 초과하였습니다.");
				}
				break;
			case 6:
				this.deleteBook();
				break;
			case 9:
				System.out.println("프로그램을 종료합니다.");
				return;
				default:
					System.out.println("잘 못 입력하셨습니다. 다시 입력 해주세요.");
			}

		}
		
		
	}
	
	public void selectAll() {
		Book[] bList = lc.selectAll();
		for(int i=0; i < bList.length && bList[i] != null; i++) {
			System.out.println(i + "번도서 : " + bList[i]);
		}
		
	}
	
	public void searchBook() {
		System.out.print("검색할 제목 키워드 : ");
		String keyword = sc.next();
		lc.searchBook(keyword);
		Book[] searchList = lc.searchBook(keyword);
		for(int i = 0; i < searchList.length && searchList[i] != null; i++) {
			System.out.println(searchList[i]);
		}
//		 if (searchList.length == 0) {
//		        System.out.println("검색 결과가 없습니다.");
//		        return;
//		    } else {
//		        for (Book SL : searchList) {
//		            System.out.println(SL);
//		        }
//		    }
	}
	
	public void rentBook() {
		selectAll();
		System.out.print("대여할 도서 번호 선택 : ");
		int index = sc.nextInt();
		
		int result = lc.rentBook(index);
		
		switch(result) {
		case 0:
			System.out.println("성공적으로 대여되었습니다.");
			break;
		case 1:
			System.out.println("나이 제한으로 대여 불가능입니다.");
			break;
		case 2:
			System.out.println("성공적으로 대여되었습니다. 요리학원 쿠폰이 발급되었으니 마이페이지에서 확인하세요");
			break;
		}
		
	}
	
	public void deleteBook() {
		selectAll();
		System.out.print("삭제할 도서 제목 : ");
		String title = sc.next();
		
		boolean result = lc.deleteBook(title);
		if(result) {
			System.out.println("삭제완료되었습니다.");
		} else {
			System.out.println("존재하지 않는 책입니다.");
		}
	}
	
	public void addBook() {		
//		if(lc.bList.length == 10) {
//			for(int i = 0; i < lc.bList.length; i++) {
//				if(lc.bList ==null) {
//					break;
//				} else
//					count++;
//				System.out.println("현재 도서는 " + count + "권으로 추가 가능합니다.");
//			}
//		} else {
//			System.out.println("도서 추가를 할 수 없습니다.");
//		}
		while (true) {
			System.out.println("==================도서 추가================");
			System.out.println("어떤 도서를 추가하시겠습니까?");
			System.out.println("1. 만화책  2. 요리책");
			System.out.print("번호 입력 : ");
			int type = sc.nextInt();
			
			if(!(type == 1 || type == 2)) {
				System.out.println("잘못입력하셨습니다.");
				continue;
			}
			
			System.out.print("제목을 입력하세요 : ");
			String title = sc.nextLine();
			
			System.out.print("저자를 입력하세요 : ");
			String author = sc.nextLine();
			
			System.out.print("출판사를 입력하세요 : ");
			String publisher = sc.nextLine();
			int index = 0;
			switch(type) {
			case 1:
				System.out.print("연력제한 나이를 입력하세요 : ");
				int accessAge = sc.nextInt();
				index = lc.addBook(new AniBook(title, author, publisher, accessAge));
			case 2:
				System.out.print("쿠폰 여부(y/n) : ");
//				char isCoupon = sc.next().charAt(0);
				boolean isCoupon = (sc.next().toLowerCase().charAt(0) == 'y');
				index = lc.addBook(new CookBook(title, author, publisher, isCoupon));
				
			}
			System.out.println(index + "번에 추가");
			break;
		}
	}
}
