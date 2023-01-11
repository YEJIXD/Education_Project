package com.edu.java.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.edu.java.CmmService;
import com.edu.java.biz.AdminBiz;
import com.edu.java.dto.ApplicationDto;
import com.edu.java.dto.CourseDto;
import com.edu.java.dto.Criteria;
import com.edu.java.dto.FaqDto;
import com.edu.java.dto.MemberDto;
import com.edu.java.dto.NoticeDto;
import com.edu.java.dto.PageDto;
import com.edu.java.dto.QnaDto;
import com.google.gson.JsonObject;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class AdminController {

	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

	@Inject
	AdminBiz adminBiz;

	@Autowired
	CmmService cmmService;

	@RequestMapping(value = "/adminMain", method = RequestMethod.GET)
	public ModelAndView adminMain(@RequestParam HashMap<String, Object> paramMap) {
		logger.info("admin Main");
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("pageName", "adminMain");

		return mav;
	}

	@RequestMapping(value = "/noticeList", method = RequestMethod.GET)
	public ModelAndView adminNoticeList() {
		logger.info("admin Notice List");
		ModelAndView mav = new ModelAndView();
		List<NoticeDto> list = null;

		try {
			list = adminBiz.noticeList();
		} catch (Exception e) {
			log.debug("[ ERROR ] : notice List");
			e.printStackTrace();
		}

		mav.setViewName("/admin/adminNoticeList");
		mav.addObject("list", list);

		return mav;
	}

	@RequestMapping(value = "/adminNoticeInsert", method = RequestMethod.GET)
	public String adminNoticeInsert() {
		logger.info("admin Notice Insert page");
		return "/admin/adminNoticeInsert";
	}

	@RequestMapping(value="adminNoticeInsertRes", method=RequestMethod.POST)
	public ModelAndView adminNotieInsertRes(NoticeDto dto, HttpServletRequest request) throws Exception{
		
		logger.info("admin Notice Insert Res");
		
		ModelAndView mav = new ModelAndView("jsonview");
		//mav.addObject("noticeList", )
		
		return mav;
	}

	@RequestMapping("/adminNoticeUpdate")
	public String adminNoticeUpdate() {
		logger.info("admin Notice Update page");
		return "/admin/adminNoticeUpdate";
	}

	@RequestMapping(value = "/adminNoticeDelete", method = RequestMethod.GET)
	public String adminNoticeDelete(Model model, HttpServletRequest httpServletRequest) {
		System.out.println("admin notice delete");
		String[] chk = httpServletRequest.getParameterValues("RowCheck[]");
		System.out.println(chk);

		int chk_length = chk.length;
		System.out.println(chk_length);

		for (int i = 0; i < chk_length; i++) {
			System.out.println(chk[i]);
			adminBiz.deleteNotice(Integer.parseInt(chk[i]));
		}

		return "redirect:/adminNoticeList";
	}

	@RequestMapping(value = "/adminFaqList", method = RequestMethod.GET)
	public ModelAndView adminFaqList() throws Exception {
		logger.info("admin Faq LIST PAGE");

		List<FaqDto> list = adminBiz.faqList();
		ModelAndView mav = new ModelAndView("jsonView");
		mav.setViewName("/admin/adminFaqList");
		mav.addObject("list", list);

		return mav;
	}

	@RequestMapping("/adminFaqInsert")
	public String adminFaqInsert() {
		logger.info("admin Faq Insert page");
		return "/admin/adminFaqInsert";
	}

	@RequestMapping(value = "/adminFaqInsertRes", method = RequestMethod.POST)
	public ModelAndView adminFaqInsertRes() throws Exception {
		logger.info("admin Faq Insert Result");
		List<FaqDto> list = adminBiz.faqList();
		ModelAndView mav = new ModelAndView("jsonview");

		mav.setViewName("/community/faq");
		mav.addObject("list", list);

		return mav;
	}

	@RequestMapping("/modifyFaq")
	public String modifyFaq() {
		logger.info("admin Faq Update page");
		return "/admin/adminFaqUpdate";
	}

	@RequestMapping("/adminFaqUpdateRes")
	public String adminFaqUpdateRes() {
		logger.info("Faq Update Result");
		return "";
	}

	@RequestMapping(value = "/deleteFaq", method = RequestMethod.GET)
	public String adminFaqDelete(Model model, HttpServletRequest httpServletRequest) {
		System.out.println("admin Faq delete");

		String[] chk = httpServletRequest.getParameterValues("RowCheck[]");
		System.out.println(chk);

		int chk_length = chk.length;
		System.out.println(chk_length);

		for (int i = 0; i < chk_length; i++) {
			System.out.println(chk[i]);
			adminBiz.deleteFaq(Integer.parseInt(chk[i]));
		}

		return "redirect:/adminFaqList";
	}

	@RequestMapping("/subMenu")
	public String subMenu(Model model, String faq_category) {
		logger.info("subMenu");

		String str = "";
		String category = "";

		if (faq_category.equals("all")) {
			str = "전 체";

		} else if (faq_category.equals("education")) {
			str = "교 육";

		} else if (faq_category.equals("price")) {
			str = "비 용";
		} else if (faq_category.equals("site")) {
			str = "사이트";
		} else {
			str = "기 타";
		}

		model.addAttribute("faq_category", str);

		return "";

	}

	@RequestMapping(value = "qnaList", method = RequestMethod.GET)
	public ModelAndView qnaList(Model model) {
		logger.info("admin qna list");

		ModelAndView mav = new ModelAndView();
		List<QnaDto> list = adminBiz.qnaList();

		mav.setViewName("/admin/adminQnaList");
		mav.addObject("list", list);

		return mav;
	}

	@RequestMapping(value = "courseList", method = RequestMethod.GET)
	public ModelAndView courseList(PageDto dto, @ModelAttribute("cri") Criteria cri) throws Exception {
		logger.info("admin Course List");
		ModelAndView mav = new ModelAndView("jsonView");
		dto.setCri(cri); // page와 amount 설정
		dto.setTotal(adminBiz.getTotalCount(dto.getKeyword())); // 총 게시글 수 조회하는 로직 담기

		List<Map<String, Object>> list = adminBiz.courseList(dto, cri);
		mav.addObject("list", list);
		// endPage 숫자 다르게 나오는 것 아래처럼 객체에 담아 수정
		mav.addObject("dto", dto); // keyword 잘 담김
		// page와 amount 담아오기
		mav.addObject("cri", cri);
		mav.setViewName("/admin/adminCourseList");

		return mav;
	}

	@RequestMapping(value = "courseDetail", method = RequestMethod.GET)
	public ModelAndView adminCourseDetail(PageDto dto, @RequestParam("c_no") int c_no,
			@ModelAttribute("cri") Criteria cri) throws Exception {
		logger.info("admin Course Detail");
		ModelAndView mav = new ModelAndView("jsonView");

		mav.addObject("dto", adminBiz.courseDetail(c_no));
		mav.addObject("cri", cri);
		mav.setViewName("/admin/adminCourseDetail");

		return mav;
	}

	@RequestMapping("/adminCourseInsert")
	public String inputCourse() throws Exception {
		logger.info("admin Course Insert Form");

		return "/admin/adminCourseInsert";
	}

	@RequestMapping(value = "/courseInsertRes", method = RequestMethod.POST)
	public ModelAndView adminCourseInsertRes(@RequestBody CourseDto dto, HttpSession session) throws Exception {
		logger.info("admin course insert Res");
		ModelAndView mav = new ModelAndView("jsonView");
		int resultCode = 0;

		try {
			// if(검사 ==1) { throw new Userexception 코드 200 이유 : 검사값이 맞지않아 }
			@SuppressWarnings("unchecked")
			HashMap<String, Object> user = (HashMap<String, Object>) session.getAttribute("USER");
			if (user == null) {
				resultCode = 10;
			} else {
				String UserName = String.valueOf(user.get("USER_NAME"));
				dto.setC_init_writer(UserName);
				adminBiz.inputCourse(dto);
			}
		} catch (Exception e) {
			logger.trace(e.getMessage());
			e.printStackTrace();
		} finally {
			mav.addObject("resultCode", resultCode);
		}
		System.out.println(dto.toString());
		mav.addObject("msg", "교육 등록 완료");

		return mav;
	}

	@RequestMapping(value = "/adminCourseUpdate", method = RequestMethod.GET)
	public String adminCourseUpdate(@RequestParam int c_no, Model model, @ModelAttribute("cri") Criteria cri)
			throws Exception {
		logger.info("admin Course Update Form");
		CourseDto dto = adminBiz.courseDetail(c_no);
		model.addAttribute("dto", dto);
		model.addAttribute("cri", cri); // page amount 값

		return "/admin/adminCourseUpdate";
	}

	@RequestMapping(value = "courseUpdateRes", method = RequestMethod.POST)
	public ModelAndView adminCourseUpdateRes(@RequestBody CourseDto dto, HttpSession session,
			@ModelAttribute("cri") Criteria cri) throws Exception {
		logger.info("Admin Course Update Res");
		ModelAndView mav = new ModelAndView("jsonView");
		int resultCode = 0;

		try { /* 로그인 되어있는 상태에서만 수정할 수 있도록 작성 */
			@SuppressWarnings("unchecked")
			HashMap<String, Object> User = (HashMap<String, Object>) session.getAttribute("USER");
			if (User == null) {
				resultCode = 10;
			} else {
				String UserName = String.valueOf(User.get("USER_NAME")); // String.valueOf 사용 -> User에서 USER_NAME
																			// 가져와서(get) UserName에 저장

				dto.setC_init_writer(UserName); // CourseDto의 c_init_writer에 UserName 저장
				adminBiz.modifyCourse(dto); // adminBiz(Service단)에서 adminCourseUpdate() 메서드 실행
				mav.addObject("cri", cri); // cri 객체로 page와 amount값 가지고 다니기

			}
		} catch (Exception e) {
			logger.trace(e.getMessage());
			e.printStackTrace();
		} finally {
			mav.addObject("resultCode", resultCode);
			mav.addObject("cri", cri);
		}
		System.out.println(dto.toString());
		mav.addObject("msg", "교육 수정 완료");

		return mav;
	}

	@RequestMapping(value = "/adminCourseDelete", method = RequestMethod.POST)
	public ModelAndView adminCourseDelete(@RequestBody String param) throws Exception {
		logger.info("admin Course Delete");

		// 1) form 보낼 때 사용하는 코드 => String 사용 + @RequestParam
		// adminBiz.adminCourseDelete(c_no);

		// 2) json으로 보낼 때 사용하는 코드 => ModelAndView 사용 + @RequestBody
		ModelAndView mav = new ModelAndView("jsonView");
		// System.out.println(param);
		HashMap<String, Object> map = cmmService.jsonStringToHashMap(param);
		// System.out.println(map);
		int resultCode = 0;

		try {
			adminBiz.deleteCourse(Integer.valueOf(String.valueOf(map.get("c_no"))));
			mav.addObject("msg", "삭제 성공");
		} catch (Exception e) {
			resultCode = 1;
			e.printStackTrace();
		} finally {
			mav.addObject("resultCode", resultCode);
		}

		return mav;
	}

	@RequestMapping(value = "teacherList", method = RequestMethod.GET)
	public ModelAndView teacherList(Model model) {
		logger.info("admin Teacher List");
		ModelAndView mav = new ModelAndView();

		mav.setViewName("/admin/adminTeacherList");
		mav.addObject("msg", "teacherList");

		return mav;
	}

	@RequestMapping(value = "memberList")
	public ModelAndView memberList(Model model) {
		logger.info("admin Member List");
		ModelAndView mav = new ModelAndView();

		mav.setViewName("/admin/adminMemberList");
		mav.addObject("msg", "memberList");

		return mav;
	}

	@RequestMapping(value = "appList", method = RequestMethod.GET)
	public ModelAndView adminAppList(PageDto dto, @ModelAttribute("cri") Criteria cri) throws Exception {
		logger.info("admin Application List Controller");
		ModelAndView mav = new ModelAndView("jsonView");
		dto.setCri(cri);
		dto.setTotal(adminBiz.getAppTotal(dto.getKeyword()));

		List<Map<String, Object>> list = adminBiz.appList(dto, cri);
		mav.addObject("list", list);
		mav.addObject("dto", dto);
		mav.addObject("cri", cri);
		mav.setViewName("/admin/adminApplicationList");

		return mav;
	}

	@RequestMapping(value = "appDetail", method = RequestMethod.GET)
	public ModelAndView adminAppDetail(PageDto dto, @RequestParam("app_no") int app_no,
			@ModelAttribute("cri") Criteria cri) throws Exception {
		logger.info("admin App Detail");
		ModelAndView mav = new ModelAndView("jsonView");

		mav.addObject("dto", adminBiz.appDetail(app_no));
		mav.addObject("cri", cri);
		mav.setViewName("/admin/adminAppDetail");

		return mav;
	}
}
