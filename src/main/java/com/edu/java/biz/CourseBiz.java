package com.edu.java.biz;

import java.util.HashMap;
import java.util.List;

import com.edu.java.dto.CourseDto;
import com.edu.java.dto.PageDto;

public interface CourseBiz {
	
	// 교욱 전체 리스트
	public List<CourseDto> courseList(PageDto dto);
	
	// 교육 상세 페이지
	public CourseDto selectOne(int c_no);
	
	// 교육 신청
	public int courseAppInsert(HashMap<String, Object> params) throws Exception;
	//public HashMap<String, Object> courseAppInsert(HashMap<String, Object> params) throws Exception;
	
	public int getAppTotal(String param);
}
