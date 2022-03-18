package com.edu.java.biz;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.edu.java.dao.CourseDao;
import com.edu.java.dto.CourseDto;

@Service
public class CourseBizImpl implements CourseBiz{
	@Inject
	CourseDao courseDao;
	
	@Override
	public List<CourseDto> courseList(){
		return courseDao.courseList();
	}
	
	@Override
	public CourseDto selectOne(int c_no) {
		return courseDao.selectOne(c_no);
	}
	
	
}
