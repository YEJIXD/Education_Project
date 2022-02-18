package com.edu.java.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.edu.java.biz.UserBiz;
import com.edu.java.dto.UserDto;

@Controller
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Inject
	UserBiz userBiz;
	
	//@Autowired
	//private JavaMailSender mailSender;
	
	// 회원가입
	@RequestMapping("/registForm.do")
	public String registForm() {
		logger.info("regist Form page");
		return "/login/registForm.jsp";
	}
	
	// id 중복 체크
	@ResponseBody
	@RequestMapping(value="/idCheck.do", method=RequestMethod.POST)
	public int idCheck(UserDto dto) throws Exception{
		System.out.println("id_Check");
		System.out.println(dto);
		int result = userBiz.idCheck(dto);
		return result;
	}
	
	// 이메일 인증
	@ResponseBody
	@RequestMapping(value="/emailCheck.do", method=RequestMethod.GET)
	public String mailCheckGET(String user_email) throws Exception{
		// View에서 넘어온 Data 확인
		logger.info("email Data 전송 확인");
		logger.info("입력된 주소 : " + user_email);
		return "";
	}
}
