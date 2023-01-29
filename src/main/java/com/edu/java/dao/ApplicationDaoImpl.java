package com.edu.java.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edu.java.dto.ApplicationDto;

@Repository
public class ApplicationDaoImpl implements ApplicationDao{

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<ApplicationDto> getCourse(){
		List<ApplicationDto> courseList = sqlSession.selectList(NAMESPACE + "getCourse");
		return courseList;
	}
}
