package com.edu.java.dao;

import java.util.HashMap;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.edu.java.dto.UserDto;

@Repository
public class UserDaoImpl implements UserDao{
	@Inject
	SqlSession sqlSession;
	
	@Override
	public HashMap<String, Object> loginCheck(HashMap<String, Object> map) { 
		return sqlSession.selectOne(NAMESPACE + "loginCheck", map); 
	}
	
	@Override
	public void logout(UserDto dto) throws Exception {
		// TODO Auto-generated method stub
	}
	
	@Override
	public int idCheck(String user_id) throws Exception{
		return sqlSession.selectOne(NAMESPACE+ "idCheck", user_id);
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
}
