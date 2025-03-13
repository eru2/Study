package com.kh.boot.service;

import com.kh.boot.domain.vo.Member;
import org.apache.ibatis.annotations.Param;

public interface MemberService {
    //로그인
//    Member loginMember(Member m);
    Member loginMember(@Param("userId") String userId);
    //회원가입
    int insertMember(Member m);
    //id중복조회(count)
    int idCheck(String userId);
    //회원정보변경
    int updateMember(Member member);

}
