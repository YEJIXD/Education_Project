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
	private Date input_date;		// 문의글 등록일
	private Date upd_date;	// 문의글 수정일
	private String q_status;	// 문의글 답변 여부(대기"W"/완료"F")
	private String q_public;		// 문의글 공개여부 (공개"Y"/비공개"N")
	
	private int q_re_no;		// 문의글 답변 번호
	private String q_re_title;	// 문의글 답변 제목
	private String q_re_content;// 문의글 답변 내용
	private Date q_re_date;		// 문의글 답변 등록일
	private Date q_re_upd_date;	// 문의글 답변 수정일
}
