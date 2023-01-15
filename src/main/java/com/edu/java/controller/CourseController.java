package com.edu.java.controller;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.edu.java.CmmService;
import com.edu.java.service.AdminService;
import com.edu.java.service.CourseService;
import com.edu.java.dto.Criteria;
import com.edu.java.dto.PageDto;

@Controller
public class CourseController {
	private static final Logger logger = LoggerFactory.getLogger(CourseController.class);

	@Inject
	CourseService courseService;

	@Autowired
	AdminService adminService;
	
	@Autowired
	CmmService cmmService;

	/*@RequestMapping(value="/courseList", method=RequestMethod.GET)
	public ModelAndView courseList(PageDto dto, @ModelAttribute("cri") Criteria cri) throws Exception{
		logger.info("course LIST PAGE");
		ModelAndView mav = new ModelAndView("jsonView");
		dto.setCri(cri); 									// page와 amount 설정
		dto.setTotal(adminBiz.getTotalCount(dto.getKeyword())); 	// 총 게시글 수 조회하는 로직 담기

		List<Map<String, Object>> list = adminBiz.courseList(dto, cri);
		mav.addObject("list", list);
		mav.addObject("dto", dto); // total 값 가져오기 => 페이지 수 카운트
		mav.addObject("cri", cri);
		mav.setViewName("/edu_Application/courseList");

		return mav;
	}

	@RequestMapping(value="courseDetail", method=RequestMethod.GET)
	public ModelAndView courseDetail(@RequestParam("c_no") int c_no, @ModelAttribute("cri") Criteria cri) throws Exception{
		ModelAndView mav = new ModelAndView("jsonView");

		mav.addObject("dto", courseBiz.selectOne(c_no));
		mav.addObject("cri", cri);
		mav.setViewName("/edu_Application/courseDetail");

		return mav;
	}

	@RequestMapping(value="/appForm", method=RequestMethod.GET)
	public String appForm() {
		return "/edu_Application/appForm";
	}*/
}
