package com.edu.java.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommonController {
	private static final Logger logger = LoggerFactory.getLogger(CommonController.class);
	
	// 메인페이지
	@RequestMapping("/main.do")
	public String goMain() {
		logger.info("Main page");
		return "../../index";
	}
	
	// 교육 소개_ 인사말
	@RequestMapping("/greeting.do")
	public String greeting() {
		logger.info("greeting page");
		return "/edu_Introduce/greeting";
	}
	
	// 교육 소개_ 교수진
	@RequestMapping("/teacher.do")
	public String teacher() {
		logger.info("teacher page");
		return "/edu_Introduce/teacher";
	}
	
	// 교육 소개_ 오시는 길
	@RequestMapping("/wayToCenter.do")
	public String wayToCenter() {
		logger.info("wayToCenter page");
		return "/edu_Introduce/wayToCenter";
	}
	
	// 교육 목표
	@RequestMapping("/goal.do")
	public String goal() {
		logger.info("goal page");
		return "/edu_Information/goal";
	}
	
	// 교육 신청_ 신청 전 확인사항 페이지
	@RequestMapping("/goApp.do")
	public String goApp() {
		logger.info("goApp page");
		return "/edu_Application/goApp";
	}
	
	// 교육 강의 목록
	@RequestMapping("/courseList.do")
	public String courseList() {
		logger.info("course List page");
		return "/edu_Application/courseList";
	}
	
	// 강의 상세 페이지
	@RequestMapping("/courseDetail.do")
	public String courseDetail() {
		logger.info("course Detail page");
		return "/edu_Application/courseDetail";
	}
	
	// 강의 신청 확인페이지
	@RequestMapping("/appForm.do")
	public String appForm() {
		logger.info("app Form page");
		return "/edu_Application/appForm";
	}

	// 교육 등록 페이지
	@RequestMapping("/courseInsert.do")
	public String courseInsert() {
		logger.info("course Insert page");
		return "/edu_Application/courseInsert";
	}
	
	// 교육 Insert
	
	// 교육 수정 페이지
	@RequestMapping("/courseUpdate.do")
	public String courseUpdate() {
		logger.info("course Update page");
		return "/edu_Application/courseUpdate";
	}
	
	// 교육 Update
	
	// 커뮤니티_ 공지사항 목록
	@RequestMapping("/notice.do")
	public String notice() {
		logger.info("notice page");
		return "/community/notice";
	}
	
	// 커뮤니티_ 공지사항 상세
	@RequestMapping("/noticeDetail.do")
	public String noticeDetail() {
		logger.info("notice Detail page");
		return "/community/noticeDetail";
	}
	
	// 커뮤니티_ 공지사항 등록 페이지
	@RequestMapping("/noticeInsert.do")
	public String noticeInsert() {
		logger.info("notice Insert page");
		return "/community/noticeInsert";
	}
	
	// 커뮤니티_ 공지사항 Insert
	
	// 커뮤니티_ 공지사항
	@RequestMapping("/noticeUpdate.do")
	public String noticeUpdate() {
		logger.info("notice Update page");
		return "/community/adminNoticeUpdate";
	}
	
	// 커뮤니티_ 공지사항 Update
	
	// 커뮤니티_ Faq List
	@RequestMapping("/faq.do")
	public String faqList() {
		logger.info("faq page");
		return "/community/faq";
	}
	
	// 커뮤니티_ Qna List
	@RequestMapping("/qnaList.do")
	public String qnaList() {
		logger.info("qna List page");
		return "/community/qnaList";
	}
	
	// 커뮤니티_ Qna 상세
	@RequestMapping("/qnaDetail.do")
	public String qnaDetail() {
		logger.info("qna Detail page");
		return "/community/qnaDetail";
	}
	
	// 커뮤니티_ Qna 답변
	@RequestMapping("/qnaAnswer.do")
	public String qnaAnswer() {
		logger.info("qna Answerpage");
		return "/admin/adminQnaAnswer";
	}
	
	// community_ Qna 답변 완료
	@RequestMapping("/qnaAnswerRes.do")
	public String adminQnaAnswerRes() {
		logger.info("Qna Answer Result");
		return "";
	}

	
	// 커뮤니티_ Qna 등록 페이지
	@RequestMapping("/qnaInsert.do")
	public String qnaInsert() {
		logger.info("qna Insert Page");
		return "/community/qnaInsert";
	}
	
	// 커뮤니티_ Qna Insert
	
	
	// 커뮤니티_ Qna 수정 페이지
	@RequestMapping("/qnaUpdate.do")
	public String qnaUpdate() {
		logger.info("qna Update Page");
		return "/community/qnaUpdate";
	}
		
	// 커뮤니티_ Qna Update
	

	// My Class_ 내 강의실 Main
	@RequestMapping("/myRoomMain.do")
	public String myRoomMain() {
		logger.info("myRoomMain page");
		return "/myRoom/myRoomMain";
	}
	
	// My Class_ 수강 교육
	@RequestMapping("/myStudy.do")
	public String myStudy() {
		logger.info("my Study page");
		return "/myRoom/myStudy";
	}
	
	// 수료증 발급
	@RequestMapping("/receiveCert.do")
	public String receiveCert() {
		logger.info("receive Certificate page");
		return "/myRoom/receiveCertificate";
	}

	// My Class_ 수강 후기 List
	@RequestMapping("/review.do")
	public String review() {
		logger.info("review page");
		return "/myRoom/review";
	}
	
	// My Class_ 수강 후기 Insert
	@RequestMapping("/reviewInsert.do")
	public String reviewInsert() {
		logger.info("review Insert page");
		return "/myRoom/reviewInsert";
	}
	
	// My Class_ 수강 후기 Update
	@RequestMapping("/reviewUpdate.do")
	public String reviewUpdate() {
		logger.info("review Update page");
		return "/myRoom/reviewUpdate";
	}
	
	// My Class_ 정보 수정 (비밀번호 확인 페이지)
	@RequestMapping("/pwConfirm.do")
	public String pwConfirm() {
		logger.info("password Confirm page");
		return "/myRoom/pwConfirm";
	}
	
	// My Class_ 정보 수정 page
	@RequestMapping("/userUpdate.do")
	public String userUpdate() {
		logger.info("user Update page");
		return "/myRoom/userUpdate";
	}
	
	// admin_ Main
	@RequestMapping("/adminMain.do")
	public String adminMain() {
		logger.info("admin Main page");
		return "/admin/adminMain";
	}
	
	// admin_ Notice
	@RequestMapping("/adminNoticeList.do")
	public String adminNoticeList() {
		logger.info("admin Notice List page");
		return "/admin/adminNotice";
	}
	
	// admin_ Notice 등록 페이지
	@RequestMapping("/adminNoticeInsert.do")
	public String adminNoticeInsert() {
		logger.info("admin Notice Insert page");
		return "/admin/adminNoticeInsert";
	}
	
	// admin_  Notice Insert
	
	// admin_ Notice 수정 페이지
	@RequestMapping("/adminNoticeUpdate.do")
	public String adminNoticeUpdate() {
		logger.info("admin Notice Update page");
		return "/admin/adminNoticeUpdate";
	}
	
	// admin_ Notice Update
	
	// admin_ Qna List (삭제 및 답변용)
	@RequestMapping("/adminQnaList.do")
	public String adminQnaList() {
		logger.info("admin Qna List page");
		return "/admin/adminQnaList";
	}
	
	// admin_ Faq List
	@RequestMapping("/adminFaqList.do")
	public String adminFaqList() {
		logger.info("admin Faq List page");
		return "/admin/adminFaqList";
	}
	
	// admin_ Faq 등록 페이지
	@RequestMapping("/adminFaqInsert.do")
	public String adminFaqInsert() {
		logger.info("admin Faq Insert page");
		return "/admin/adminFaqInsert";
	}
	
	// admin_ Faq Insert
		
	// admin_ Faq 수정 페이지
	@RequestMapping("/adminFaqUpdate.do")
	public String adminFaqUpdate() {
		logger.info("admin Faq Update page");
		return "/admin/adminFaqUpdate";
	}
		
	// admin_ Faq Update
	@RequestMapping("/adminFaqUpdateRes.do")
	public String adminFaqUpdateRes() {
		logger.info("Faq Update Result");
		return "";
	}
	
	// admin_ 강의 List
	@RequestMapping("/adminCourseList.do")
	public String adminCourseList() {
		logger.info("Course List page");
		return "/admin/adminCourseList";
	}
	
	// admin_ 수강 취소 List 
	@RequestMapping("/adminCancleList.do")
	public String adminCancleList() {
		logger.info("Cancle List page");
		return "/admin/adminCancleList";
	}
	
	// admin_ 수강 후기 List
	@RequestMapping("/adminReviewList.do")
	public String adminReviewList() {
		logger.info("Review List page");
		return "/admin/adminReviewList";
	}

}
