package com.edu.java.dao;

import java.util.HashMap;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.edu.java.dto.MemberDto;

@Repository
public class UserDaoImpl implements MemberDao{
	@Inject
	SqlSession sqlSession;
	
	// 로그인
	@Override
	public HashMap<String, Object> loginCheck(HashMap<String, Object> map) { 
		return sqlSession.selectOne(NAMESPACE + "loginCheck", map); 
	}
	
	// 로그아웃
	@Override
	public void logout(UserDto dto) throws Exception {
		// TODO Auto-generated method stub
	}
	
	// id 중복 체크
	@Override
	public int idCheck(String user_id) throws Exception{
		return sqlSession.selectOne(NAMESPACE+ "idCheck", user_id);
	}

	// 회원가입
	@Override
	public void memberRegist(UserDto dto) throws Exception {
		sqlSession.insert(NAMESPACE + "memberRegist", dto);
	}
	
	//회원정보 수정
	@Override
	public void memberUpdate(UserDto dto) throws Exception {
		sqlSession.update(NAMESPACE + "memberUpdate", dto);
	}

	//회원 비활성화
	@Override
	public void memberDelete(UserDto dto) throws Exception {
		sqlSession.update(NAMESPACE + "memberDelete", dto);
	}

}
