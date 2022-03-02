package com.edu.java.controller;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.edu.java.biz.AdminBiz;
import com.edu.java.biz.MemberBiz;
import com.edu.java.dto.NoticeDto;

@Controller
public class AdminController {
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Inject
	AdminBiz adminBiz;
	
	/* 관리자 메인 */
	@RequestMapping("/adminMain.do")
	public String adminMain(Model model) {
		logger.info("admin Main");
		model.addAttribute("newUserCount", adminBiz.newAdminUserCount());
		
		return "/admin/adminMain";
	}
	
	/* 공지사항 list */
	@RequestMapping("/adminNoticeList.do")
	public ModelAndView adminNoticeList(Model model) {
		logger.info("admin Notice List");
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/admin/adminNotice");
		
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
	public String adminNotieInsertRes(MultipartFile uploadFile, NoticeDto dto, HttpServletRequest request) {
		logger.info("admin Notice Insert Res");
		
		//JsonObject jsonObject = new JsonObject();
		
		String path = request.getRealPath("resources/images/");
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
		dto.setImg_path("resources/images/admin/"+fname);
		int res = adminBiz.adminNoticeInsert(dto);
		
		System.out.println(dto);
		return "redirect:/adminNoticeList.do";
	}
	
	
	// admin_ Notice 수정 페이지
		@RequestMapping("/adminNoticeUpdate.do")
		public String adminNoticeUpdate() {
			logger.info("admin Notice Update page");
			return "/admin/adminNoticeUpdate";
		}
	
	/* 공지사항 Update */
	
		
	// admin_ Faq List
	@RequestMapping("/adminFaqList.do")
	public String adminFaqList() {
		logger.info("admin Faq List page");
		return "/admin/adminFaqList";
	}
	
	// admin_ Faq 등록 페이지
	@RequestMapping("/adminFaqInsert.do")
	public String adminFaqInsert() {
		logger.info("admin Faq Insert page");
		return "/admin/adminFaqInsert";
	}
		
	// admin_ Faq Insert
			
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
	
	/* QnA List */
	@RequestMapping(value="adminQnaList.do", method=RequestMethod.GET)
	public ModelAndView adminQnaList(Model model) {
		logger.info("admin qna list");
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("/admin/adminQnaList");
		mav.addObject("msg", "qna list");
		
		return mav;
	}
	
	/* QnA Insert */
	
	/* 교육 목록 */
	@RequestMapping(value="adminCourseList.do", method=RequestMethod.GET)
	public ModelAndView adminCourseList(Model model) {
		logger.info("admin Course List");
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("/admin/adminCourseList");
		mav.addObject("msg", "course List");
		
		return mav;
	}
	
	/* 수강 취소 목록 */
	@RequestMapping(value="adminCancleList.do", method=RequestMethod.GET)
	public ModelAndView adminCancleList(Model model) {
		logger.info("admin Cancle List");
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("/admin/adminCancleList");
		mav.addObject("msg", "cancleList");
		
		return mav;
	}
	
	/* 수강 후기 목록 */
	@RequestMapping(value="adminReviewList.do", method=RequestMethod.GET)
	public ModelAndView adminReviewList(Model model) {
		logger.info("admin Review list");
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("/admin/adminReviewList");
		mav.addObject("msg", "review list");
		
		return mav;
	}
}
