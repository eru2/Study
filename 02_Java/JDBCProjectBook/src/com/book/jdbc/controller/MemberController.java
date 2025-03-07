package com.book.jdbc.controller;

import java.util.ArrayList;

import com.book.jdbc.model.vo.Book;
import com.book.jdbc.model.vo.Member;
import com.book.jdbc.service.MemberService;
import com.book.jdbc.view.MemberMenu;

public class MemberController {

	private MemberService ms = new MemberService();

	// checkmember따로 만들기
	public void logIn(String memberId, String memberPwd) {
		String memberName = ms.logIn(memberId, memberPwd);
		
		if (memberName != null) {
			if("administrator".equals(memberId)) {
				new MemberMenu().administratorPage();
			} else {
				new MemberMenu().userPage(memberName, memberId);
			}
		} else {
			new MemberMenu().NonLog("아이디또는 비밀번호가 틀렸습니다. 처음 화면으로 돌아갑니다.");
		}
	}

	public void insertMember(String userId, String userPwd, String userName, String gender, String phone,
			String address) {

		Member m = new Member(userId, userPwd, userName, gender, phone, address);

		int result = ms.insertMember(m);

		if (result > 0) {
			new MemberMenu().displaySuccess("회원가입이 완료되었습니다.");
		} else {
			new MemberMenu().displayFail("회원가입에 실패하였습니다. 처음 화면으로 돌아갑니다.");
		}
	}

	public void selectBookList() {
		ArrayList<Book> list = ms.selectBookList();
		if (list.isEmpty()) {
			new MemberMenu().displayNoDate("전체 조회 결과가 없습니다.");
		} else {
			new MemberMenu().displayBookList(list);
		}
	}

	public void selectByBookTitle(String keyword) {
		ArrayList<Book> list = ms.selectByBookTitle(keyword);
		if (list.isEmpty()) {
			new MemberMenu().displayNoDate(keyword + "에 해당하는 검색 결과가 없습니다");
		} else {
			new MemberMenu().displayBookList(list);
		}
	}

	public void buyBook(String title, String memberId) {
		 int result = ms.buyBook(title, memberId);
		  if (result > 0) {
	            new MemberMenu().displaySuccess("도서 구매가 완료되었습니다.");
	        } else {
	            new MemberMenu().displayFail("도서 구매에 실패하였습니다.");
	        }
	    }
	
	public void checkMember(String memberId, String memberaPwd) {
		Member m = new Member();
		m.setMemberId(memberId);
		m.setMemberPwd(memberaPwd);

		if (ms.checkMember(m)) {
			new MemberMenu().updateMember(m);
		} else {
			new MemberMenu().notUserPwd("비밀번호가 맞지않습니다.");
		}
	}

	public void updateMember(Member m, String userName, String gender, String address, String phone) {
		Member updatem = new Member(m.getMemberId(), m.getMemberPwd(), userName, gender, address, phone);

		int result = ms.updateMember(updatem);

		if (result > 0) {
			new MemberMenu().updateSuccess("회원 정보 수정이 완료되었습니다.");
		} else {
			new MemberMenu().updateFail("회원 정보 수정에 실패하였습니다.");
		}
	}
	
	public void deleteMember(String del, String memberId) {
		if(del.toLowerCase().equals("y")) {
			int result = ms.deleteMember(memberId);
			if (result > 0) {
				new MemberMenu().deleteSuccess("탈퇴가 완료되었습니다.");
			} else {
				new MemberMenu().deleteFail("회원 탈퇴에 실패하였습니다.");
			}
		} else {
			new MemberMenu().deleteFail("회원 탈퇴를 취소하였습니다.");
		}
	}
	public void insertBook(String title, String author, int num, int price, String pubNo) {
		Book b = new Book(title, author, num, price, pubNo);
		int result = ms.insertBook(b);
		
		if (result > 0) {
			new MemberMenu().displaySuccess("도서추가가 완료되었습니다.");
		} else {
			new MemberMenu().displayFail("도서추가에 실패하였습니다.");
		}
	}
	public void updateBook(int no, String title, String author, int num, int price, String pubNo) {
		Book b = new Book(no, title, author, num, price, pubNo);

		int result = ms.updateBook(b);
		if (result > 0) {
			new MemberMenu().updateSuccess("도서 정보 수정이 완료되었습니다.");
		} else {
			new MemberMenu().updateFail("도서 정보 수정에 실패하였습니다.");
		}
	}
	
	public void deleteBook(String title) {
		int result = ms.deleteBook(title);
		if (result > 0) {
			new MemberMenu().deleteSuccess("도서 삭제가 완료되었습니다.");
		} else {
			new MemberMenu().deleteFail("도서 삭제에 실패하였습니다.");
		}	
	}

	public void deleteMemberByroot(String del, String memberId) {
		if(del.toLowerCase().equals("y")) {
			int result = ms.deleteMember(memberId);
			if (result > 0) {
				new MemberMenu().deleteSuccessbyroot("삭제가 완료되었습니다.");
			} else {
				new MemberMenu().deleteFail("회원 삭제에 실패하였습니다.");
			}
		} else {
			new MemberMenu().deleteFail("회원 삭제를 취소하였습니다.");
		}
	}

	public ArrayList<Member> getAllMembers() {
		ArrayList<Member> list = ms.getAllMembers();
		if (list.isEmpty()) {
			new MemberMenu().displayNoDate("전체 조회 결과가 없습니다.");
		} else {
			new MemberMenu().displayMemberList(list);
		}
		return list;
	}
	
	public ArrayList<Book> BooksByMember(int memberNo) {
		ArrayList<Book> list = ms.BooksByMember(memberNo);
		return list;
	}

	public void searchMemberById(String memberId) {

		Member member = ms.findMemberById(memberId);

		
		if (member == null) {
			System.out.println("해당 ID를 가진 회원이 없습니다.");
			return;
		}
		System.out.println("\n=== 회원 정보 ===");
		System.out.println("회원번호: " + member.getMemberNo());
		System.out.println("아이디: " + member.getMemberId());
		System.out.println("이름: " + member.getMemberName());
		System.out.println("성별: " + member.getGender());
		System.out.println("주소: " + member.getAddress());
		System.out.println("연락처: " + member.getPhone());
		System.out.println("가입일: " + member.getEnrollDate());

		ArrayList<Book> purchasedBooks = ms.findPurchasedBooks(member.getMemberNo());

		if (purchasedBooks.isEmpty()) {
			System.out.println("\n구매한 책이 없습니다.");
		} else {
			System.out.println("\n=== 구매한 책 목록 ===");
			for (Book b : purchasedBooks) {
				System.out.println(b);
			}
		}
	}
	
}
