package com.edu.java.biz;

import javax.servlet.http.HttpSession;

import com.edu.java.dto.UserDto;

public interface UserBiz {
	// 로그인
	public UserDto loginCheck(UserDto dto, HttpSession session) throws Exception;
	
	// 로그아웃
	public void logout(HttpSession session);
	
	// id 중복 체크
	public int idCheck(UserDto dto) throws Exception;
	
	// 회원가입
	public void userRegist(UserDto dto) throws Exception;
	
	// 회원정보 수정
	public void userUpdate(UserDto dto) throws Exception;
	
	// 회원 탈퇴
	public void userDelete(UserDto dto) throws Exception;
	
}
