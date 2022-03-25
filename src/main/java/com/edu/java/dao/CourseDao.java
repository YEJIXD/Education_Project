package com.edu.java.dao;

import java.util.List;

import com.edu.java.dto.CourseDto;
import com.edu.java.dto.PageDto;

public interface CourseDao {
	String NAMESPACE = "course.";
	
	// list
	public List<CourseDto> courseList(PageDto dto);
	
	// selectOne
	public CourseDto selectOne(int c_no);
	
	// 교육 신청
	public int courseAppInsert(CourseDto dto) throws Exception;
}
