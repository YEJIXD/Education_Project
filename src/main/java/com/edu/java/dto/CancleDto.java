package com.edu.java.dto;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class CancleDto {
	private int cancle_no;			// 수강 신청 취소 번호
	private String cancle_title;	// 수강 신청 취소_제목
	private String cancle_content;	// 수강 신청 취소_사유
	private Date cancle_regdate;	// 수강 신청 취소_등록일
	private Date cancle_upd_date;	// 수강 신청 취소_수정일
}
