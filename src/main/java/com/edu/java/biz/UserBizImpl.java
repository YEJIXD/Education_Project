package com.edu.java.biz;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.edu.java.dao.UserDao;
import com.edu.java.dto.UserDto;

@Service
public class UserBizImpl implements UserBiz{
	@Inject
	UserDao userDao;
	
	// 로그인
	@Override
	public UserDto loginCheck(UserDto dto, HttpSession session) throws Exception{
		return userDao.loginCheck(dto);
	}

	// 로그아웃 
	@Override
	public void logout(HttpSession session) {
		session.invalidate();
	}

	// id 중복체크
	@Override
	public int idCheck(UserDto dto) throws Exception {
		return userDao.idCheck(dto);
	}

	// 회원가입
	@Override
	public void userRegist(UserDto dto) throws Exception {
		userDao.userRegist(dto);
	}

	// 회원정보 수정
	@Override
	public void userUpdate(UserDto dto) throws Exception {
		userDao.userUpdate(dto);
	}

	// 회원 탈퇴
	@Override
	public void userDelete(UserDto dto) throws Exception {
		userDao.userDelete(dto);
	}
}
