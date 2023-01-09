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
	
	// 교욱 전체 리스트
	@Override
	public List<CourseDto> courseList(PageDto dto){
		return courseDao.courseList(dto);
	}
	
	// 교육 상세 페이지
	@Override
	public CourseDto selectOne(int c_no) {
		return courseDao.selectOne(c_no);
	}

	// 교육 신청
	@Override
	public int courseAppInsert(HashMap<String, Object> params) throws Exception {
		return courseDao.courseAppInsert(params);
	}
	
	@Override
	public int getAppTotal(String param) {
		return courseDao.getAppTotal(param);
	}
	
	/*
	@Override
	public HashMap<String, Object> courseAppInsert(HashMap<String, Object> params) throws Exception{ 
		return courseDao.courseAppInsert(params); 
	}*/
	
}
