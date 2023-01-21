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
	
	private int seq;
	private Date input_date;
	private String type;
	private String tuition;
	private String status;
	
	public ApplicationDto() {
		super();
	}
	
	public ApplicationDto(CourseDto cDto, MemberDto mDto, int seq, Date input_date, String type, String tuition, String status) {
		super();
		this.cDto = cDto;
		this.mDto = mDto;
		this.seq = seq;
		this.input_date = input_date;
		this.type = type;
		this.tuition = tuition;
		this.status = status;
	}
}
