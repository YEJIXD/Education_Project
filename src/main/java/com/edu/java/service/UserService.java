package com.edu.java.service;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.java.dao.UserDao;
import com.edu.java.dto.UserDto;

@Service
public class UserService {
	
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