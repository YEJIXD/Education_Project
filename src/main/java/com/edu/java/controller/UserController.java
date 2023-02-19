package com.edu.java.controller;

import java.util.HashMap;
import java.util.Random;

import javax.inject.Inject;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import com.edu.java.dto.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.edu.java.CmmService;
import com.edu.java.mapper.UserMapper;

@Controller
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Inject
	UserMapper memberBiz;
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private CmmService cmmservice;
	
	@RequestMapping("/registForm")
	public String registForm() {
		return "/login/registForm";
	}
	
	@RequestMapping(value="/registRes", method=RequestMethod.POST)
	public ModelAndView registMember(UserDto dto) throws Exception{
		logger.info("regist Result");
		ModelAndView mav = new ModelAndView("jsonView");

		memberBiz.inputUser(dto);
		return new ModelAndView("../../index");
	}
	
	@ResponseBody
	@RequestMapping(value="/idCheck", method=RequestMethod.POST)
	public int idCheck(String user_id) throws Exception{
		return memberBiz.idCheck(user_id);
	}
	
	@ResponseBody
	@RequestMapping(value="/emailCheck", method=RequestMethod.GET)
	public String mailCheckGET(String user_email) throws Exception{
		// 뷰에서 넘어온 데이터 확인
		logger.info("이메일 데이터 전송 확인");
		logger.info("입력된 주소: " + user_email);
			
		// 인증번호 난수 생성(범위: 111111~999999)
		Random random = new Random();
		int checkNum = random.nextInt(888888) + 111111;
		logger.info("인증번호: " + checkNum);
				
		//이메일 보내기
	    String toMail = user_email;
	    String title = "[CUBe Academy] 회원가입 이메일 인증번호입니다.";
	    String content = "CUBe Academy에 방문해주셔서 감사합니다:)" +
		            	 "<br><br>" + 
		            	 "인증번호는 " + checkNum + " 입니다." + 
		            	 "<br>" + 
		            	 "해당 번호를 인증번호 확인란에 기입하여 주세요.";
	    
	    try {
	    	MimeMessage message = mailSender.createMimeMessage();
		    MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
		    
		    message.setFrom(new InternetAddress("CUBeAcademy@gmail.com", "CUBe"));
		    helper.setTo(toMail);
		    helper.setSubject(title);
		    helper.setText(content,true);
		    mailSender.send(message);
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }
	    String num = Integer.toString(checkNum);
	    return num;
	}
	
	@RequestMapping("/loginForm")
	public String login() {
		return "login/loginForm";
	}
	
	@ResponseBody
	@RequestMapping(value="/loginCheck", method=RequestMethod.POST)
	public ModelAndView loginCheck(@RequestBody String param ,HttpSession session) throws Exception {
		ModelAndView mav = new ModelAndView("jsonView");
		HashMap <String, Object> resultMap = memberBiz.loginCheck(cmmservice.jsonStringToHashMap(param));
		
		if(!resultMap.isEmpty()) {
			session.setAttribute("USER", resultMap);
		}
		mav.addObject("result", resultMap);

		return mav;
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public ModelAndView logout(HttpSession session) throws Exception {	
		ModelAndView mav = new ModelAndView();
		memberBiz.logout(session);

		mav.setViewName("../../index");
		mav.addObject("msg", "logout");
		
		return mav;
	}

	// login 필요한 페이지
	@RequestMapping("/needLogin.do")
	public String needLoginPage(HttpSession session) {
		if(session.getAttribute("loginCheck") != null) {
			return "needLogin";
		}else {
			return "login";
		}
	}
	
	@RequestMapping(value="/modifyUser", method=RequestMethod.POST)
	public String modifyUser(UserDto dto, HttpSession session) throws Exception{
		memberBiz.modifyUser(dto);
		session.invalidate();
			
		return "../../index"; 
	}
		  
	@RequestMapping(value="/deleteUser", method=RequestMethod.GET)
	public String deleteUser(UserDto dto, HttpSession session) throws Exception{
		memberBiz.deleteUser(dto);
		session.invalidate();
			
		return "../../index";
	}
}
