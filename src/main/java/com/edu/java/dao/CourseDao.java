package com.edu.java.dao;

import com.edu.java.dto.CourseDto;

public interface CourseDao {
	String NAMESPACE = "course.";
	
	// 교육 등록
	public void courseInsertRes(CourseDto dto) throws Exception;
	
	// 교육 수정
	public void courseUpdateRes(CourseDto dto) throws Exception;
}
