package com.edu.java.dto;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class TeacherDto {
	private int t_no;			// 강사_ 번호
	private String t_name;		// 강사_ 이름
	private String t_img;		// 강사_ 사진
	private String t_career;	// 강사_ 경력사항
	private String t_course;	// 강사_ 강의명
	private Date t_regdate;		// 강사_ 등록일
	private Date t_upd_date;	// 강사_ 수정일
}
