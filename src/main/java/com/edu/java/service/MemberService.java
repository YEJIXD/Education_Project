package com.edu.java.service;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.java.dao.MemberDao;
import com.edu.java.dto.MemberDto;

@Service
public class MemberService {
	
	@Autowired
	MemberDao memberDao;
	
	public HashMap<String, Object> loginCheck(HashMap<String, Object> map) throws Exception {
		return memberDao.loginCheck(map);
	}
	
	public void logout(HttpSession session) {
		session.invalidate();
	}
	
	public int idCheck(String user_id) throws Exception {
		return memberDao.idCheck(user_id);
	}
	
	public void memberRegist(MemberDto dto) throws Exception {
		memberDao.memberRegist(dto);
	}
	
	public void memberUpdate(MemberDto dto) throws Exception {
		memberDao.memberUpdate(dto);
	}
	
	public void memberDelete(MemberDto dto) throws Exception {
		memberDao.memberDelete(dto);
	}
}