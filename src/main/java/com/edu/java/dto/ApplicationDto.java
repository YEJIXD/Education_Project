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
	private int rnum;
	
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
}
