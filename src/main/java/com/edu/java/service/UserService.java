package com.edu.java.service;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import com.edu.java.dto.UserDto;
import com.edu.java.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.java.dao.UserDao;

@Service
public class UserService implements UserMapper {
	
	@Autowired
	UserDao userDao;
	
	public HashMap<String, Object> loginCheck(HashMap<String, Object> map) throws Exception {
		return userDao.loginCheck(map);
	}
	
	public void logout(HttpSession session) {
		session.invalidate();
	}
	
	public int idCheck(String user_id) throws Exception {
		return userDao.idCheck(user_id);
	}

	@Override
	public void inputUser(UserDto dto) throws Exception {

	}

	@Override
	public void modifyUser(UserDto dto) throws Exception {

	}

	@Override
	public void deleteUser(UserDto dto) throws Exception {

	}

	/*
	 * public void memberRegist(UserDto dto) throws Exception {
	 * userDao.memberRegist(dto); }
	 * 
	 * public void memberUpdate(UserDto dto) throws Exception {
	 * userDao.memberUpdate(dto); }
	 * 
	 * public void memberDelete(UserDto dto) throws Exception {
	 * userDao.memberDelete(dto); }
	 */
}