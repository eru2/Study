package com.kh.mybatis.member.service;

import com.kh.mybatis.member.model.vo.Member;

public interface MemberService {
	Member loginMember(Member m);
	int insertMember(Member m);
	Member updateMember(Member m);
	Member updatePwd(String userId, String updatePwd);
}