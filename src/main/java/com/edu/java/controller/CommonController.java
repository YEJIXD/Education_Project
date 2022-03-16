package com.edu.java.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.edu.java.biz.CommunityBiz;
import com.edu.java.biz.MemberBiz;
import com.edu.java.dto.FaqDto;
import com.edu.java.dto.NoticeDto;
import com.edu.java.dto.QnaDto;

@SessionAttributes("member")
@Controller
public class CommonController {
	private static final Logger logger = LoggerFactory.getLogger(CommonController.class);
	
	@Autowired
	MemberBiz memberBiz;
	
	@Autowired
	CommunityBiz communityBiz;
	
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
	@RequestMapping("/noticeList.do")
	public ModelAndView noticeList() throws Exception{
		logger.info("notice page");
		
		ModelAndView mav = new ModelAndView("jsonView");
		List<NoticeDto> list = communityBiz.noticeList();
		
		mav.setViewName("/community/noticeList");
		mav.addObject("list", list);
			
		return mav;
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
	@RequestMapping(value="/faqList.do", method=RequestMethod.GET)
	public ModelAndView faqList() throws Exception{
		logger.info("faq List page");
		
		/*
		  ModelAndView mav = new ModelAndView("jsonView"); 
		  List<FaqDto> list = null;
		  
		  try { 
		  		list = communityBiz.faqList(); 
		  }catch(Exception e){
		  		System.out.println("[error] : faq List error"); 
		  		e.printStackTrace(); 
		  }
		  
		 mav.setViewName("/community/faqList"); 
		 mav.addObject("list", list);
		  
		  return mav;
		 */
		
		ModelAndView mav = new ModelAndView("jsonView");
		List<FaqDto> list = communityBiz.faqList();
		
		mav.setViewName("/community/faqList");
		mav.addObject("list", list);
			
		return mav;
	}
	
	// 커뮤니티_ Qna List
	@RequestMapping("/qnaList.do")
	public ModelAndView qnaList() throws Exception {
		logger.info("qna List page");
		
		ModelAndView mav = new ModelAndView("jsonView");
		List<QnaDto> list = communityBiz.qnaList();
		
		mav.setViewName("/community/qnaList");
		mav.addObject("list", list);
			
		return mav;
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

}
