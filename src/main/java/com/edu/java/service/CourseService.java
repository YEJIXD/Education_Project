package com.edu.java.service;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import com.edu.java.mapper.CourseBiz;
import org.springframework.stereotype.Service;

import com.edu.java.dao.CourseDao;
import com.edu.java.dto.CourseDto;
import com.edu.java.dto.PageDto;

@Service
public class CourseService implements CourseBiz {
	@Inject
	CourseDao courseDao;
	
	@Override
	public List<CourseDto> courseList(PageDto dto){
		return courseDao.courseList(dto);
	}
	
	@Override
	public CourseDto selectOne(int course_no) {
		return courseDao.selectOne(course_no);
	}

	@Override
	public int courseAppInsert(HashMap<String, Object> params) throws Exception {
		return courseDao.courseAppInsert(params);
	}
	
	
}
