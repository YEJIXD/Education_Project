package com.edu.java.dao;

import java.util.HashMap;
import java.util.List;

import com.edu.java.dto.CourseDto;
import com.edu.java.dto.PageDto;

public interface CourseDao {
	String NAMESPACE = "course.";
	
	List<CourseDto> courseList(PageDto dto);
	CourseDto selectOne(int c_no);
	int courseAppInsert(HashMap<String, Object> params) throws Exception;
	// count로 중복 신청 안되게 하려고 아래 하나 더 작성해보는 것
	//HashMap<String, Object> courseAppInsert(HashMap<String, Object> params) throws Exception;
	int getAppTotal(String param);
}
