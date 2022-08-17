package com.br.mybatis.member.model.service;

import com.br.mybatis.member.model.vo.Member;

public interface MemberService {

	// 인터페이스의 모든 메소드는 추상메소드(미완성된메소드)로만 작성해야됨
	
	// 1. 회원가입 처리용 
	int insertMember(Member m);
	
	// 2. 로그인 처리용
	Member loginMember(Member m);
	
	// 3. 회원정보 수정 처리용
	int updateMember(Member m);
	
	// 4. 회원탈퇴 처리용 
	int deleteMember(String userId);
	
	
}
