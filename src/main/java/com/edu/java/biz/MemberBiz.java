package com.edu.java.biz;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import com.edu.java.dto.MemberDto;

public interface MemberBiz {
	// 로그인
	//public MemberDto loginCheck(MemberDto dto, HttpSession session) throws Exception;
	//public boolean isLogin(String user_id, String user_pw);
	public HashMap<String, Object> loginCheck(HashMap<String, Object> map) throws Exception;
	
	
	// 로그아웃
	public void logout(HttpSession session);
	
	// id 중복 체크
	public int idCheck(String user_id) throws Exception;
	
	// 회원가입
	public void memberRegist(MemberDto dto) throws Exception;
	
	// 회원정보 수정
	public void memberUpdate(MemberDto dto) throws Exception;
	
	// 회원 비활성화
	public void memberDelete(MemberDto dto) throws Exception;

}