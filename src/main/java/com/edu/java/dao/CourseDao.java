package com.edu.java.dao;

import java.util.List;

import com.edu.java.dto.CourseDto;

public interface CourseDao {
	String NAMESPACE = "course.";
	
	// list
	public List<CourseDto> courseList();
	
	// 교육 등록
	public void courseInsertRes(CourseDto dto) throws Exception;
	
	// 교육 수정
	public void courseUpdateRes(CourseDto dto) throws Exception;
}
