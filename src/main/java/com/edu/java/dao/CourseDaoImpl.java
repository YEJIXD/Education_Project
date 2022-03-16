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
	
	// 교육 등록(insert)
	@Override
	public void courseInsertRes(CourseDto dto) throws Exception{
		sqlSession.insert(NAMESPACE + "courseInsertRes", dto);
	}
	
	// 교육 수정
	@Override
	public void courseUpdateRes(CourseDto dto) throws Exception{
		sqlSession.update(NAMESPACE + "courseUpdateRes", dto);
	}
}
