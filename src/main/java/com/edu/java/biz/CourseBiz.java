package com.edu.java.biz;

import java.util.HashMap;
import java.util.List;

import com.edu.java.dto.CourseDto;
import com.edu.java.dto.PageDto;

public interface CourseBiz {
	
	// list
	public List<CourseDto> courseList(PageDto dto);
	
	// select one
	public CourseDto selectOne(int c_no);
	
	// 교육 신청
	public int courseAppInsert(HashMap<String, Object> params) throws Exception;
	
}
