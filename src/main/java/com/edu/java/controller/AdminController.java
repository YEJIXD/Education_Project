package com.edu.java.controller;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.edu.java.CmmService;
import com.edu.java.biz.AdminBiz;
import com.edu.java.dto.CourseDto;
import com.edu.java.dto.FaqDto;
import com.edu.java.dto.NoticeDto;
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
	@RequestMapping("/adminMain.do")
	public String adminMain(Model model) {
		logger.info("admin Main");
		//model.addAttribute("newUserCount", adminBiz.newAdminUserCount());
		
		return "/admin/adminMain";
	}
	
	/* 공지사항 list */
	@RequestMapping(value="/adminNoticeList.do", method=RequestMethod.GET)
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
	@RequestMapping("/adminNoticeInsert.do")
	public String adminNoticeInsert() {
		logger.info("admin Notice Insert page");
		return "/admin/adminNoticeInsert";
	}
	
	/* 공지사항 Insert */
	@RequestMapping("adminNoticeInsertRes.do")
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
		
		return new ModelAndView("redirect:/adminNoticeList.do");
	}
	
	
	// admin_ Notice 수정 페이지
		@RequestMapping("/adminNoticeUpdate.do")
		public String adminNoticeUpdate() {
			logger.info("admin Notice Update page");
			return "/admin/adminNoticeUpdate";
		}
	
	/* 공지사항 Update */
		
		
	/* 공지사항 Delete */
	@RequestMapping(value="/adminNoticeDelete.do", method=RequestMethod.GET)
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
			
		return "redirect:/adminNoticeList.do";
	}
	
		
	// admin_ Faq List
	@RequestMapping(value="/adminFaqList.do", method=RequestMethod.GET)
	public ModelAndView adminFaqList() throws Exception {
		logger.info("admin Faq LIST PAGE");
			
		List<FaqDto> list = adminBiz.adminFaqList();
		ModelAndView mav = new ModelAndView("jsonView");
		mav.setViewName("/admin/adminFaqList");
		mav.addObject("list", list);
			
		return mav;
	}
	
	// admin_ Faq 등록 페이지
	@RequestMapping("/adminFaqInsert.do")
	public String adminFaqInsert() {
		
		logger.info("admin Faq Insert page");
		return "/admin/adminFaqInsert";
	}
		
	// admin_ Faq Insert Res
	@RequestMapping(value="/adminFaqInsertRes.do", method=RequestMethod.POST)
	public ModelAndView adminFaqInsertRes() throws Exception {
		logger.info("admin Faq Insert Result");
		
		List<FaqDto> list = adminBiz.adminFaqList();
		
		ModelAndView mav = new ModelAndView("jsonview");
		mav.setViewName("/community/faq");
		mav.addObject("list", list);
		
		//System.out.println(dto.toString());
		//adminBiz.adminFaqInsert(dto);
		
		return mav;
	}
			
	// admin_ Faq 수정 페이지
	@RequestMapping("/adminFaqUpdate.do")
	public String adminFaqUpdate() {
		logger.info("admin Faq Update page");
		return "/admin/adminFaqUpdate";
	}
			
	// admin_ Faq Update
	@RequestMapping("/adminFaqUpdateRes.do")
	public String adminFaqUpdateRes() {
		logger.info("Faq Update Result");
		return "";
	}
	
	/* admin_Faq Delete */
	@RequestMapping(value="/adminFaqDelete.do", method=RequestMethod.GET)
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
			
		return "redirect:/adminFaqList.do";
	}
	
	/* FAQ category select*/
	@RequestMapping("/subMenu.do")
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
	@RequestMapping(value="adminQnaList.do", method=RequestMethod.GET)
	public ModelAndView adminQnaList(Model model) {
		logger.info("admin qna list");
		
		ModelAndView mav = new ModelAndView();
		List<QnaDto> list = adminBiz.adminQnaList();
		
		mav.setViewName("/admin/adminQnaList");
		mav.addObject("list", list);
		
		return mav;
	}
	
	/* QnA Insert */
	
	/* QnA Search */
	/*@RequestMapping(value="/searching.do", method=RequestMethod.POST)
	@ResponseBody
	public List<ProductDto> searchKeyword(@RequestBody String tagname) {
		logger.info("hashTagSearch, tagName : " + tagname);
		String hashTag = tagname.substring(1, tagname.length()-1);
		
		List<ProductDto> list = marketBiz.searchKeyword(hashTag);
		return list;
	}*/
	
	/* Course */
	/* 교육 목록 */
	@RequestMapping(value="adminCourseList.do", method=RequestMethod.GET)
	public ModelAndView adminCourseList() throws Exception{
		logger.info("admin Course List");
		ModelAndView mav = new ModelAndView();
		List<CourseDto> list = adminBiz.adminCourseList();
		
		mav.setViewName("/admin/adminCourseList");
		mav.addObject("list", list);
		
		return mav;
	}
	
	/* Course Detail */
	@RequestMapping(value="adminCourseDetail.do", method=RequestMethod.GET)
	public ModelAndView adminCourseDetail(@RequestParam("c_no") int c_no) throws Exception{
		logger.info("admin Course Detail");
		ModelAndView mav = new ModelAndView("jsonView");
		CourseDto dto = adminBiz.adminCourseDetail(c_no);

		// List에서 상세 페이지로 넘길 때 c_no 값 전달
		mav.addObject("dto", dto);
		//mav.addObject(adminBiz.adminCourseCount(c_count));
		mav.setViewName("/admin/adminCourseDetail");
		
		return mav;
	}
	
	/* Course Insert Form */
	@RequestMapping("/adminCourseInsert.do")
	public String adminCourseInsert() throws Exception{
		logger.info("admin Course Insert Form");
		
		return "/admin/adminCourseInsert";
	}
	
	
	/* Course INSERT RES */
	@RequestMapping(value="courseInsertRes.do", method=RequestMethod.POST)
	public ModelAndView adminCourseInsertRes(@RequestBody CourseDto dto, HttpSession session) throws Exception {
		logger.info("admin course insert Res");
		ModelAndView mav = new ModelAndView("jsonView");
		int resultCode = 0;	
			
		try {
			//if(검사 ==1) { throw new Userexception 코드 200 이유 : 검사값이 맞지않아 }
			HashMap<String, Object> User = (HashMap<String, Object>) session.getAttribute("USER");
			if(User == null) {
				resultCode = 10;
			}else {
				String UserName = String.valueOf(User.get("USER_NAME"));
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
	@RequestMapping(value="/adminCourseUpdate.do", method=RequestMethod.GET)
	public String adminCourseUpdate(@RequestParam int c_no, Model model) throws Exception{
		logger.info("admin Course Update Form");
		CourseDto dto = adminBiz.adminCourseDetail(c_no);
		model.addAttribute("dto", dto);
		
		return "/admin/adminCourseUpdate";
	}
	
	/* Course Update RES */
	@RequestMapping(value="courseUpdateRes.do", method=RequestMethod.POST)
	public ModelAndView adminCourseUpdateRes(@RequestBody CourseDto dto, HttpSession session) throws Exception{
		logger.info("admin course update Res");
		ModelAndView mav = new ModelAndView("jsonView");
		int resultCode = 0;
		
		/* 로그인 되어있는 상태에서만 수정할 수 있도록 작성 */
			try {
				HashMap<String, Object> User = (HashMap<String, Object>) session.getAttribute("USER");
				if(User == null) {
					resultCode = 10;
				}else {
					String UserName = String.valueOf(User.get("USER_NAME"));
					dto.setC_init_writer(UserName);
					adminBiz.adminCourseUpdate(dto);
				}
			} catch (Exception e) {
				logger.trace(e.getMessage());
				e.printStackTrace();
			}finally {
				mav.addObject("resultCode", resultCode);
			}
			System.out.println(dto.toString());
			mav.addObject("msg", "교육 수정 완료");
			
			return mav;
	}
	
	/* Course Delete */
	@RequestMapping(value="/adminCourseDelete.do", method=RequestMethod.GET)
	public String adminCourseDelete(int c_no) throws Exception{
		logger.info("admin Course Delete");
		adminBiz.adminCourseDelete(c_no);
		
		return "redirect:adminCourseList";
	}
	
	
	/* 강사진 목록 */
	@RequestMapping(value="adminTeacherList.do", method=RequestMethod.GET)
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
	@RequestMapping(value="adminMemberList.do")
	public ModelAndView adminMemberList(Model model) {
		logger.info("admin Member List");
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("/admin/adminMemberList");
		mav.addObject("msg", "memberList");
		
		return mav;
	}
	
}
