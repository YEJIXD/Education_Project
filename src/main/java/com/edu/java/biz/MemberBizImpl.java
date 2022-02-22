package com.edu.java.biz;

import javax.inject.Inject;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.servlet.http.HttpSession;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.edu.java.dao.MemberDao;
import com.edu.java.dto.EmailDto;
import com.edu.java.dto.MemberDto;

@Service
public class MemberBizImpl implements MemberBiz{
	@Inject
	MemberDao memberDao;
	JavaMailSender mailSender;
	
	// 로그인
	@Override
	public MemberDto loginCheck(MemberDto dto, HttpSession session) throws Exception{
		return memberDao.loginCheck(dto);
	}

	// 로그아웃 
	@Override
	public void logout(HttpSession session) {
		session.invalidate();
	}

	// id 중복체크
	@Override
	public int idCheck(String user_id) throws Exception {
		return memberDao.idCheck(user_id);
	}

	// 회원가입
	@Override
	public void memberRegist(MemberDto dto) throws Exception {
		memberDao.memberRegist(dto);
	}

	// 회원정보 수정
	@Override
	public void memberUpdate(MemberDto dto) throws Exception {
		memberDao.memberUpdate(dto);
	}

	// 회원 비활성화
	@Override
	public void memberDelete(MemberDto dto) throws Exception {
		memberDao.memberDelete(dto);
	}

}