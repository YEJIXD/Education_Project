package com.edu.java.dao;

import java.util.HashMap;
import java.util.List;

import com.edu.java.dto.CourseDto;
import com.edu.java.dto.PageDto;

public interface CourseDao {
	String NAMESPACE = "course.";
	
	// 교육 전체 리스트
	public List<CourseDto> courseList(PageDto dto);
	
	// 교육 상세 페이지
	public CourseDto selectOne(int c_no);
	
	// 교육 신청
	public int courseAppInsert(HashMap<String, Object> params) throws Exception;	
	// count로 중복 신청 안되게 하려고 아래 하나 더 작성해보는 것
	//public HashMap<String, Object> courseAppInsert(HashMap<String, Object> params) throws Exception;

	public int getAppTotal(String param);
}
