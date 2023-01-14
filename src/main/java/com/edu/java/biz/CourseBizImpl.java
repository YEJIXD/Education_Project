package com.edu.java.biz;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.edu.java.dao.CourseDao;
import com.edu.java.dto.CourseDto;
import com.edu.java.dto.PageDto;

@Service
public class CourseBizImpl implements CourseBiz{
	@Inject
	CourseDao courseDao;
	
	@Override
	public List<CourseDto> courseList(PageDto dto){
		return courseDao.courseList(dto);
	}
	
	@Override
	public CourseDto selectOne(int c_no) {
		return courseDao.selectOne(c_no);
	}

	@Override
	public int courseAppInsert(HashMap<String, Object> params) throws Exception {
		return courseDao.courseAppInsert(params);
	}
	
	@Override
	public int getAppTotal(String param) {
		return courseDao.getAppTotal(param);
	}
}
