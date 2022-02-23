package com.edu.java.dto;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class ApplicationDto {
	private int app_no;					// 수강 신청 번호
	private Date app_date;				// 교육 신청일
	private Date app_schedule;			// 교육 신청 기간
	private String app_type;			// 교육 신청 방법 (온"O"/오프라인"F")
	private String app_tuition;			// 교육 수강료
	private String app_status;			// 접수 상태 (접수 가능"O" / 접수 완료"F" / 접수 마감"F")
	private String app_cancle_title;	// 수강 신청 취소 사유_제목
	private String app_cancle_content;	// 수강 신청 취소 사유_내용
	private Date app_cancle_regdate;	// 수강 신청 취소 사유_등록일
	private Date app_cancle_upd_date;	// 수강 신청 취소 사유_수정일
}
