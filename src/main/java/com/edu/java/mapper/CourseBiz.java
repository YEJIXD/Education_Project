package com.edu.java.mapper;

import java.util.HashMap;
import java.util.List;

import com.edu.java.dto.CourseDto;
import com.edu.java.dto.PageDto;

public interface CourseBiz {
	
	List<CourseDto> courseList(PageDto dto);

	CourseDto selectOne(int c_no);

	int courseAppInsert(HashMap<String, Object> params) throws Exception;
	
}
