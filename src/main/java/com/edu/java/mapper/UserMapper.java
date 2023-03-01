package com.edu.java.mapper;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import com.edu.java.dto.UserDto;

public interface UserMapper {
	//public MemberDto loginCheck(MemberDto dto, HttpSession session) throws Exception;
	//public boolean isLogin(String user_id, String user_pw);
	HashMap<String, Object> loginCheck(HashMap<String, Object> map) throws Exception;

	void logout(HttpSession session);

	int idCheck(String user_id) throws Exception;

	void inputUser(UserDto dto) throws Exception;

	void modifyUser(UserDto dto) throws Exception;

	void deleteUser(UserDto dto) throws Exception;
}