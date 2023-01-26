package com.edu.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.edu.java.service.CommunityService;
import com.edu.java.service.UserService;

@Controller
public class CommonController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	CommunityService communityService;
	
	@RequestMapping(value="/main", method=RequestMethod.GET)
	public String main() {
		return "common/index";
	}
	
	@RequestMapping(value="/greeting", method=RequestMethod.GET)
	public String greeting() {
		return "/user/introduce/greeting";
	}
	
	@RequestMapping("/teacher")
	public String teacher() {
		return "/user/introduce/teacher";
	}
	
	@RequestMapping("/wayToCenter")
	public String wayToCenter() {
		return "/user/introduce/wayToCenter";
	}
	
	@RequestMapping("/goal")
	public String goal() {
		return "/user/information/goal";
	}
	
	@RequestMapping("/goApp")
	public String goApp() {
		return "/application/goApp";
	}
	
	@RequestMapping("/courseList")
	public String courseList() {
		return "/application/getCourse";
	}
	
	@RequestMapping("/courseDetail")
	public String courseDetail() {
		return "/application/courseDetail";
	}
	
	@RequestMapping(value="/community/notice", method=RequestMethod.GET)
	public ModelAndView noticeList() {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("/community/notice");
		mav.addObject("list", communityService.notice());
			
		return mav;
	}
	
	@RequestMapping(value = "/community/noticeDetail", method=RequestMethod.GET)
	public ModelAndView noticeDetail() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/community/noticeDetail");
		
		return mav;
	}
	
	@RequestMapping(value="/community/faq", method=RequestMethod.GET)
	public ModelAndView faq() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/community/faq");
		return mav;
	}
	
	@RequestMapping(value="/community/faq", method=RequestMethod.POST)
	public ModelAndView faqList() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", communityService.faq());
			
		return mav;
	}
	
	@RequestMapping(value="/community/qna", method=RequestMethod.GET)
	public ModelAndView qna() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/community/qna");
			
		return mav;
	}
	
	@RequestMapping(value="/community/qna", method=RequestMethod.POST)
	public ModelAndView qnaList() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", communityService.qna());
			
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
		return "/myRoom/main";
	}
	
	@RequestMapping("/myStudy")
	public String myStudy() {
		return "/myRoom/myStudy";
	}
	
	@RequestMapping("/receiveCert")
	public String receiveCert() {
		return "/myRoom/certificate";
	}

	@RequestMapping("/review")
	public String review() {
		return "/myRoom/review";
	}
	
	@RequestMapping("/inputReview")
	public String reviewInsert() {
		return "/myRoom/inputReview";
	}
	
	@RequestMapping("/modifyReview")
	public String reviewUpdate() {
		return "/myRoom/modifyReview";
	}
	
	@RequestMapping("/pwConfirm")
	public String pwConfirm() {
		return "/myRoom/pwConfirm";
	}
	
	@RequestMapping("/modifyUser")
	public String userUpdate() {
		return "/myRoom/modifyUser";
	}

}
