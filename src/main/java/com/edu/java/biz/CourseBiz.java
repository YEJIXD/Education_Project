package com.edu.java.biz;

import java.util.List;

import com.edu.java.dto.CourseDto;

public interface CourseBiz {
	
	// list
	public List<CourseDto> courseList();
	
	// 교육 등록
	public void courseInsertRes(CourseDto dto) throws Exception;
	
	// 교육 수정
	public void courseUpdateRes(CourseDto dto) throws Exception;

}
