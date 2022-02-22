package com.edu.java.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.edu.java.dto.CourseDto;

@Repository
public class CourseDaoImpl implements CourseDao{
	@Inject
	SqlSession sqlsession;
	
	// 교육 등록(insert)
	@Override
	public void courseInsertRes(CourseDto dto) throws Exception{
		sqlsession.insert(NAMESPACE + "courseInsertRes", dto);
	}
	
	// 교육 수정
	@Override
	public void courseUpdateRes(CourseDto dto) throws Exception{
		sqlsession.update(NAMESPACE + "courseUpdateRes", dto);
	}
}
