package com.edu.java.dao;

import java.util.List;

import com.edu.java.dto.ApplicationDto;
import com.edu.java.dto.CancleDto;
import com.edu.java.dto.CourseDto;
import com.edu.java.dto.FaqDto;
import com.edu.java.dto.MemberDto;
import com.edu.java.dto.NoticeDto;
import com.edu.java.dto.QnaDto;
import com.edu.java.dto.ReviewDto;
import com.edu.java.dto.TeacherDto;

public interface AdminDao {
	String NAMESPACE = "admin.";
	
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
	
		
	/* 공지사항 리스트 */
	public List<NoticeDto> adminNoticeList() throws Exception;
	public NoticeDto noticeSelectOne(int noti_no);
	public int adminNoticeInsert(NoticeDto dto);
	public int adminNoticeUpdate(NoticeDto dto);
	public int adminNoticeDelete(int noti_no);
	
	/* QnA */
	public List<QnaDto> adminQnaList();
	public QnaDto qnaSelectOne(int q_no);
	public int adminQnaDelete(int q_no);
	
	
	/* FAQ */
	public List<FaqDto> adminFaqList();
	public FaqDto faqSelectOne(int faq_no);
	public int adminFaqInsert(FaqDto dto);
	public int adminFaqUpdate(FaqDto dto);
	public int adminFaqDelete(int faq_no);
	public List<FaqDto> hashTagSearch(String faq_category);
	
	/* Course */
	public List<CourseDto> adminCourseList();
	public CourseDto courseSelectOne(int c_no);
	public int adminCourseInsert(CourseDto dto);
	public int adminCourseUpdate(CourseDto dto);
	public int adminCourseDelete(int c_no);
	
	/* Teacher */
	public List<TeacherDto> adminTeacherList();
	public int adminTeacherInsert(TeacherDto dto);
	public int adminTeacherUpdate(TeacherDto dto);
	public int adminTeacherDelete(int t_no);
	
	/* Member */
	public List<MemberDto> adminMemberList();
	public int adminMemberDelete(int user_no);
	
	/* Cancle */
	public List<CancleDto> adminCancleList();
	public CancleDto cancleSelectOne(int cancle_no);
	public int adminCancleDelete(int cancle_no);
	
	/* Review */
	public List<ReviewDto> adminReviewList();
	public ReviewDto reviewSelectOne(int r_no);
	public int adminReviewDelete(int r_no);
	
}