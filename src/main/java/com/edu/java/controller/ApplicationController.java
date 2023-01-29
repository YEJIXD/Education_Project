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
	public ModelAndView goApp() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/user/application/goApp");
		
		return mav;
	}
	
}
