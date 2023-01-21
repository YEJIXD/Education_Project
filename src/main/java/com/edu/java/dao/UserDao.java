package com.edu.java.dao;

import java.util.HashMap;

import com.edu.java.dto.UserDto;

public interface UserDao {
	String NAMESPACE = "member.";

	// 로그인 체크
	public HashMap<String, Object> loginCheck(HashMap<String, Object> map);
	
	// 로그아웃
	public void logout(UserDto dto) throws Exception;
	
	// 아이디 중복체크
	public int idCheck(String user_id) throws Exception;
	
	// 회원가입
	public void memberRegist(UserDto dto) throws Exception;
	
	// 회원 정보 수정
	public void memberUpdate(UserDto dto) throws Exception;
	
	// 회원 비활성화
	public void memberDelete(UserDto dto) throws Exception;
}
