package com.edu.java.biz;

import java.util.List;

import com.edu.java.dto.CourseDto;
import com.edu.java.dto.ReviewDto;

public interface AdminBiz {
	/* 관리자 메인*/
	// 회원 수
	public int adminUserCount();
	public int newAdminUserCount();
	
	// 게시글 수
	
	// 수강 취소 수
	public int adminCancleCount();
	public int newAdminCancleCount();
	
	// 후기 수
	public int adminReviewCount();
	public int newAdminReviewCount();
	
	/* 교육 리스트 */
	public List<CourseDto> adminCourseList();
	//public CourseDto selectOne(int c_no);
	
	public int adminCourseInsert(CourseDto dto);
	public int adminCourseUpdate(CourseDto dto);
	public int adminCourseDelete(CourseDto dto);
	
	/* 수강 취소 */
	
	/* 후기 */
	public List<ReviewDto> adminReviewList();
	//public ReviewDto selectOne(int r_no);
	
	public int adminReviewDelete(int user_no);
	
}
