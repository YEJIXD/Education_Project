package com.edu.java.controller;

import java.util.Random;

import javax.inject.Inject;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.edu.java.biz.MemberBiz;
import com.edu.java.dto.EmailDto;
import com.edu.java.dto.MemberDto;

@Controller
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Inject
	MemberBiz memberBiz;
	
	@Autowired
	private JavaMailSender mailSender;
	
	// 회원가입
	@RequestMapping("/registForm.do")
	public String registForm() throws Exception {
		logger.info("regist Form page");
		return "/login/registForm.jsp";
	}
	
	@RequestMapping(value="/registRes.do", method=RequestMethod.POST)
	public String registRes(MemberDto dto) throws Exception{
		logger.info("regist Result");
		memberBiz.memberRegist(dto);
		
		return "../../index.jsp";
	}
	
	// id 중복 체크
	@ResponseBody
	@RequestMapping(value="/idCheck.do", method=RequestMethod.POST)
	public int idCheck(MemberDto dto) throws Exception{
		System.out.println("id_Check");
		int result = memberBiz.idCheck(dto);
		return result;
	}
	
	// 이메일 인증
	@ResponseBody
	@RequestMapping(value="/emailCheck.do", method=RequestMethod.GET)
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
}
