package com.edu.java.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.java.dao.CourseDao;
import com.edu.java.dto.CourseDto;
import com.edu.java.dto.PageDto;

@Service
public class CourseService {
	
	@Autowired
	CourseDao courseDao;
	
	public List<CourseDto> courseList(PageDto dto) {
		return courseDao.courseList(dto);
	}
	
	public CourseDto selectOne(int c_no) {
		return courseDao.selectOne(c_no);
	}
	
	public int courseAppInsert(HashMap<String, Object> params) throws Exception {
		return courseDao.courseAppInsert(params);
	}
	
	public int getAppTotal(String param) {
		return courseDao.getAppTotal(param);
	}
}
