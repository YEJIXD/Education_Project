package com.edu.java.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.edu.java.dto.CourseDto;
import com.edu.java.dto.PageDto;

@Repository
public class CourseDaoImpl implements CourseDao{
	@Inject
	SqlSession sqlSession;
	
	// LIST
	@Override
	public List<CourseDto> courseList(PageDto dto) {
		List<CourseDto> courseList = new ArrayList<CourseDto>();
		
		try {
			courseList = sqlSession.selectList(NAMESPACE + "courseList", dto);
		} catch (Exception e) {
			System.out.println("[error] : course list");
			e.printStackTrace();
		}
		return courseList;
	}
	
	@Override
	public CourseDto selectOne(int c_no) {
		CourseDto dto = null;
		
		try {
			dto = sqlSession.selectOne(NAMESPACE + "courseDetail", c_no);
		} catch (Exception e) {
			System.out.println("[error] : course Detail Error");
			e.printStackTrace();
		}
		
		return dto;
	}

	@Override
	public int courseAppInsert(HashMap<String, Object> params) throws Exception {
		int res = 0;
		
		try {
			res = sqlSession.insert(NAMESPACE + "courseAppInsert", params);
			System.out.println("params : " + params);
		} catch (Exception e) {
			System.out.println("[error] : Course App Insert error");
			e.printStackTrace();
		}
		return res;
	}
	
}
