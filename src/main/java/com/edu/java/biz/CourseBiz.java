package com.edu.java.biz;

import java.util.List;

import com.edu.java.dto.CourseDto;

public interface CourseBiz {
	
	// list
	public List<CourseDto> courseList();
	
	// select one
	public CourseDto selectOne(int c_no);
	
}
