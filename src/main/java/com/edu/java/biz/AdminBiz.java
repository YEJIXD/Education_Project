package com.edu.java.biz;

import java.util.List;

import com.edu.java.dto.ApplicationDto;
import com.edu.java.dto.CourseDto;
import com.edu.java.dto.FaqDto;
import com.edu.java.dto.FaqDto;
import com.edu.java.dto.NoticeDto;
import com.edu.java.dto.QnaDto;
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
	
	/* 공지사항 리스트 */
	public List<NoticeDto> adminNoticeList();
	//public NoticeDto selectOne(int noti_no);
	
	public int adminNoticeInsert(NoticeDto dto);
	public int adminNoticeUpdate(NoticeDto dto);
	public int adminNoticeDelete(int noti_no);
	
	/* FAQ */
	public List<FaqDto> adminFaqList();
	//public FaqDto selectOne(int faq_no);
	
	public int adminFaqInsert(FaqDto dto);
	public int adminFaqUpdate(FaqDto dto);
	public int adminFaqDelete(int faq_no);
	
	public List<FaqDto> hashTagSearch(String faq_category);
	
	/* QnA */
	public List<QnaDto> adminQnaList();
	//public QnaDto selectOne(int q_no);
	
	public int adminQnaDelete(int q_no);
	
	/* 교육 리스트 */
	public List<CourseDto> adminCourseList();
	//public CourseDto selectOne(int c_no);
	
	public int adminCourseInsert(CourseDto dto);
	public int adminCourseUpdate(CourseDto dto);
	public int adminCourseDelete(int c_no);
	
	/* 수강 취소 */
	public List<ApplicationDto> adminCancleList();
	//public ApplicationDto selectOne(int cancle_no);
	
	public int adminCancleDelete(int cancle_no);
	
	/* 후기 */
	public List<ReviewDto> adminReviewList();
	//public ReviewDto selectOne(int r_no);
	
	public int adminReviewDelete(int r_no);
	
}
