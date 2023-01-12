package com.edu.java.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.edu.java.CmmService;
import com.edu.java.biz.AdminBiz;
import com.edu.java.dto.CourseDto;
import com.edu.java.dto.Criteria;
import com.edu.java.dto.FaqDto;
import com.edu.java.dto.NoticeDto;
import com.edu.java.dto.PageDto;
import com.edu.java.dto.QnaDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class AdminController {

	@Inject
	AdminBiz adminBiz;

	@Autowired
	CmmService cmmService;

	@RequestMapping(value = "/adminMain", method = RequestMethod.GET)
	public ModelAndView adminMain(@RequestParam HashMap<String, Object> paramMap) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("main");

		return mav;
	}

	@RequestMapping(value = "/noticeList", method = RequestMethod.GET)
	public ModelAndView adminNoticeList() {
		ModelAndView mav = new ModelAndView();

		try {
			mav.setViewName("/admin/noticeList");
			mav.addObject("list", adminBiz.noticeList());
		} catch (Exception e) {
			log.debug("[ ERROR ] : notice List");
			e.printStackTrace();
		}
		return mav;
	}

	@RequestMapping(value = "/inputNotice", method = RequestMethod.GET)
	public ModelAndView adminNoticeInsert() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("inputNotice");
		
		return mav;
	}

	@RequestMapping(value="inputNoticeRes", method=RequestMethod.POST)
	public ModelAndView inputNoticeRes(NoticeDto dto, HttpServletRequest request) throws Exception{
		ModelAndView mav = new ModelAndView("jsonview");
		mav.addObject("noticeList", adminBiz.inputNotice(dto));
		
		return mav;
	}

	@RequestMapping("/modifyNotice")
	public ModelAndView modifyNotice() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("modifyNotice");
		
		return mav;
	}

	@RequestMapping(value = "/deleteNotice", method = RequestMethod.GET)
	public ModelAndView deleteNotice(Model model, HttpServletRequest httpServletRequest) {
		ModelAndView mav = new ModelAndView();
		
		String[] chk = httpServletRequest.getParameterValues("RowCheck[]");
		int chk_length = chk.length;

		for (int i = 0; i < chk_length; i++) {
			adminBiz.deleteNotice(Integer.parseInt(chk[i]));
		}
		mav.setViewName("noticeList");

		return mav;
	}

	@RequestMapping(value = "/faqList", method = RequestMethod.GET)
	public ModelAndView faqList() throws Exception {
		ModelAndView mav = new ModelAndView("jsonView");
		
		mav.setViewName("/admin/faqList");
		mav.addObject("list", adminBiz.faqList());

		return mav;
	}

	@RequestMapping(value = "/inputFaq", method = RequestMethod.GET)
	public ModelAndView inputFaq() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("inputFaq");
		
		return mav;
	}

	@RequestMapping(value = "/inputFaqRes", method = RequestMethod.POST)
	public ModelAndView inputFaqRes() throws Exception {
		ModelAndView mav = new ModelAndView("jsonview");

		mav.setViewName("/community/faq");
		mav.addObject("list", adminBiz.faqList());

		return mav;
	}

	@RequestMapping("/modifyFaq")
	public String modifyFaq() {
		log.info("[ modifyFaq ]");
		return "/admin/modifyFaq";
	}

	@RequestMapping("/modifyFaqRes")
	public String modifyFaqRes() {
		log.info("[ modify Faq Res ]");
		return "";
	}

	@RequestMapping(value = "/deleteFaq", method = RequestMethod.GET)
	public String deleteFaq(Model model, HttpServletRequest httpServletRequest) {

		String[] chk = httpServletRequest.getParameterValues("RowCheck[]");
		int chk_length = chk.length;

		for (int i = 0; i < chk_length; i++) {
			adminBiz.deleteFaq(Integer.parseInt(chk[i]));
		}

		return "redirect:/faqList";
	}

	@RequestMapping("/subMenu")
	public String subMenu(Model model, String faq_category) {
		log.info("subMenu");

		String str = "";

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
		ModelAndView mav = new ModelAndView();
		List<QnaDto> list = adminBiz.qnaList();

		mav.setViewName("/admin/adminQnaList");
		mav.addObject("list", list);

		return mav;
	}

	@RequestMapping(value = "courseList", method = RequestMethod.GET)
	public ModelAndView courseList(PageDto dto, @ModelAttribute("cri") Criteria cri) throws Exception {
		ModelAndView mav = new ModelAndView("jsonView");
		dto.setCri(cri); // page와 amount 설정
		dto.setTotal(adminBiz.getTotalCount(dto.getKeyword())); // 총 게시글 수 조회하는 로직 담기

		List<Map<String, Object>> list = adminBiz.courseList(dto, cri);
		mav.addObject("list", list);
		// endPage 숫자 다르게 나오는 것 아래처럼 객체에 담아 수정
		mav.addObject("dto", dto); // keyword 잘 담김
		// page와 amount 담아오기
		mav.addObject("cri", cri);
		mav.setViewName("/admin/courseList");

		return mav;
	}

	@RequestMapping(value = "courseDetail", method = RequestMethod.GET)
	public ModelAndView courseDetail(PageDto dto, @RequestParam("c_no") int c_no,
			@ModelAttribute("cri") Criteria cri) throws Exception {
		log.info("[ course Detail ]");
		ModelAndView mav = new ModelAndView("jsonView");

		mav.addObject("dto", adminBiz.courseDetail(c_no));
		mav.addObject("cri", cri);
		mav.setViewName("/admin/courseDetail");

		return mav;
	}

	@RequestMapping("/inputCourse")
	public String inputCourse() throws Exception {
		return "/admin/adminCourseInsert";
	}

	@RequestMapping(value = "/inputCourseRes", method = RequestMethod.POST)
	public ModelAndView inputCourseRes(@RequestBody CourseDto dto, HttpSession session) throws Exception {
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
			log.debug(e.getMessage());
			e.printStackTrace();
		} finally {
			mav.addObject("resultCode", resultCode);
		}
		mav.addObject("msg", "교육 등록 완료");

		return mav;
	}

	@RequestMapping(value = "/modifyCourse", method = RequestMethod.GET)
	public String modifyCourse(@RequestParam int c_no, Model model, @ModelAttribute("cri") Criteria cri) throws Exception {
		//CourseDto dto = adminBiz.courseDetail(c_no);
		
		model.addAttribute("dto", adminBiz.courseDetail(c_no));
		model.addAttribute("cri", cri); // page amount 값

		return "/admin/modifyCourse";
	}

	@RequestMapping(value = "modifyCourseRes", method = RequestMethod.POST)
	public ModelAndView modifyCourseRes(@RequestBody CourseDto dto, HttpSession session, @ModelAttribute("cri") Criteria cri) throws Exception {
		ModelAndView mav = new ModelAndView("jsonView");
		int resultCode = 0;

		try { /* 로그인 되어있는 상태에서만 수정할 수 있도록 작성 */
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
			log.debug(e.getMessage());
			e.printStackTrace();
		} finally {
			mav.addObject("resultCode", resultCode);
			mav.addObject("cri", cri);
		}
		mav.addObject("msg", "교육 수정 완료");

		return mav;
	}

	@RequestMapping(value = "/deleteCourse", method = RequestMethod.POST)
	public ModelAndView deleteCourse(@RequestBody String param) throws Exception {
		// 1) form 보낼 때 사용하는 코드 => String 사용 + @RequestParam
		// adminBiz.adminCourseDelete(c_no);

		// 2) json으로 보낼 때 사용하는 코드 => ModelAndView 사용 + @RequestBody
		ModelAndView mav = new ModelAndView("jsonView");
		HashMap<String, Object> map = cmmService.jsonStringToHashMap(param);
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
		ModelAndView mav = new ModelAndView();

		mav.setViewName("/admin/adminTeacherList");
		mav.addObject("msg", "teacherList");

		return mav;
	}

	@RequestMapping(value = "memberList")
	public ModelAndView memberList(Model model) {
		ModelAndView mav = new ModelAndView();

		mav.setViewName("/admin/adminMemberList");
		mav.addObject("msg", "memberList");

		return mav;
	}

	@RequestMapping(value = "appList", method = RequestMethod.GET)
	public ModelAndView appList(PageDto dto, @ModelAttribute("cri") Criteria cri) throws Exception {
		ModelAndView mav = new ModelAndView("jsonView");
		dto.setCri(cri);
		dto.setTotal(adminBiz.getAppTotal(dto.getKeyword()));

		List<Map<String, Object>> list = adminBiz.appList(dto, cri);
		mav.addObject("list", list);
		mav.addObject("dto", dto);
		mav.addObject("cri", cri);
		mav.setViewName("/admin/appList");

		return mav;
	}

	@RequestMapping(value = "appDetail", method = RequestMethod.GET)
	public ModelAndView appDetail(PageDto dto, @RequestParam("app_no") int app_no, @ModelAttribute("cri") Criteria cri) throws Exception {
		ModelAndView mav = new ModelAndView("jsonView");

		mav.addObject("dto", adminBiz.appDetail(app_no));
		mav.addObject("cri", cri);
		mav.setViewName("/admin/appDetail");

		return mav;
	}
}
