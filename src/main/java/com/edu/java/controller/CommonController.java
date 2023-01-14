package com.edu.java.controller;

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

@SessionAttributes("member")
@Controller
public class CommonController {
	private static final Logger logger = LoggerFactory.getLogger(CommonController.class);
	
	@Autowired
	MemberBiz memberBiz;
	
	@Autowired
	CommunityBiz communityBiz;
	
	@RequestMapping(value="/main", method=RequestMethod.GET)
	public String main() {
		return "common/index";
	}
	
	@RequestMapping("/greeting")
	public String greeting() {
		logger.info("greeting page");
		return "/edu_Introduce/greeting";
	}
	
	@RequestMapping("/teacher")
	public String teacher() {
		logger.info("teacher page");
		return "/edu_Introduce/teacher";
	}
	
	@RequestMapping("/wayToCenter")
	public String wayToCenter() {
		logger.info("wayToCenter page");
		return "/edu_Introduce/wayToCenter";
	}
	
	@RequestMapping("/goal")
	public String goal() {
		logger.info("goal page");
		return "/edu_Information/goal";
	}
	
	@RequestMapping("/goApp")
	public String goApp() {
		logger.info("goApp page");
		return "/edu_Application/goApp";
	}
	
	@RequestMapping("/courseList")
	public String courseList() {
		logger.info("course List page");
		return "/edu_Application/courseList";
	}
	
	@RequestMapping("/courseDetail")
	public String courseDetail() {
		logger.info("course Detail page");
		return "/edu_Application/courseDetail";
	}
	
	@RequestMapping("/appForm")
	public String appForm() {
		logger.info("app Form page");
		return "/edu_Application/appForm";
	}
	
	@RequestMapping("/noticeList")
	public ModelAndView noticeList() throws Exception{
		ModelAndView mav = new ModelAndView("jsonView");
		mav.setViewName("/community/noticeList");
		mav.addObject("list", communityBiz.noticeList());
			
		return mav;
	}
	
	@RequestMapping("/noticeDetail")
	public ModelAndView noticeDetail() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/community/noticeDetail");
		
		return mav;
	}
	
	@RequestMapping(value="/faqList", method=RequestMethod.GET)
	public ModelAndView faqList() throws Exception{
		ModelAndView mav = new ModelAndView("jsonView");
		
		mav.addObject("list", communityBiz.faqList());
		mav.setViewName("/community/faqList");
			
		return mav;
	}
	
	@RequestMapping("/qnaList")
	public ModelAndView qnaList() throws Exception {
		ModelAndView mav = new ModelAndView("jsonView");
		
		mav.addObject("list", communityBiz.qnaList());
		mav.setViewName("/community/qnaList");
			
		return mav;
	}
	
	@RequestMapping("/qnaDetail")
	public String qnaDetail() {
		return "/community/qnaDetail";
	}
	
	@RequestMapping("/qnaAnswer")
	public String qnaAnswer() {
		return "/admin/adminQnaAnswer";
	}
	
	@RequestMapping("/qnaAnswerRes")
	public String adminQnaAnswerRes() {
		return "";
	}

	@RequestMapping("/myRoomMain")
	public String myRoomMain() {
		return "/myRoom/myRoomMain";
	}
	
	@RequestMapping("/myStudy")
	public String myStudy() {
		return "/myRoom/myStudy";
	}
	
	@RequestMapping("/receiveCert")
	public String receiveCert() {
		return "/myRoom/receiveCertificate";
	}

	@RequestMapping("/review")
	public String review() {
		return "/myRoom/review";
	}
	
	@RequestMapping("/reviewInsert")
	public String reviewInsert() {
		return "/myRoom/reviewInsert";
	}
	
	@RequestMapping("/reviewUpdate")
	public String reviewUpdate() {
		return "/myRoom/reviewUpdate";
	}
	
	@RequestMapping("/pwConfirm")
	public String pwConfirm() {
		return "/myRoom/pwConfirm";
	}
	
	@RequestMapping("/userUpdate")
	public String userUpdate() {
		return "/myRoom/userUpdate";
	}

}
