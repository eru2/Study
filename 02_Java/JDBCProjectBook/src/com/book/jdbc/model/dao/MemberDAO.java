package com.book.jdbc.model.dao;

import static com.book.jdbc.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.book.jdbc.model.vo.Book;
import com.book.jdbc.model.vo.Member;

public class MemberDAO {

	public boolean checkMember(Member m, Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String sql = "SELECT * FROM TB_MEMBER WHERE MEMBER_ID = ? AND MEMBER_PWD = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getMemberId());
			pstmt.setString(2, m.getMemberPwd());
			rset = pstmt.executeQuery();
			if (rset.next()) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return false;
	}

	public String logIn(String memberId, String memberpwd, Connection conn) {
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        String sql = "SELECT MEMBER_NAME FROM TB_MEMBER WHERE MEMBER_ID = ? AND MEMBER_PWD = ?";
        String name = null;
        try {
        	 System.out.println("로그인 시도: 아이디=" + memberId + ", 비밀번호=" + memberpwd);  // 디버깅 로그 추가
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, memberId);
            pstmt.setString(2, memberpwd);

            rset = pstmt.executeQuery();
            if (rset.next()) {
            	name = rset.getString("MEMBER_NAME");
            } else {
            	System.out.println("쿼리 결과가 없습니다.");
            }
            return name;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("SQL 오류: " + e.getMessage());
        } finally {
            close(rset);
            close(pstmt);
        }
        return null; // 로그인 실패 시 null 반환
    }

	// 회원가입
	public int insertMember(Member m, Connection conn) {
		int result = 0;
		PreparedStatement pstmt = null;

		String sql = "INSERT INTO TB_MEMBER " + "VALUES(SEQ_USERNO.NEXTVAL, ?, ?, ?, ?, ?, ?, SYSDATE)";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getMemberId());
			pstmt.setString(2, m.getMemberPwd());
			pstmt.setString(3, m.getMemberName());
			pstmt.setString(4, m.getGender());
			pstmt.setString(5, m.getPhone());
			pstmt.setString(6, m.getAddress());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public ArrayList<Book> selectBookList(Connection conn) {

		ResultSet rset = null;
		ArrayList<Book> list = new ArrayList<>(); // 비어있는 상태
		PreparedStatement pstmt = null;

		String sql = "SELECT * FROM TB_BOOK";

		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				Book b = new Book();
				b.setBookNo(rset.getInt("BK_NO"));
				b.setBookTitle(rset.getString("BK_TITLE"));
				b.setBookAuthor(rset.getNString("BK_AUTHOR"));
				b.setBookNum(rset.getInt("BK_NUM"));
				b.setBookPrice(rset.getInt("BK_PRICE"));
				b.setBookPubNo(rset.getString("BK_PUB_NO"));
				list.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public ArrayList<Book> selectByBookTitle(String keyword, Connection conn) {
		ArrayList<Book> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String sql = "SELECT * FROM TB_BOOK WHERE BK_TITLE LIKE '%' || ? || '%'";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, keyword);

			rset = pstmt.executeQuery();
			while (rset.next()) {
				Book b = new Book();
				b.setBookNo(rset.getInt("BK_NO"));
				b.setBookTitle(rset.getString("BK_TITLE"));
				b.setBookAuthor(rset.getNString("BK_AUTHOR"));
				b.setBookNum(rset.getInt("BK_NUM"));
				b.setBookPrice(rset.getInt("BK_PRICE"));
				b.setBookPubNo(rset.getString("BK_PUB_NO"));
				list.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public int buyBook(String title, String memberId, Connection conn) {
		// 도서 제목을 통해 도서 번호를 찾고, 회원 ID와 도서 번호로 구매 정보를 TB_MEMBER_BOOK 테이블에 삽입
		String sql = "INSERT INTO TB_MEMBER_BOOK (MEMBER_NO, BK_NO, PURCHASE_DATE) "
				+ "VALUES ((SELECT MEMBER_NO FROM TB_MEMBER WHERE MEMBER_ID = ?), "
				+ "(SELECT BK_NO FROM TB_BOOK WHERE BK_TITLE = ?), SYSDATE)";

		PreparedStatement pstmt = null;
		int result = 0;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId); // 회원 ID
			pstmt.setString(2, title); // 도서 제목
			result = pstmt.executeUpdate(); // DB에 삽입

			if (result > 0) {
				// 도서 수량 1 감소
				String updateBookSql = "UPDATE TB_BOOK SET BK_NUM = BK_NUM - 1 WHERE BK_TITLE = ?";
				pstmt = conn.prepareStatement(updateBookSql);
				pstmt.setString(1, title);
				int updateResult = pstmt.executeUpdate();

				return updateResult; // 수량 감소 결과 반환
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int updateMember(Member m, Connection conn) {
		int result = 0;
		PreparedStatement pstmt = null;

		String sql = "UPDATE TB_MEMBER SET MEMBER_NAME = ?, GENDER = ? , PHONE = ?, ADDRESS = ? WHERE MEMBER_ID = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getMemberName());
			pstmt.setString(2, m.getGender());
			pstmt.setString(3, m.getPhone());
			pstmt.setString(4, m.getAddress());
			pstmt.setString(5, m.getMemberId());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int deleteMember(String memberId, Connection conn) {
		int result = 0;
		PreparedStatement pstmt = null;

		String sql = "DELETE FROM TB_MEMBER WHERE MEMBER_ID = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int insertBook(Book b, Connection conn) {
		int result = 0;
		PreparedStatement pstmt = null;

		String sql = "INSERT INTO TB_BOOK VALUES(SEQ_USERNO.NEXTVAL, ?, ?, ?, ?, ?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, b.getBookTitle());
			pstmt.setString(2, b.getBookAuthor());
			pstmt.setInt(3, b.getBookNum());
			pstmt.setInt(4, b.getBookPrice());
			pstmt.setString(5, b.getBookPubNo());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int updateBook(Book b, Connection conn) {
		int result = 0;
		PreparedStatement pstmt = null;

		String sql = "UPDATE TB_BOOK SET BK_TITLE = ?, BK_AUTHOR = ?, BK_NUM = ?, BK_PRICE = ?, BK_PUB_NO = ? WHERE BK_NO = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, b.getBookTitle());
			pstmt.setString(2, b.getBookAuthor());
			pstmt.setInt(3, b.getBookNum());
			pstmt.setInt(4, b.getBookPrice());
			pstmt.setString(5, b.getBookPubNo());
			pstmt.setInt(6, b.getBookNo());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int deleteBook(String title, Connection conn) {
		int result = 0;
		PreparedStatement pstmt = null;

		String sql = "DELETE FROM TB_BOOK WHERE BK_TITLE = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public ArrayList<Member> selectList(Connection conn) {
		ResultSet rset = null;
		ArrayList<Member> list = new ArrayList<>(); // 비어있는 상태
		PreparedStatement pstmt = null;

		String sql = "SELECT * FROM TB_MEMBER";

		try {
			pstmt = conn.prepareStatement(sql);

			rset = pstmt.executeQuery();
			while (rset.next()) {
				Member m = new Member();
				m.setMemberNo(rset.getInt("MEMBER_NO"));
				m.setMemberId(rset.getString("MEMBER_ID"));
				m.setMemberPwd(rset.getString("MEMBER_PWD"));
				m.setMemberName(rset.getString("MEMBER_NAME"));
				m.setGender(rset.getString("GENDER"));
				m.setAddress(rset.getString("ADDRESS"));
				m.setPhone(rset.getString("PHONE"));
				m.setEnrollDate(rset.getDate("ENROLL_DATE"));
				list.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public ArrayList<Member> selectMember(String memberId, Connection conn) {
		ResultSet rset = null;
		ArrayList<Member> list = new ArrayList<>(); // 비어있는 상태
		PreparedStatement pstmt = null;

		String sql = "SELECT * FROM TB_MEMBER";

		try {
			pstmt = conn.prepareStatement(sql);

			rset = pstmt.executeQuery();
			while (rset.next()) {
				Member m = new Member();
				m.setMemberNo(rset.getInt("MEMBER_NO"));
				m.setMemberId(rset.getString("MEMBER_ID"));
				m.setMemberPwd(rset.getString("MEMBER_PWD"));
				m.setMemberName(rset.getString("MEMBER_NAME"));
				m.setGender(rset.getString("GENDER"));
				m.setAddress(rset.getString("ADDRESS"));
				m.setPhone(rset.getString("PHONE"));
				m.setEnrollDate(rset.getDate("ENROLL_DATE"));
				list.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public ArrayList<Member> selectAllMembers(Connection conn) {

		ArrayList<Member> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String sql = "SELECT * FROM TB_MEMBER"; 

		try {
			pstmt = conn.prepareStatement(sql);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				Member m = new Member();
				m.setMemberNo(rset.getInt("MEMBER_NO"));
				m.setMemberId(rset.getString("MEMBER_ID"));
				m.setMemberPwd(rset.getString("MEMBER_PWD"));
				m.setMemberName(rset.getString("MEMBER_NAME"));
				m.setGender(rset.getString("GENDER"));
				m.setAddress(rset.getString("ADDRESS"));
				m.setPhone(rset.getString("PHONE"));
				m.setEnrollDate(rset.getDate("ENROLL_DATE"));
				list.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}

	public Member findMemberById(Connection conn, String memberId) {
		Member m = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String sql = "SELECT * FROM TB_MEMBER WHERE MEMBER_ID = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			rset = pstmt.executeQuery();
			if (rset.next()) { // 회원이 존재하면 Member 객체 생성
				m = new Member();
				m.setMemberNo(rset.getInt("MEMBER_NO"));
				m.setMemberId(rset.getString("MEMBER_ID"));
				m.setMemberPwd(rset.getString("MEMBER_PWD"));
				m.setMemberName(rset.getString("MEMBER_NAME"));
				m.setGender(rset.getString("GENDER"));
				m.setAddress(rset.getString("ADDRESS"));
				m.setPhone(rset.getString("PHONE"));
				m.setEnrollDate(rset.getDate("ENROLL_DATE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return m;
	}

	
	public ArrayList<Book> findPurchasedBooks(Connection conn, int memberNo) {
		ArrayList<Book> bookList = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String sql = "SELECT B.BK_NO, B.BK_TITLE, B.BK_AUTHOR, B.BK_PRICE " + "FROM TB_MEMBER_BOOK MB "
				+ "JOIN TB_BOOK B ON MB.BK_NO = B.BK_NO " + "WHERE MB.MEMBER_NO = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberNo);
			rset = pstmt.executeQuery();

			while (rset.next()) {
				Book b = new Book();
				b.setBookNo(rset.getInt("BK_NO"));
				b.setBookTitle(rset.getString("BK_TITLE"));
				b.setBookAuthor(rset.getString("BK_AUTHOR"));
				b.setBookPrice(rset.getInt("BK_PRICE"));
				bookList.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return bookList;
	}

}
