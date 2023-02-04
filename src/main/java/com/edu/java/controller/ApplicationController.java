package com.edu.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.edu.java.service.ApplicationService;

@Controller
public class ApplicationController {
	
	@Autowired
	ApplicationService applicationService;
	
	@RequestMapping(value="/application/goApp", method=RequestMethod.GET)
	public String goApp() {
		return "/user/application/goApp";
	}
	
	@RequestMapping(value="/application/courseList", method=RequestMethod.GET)
	public ModelAndView courseList() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/user/application/courseList");
		return mav;
	}
	
	@RequestMapping(value="/application/courseList", method=RequestMethod.POST)
	public ModelAndView getCorsePost() {
		ModelAndView mav = new ModelAndView("jsonView");
		
		// 코드 추가해야 함
		
		return mav;
	}
	
	@RequestMapping(value="/application/courseDetail", method=RequestMethod.GET)
	public String courseDetail() {
		return "/user/application/courseDetail";
	}
	
}
