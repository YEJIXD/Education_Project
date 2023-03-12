package com.edu.java.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.edu.java.CmmService;
import com.edu.java.mapper.AdminMapper;
import com.edu.java.mapper.CourseBiz;
import com.edu.java.dto.Criteria;
import com.edu.java.dto.PageDto;

@Controller
public class CourseController {
	private static final Logger logger = LoggerFactory.getLogger(CourseController.class);

	@Inject
	CourseBiz courseBiz;

	@Autowired
	AdminMapper adminBiz;
	
	@Autowired
	CmmService cmmService;

	@RequestMapping(value = "/courseList", method = RequestMethod.GET)
	public ModelAndView courseList(PageDto dto, @ModelAttribute("cri") Criteria cri) throws Exception {
		ModelAndView mav = new ModelAndView("jsonView");

		dto.setCri(cri); // page와 amount 설정
		dto.setTotal(adminBiz.getTotal(dto.getKeyword())); // 총 게시글 수 조회하는 로직 담기

		List<HashMap<String, Object>> list = adminBiz.courseList(dto, cri);
		mav.addObject("list", list);
		mav.addObject("dto", dto); // total 값 가져오기 => 페이지 수 카운트
		mav.setViewName("/edu_Application/courseList");

		return mav;
	}

	@RequestMapping(value = "selectCourse", method = RequestMethod.GET)
	public ModelAndView courseDetail(@RequestParam("c_no") int c_no, @ModelAttribute("cri") Criteria cri) {
		ModelAndView mav = new ModelAndView("jsonView");
		// CourseDto dto = courseBiz.selectOne(c_no);

		mav.addObject("dto", courseBiz.selectOne(c_no));
		mav.addObject("cri", cri);
		mav.setViewName("/edu_Application/courseDetail");

		return mav;
	}

	@RequestMapping(value="/appForm", method=RequestMethod.GET)
	public ModelAndView appForm() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/user/application/application");
		return mav;
	}

	
	@RequestMapping(value = "inputApp", method = RequestMethod.POST)
	public ModelAndView appInsert(@RequestBody String param, HttpSession session) throws Exception {
		logger.info("App Insert Res");
		ModelAndView mav = new ModelAndView("jsonView");

		try {
			HashMap<String , Object> paramMap = cmmService.jsonStringToHashMap(param);
			@SuppressWarnings("unchecked")
			HashMap<String, Object> user = (HashMap<String, Object>) session.getAttribute("USER");

			if (user == null) {
				mav.addObject("msg", "user is null");
			} else {
				String user_no = user.get("USER_NO").toString();
				paramMap.put("user_no", user_no);
				courseBiz.courseAppInsert(paramMap);
			}
		} catch (Exception e) {
			logger.trace(e.getMessage());
			e.printStackTrace();
		} finally {
			//mav.addObject("")
		}
		mav.addObject("msg", "교육 신청 완료");

		return mav;
	}

	/*
	 * @RequestMapping("/courseUpdateRes") public String
	 * courseUpdateRes(CourseDto dto) throws Exception{
	 * logger.info("course Update Res"); courseBiz.courseUpdateRes(dto);
	 * 
	 * return "/edu_Application/courseDetail"; }
	 */

}
