package com.book.jdbc.controller;

import com.book.jdbc.model.dao.MemberDAO;
import com.book.jdbc.model.vo.Member;
import com.book.jdbc.view.MemberMenu;

public class MemberController {

	private MemberDAO md = new MemberDAO();
	
	public void logIn(String memberId, String memberPwd) {
		Member m = new Member();
		if (m.getMemberId().equals(memberId) && m.getMemberPwd().equals(memberPwd)) {
			new MemberMenu().userPage();
		} else if (!m.getMemberId().equals(memberId) && m.getMemberPwd().equals(memberPwd)
				|| m.getMemberId().equals(memberId) && !m.getMemberPwd().equals(memberPwd)) {
			new MemberMenu().failLogIn("아이디 또는 비밀번호가 틀렸습니다. 다시 입력해주세요.");
		} else {
			new MemberMenu().NonLog("아이디와 비밀번호가 틀렸습니다. 처음 화면으로 돌아갑니다.");
		}
	}
	
	public void insertMember(String userId, String userPwd, String userName, String gender, String phone, String address) {
		Member m = new Member(userId, userPwd, userName, gender, phone, address);
		int result;
		
	}
}
