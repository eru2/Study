package com.book.jdbc.service;

import static com.book.jdbc.common.JDBCTemplate.close;
import static com.book.jdbc.common.JDBCTemplate.commit;
import static com.book.jdbc.common.JDBCTemplate.getConnection;
import static com.book.jdbc.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.book.jdbc.model.dao.MemberDAO;
import com.book.jdbc.model.vo.Book;
import com.book.jdbc.model.vo.Member;

public class MemberService {

	private MemberDAO md = new MemberDAO();
	
	//로그인 성공하면 memberName반환 아니면 null반환
	public String logIn(String memberId, String memberpwd) {
		Connection conn = getConnection();
		String result = md.logIn(memberId, memberpwd, conn);
		
		close(conn);
		return result;
	}
	
	//회원가입
	public int insertMember(Member m) {
		Connection conn = getConnection();
		int result = md.insertMember(m, conn);
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	public ArrayList<Book> selectBookList(){
		Connection conn = getConnection();
		ArrayList list = md.selectBookList(conn);
		
		close(conn);
		return list;
	}

	public ArrayList<Book> selectByBookTitle(String keyword){
		Connection conn = getConnection();
		ArrayList list = md.selectByBookTitle(keyword, conn);
		
		close(conn);
		return list;
	} 
	
	public int buyBook(String title, String memberId) {
		Connection conn = getConnection();
		int result = md.buyBook(title, memberId, conn);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
    }
	
	
	public boolean checkMember(Member m) {
		Connection conn = getConnection();
		boolean check = md.checkMember(m, conn);
		
		close(conn);
		return check;
	}
	
	public int updateMember(Member m) {
		Connection conn = getConnection();
		int result = md.updateMember(m, conn);
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	public int deleteMember(String memberId) {
		Connection conn = getConnection();
		int result = md.deleteMember(memberId, conn);
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	public int insertBook(Book b) {
		Connection conn = getConnection();
		int result = md.insertBook(b, conn);
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	public int updateBook(Book b) {
		Connection conn = getConnection();
		int result = md.updateBook(b, conn);
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	public int deleteBook(String title) {
		Connection conn = getConnection();
		int result = md.deleteBook(title, conn);
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	public ArrayList<Member> selectList(){
		Connection conn = getConnection();
		ArrayList list = md.selectBookList(conn);
		
		close(conn);
		return list;
	}
	public ArrayList<Member> getAllMembers() {
		Connection conn = getConnection();
		ArrayList list = md.selectAllMembers(conn);
		close(conn);
		return list;
	}

	public ArrayList<Book> BooksByMember(int memberNo) {
		Connection conn = getConnection();
		ArrayList<Book> list = md.findPurchasedBooks(conn, memberNo);
		close(conn);
		return list;
	}


	public ArrayList<Member> selectMember(String memberId){
		Connection conn = getConnection();
		ArrayList list = md.selectMember(memberId, conn);
		close(conn);
		return list;
	}
	public Member findMemberById(String memberId) {
		Connection conn = getConnection();
		Member m = md.findMemberById(conn, memberId);

		close(conn);
		return m;
	}

	public ArrayList<Book> findPurchasedBooks(int memberNo) {
		Connection conn = getConnection();
		ArrayList<Book> list = new ArrayList<>();
		
		list = md.findPurchasedBooks(conn, memberNo);

		close(conn);
		return list;
	}
}
