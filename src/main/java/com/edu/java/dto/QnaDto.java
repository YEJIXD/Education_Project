package com.edu.java.dto;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class QnaDto {
	private int q_no;			// 문의글 번호
	private String q_title;		// 문의글 제목
	private String q_content;	// 문의글 내용
	private Date q_date;		// 문의글 등록일
	private Date q_upd_date;	// 문의글 수정일
	private String q_status;	// 문의글 답변 여부(대기"W"/완료"F"
	private int q_count;		// 문의글 조회수
	
}
