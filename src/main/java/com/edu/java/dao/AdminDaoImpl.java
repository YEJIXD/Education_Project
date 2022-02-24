package com.edu.java.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edu.java.dto.CourseDto;
import com.edu.java.dto.ReviewDto;

@Repository
public class AdminDaoImpl implements AdminDao{
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public int adminUserCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int newAdminUserCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int adminCancleCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int newAdminCancleCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int adminReviewCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int newAdminReviewCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<CourseDto> adminCourseList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int adminCourseInsert(CourseDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int adminCourseUpdate(CourseDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int adminCourseDelete(CourseDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ReviewDto> adminReviewList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int adminReviewDelete(int user_no) {
		// TODO Auto-generated method stub
		return 0;
	}
}
