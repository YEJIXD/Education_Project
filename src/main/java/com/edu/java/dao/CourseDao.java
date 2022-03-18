package com.edu.java.dao;

import java.util.List;

import com.edu.java.dto.CourseDto;

public interface CourseDao {
	String NAMESPACE = "course.";
	
	// list
	public List<CourseDto> courseList();
	
	// selectOne
	public CourseDto selectOne(int c_no);
}
