package com.edu.java.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.edu.java.biz.CourseBiz;
import com.edu.java.dto.CourseDto;
import com.edu.java.dto.FaqDto;

@Controller
public class CourseController {
	private static final Logger logger = LoggerFactory.getLogger(CourseController.class);
	
	@Inject
	CourseBiz courseBiz;
	
	/* Course List */
	@RequestMapping(value="/courseList.do", method=RequestMethod.GET)
	public ModelAndView courseList() throws Exception {
		logger.info("course LIST PAGE");
			
		List<CourseDto> list = courseBiz.courseList();
		ModelAndView mav = new ModelAndView("jsonView");
		mav.setViewName("/edu_Application/courseList");
		mav.addObject("list", list);
			
		return mav;
	}
	
	/*
	 *
	 * 
	 * @RequestMapping("/courseUpdateRes.do") public String
	 * courseUpdateRes(CourseDto dto) throws Exception{
	 * logger.info("course Update Res"); courseBiz.courseUpdateRes(dto);
	 * 
	 * return "/edu_Application/courseDetail"; }
	 */
	 
}
