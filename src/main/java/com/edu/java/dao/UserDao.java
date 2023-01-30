package com.edu.java.dao;

import java.util.HashMap;

import com.edu.java.dto.UserDto;

public interface UserDao {
	String NAMESPACE = "member.";

	HashMap<String, Object> loginCheck(HashMap<String, Object> map);

	void logout(UserDto dto) throws Exception;

	int idCheck(String user_id) throws Exception;

	void inputUser(UserDto dto) throws Exception;

	void modifyUser(UserDto dto) throws Exception;

	void deleteUser(UserDto dto) throws Exception;
}
