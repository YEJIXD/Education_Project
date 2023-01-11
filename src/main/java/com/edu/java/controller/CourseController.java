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
import com.edu.java.biz.AdminBiz;
import com.edu.java.biz.CourseBiz;
import com.edu.java.dto.ApplicationDto;
import com.edu.java.dto.CourseDto;
import com.edu.java.dto.Criteria;
import com.edu.java.dto.MemberDto;
import com.edu.java.dto.PageDto;

@Controller
public class CourseController {
	private static final Logger logger = LoggerFactory.getLogger(CourseController.class);

	@Inject
	CourseBiz courseBiz;

	@Autowired
	AdminBiz adminBiz;
	
	@Autowired
	CmmService cmmService;

	/* Course List */
	@RequestMapping(value="/courseList", method=RequestMethod.GET)
	public ModelAndView courseList(PageDto dto
								 , @ModelAttribute("cri") Criteria cri) throws Exception{
		logger.info("course LIST PAGE");
		ModelAndView mav = new ModelAndView("jsonView");
		dto.setCri(cri); 									// page와 amount 설정
		dto.setTotal(adminBiz.getTotalCount(dto.getKeyword())); 	// 총 게시글 수 조회하는 로직 담기

		List<Map<String, Object>> list = adminBiz.courseList(dto, cri);
		mav.addObject("list", list);
		mav.addObject("dto", dto); // total 값 가져오기 => 페이지 수 카운트
		mav.addObject("cri", cri);
		mav.setViewName("/edu_Application/courseList");

		System.out.println("PageDto :: " + dto);

		return mav;
	}

	/* Course Detail */

	@RequestMapping(value="courseDetail", method=RequestMethod.GET)
	public ModelAndView courseDetail(@RequestParam("c_no") int c_no
								   , @ModelAttribute("cri") Criteria cri) throws Exception{
		logger.info("course Detail Page");
		ModelAndView mav = new ModelAndView("jsonView");

		mav.addObject("dto", courseBiz.selectOne(c_no));
		mav.addObject("cri", cri);
		mav.setViewName("/edu_Application/courseDetail");

		return mav;
	}

	/* 교육 신청 확인 FORM */
	@RequestMapping(value="/appForm", method=RequestMethod.GET)
	public String appForm() {
		logger.info("APP FORM PAGE");
		
		return "/edu_Application/appForm";
	}
	/* 교육 신청 */
	/*@RequestMapping(value="/appInsert", method=RequestMethod.POST)
	public ModelAndView appInsert(@RequestBody CourseDto cDto, @ModelAttribute MemberDto mDto, @ModelAttribute ApplicationDto aDto, HttpSession session) throws Exception{
		logger.info("App Insert Res");
		ModelAndView mav = new ModelAndView("jsonView");
		int resultCode = 0;

		try {
			HashMap<String, Object> paramMap = cmmService.jsonStringToHashMap(param);
			@SuppressWarnings("unchecked")
			HashMap<String, Object> user = (HashMap<String, Object>) session.getAttribute("USER");

			if (user == null) {
				resultCode = 10;
			} else {
				String user_no = user.get("USER_NO").toString();
				paramMap.put("user_no", user_no);
				courseBiz.courseAppInsert(paramMap);
			}
		} catch (Exception e) {
			logger.trace(e.getMessage());
			e.printStackTrace();
		} finally {
			mav.addObject("resultCode", resultCode);
		}
		mav.addObject("msg", "교육 신청이 완료되었습니다.");

		return mav;
	}*/
}
