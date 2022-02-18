package com.edu.java.dao;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.edu.java.dto.UserDto;

@Repository
public class UserDaoImpl implements UserDao{
	@Inject
	SqlSession sqlSession;
	
	// 로그인
	@Override
	public UserDto loginCheck(UserDto dto) throws Exception{
		return sqlSession.selectOne(NAMESPACE + "loginCheck", dto);
	}
	
	// 로그아웃
	@Override
	public void logout(UserDto dto) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	// id 중복 체크
	@Override
	public int idCheck(UserDto dto) throws Exception{
		return sqlSession.selectOne(NAMESPACE+ "idCheck", dto);
	}


	// 회원가입
	@Override
	public void userRegist(UserDto dto) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	//회원정보 수정
	@Override
	public void userUpdate(UserDto dto) throws Exception {
		sqlSession.update(NAMESPACE + "memberUpdate", dto);
	}

	//회원탈퇴
	@Override
	public void userDelete(UserDto dto) throws Exception {
		sqlSession.update(NAMESPACE + "memberDelete", dto);
	}

}
