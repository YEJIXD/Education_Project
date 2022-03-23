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
	
	private Date app_date;				// 교육 신청일
	private String app_tuition;			// 교육 수강료
	private String app_status;			// 접수 상태 (접수 가능/ 접수 완료 / 접수 마감)
}
