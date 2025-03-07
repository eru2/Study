package com.book.jdbc.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.book.jdbc.controller.MemberController;
import com.book.jdbc.model.vo.Book;
import com.book.jdbc.model.vo.Member;


public class MemberMenu {

	
	private Scanner sc = new Scanner(System.in);
	MemberController mc = new MemberController();
	
	public void firstMenu() {
		while(true) {
			System.out.println("1. 로그인");
			System.out.println("2. 회원가입");
			System.out.println("9. 종료");
			System.out.print("메뉴 입력 : ");
			int log = sc.nextInt();
			sc.nextLine();
			
			switch(log) {
			case 1:
				this.logIn();
				break;
			case 2:
				this.insertMember();
				break;
			case 9:
				System.out.println("프로그램을 종료합니다.");
				return;
				default:
					System.out.println("잘못입력하셨습니다. 다시 입력해주세요.");
			}
		}
	}
	
	public void logIn() {
		System.out.println("----- 로그인 페이지 -----");
		System.out.print("\n아이디 : ");
		String memberId = sc.nextLine();
		System.out.print("비밀번호 : ");
		String memberPwd = sc.nextLine();
		
		mc.logIn(memberId, memberPwd);
		
	}
	public void insertMember() {
		System.out.println("----- 회원가입 페이지 -----");
		System.out.print("\n아이디 : ");
		String memberId = sc.nextLine();
		System.out.print("비밀번호 : ");
		String memberPwd = sc.nextLine();
		System.out.print("이름 : ");
		String memberName = sc.nextLine();
		System.out.print("성별(M/F) : ");
		String gender = sc.nextLine();
		System.out.print("주소 : ");
		String address = sc.nextLine();
		System.out.print("전화번호 : ");
		String phone = sc.nextLine();
		
		mc.insertMember(memberId, memberPwd, memberName, gender, phone, address);
	}
	//로그인 성공(유저페이지)
	public void userPage(String memberName, String memberId) {
		System.out.println("\n------ 환영합니다! " + memberName + "님 -----");
		while(true) {
			System.out.println("1. 전체 도서 출력");
			System.out.println("2. 도서 검색");
			System.out.println("3. 도서구매");
			System.out.println("4. 회원정보 변경");
			System.out.println("5. 회원 탈퇴");
			System.out.println("9. 로그아웃");
			System.out.print("메뉴 입력 : ");
			int menu = sc.nextInt();
			sc.nextLine();
			switch(menu) {
			case 1:
				mc.selectBookList();
				break;
			case 2:
				this.selectByBookTitle();
				break;
			case 3:
				this.buyBook(memberId);
				break;
			case 4:
				this.checkMember(memberId);
				break;
			case 5:
				this.deleteMember(memberId);
				break;
			case 9:
				System.out.println("로그아웃 되었습니다.");
				return;
				default:
					System.out.println("메뉴를 잘못입력하셨습니다. 다시 입력해주세요.");
			}
		}
	}
	public void selectByBookTitle() {
		System.out.print("키워드 입력 : ");
		String keyword = sc.nextLine();
		
		mc.selectByBookTitle(keyword);
	}
	
	public void buyBook(String memberId) {
		System.out.println("구매할 도서 제목: ");
		String title = sc.nextLine();
		
		mc.buyBook(title, memberId);
	}
	
	public void checkMember(String memberId) {
		System.out.print("비밀번호 : ");
		String pwd = sc.nextLine();
		
		mc.checkMember(memberId, pwd);
	}
	
	public void updateMember(Member m) {
		System.out.print("이름 : ");
		String memberName = sc.nextLine();
		System.out.print("성별(M/F) : ");
		String gender = sc.nextLine();
		System.out.print("주소 : ");
		String address = sc.nextLine();
		System.out.print("전화번호 : ");
		String phone = sc.nextLine();
		
		mc.updateMember(m, memberName, gender, address, phone);
	}
	
	public void deleteMember(String memberId) {
		System.out.print("탈퇴하시겠습니까? (Y/N) : ");
		String del = sc.nextLine();
		
		mc.deleteMember(del, memberId);
	}
	
	public void administratorPage() {
		while(true) {
			System.out.println("\n------ 관리자페이지 -----");
			System.out.println("0. 전체 도서 조회");
			System.out.println("1. 신규 도서 추가");
			System.out.println("2. 도서 정보 수정");
			System.out.println("3. 도서 삭제");
			System.out.println("4. 회원 전체 조회");
			System.out.println("5. 회원 삭제");
			System.out.println("6. 회원 검색");
			System.out.println("9. 로그아웃");
			System.out.print("메뉴 입력 : ");
			int menu = sc.nextInt();
			sc.nextLine();
			
			switch(menu) {
			case 0:
				mc.selectBookList();
				break;
			case 1:
				this.insertBook();
				break;
			case 2:
				this.updateBook();
				break;
			case 3:
				this.deleteBook();
				break;
			case 4:
				mc.getAllMembers();
				break;
			case 5:
				this.memberDelete();
				break;
			case 6:
				this.selectMember();
				break;
			case 9:
				System.out.println("로그아웃 되었습니다.");
				return;
				default:
					System.out.println("메뉴를 잘못입력하셨습니다. 다시 입력해주세요.");
			}
		}
	}
	public void insertBook() {
		System.out.print("제목 : ");
		String title = sc.nextLine();
		
		System.out.print("작가 : ");
		String author = sc.nextLine();
		
		System.out.print("개수 : ");
		int num = sc.nextInt();
		
		System.out.print("가격 : ");
		int price = sc.nextInt();
		sc.nextLine();
		
		System.out.print("출판서 전화번호 : ");
		String pubno = sc.nextLine();
		
		mc.insertBook(title, author, num, price, pubno);
	}
	public void updateBook() {
		System.out.print("수정할 도서 번호 : ");
		int no = sc.nextInt();
		sc.nextLine();
		System.out.print("도서 제목 : ");
		String title = sc.nextLine();
		
		System.out.print("작가 : ");
		String author = sc.nextLine();
		
		System.out.print("개수 : ");
		int num = sc.nextInt();
		
		System.out.print("가격 : ");
		int price = sc.nextInt();
		
		System.out.print("출판서 전화번호 : ");
		String pubno = sc.nextLine();
		
		mc.updateBook(no, title, author, num, price, pubno);
	}
	public void deleteBook() {
		System.out.print("삭제할 도서 제목 : ");
		String title = sc.nextLine();
		
		mc.deleteBook(title);
	}
	public void memberDelete() {
		System.out.print("삭제할 회원 Id : ");
		String memberId = sc.nextLine();
		
		System.out.print("삭제하시겠습니까? (Y/N) : ");
		String del = sc.nextLine();
		
		mc.deleteMemberByroot(del, memberId);
	}
	public void selectMember() {
		 System.out.print("검색할 회원 Id : ");
		 String memberId = sc.nextLine();
		 
		 mc.searchMemberById(memberId);
	}

	//------------------------------------- 응답 화면 ---------------------------------
	//로그인실패 -> 처음화면으로 이동
	public void NonLog(String message) {
		System.out.println(message);
		this.firstMenu();
	}
	//회원가입 성공, 도서구매 성공
	public void displaySuccess(String message) {
		System.out.println(message);
	}
	//회원가입실패, 도서구매 실패
	public void displayFail(String message) {
		System.out.println(message);
	}
	
	//도서 정보 없음
	public void displayNoDate(String message) {
		System.out.println(message);
	}
	//도서 전체 조회
	public void displayBookList(ArrayList<Book> list) {
		for(Book b : list) {
			System.out.println(b);
		}
	}
	
	public void notUserPwd(String message) {
		System.out.println(message);
	}
	//회원정보수정 성종
	public void updateSuccess(String message) {
		System.out.println(message);
	}
	//회원정보수정실패
	public void updateFail(String message) {
		System.out.println(message);
	}
	//회원탈퇴성공
	public void deleteSuccess(String message) {
		System.out.println(message);
		this.firstMenu();
	}
	//회원탈퇴실패
	public void deleteFail(String message) {
		System.out.println(message);
	}
	public void deleteSuccessbyroot(String message) {
		System.out.println(message);
	}

	public void displayMemberList(ArrayList<Member> list) { 
	    if (list.isEmpty()) {
	        System.out.println("전체 조회 결과가 없습니다.");
	    } else {
	        for (Member m : list) {
	            System.out.println(m);
	            ArrayList<Book> b = mc.BooksByMember(m.getMemberNo());  // 회원의 도서 목록 조회
	            if (b != null && !b.isEmpty()) {
	                for (Book book : b) {
	                    System.out.println(" : " + book.getBookTitle() + " - " + book.getBookAuthor() + " - " + book.getBookPrice());
	                }
	            } else {
	                System.out.println("구매한 도서가 없습니다.");
	            }
	        }
	    }
	}
}
