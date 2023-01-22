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
		return "/application/courseList";
	}
	
	@RequestMapping("/courseDetail")
	public String courseDetail() {
		return "/application/courseDetail";
	}
	
	@RequestMapping("/appForm")
	public String appForm() {
		return "/application/appForm";
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
