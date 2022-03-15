package com.edu.java.dto;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class MemberDto {
	private int user_no;		// 사용자 번호
	private String user_id;		// 사용자 아이디
	private String user_pw;		// 사용자 비밀번호
	private String user_name;	// 사용자 이름
	private String user_email;	// 사용자 이메일
	private String user_addr;	// 사용자 주소
	private String user_phone;	// 사용자 휴대전화번호
	private String user_role;	// 사용자 권한 (U:일반 / A:관리자)
	private String user_enable;	// 사용자 활성화(Y:활성화/N:비활성화)
	private Date user_regdate;	// 회원 가입일
	private Date user_upd_date;	// 회원 수정일
	
	/*
	 * // 비밀번호 확인 public boolean matchPwd(String user_pw) { return
	 * this.user_pw.equals(user_pw); }
	 */
	
}
