package com.edu.java.dto;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ApplicationDto {
	private CourseDto cDto;
	private MemberDto mDto;
	
	private int app_no;					// 수강 신청 번호
	private Date app_date;				// 교육 신청일
	
	public ApplicationDto() {
		super();
	}
	
	public ApplicationDto(CourseDto cDto, MemberDto mDto, int app_no, Date app_date) {
		super();
		this.cDto = cDto;
		this.mDto = mDto;
		this.app_no = app_no;
		this.app_date = app_date;
	}

//	private int user_no;				// 사용자 번호
//	private String user_name;			// 사용자 이름
//	private String user_email;			// 사용자 이메일
//	private String user_phone;			// 사용자 전화번호
//	
//	private int c_no;					// 교육 번호
//	private String c_name;				// 교육명
//	private String c_category;			// 교육 과정 분류(경영/경제/심리/취미/의료/기타)
//	private String c_type;				// 교육 형태 (집합 / 온라인)
//	private int c_time;					// 교육 시간 (ex.8시간)
//	private String c_start_time;		// 수업 시작 시간
//	private String c_detail;			// 교육 상세 설명
//	private String c_start_date;		// 교육 시작일
//	private String c_last_date;			// 교육 종료일
//	private String c_tuition;			// 수강료
	
}
