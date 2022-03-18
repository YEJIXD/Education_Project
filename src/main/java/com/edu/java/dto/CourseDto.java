package com.edu.java.dto;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class CourseDto {
	private int c_no;					// 교육 번호
	private int user_no;				// 사용자 번호
	private String c_name;				// 교육명
	private String c_addr;				// 교육 기관 장소
	private String c_addr_sub;			// 교육 기관 장소 _상세 주소
	private String c_category;			// 교육 과정 분류(일반 직무 - 인사행정)
	private String c_type;				// 교육 형태 (집합"G" / 온라인""O")
	private int c_time;					// 교육 시간 (8시간)
	private String c_start_time;		// 수업 시작 시간
	private String c_detail;			// 교육 상세 설명
	private int ent_personnel;			// 전체 모집 인원
	
	private Date c_regdate;				// 교육 등록일
	private Date c_upd_date;			// 교육 수정일
	private String c_init_writer;		// 교육 최초 등록자
	private String c_upd_writer;		// 교육 수정자
	private Date c_start_date;			// 교육 시작일
	private Date c_last_date;			// 교육 종료일
	private int c_count;				// 교육 조회수
	private Date app_start_date;		// 교육 신청 _접수 시작일 
	private Date app_last_date;			// 교육 신청 _접수 마감일
}
