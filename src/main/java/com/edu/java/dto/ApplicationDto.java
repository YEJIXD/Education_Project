package com.edu.java.dto;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class ApplicationDto {
	private int app_no;					// 수강 신청 번호
	private int c_no;					// 교육 번호
	private int user_no;				// 사용자 번호
	private String user_name;			// 사용자 이름
	private String user_email;			// 사용자 이메일
	private String user_phone;			// 사용자 전화번호
	
	private Date app_date;				// 교육 신청일
}
