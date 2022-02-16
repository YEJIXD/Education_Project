package com.edu.java.dto;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class UserDto {
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
	
	public UserDto() {
		super();
	}
	
	public UserDto(int user_no, String user_id, String user_pw, String user_name, String user_email, String user_addr,
			String user_phone, String user_role, String user_enable, Date user_regdate, Date user_upd_date) {
		super();
		this.user_no = user_no;
		this.user_id = user_id;
		this.user_pw = user_pw;
		this.user_name = user_name;
		this.user_email = user_email;
		this.user_addr = user_addr;
		this.user_phone = user_phone;
		this.user_role = user_role;
		this.user_enable = user_enable;
		this.user_regdate = user_regdate;
		this.user_upd_date = user_upd_date;
	}
	
	public int getUser_no() {
		return user_no;
	}
	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_pw() {
		return user_pw;
	}
	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_addr() {
		return user_addr;
	}
	public void setUser_addr(String user_addr) {
		this.user_addr = user_addr;
	}
	public String getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	public String getUser_role() {
		return user_role;
	}
	public void setUser_role(String user_role) {
		this.user_role = user_role;
	}
	public String getUser_enable() {
		return user_enable;
	}
	public void setUser_enable(String user_enable) {
		this.user_enable = user_enable;
	}
	public Date getUser_regdate() {
		return user_regdate;
	}
	public void setUser_regdate(Date user_regdate) {
		this.user_regdate = user_regdate;
	}
	public Date getUser_upd_date() {
		return user_upd_date;
	}
	public void setUser_upd_date(Date user_upd_date) {
		this.user_upd_date = user_upd_date;
	}
	
	@Override
	public String toString() {
		return "UserDto [user_no=" + user_no +", user_id=" + user_id + ", user_pw=" + user_pw + ", user_name=" + user_name + ", user_email=" + user_email +", user_addr=" + user_addr 
				+ ", user_phone=" + user_phone + ", user_role=" + user_role + ", user_enable=" + user_enable+ ", user_regdate=" + user_regdate + ", user_upd_date=" + user_upd_date + "]";
	}
	
	
}
