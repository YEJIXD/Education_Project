package com.edu.java.dao;

import com.edu.java.dto.UserDto;

public interface UserDao {
	String NAMESPACE = "user.";

	// 로그인 체크
	public UserDto loginCheck(UserDto dto) throws Exception;
	
	// 로그아웃
	public void logout(UserDto dto) throws Exception;
	
	// 아이디 중복체크
	public int idCheck(UserDto dto) throws Exception;
	
	// 회원가입
	public void userRegist(UserDto dto) throws Exception;
	
	// 회원 정보 수정
	public void userUpdate(UserDto dto) throws Exception;
	
	// 회원 삭제
	public void userDelete(UserDto dto) throws Exception;
}
