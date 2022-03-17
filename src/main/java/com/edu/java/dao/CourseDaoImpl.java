package com.edu.java.dao;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.edu.java.dto.CourseDto;
import com.edu.java.dto.FaqDto;

@Repository
public class CourseDaoImpl implements CourseDao{
	@Inject
	SqlSession sqlSession;
	
	// LIST
	@Override
	public List<CourseDto> courseList() {
		List<CourseDto> courseList = new ArrayList<CourseDto>();
		
		try {
			courseList = sqlSession.selectList(NAMESPACE + "courseList");
		} catch (Exception e) {
			System.out.println("[error] : course list");
			e.printStackTrace();
		}
		return courseList;
	}
	
}
