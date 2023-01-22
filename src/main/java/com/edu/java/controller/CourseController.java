package com.edu.java.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.edu.java.CmmService;
import com.edu.java.dao.AdminDao;
import com.edu.java.dao.CourseDao;
import com.edu.java.dto.Criteria;
import com.edu.java.dto.PageDto;
import com.edu.java.service.AdminService;
import com.edu.java.service.CourseService;

@Controller
public class CourseController {

	@Autowired
	CourseService courseService;

	@Autowired
	AdminService adminService;
	
	@Autowired
	CmmService cmmService;
	
	@Autowired
	AdminDao adminDao;
	
	@Autowired
	CourseDao courseDao;

	@RequestMapping(value="/getCourse", method=RequestMethod.GET)
	public ModelAndView courseList(PageDto dto, @ModelAttribute("cri") Criteria cri) throws Exception{
		ModelAndView mav = new ModelAndView("jsonView");
		dto.setCri(cri); 									// page와 amount 설정
		dto.setTotal(adminDao.getTotalCount(dto.getKeyword())); 	// 총 게시글 수 조회하는 로직 담기

		List<Map<String, Object>> list = adminDao.courseList(dto, cri);
		mav.addObject("list", list);
		mav.addObject("dto", dto); // total 값 가져오기 => 페이지 수 카운트
		mav.addObject("cri", cri);
		mav.setViewName("/user/application/courseList");

		return mav;
	}

	@RequestMapping(value="/coursedetail", method=RequestMethod.GET)
	public ModelAndView courseDetail() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/user/application/courseDetail");

		return mav;
	}
	
	@RequestMapping(value="/coureDetail", method=RequestMethod.POST)
	public ModelAndView courseDetailPost(@RequestParam("seq") int seq, @ModelAttribute("cri") Criteria cri) {
		ModelAndView mav = new ModelAndView("jsonView");
		mav.addObject("dto", courseDao.selectOne(seq));
		mav.addObject("cri", cri);
		
		return mav;
	}

	@RequestMapping(value="/appForm", method=RequestMethod.GET)
	public String appForm() {
		return "/user/application/appForm";
	}
}
