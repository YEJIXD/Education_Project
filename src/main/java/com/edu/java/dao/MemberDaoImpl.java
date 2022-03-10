package com.edu.java.dao;

import java.util.HashMap;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.edu.java.dto.MemberDto;

@Repository
public class MemberDaoImpl implements MemberDao{
	@Inject
	SqlSession sqlSession;
	
	// 로그인
	@Override
	public boolean isLogin(String user_id, String user_pw) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("user_id", user_id);
		map.put("user_pw", user_pw);
		
		int res = sqlSession.selectOne("loginSuccess", map);
		return res==1? true:false;
	}
	/*
	 * public String loginCheck(MemberDto dto) throws Exception{ return
	 * sqlSession.selectOne(NAMESPACE + "loginCheck", dto); }
	 */

	
	// 로그아웃
	@Override
	public void logout(MemberDto dto) throws Exception {
		// TODO Auto-generated method stub
	}
	
	// id 중복 체크
	@Override
	public int idCheck(String user_id) throws Exception{
		return sqlSession.selectOne(NAMESPACE+ "idCheck", user_id);
		//int result = sqlSession.selectOne(NAMESPACE + "idCheck", dto);
		//return result;
	}

	// 회원가입
	@Override
	public void memberRegist(MemberDto dto) throws Exception {
		sqlSession.insert(NAMESPACE + "memberRegist", dto);
	}
	
	//회원정보 수정
	@Override
	public void memberUpdate(MemberDto dto) throws Exception {
		sqlSession.update(NAMESPACE + "memberUpdate", dto);
	}

	//회원 비활성화
	@Override
	public void memberDelete(MemberDto dto) throws Exception {
		sqlSession.update(NAMESPACE + "memberDelete", dto);
	}

}
