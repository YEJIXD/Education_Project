package com.edu.java.biz;

import java.util.HashMap;
import java.util.List;

import com.edu.java.dto.CourseDto;
import com.edu.java.dto.PageDto;

public interface CourseBiz {
	
	public List<CourseDto> courseList(PageDto dto);
	
	public CourseDto selectOne(int c_no);
	
	public int courseAppInsert(HashMap<String, Object> params) throws Exception;
	
	public int getAppTotal(String param);
}
