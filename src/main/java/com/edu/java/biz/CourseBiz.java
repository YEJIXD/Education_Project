package com.edu.java.biz;

import java.util.List;

import com.edu.java.dto.CourseDto;

public interface CourseBiz {
	
	// list
	public List<CourseDto> courseList(String param);
	
	// select one
	public CourseDto selectOne(int c_no);
	
	// 교육 신청
	public int courseAppInsert(CourseDto dto) throws Exception;
	
}
