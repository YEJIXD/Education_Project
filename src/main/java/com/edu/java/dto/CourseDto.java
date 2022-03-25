package com.edu.java.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CourseDto {
	private int rnum;                   // 게시판 글 번호
	private int c_no;					// 교육 번호
	private int user_no;				// 사용자 번호
	private String c_name;				// 교육명
	private String c_category;			// 교육 과정 분류(일반 직무 - 인사행정)
	private String c_type;				// 교육 형태 (집합"G" / 온라인""O")
	private int c_time;					// 교육 시간 (8시간)
	private String c_start_time;		// 수업 시작 시간
	private String c_detail;			// 교육 상세 설명
	private int ent_personnel;			// 전체 모집 인원
	
	private String c_regdate;			// 교육 등록일
	private String c_upd_date;			// 교육 수정일
	private String c_init_writer;		// 교육 최초 등록자
	private String c_upd_writer;		// 교육 수정자
	private String c_start_date;		// 교육 시작일
	private String c_last_date;			// 교육 종료일
	private String c_count;				// 교육 조회수
	private String app_start_date;		// 교육 신청 _접수 시작일 
	private String app_last_date;		// 교육 신청 _접수 마감일
	private int app_personnel;			// 교육 신청 _ 신청 인원
	private String app_status;			// 접수 상태 _ 접수중 / 접수마감 / 신청완료
	private String c_tuition;				// 교육 수강료
}
