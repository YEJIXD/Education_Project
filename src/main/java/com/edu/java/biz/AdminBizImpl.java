package com.edu.java.biz;

import java.util.List;

import org.springframework.stereotype.Service;

import com.edu.java.dto.CourseDto;
import com.edu.java.dto.ReviewDto;

@Service
public class AdminBizImpl implements AdminBiz{

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
