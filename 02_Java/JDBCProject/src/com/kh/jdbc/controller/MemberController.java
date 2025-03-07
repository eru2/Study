package com.kh.jdbc.controller;

import java.util.ArrayList;

import com.kh.jdbc.model.dao.MemberDao;
import com.kh.jdbc.model.vo.Member;
import com.kh.jdbc.view.MemberMenu;

/*
 * Controller : View를 통해서 사용자가 요청한 기능에 대해 처리하는 객체
 *    			해당 메서드로 전달된 데이터[가공처리 후] Dao로 전달하여 호출
 *    			Dao로부터 반환받은 결과에 따라서 성공 실패 여부를 판단하여 응답화면 결정 -> view메서드 호출
 */

public class MemberController {
	private MemberDao md = new MemberDao();
	/*
	 * 사용자의 추가요청을 처리하는 메서드
	 * userId~hobby : 사용자가 입력한 정보들을 매게변수로 받음 
	 */
	
	public void insertMember(String userId, String userPwd, String userName, String gender,
			   				 String age, String email, String phone, String address, String hobby ) {
		//View로부터 전달받은 값을 바로 dao쪽을 전달 x
		//어딘가에 담아서 전달(Member 객체)
		
		Member m = new Member(userId, userPwd, userName, gender, Integer.parseInt(age),
							  email, phone, address, hobby);
		
		int result = md.insertMember(m);
		
		if(result > 0) { //insert성공
			//성공화면
			new MemberMenu().displaySuccess("성공적으로 회원이 추가되었습니다.");
		} else { //insert 실패
			//실패화면
			new MemberMenu().displayFail("회원추가에 실패하였습니다.");
		}
	}
	
	/*
	 * 회원을 모두 조회하는 메서드
	 */
	public void selectList() {
		ArrayList<Member> list = md.selectList();
		
		//조회된 결과에 따라서 사용자가 보게될 응답화면
		if(list.isEmpty()) {
			new MemberMenu().displayNoDate("전체 조회 결과가 없습니다.");
		} else {
			new MemberMenu().displayMemberList(list);
		}
	}
	/*
	 * 아이디를 받아서 회원의 이메일 전화번호, 주소, 취미를 수정하는 메서드
	 */
	public void updateMember(String userId, String email, String phone, String address, String hobby) {
		Member m = new Member();
		m.setUserId(userId);
		m.setEmail(email);
		m.setPhone(phone);
		m.setAddress(address);
		m.setHobby(hobby);
		
		int result = md.updateMember(m);
		
		if(result > 0) { //delete 성공
			//성공화면
			new MemberMenu().displaySuccess("성공적으로 회원정보를 수정하였습니다.");
		} else {//delete 실패
			//실패화면
			new MemberMenu().displayFail("회원 정보 수정에 실패하였습니다.");
		}
	}
	
	/*
	 * 아이디를 받아서 회원을 삭제하는 메서드
	 */
	public void deleteMember(String userId) {
		int result = md.deleteMember(userId);
		
		if(result > 0) { //delete 성공
			//성공화면
			new MemberMenu().displaySuccess("성공적으로 회원이 삭제되었습니다.");
		} else {//delete 실패
			//실패화면
			new MemberMenu().displayFail("회원삭제에 실패하였습니다.");
		}
	}

}
