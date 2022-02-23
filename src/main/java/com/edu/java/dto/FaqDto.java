package com.edu.java.dto;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class FaqDto {
	private int faq_no;				// 자주 묻는 질문_번호
	private String faq_title;		// 자주 묻는 질문_제목
	private String faq_content;		// 자주 묻는 질문_내용
	private Date faq_date;			// 자주 묻는 질문_등록일
	private Date faq_upd_date;		// 자주 묻는 질문_수정일
	private String faq_category;	// 자주 묻는 질문_분류 (전체 | 교육 | 비용 | 사이트 | 기타)
	
}
