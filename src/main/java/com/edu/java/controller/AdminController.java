package com.edu.java.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.edu.java.biz.AdminBiz;
import com.edu.java.biz.MemberBiz;

@Controller
public class AdminController {
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Inject
	AdminBiz adminBiz;
	MemberBiz memberBiz;
	
	/* 관리자 메인 */
	@RequestMapping("/adminMain.do")
	public String adminMain(Model model) {
		logger.info("admin Main");
		
		model.addAttribute("newUserCount", memberBiz.newAdminUserCount());
		
		
		
		return "/admin/adminMain";
	}
	
	/* 교육 목록 */
	@RequestMapping(value="adminCourseList.do", method=RequestMethod.GET)
	public String adminCourseList(Model model) {
		logger.info("admin Course List");
		model.addAttribute("courseList", adminBiz.adminCourseList());
		
		return "/admin/adminCourseList";
	}
}
