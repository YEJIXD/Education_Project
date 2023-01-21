package com.edu.java.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.edu.java.service.CommunityService;
import com.edu.java.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SessionAttributes("member")
@Controller
public class CommonController {
	private static final Logger logger = LoggerFactory.getLogger(CommonController.class);
	
	@Autowired
	UserService userService;
	
	@Autowired
	CommunityService communityService;
	
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
	
	@RequestMapping(value="/community/notice", method=RequestMethod.GET)
	public ModelAndView noticeList() {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("/community/notice");
		mav.addObject("list", communityService.notice());
			
		return mav;
	}
	
	@RequestMapping("/noticeDetail")
	public ModelAndView noticeDetail() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/community/noticeDetail");
		
		return mav;
	}
	
	@RequestMapping(value="/community/faq", method=RequestMethod.GET)
	public ModelAndView faqList() {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("list", communityService.faq());
		mav.setViewName("/community/faq");
			
		return mav;
	}
	
	@RequestMapping(value="/community/qna", method=RequestMethod.GET)
	public ModelAndView qnaList() {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("list", communityService.qna());
		mav.setViewName("/community/qna");
			
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
