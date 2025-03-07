package com.kh.jdbc.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kh.jdbc.model.vo.Member;

/*
 * DAO(Data Access Object) : db에 직접적으로 접근해서 사용자의 요청에 맞는 sql문 실행 후 결과 반환(JDBC)
 */

public class MemberDao {

	/*
	 * 사용자가 입력한 정보들을 db에 추가시켜주는 메서드 Member m : 사용자가 입력한 값들이 담겨있는 Member객체를 받아서
	 * insert실행 후 처리된 행 수 return (int)
	 */

	public int insertMember(Member m) {
		/*
		 * JDBC 사용 순서 1) JDBC Driver 등록 : JDBC인터페이스가 특정 DBMS가 제공하는 클래스를 사용할 수 있도록 등록 2)
		 * Connection 생성 : 연결하고자하는 db정보를 입력해서 해당 db와 연결할 수 있는 객체 생성 3) Statement 생성 :
		 * Connection 객체를 이용해서 생성(sql문을 실행하고 결과를 받는 객체) 4) sql문 전달해서 실행 : Statement객체를
		 * 이용해서 sql문 실행 5) 결과받기 > SELECT문 실행 (6-1) => ResultSet객체(조회된 결과를 담아준다.),
		 * DNL(INSERT, UPDATE, DELETE)문 실행 (6-2) => int
		 * 
		 * 6-1) ResultSet객체에 담겨있는 데이터들을 하나씩 추출해서 차근차근 옮겨담기
		 * 
		 * 6-2) 트랜잭션 처리(성공했으면 commit, 실패했다면 rollback 실행)
		 * 
		 * 7) 다 사용한 JDBC 객체를 반드시 자원 반납(close) => 생성된 역순으로
		 */

		// 필요한 변수 세팅하기
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		// 실행할 SQL문(완전한 상태로 만들자) | (SQL뒤에 ;없어야한다!!!!)
		String sql = "INSERT INTO MEMBER " + "VALUES(SEQ_USERNO.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE)";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");// 오타 | ojdbc.jar 파일 추가하지 않았을 때 => 에러
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "C##JDBC", "JDBC");
			conn.setAutoCommit(false);

			pstmt = conn.prepareStatement(sql); // 아직 미완성 sql이다. ?를 전부 채워줘야한다.
			pstmt.setString(1, m.getUserId());
			pstmt.setString(2, m.getUserPwd());
			pstmt.setString(3, m.getUserName());
			pstmt.setString(4, m.getGender());
			pstmt.setInt(5, m.getAge());
			pstmt.setString(6, m.getEmail());
			pstmt.setString(7, m.getPhone());
			pstmt.setString(8, m.getAddress());
			pstmt.setString(9, m.getHobby());

			result = pstmt.executeUpdate();

			if (result > 0) {
				conn.commit();
			} else {
				conn.rollback();
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

	/*
	 * 회원의 목록을 반환하는 메서드 ArrayList
	 */
	public ArrayList<Member> selectList() {
		// select문(여러행 조회) -> ResultSet -> ArrayList담기

		ResultSet rset = null;
		ArrayList<Member> list = new ArrayList<>(); // 비어있는 상태
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "SELECT * FROM MEMBER";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "C##JDBC", "JDBC");
			conn.setAutoCommit(false);

			pstmt = conn.prepareStatement(sql); // 완성된 SQL

			rset = pstmt.executeQuery();
			while (rset.next()) {
				Member m = new Member();
				m.setUserNo(rset.getInt("USERNO"));
				m.setUserId(rset.getString("USERID"));
				m.setUserPwd(rset.getString("USERPWD"));
				m.setUserName(rset.getString("USERNAME"));
				m.setGender(rset.getString("GENDER"));
				m.setAge(rset.getInt("AGE"));
				m.setEmail(rset.getString("EMAIL"));
				m.setPhone(rset.getString("PHONE"));
				m.setAddress(rset.getString("ADDRESS"));
				m.setHobby(rset.getString("HOBBY"));
				m.setEnrollDate(rset.getDate("ENROLLDATE"));
				list.add(m);
			}

			// 반복문이 끝난 시전
			// 조회된 데이터가 없다면 list가 비어있을 것이다.
			// 조회된 데이터가 있다면 list의 크기가 1이상

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 오타 | ojdbc.jar 파일 추가하지 않았을 때 => 에러
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	/*
	 * Member객체 m을 통해서 update sql을 전달하는 메서드
	 */

	public int updateMember(Member m) {
		// update문 -> 처리된 행의 수 : result(int) -> 트랜잭션
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "UPDATE MEMBER SET EMAIL = ?, PHONE = ?, ADDRESS = ?, HOBBY = ? WHERE USERID = ?";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "C##JDBC", "JDBC");
			conn.setAutoCommit(false);

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, m.getEmail());
			pstmt.setString(2, m.getPhone());
			pstmt.setString(3, m.getAddress());
			pstmt.setString(4, m.getHobby());
			pstmt.setString(5, m.getUserId());

			result = pstmt.executeUpdate();
			
			if (result > 0) {
				conn.commit();
			} else {
				conn.rollback();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

	/*
	 * userId를 받아 Member를 삭제하는 sql전달 delete문 -> 처리한 행 수(int) -> 트랜잭션 처리
	 */
	public int deleteMember(String userId) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "DELETE FROM MEMBER WHERE USERID = ?";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "C##JDBC", "JDBC");
			conn.setAutoCommit(false);

			pstmt = conn.prepareStatement(sql); // 미완성된 SQL
			pstmt.setString(1, userId);

			result = pstmt.executeUpdate();

			if (result > 0) {
				conn.commit();
			} else {
				conn.rollback();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
}
