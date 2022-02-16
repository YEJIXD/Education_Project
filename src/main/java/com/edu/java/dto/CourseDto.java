package com.edu.java.dto;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class CourseDto {
	private int c_no;					// 교육 번호
	private String c_name;				// 교육명
	private String c_division;			// 교육 과정 구분(ex.2022년도 1분기)
	private String c_addr;				// 교육 기관 장소
	private String c_classification;	// 교육 과정 분류(일반 직무 - 인사행정)
	private String c_type;				// 교육 형태 (집합"G" / 온라인""O")
	private Date c_time;					// 교육 시간 (8시간)
	private Date c_period;				// 교육 기간 
	private String c_detail;			// 교육 상세 설명
	private String ent_personnel;		// 전체 모집 인원
	private Date c_regdate;				// 교육 등록일
	private Date c_upd_date;			// 교육 수정일
	private String c_init_writer;		// 교육 최초 등록자
	private String c_upd_writer;		// 교육 수정자
	
	public CourseDto() {
		super();
	}
	
	public CourseDto(int c_no, String c_name, String c_division, String c_addr, String c_classification, String c_type,
			Date c_time, Date c_period, String c_detail, String ent_personnel, Date c_regdate, Date c_upd_date,
			String c_init_writer, String c_upd_writer) {
		super();
		this.c_no = c_no;
		this.c_name = c_name;
		this.c_division = c_division;
		this.c_addr = c_addr;
		this.c_classification = c_classification;
		this.c_type = c_type;
		this.c_time = c_time;
		this.c_period = c_period;
		this.c_detail = c_detail;
		this.ent_personnel = ent_personnel;
		this.c_regdate = c_regdate;
		this.c_upd_date = c_upd_date;
		this.c_init_writer = c_init_writer;
		this.c_upd_writer = c_upd_writer;
	}
	
	public int getC_no() {
		return c_no;
	}
	public void setC_no(int c_no) {
		this.c_no = c_no;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public String getC_division() {
		return c_division;
	}
	public void setC_division(String c_division) {
		this.c_division = c_division;
	}
	public String getC_addr() {
		return c_addr;
	}
	public void setC_addr(String c_addr) {
		this.c_addr = c_addr;
	}
	public String getC_classification() {
		return c_classification;
	}
	public void setC_classification(String c_classification) {
		this.c_classification = c_classification;
	}
	public String getC_type() {
		return c_type;
	}
	public void setC_type(String c_type) {
		this.c_type = c_type;
	}
	public Date getC_time() {
		return c_time;
	}
	public void setC_time(Date c_time) {
		this.c_time = c_time;
	}
	public Date getC_period() {
		return c_period;
	}
	public void setC_period(Date c_period) {
		this.c_period = c_period;
	}
	public String getC_detail() {
		return c_detail;
	}
	public void setC_detail(String c_detail) {
		this.c_detail = c_detail;
	}
	public String getEnt_personnel() {
		return ent_personnel;
	}
	public void setEnt_personnel(String ent_personnel) {
		this.ent_personnel = ent_personnel;
	}
	public Date getC_regdate() {
		return c_regdate;
	}
	public void setC_regdate(Date c_regdate) {
		this.c_regdate = c_regdate;
	}
	public Date getC_upd_date() {
		return c_upd_date;
	}
	public void setC_upd_date(Date c_upd_date) {
		this.c_upd_date = c_upd_date;
	}
	public String getC_init_writer() {
		return c_init_writer;
	}
	public void setC_init_writer(String c_init_writer) {
		this.c_init_writer = c_init_writer;
	}
	public String getC_upd_writer() {
		return c_upd_writer;
	}
	public void setC_upd_writer(String c_upd_writer) {
		this.c_upd_writer = c_upd_writer;
	}
	
	@Override
	public String toString() {
		return "CourseDto [c_no=" + c_no + ", c_name=" + c_name + ", c_division=" + c_division + ", c_addr=" + c_addr + ", c_classification=" + c_classification + ", c_type=" + c_type 
				+ ", c_time=" + c_time + ", c_period=" + c_period+ ", c_detail=" + c_detail+ ", ent_personnel=" + ent_personnel	+ ", c_regdate=" + c_regdate+ ", c_upd_date=" + c_upd_date
				+", c_init_writer=" + c_init_writer+", c_upd_writer=" + c_upd_writer+"]";
	}
	
	
}
