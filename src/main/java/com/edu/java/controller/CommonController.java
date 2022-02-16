package com.edu.java.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommonController {
	private static final Logger logger = LoggerFactory.getLogger(CommonController.class);
	
	@RequestMapping("/main.do")
	public String goMain() {
		logger.info("Main page");
		return "../../index.jsp";
	}
	
	@RequestMapping("/registForm.do")
	public String registForm() {
		logger.info("regist Form page");
		return "/login/registForm2.jsp";
	}
	
	@RequestMapping("/regist.do")
	public String regist() {
		logger.info("regist page");
		return "../../index.jsp";
	}
	
	@RequestMapping("/greeting.do")
	public String greeting() {
		logger.info("greeting page");
		return "/edu_Introduce/greeting.jsp";
	}
	
	@RequestMapping("/teacher.do")
	public String teacher() {
		logger.info("teacher page");
		return "/edu_Introduce/teacher.jsp";
	}
	
	@RequestMapping("/wayToCenter.do")
	public String wayToCenter() {
		logger.info("wayToCenter page");
		return "/edu_Introduce/wayToCenter.jsp";
	}
	
	@RequestMapping("/goal.do")
	public String goal() {
		logger.info("goal page");
		return "/edu_Information/goal.jsp";
	}
	
	@RequestMapping("/goApp.do")
	public String goApp() {
		logger.info("goApp page");
		return "/edu_Application/goApp.jsp";
	}
	
	@RequestMapping("/courseList.do")
	public String courseList() {
		logger.info("course List page");
		return "/edu_Application/courseList.jsp";
	}
	
	@RequestMapping("/courseDetail.do")
	public String courseDetail() {
		logger.info("course Detail page");
		return "/edu_Application/courseDetail.jsp";
	}
	
	@RequestMapping("/appForm.do")
	public String appForm() {
		logger.info("app Form page");
		return "/edu_Application/appForm.jsp";
	}
	
	@RequestMapping("/appFinish.do")
	public String appFinish() {
		logger.info("app Finish page");
		return "";
	}
	
	@RequestMapping("/courseInsert.do")
	public String courseInsert() {
		logger.info("course Insert page");
		return "/edu_Application/courseInsert.jsp";
	}
	
	@RequestMapping("/courseUpdate.do")
	public String courseUpdate() {
		logger.info("course Update page");
		return "/edu_Application/courseUpdate.jsp";
	}
	
	@RequestMapping("/notice.do")
	public String notice() {
		logger.info("notice page");
		return "/community/notice.jsp";
	}
	
	@RequestMapping("/faq.do")
	public String faqList() {
		logger.info("faq page");
		return "/community/faq.jsp";
	}
	
	@RequestMapping("/qnaList.do")
	public String qnaList() {
		logger.info("qnaList page");
		return "/community/qnaList.jsp";
	}

	@RequestMapping("/myRoomMain.do")
	public String myRoomMain() {
		logger.info("myRoomMain page");
		return "/myRoom/myRoomMain.jsp";
	}
	
	@RequestMapping("/myStudy.do")
	public String myStudy() {
		logger.info("my Study page");
		return "/myRoom/myStudy.jsp";
	}

	@RequestMapping("/receiveCert.do")
	public String receiveCert() {
		logger.info("receive Certificate page");
		return "/myRoom/receiveCertificate.jsp";
	}
	
	@RequestMapping("/review.do")
	public String review() {
		logger.info("review page");
		return "/myRoom/review.jsp";
	}
	
	@RequestMapping("/reviewInsert.do")
	public String reviewInsert() {
		logger.info("review Insert page");
		return "/myRoom/reviewInsert.jsp";
	}
	
	@RequestMapping("/reviewUpdate.do")
	public String reviewUpdate() {
		logger.info("review Update page");
		return "/myRoom/reviewUpdate.jsp";
	}
	
	@RequestMapping("/pwConfirm.do")
	public String pwConfirm() {
		logger.info("password Confirm page");
		return "/myRoom/pwConfirm.jsp";
	}
	
	@RequestMapping("/userUpdate.do")
	public String userUpdate() {
		logger.info("user Update page");
		return "/myRoom/userUpdate.jsp";
	}

}
