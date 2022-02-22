package com.edu.java.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.edu.java.biz.CourseBiz;
import com.edu.java.dto.CourseDto;

@Controller
public class CourseController {
	private static final Logger logger = LoggerFactory.getLogger(CourseController.class);
	
	@Inject
	CourseBiz courseBiz;
	
	@RequestMapping("/courseInsertRes.do")
	public String courseInsertRes(CourseDto dto) throws Exception{
		logger.info("course Insert Res");
		courseBiz.courseInsertRes(dto);
		
		return "/edu_Application/courseList";
	}
	
	@RequestMapping("/courseUpdateRes.do")
	public String courseUpdateRes(CourseDto dto) throws Exception{
		logger.info("course Update Res");
		courseBiz.courseUpdateRes(dto);
		return "/edu_Application/courseDetail";
	}
}
