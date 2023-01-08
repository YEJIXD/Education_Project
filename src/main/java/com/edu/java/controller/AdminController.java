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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.edu.java.CmmService;
import com.edu.java.biz.AdminBiz;
import com.edu.java.dto.CourseDto;
import com.edu.java.dto.Criteria;
import com.edu.java.dto.FaqDto;
import com.edu.java.dto.NoticeDto;
import com.edu.java.dto.PageDto;
import com.edu.java.dto.QnaDto;
import com.google.gson.JsonObject;

@Controller
public class AdminController {
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Inject
	AdminBiz adminBiz;
	
	@Autowired
	CmmService cmmService;
	
	/* 관리자 메인 */
	@RequestMapping("/adminMain")
	public String adminMain(Model model) {
		logger.info("admin Main");
		//model.addAttribute("newUserCount", adminBiz.newAdminUserCount());
		
		return "/admin/adminMain";
	}
	
	/* 공지사항 list */
	@RequestMapping(value="/adminNoticeList", method=RequestMethod.GET)
	public ModelAndView adminNoticeList() {
		logger.info("admin Notice List");
		ModelAndView mav = new ModelAndView();
		List<NoticeDto> list = null;
		
		try {
			list = adminBiz.adminNoticeList();
		} catch (Exception e) {
			System.out.println("admin Notice List error Controller");
			e.printStackTrace();
		}
		
		mav.setViewName("/admin/adminNoticeList");
		mav.addObject("list", list);
		
		return mav;
	}
	
	// admin_ Notice 등록 페이지
	@RequestMapping("/adminNoticeInsert")
	public String adminNoticeInsert() {
		logger.info("admin Notice Insert page");
		return "/admin/adminNoticeInsert";
	}
	
	/* 공지사항 Insert */
	@RequestMapping("adminNoticeInsertRes")
	public ModelAndView adminNotieInsertRes(MultipartFile uploadFile, NoticeDto dto, HttpServletRequest request) throws Exception{
		logger.info("admin Notice Insert Res");
		JsonObject jsonObject = new JsonObject();
		String path = request.getRealPath("resources/images/");
		//String path = request.getSession().getServletContext().getRealPath("resources/images/");
		System.out.println("path : "  + path);
		
		String fname = uploadFile.getOriginalFilename();
		System.out.println("fname : "+ fname);
		System.out.println("uploadFile : " + uploadFile);
		System.out.println("fname : " + fname);
		
		File saveFname = new File(path+fname);
		System.out.println("saveFile : " + saveFname);
		
		if(fname != null && !fname.equals("")) {
			try {
				byte[] data = uploadFile.getBytes();
				InputStream fis = uploadFile.getInputStream();
				FileUtils.copyInputStreamToFile(fis, saveFname);
				System.out.println("fis : "+fis);
				FileOutputStream fos = new FileOutputStream(path+"/"+fname);
				fos.write(data);
				fos.close();
			} catch (IOException e) {
				System.out.println("[error] : notice insert In Controller");
				e.printStackTrace();
			}
		}
		
		dto.setImg_path("resources/images/"+fname);
		int res = adminBiz.adminNoticeInsert(dto);
		System.out.println(dto);
		
		return new ModelAndView("redirect:/adminNoticeList");
	}
	
	// admin_ Notice 수정 페이지
		@RequestMapping("/adminNoticeUpdate")
		public String adminNoticeUpdate() {
			logger.info("admin Notice Update page");
			return "/admin/adminNoticeUpdate";
		}
	
	/* 공지사항 Update */
		
		
	/* 공지사항 Delete */
	@RequestMapping(value="/adminNoticeDelete", method=RequestMethod.GET)
	public String adminNoticeDelete(Model model, HttpServletRequest httpServletRequest){
		System.out.println("admin notice delete");
		String[] chk  = httpServletRequest.getParameterValues("RowCheck[]");
		System.out.println(chk);
		
		int chk_length = chk.length;
		System.out.println(chk_length);
			
		for(int i = 0; i < chk_length; i++) {
			System.out.println(chk[i]);
			adminBiz.adminNoticeDelete(Integer.parseInt(chk[i]));
		}
			
		return "redirect:/adminNoticeList";
	}
	
		
	// admin_ Faq List
	@RequestMapping(value="/adminFaqList", method=RequestMethod.GET)
	public ModelAndView adminFaqList() throws Exception {
		logger.info("admin Faq LIST PAGE");
			
		List<FaqDto> list = adminBiz.adminFaqList();
		ModelAndView mav = new ModelAndView("jsonView");
		mav.setViewName("/admin/adminFaqList");
		mav.addObject("list", list);
			
		return mav;
	}
	
	// admin_ Faq 등록 페이지
	@RequestMapping("/adminFaqInsert")
	public String adminFaqInsert() {
		logger.info("admin Faq Insert page");
		return "/admin/adminFaqInsert";
	}
		
	// admin_ Faq Insert Res
	@RequestMapping(value="/adminFaqInsertRes", method=RequestMethod.POST)
	public ModelAndView adminFaqInsertRes() throws Exception {
		logger.info("admin Faq Insert Result");
		List<FaqDto> list = adminBiz.adminFaqList();
		ModelAndView mav = new ModelAndView("jsonview");

		mav.setViewName("/community/faq");
		mav.addObject("list", list);
		
		return mav;
	}
			
	// admin_ Faq 수정 페이지
	@RequestMapping("/adminFaqUpdate")
	public String adminFaqUpdate() {
		logger.info("admin Faq Update page");
		return "/admin/adminFaqUpdate";
	}
			
	// admin_ Faq Update
	@RequestMapping("/adminFaqUpdateRes")
	public String adminFaqUpdateRes() {
		logger.info("Faq Update Result");
		return "";
	}
	
	/* admin_Faq Delete */
	@RequestMapping(value="/adminFaqDelete", method=RequestMethod.GET)
	public String adminFaqDelete(Model model, HttpServletRequest httpServletRequest){
		System.out.println("admin Faq delete");
			
		String[] chk  = httpServletRequest.getParameterValues("RowCheck[]");
		System.out.println(chk);
		
		int chk_length = chk.length;
		System.out.println(chk_length);
			
		for(int i = 0; i < chk_length; i++) {
			System.out.println(chk[i]);
			adminBiz.adminFaqDelete(Integer.parseInt(chk[i]));
		}
			
		return "redirect:/adminFaqList";
	}
	
	/* FAQ category select*/
	@RequestMapping("/subMenu")
	public String subMenu(Model model, String faq_category) {
		logger.info("subMenu");
		
		String str = "";
		String category = "";
		
		if(faq_category.equals("all")) {
			str = "전 체";
			
		}else if(faq_category.equals("education")) {
			str ="교 육";
			
		}else if(faq_category.equals("price")) {
			str = "비 용";
		}else if(faq_category.equals("site")) {
			str = "사이트";
		}else {
			str = "기 타";
		}
		
		model.addAttribute("faq_category", str);
		
		
		return "";
		
	}
	
	/* QnA List */
	@RequestMapping(value="adminQnaList", method=RequestMethod.GET)
	public ModelAndView adminQnaList(Model model) {
		logger.info("admin qna list");
		
		ModelAndView mav = new ModelAndView();
		List<QnaDto> list = adminBiz.adminQnaList();
		
		mav.setViewName("/admin/adminQnaList");
		mav.addObject("list", list);
		
		return mav;
	}
	
	/* QnA Insert */
	
	
	/* Course */
	/* Course List + Search + Paging */
	@RequestMapping(value="adminCourseList", method=RequestMethod.GET)
	public ModelAndView adminCourseList(PageDto dto, @ModelAttribute("cri") Criteria cri) throws Exception{
		logger.info("admin Course List");
		ModelAndView mav = new ModelAndView("jsonView");
		dto.setCri(cri);											// page와 amount 설정
		dto.setTotal(adminBiz.getTotal(dto.getKeyword()));			// 총 게시글 수 조회하는 로직 담기
		
		List<Map<String, Object>> list = adminBiz.adminCourseList(dto, cri);
		mav.addObject("list", list);
		// endPage 숫자 다르게 나오는 것 아래처럼 객체에 담아 수정
		mav.addObject("dto", dto);		
		// page와 amount 담아오기
		mav.addObject("cri", cri);
		mav.setViewName("/admin/adminCourseList");
		
		System.out.println("dto :: " + dto);
		
		return mav;
	}
	
	/* Course Detail */
	@RequestMapping(value="adminCourseDetail", method=RequestMethod.GET)
	public ModelAndView adminCourseDetail(PageDto dto, @RequestParam("c_no") int c_no, @ModelAttribute("cri") Criteria cri) throws Exception{
		logger.info("admin Course Detail");
		ModelAndView mav = new ModelAndView("jsonView");
		
		mav.addObject("dto", adminBiz.adminCourseDetail(c_no));
		//mav.addObject("dto", dto);
		mav.addObject("cri", cri);
		mav.setViewName("/admin/adminCourseDetail");
		
		return mav;
	}
	
	/* Course Insert Form */
	@RequestMapping("/adminCourseInsert")
	public String adminCourseInsert() throws Exception{
		logger.info("admin Course Insert Form");
		
		return "/admin/adminCourseInsert";
	}
	
	
	/* Course INSERT RES */
	@RequestMapping(value="/courseInsertRes", method=RequestMethod.POST)
	public ModelAndView adminCourseInsertRes(@RequestBody CourseDto dto, HttpSession session) throws Exception {
		logger.info("admin course insert Res");
		ModelAndView mav = new ModelAndView("jsonView");
		int resultCode = 0;	
			
		try {
			//if(검사 ==1) { throw new Userexception 코드 200 이유 : 검사값이 맞지않아 }
			HashMap<String, Object> user = (HashMap<String, Object>) session.getAttribute("USER");
			if(user == null) {
				resultCode = 10;
			}else {
				String UserName = String.valueOf(user.get("USER_NAME"));
				dto.setC_init_writer(UserName);
				adminBiz.adminCourseInsert(dto);
			}
		}catch (Exception e) {
			logger.trace(e.getMessage());
			e.printStackTrace();
		}finally {
			mav.addObject("resultCode", resultCode);
		}
		System.out.println(dto.toString());
		mav.addObject("msg", "교육 등록 완료");
		
		return mav;
	}
	
	/* Course Update Form */
	@RequestMapping(value="/adminCourseUpdate", method=RequestMethod.GET)
	public String adminCourseUpdate(@RequestParam int c_no, Model model, @ModelAttribute("cri") Criteria cri) throws Exception{
		logger.info("admin Course Update Form");
		CourseDto dto = adminBiz.adminCourseDetail(c_no);
		model.addAttribute("dto", dto);
		model.addAttribute("cri", cri);		// page amount 값
		
		return "/admin/adminCourseUpdate";
	}
	
	/* Course Update RES */
	@RequestMapping(value="courseUpdateRes", method=RequestMethod.POST)
	public ModelAndView adminCourseUpdateRes(@RequestBody CourseDto dto, HttpSession session, @ModelAttribute("cri") Criteria cri) throws Exception{
		logger.info("Admin Course Update Res");
		ModelAndView mav = new ModelAndView("jsonView");
		int resultCode = 0;
		
			try {																/* 로그인 되어있는 상태에서만 수정할 수 있도록 작성 */
				HashMap<String, Object> User = (HashMap<String, Object>) session.getAttribute("USER");
				if(User == null) {
					resultCode = 10;
				}else {
					String UserName = String.valueOf(User.get("USER_NAME"));	// String.valueOf 사용 -> User에서 USER_NAME 가져와서(get) UserName에 저장
					
					dto.setC_init_writer(UserName);								// CourseDto의 c_init_writer에 UserName 저장
					adminBiz.adminCourseUpdate(dto);							// adminBiz(Service단)에서 adminCourseUpdate() 메서드 실행
					mav.addObject("cri", cri);									// cri 객체로 page와 amount값 가지고 다니기
					
				}
			} catch (Exception e) {
				logger.trace(e.getMessage());
				e.printStackTrace();
			}finally {
				mav.addObject("resultCode", resultCode);
				mav.addObject("cri", cri);
			}
			System.out.println(dto.toString());
			mav.addObject("msg", "교육 수정 완료");
			
			return mav;
	}
	
	/* Course Delete */
	@RequestMapping(value="/adminCourseDelete", method=RequestMethod.POST)
	public ModelAndView adminCourseDelete(@RequestBody String param) throws Exception{
		logger.info("admin Course Delete");
		
		// 1) form 보낼 때 사용하는 코드 => String 사용  + @RequestParam
		//adminBiz.adminCourseDelete(c_no);
		
		// 2) json으로 보낼 때 사용하는 코드 => ModelAndView 사용 + @RequestBody
		ModelAndView mav = new ModelAndView("jsonView");
		System.out.println(param);
		HashMap <String , Object> map = cmmService.jsonStringToHashMap(param);
		System.out.println(map);
		int resultCode = 0; 
		
		try {
			adminBiz.adminCourseDelete(Integer.valueOf(String.valueOf(map.get("c_no"))));
			mav.addObject("msg", "삭제 성공");
		} catch (Exception e) {
			resultCode = 1;
			e.printStackTrace();
		}finally {
			mav.addObject("resultCode", resultCode);
		}
		
		return mav;
	}
	
	/* 수강 내역 관리 */
	
	
	/* 강사진 목록 */
	@RequestMapping(value="adminTeacherList", method=RequestMethod.GET)
	public ModelAndView adminTeacherList(Model model) {
		logger.info("admin Teacher List");
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("/admin/adminTeacherList");
		mav.addObject("msg", "teacherList");
		
		return mav;
	}
	
	/* 강사 Insert */
	
	/* 강사 Update */
	
	/* 회원 리스트 */
	@RequestMapping(value="adminMemberList")
	public ModelAndView adminMemberList(Model model) {
		logger.info("admin Member List");
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("/admin/adminMemberList");
		mav.addObject("msg", "memberList");
		
		return mav;
	}
	
}
