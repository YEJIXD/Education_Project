package com.edu.java.dto;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class FaqDto {
	private int faq_no;				// 자주 묻는 질문_번호
	private String faq_title;		// 자주 묻는 질문_제목
	private String faq_content;		// 자주 묻는 질문_내용
	private Date faq_date;			// 자주 묻는 질문_등록일
	private Date faq_upd_date;		// 자주 묻는 질문_수정일
	private String faq_category;	// 자주 묻는 질문_분류 (전체 | 교육 | 비용 | 사이트 | 기타)
	
	public FaqDto() {
		super();
	}
	
	public FaqDto(int faq_no, String faq_title, String faq_content, Date faq_date, Date faq_upd_date,
			String faq_category) {
		super();
		this.faq_no = faq_no;
		this.faq_title = faq_title;
		this.faq_content = faq_content;
		this.faq_date = faq_date;
		this.faq_upd_date = faq_upd_date;
		this.faq_category = faq_category;
	}
	
	public int getFaq_no() {
		return faq_no;
	}
	public void setFaq_no(int faq_no) {
		this.faq_no = faq_no;
	}
	public String getFaq_title() {
		return faq_title;
	}
	public void setFaq_title(String faq_title) {
		this.faq_title = faq_title;
	}
	public String getFaq_content() {
		return faq_content;
	}
	public void setFaq_content(String faq_content) {
		this.faq_content = faq_content;
	}
	public Date getFaq_date() {
		return faq_date;
	}
	public void setFaq_date(Date faq_date) {
		this.faq_date = faq_date;
	}
	public Date getFaq_upd_date() {
		return faq_upd_date;
	}
	public void setFaq_upd_date(Date faq_upd_date) {
		this.faq_upd_date = faq_upd_date;
	}
	public String getFaq_category() {
		return faq_category;
	}
	public void setFaq_category(String faq_category) {
		this.faq_category = faq_category;
	}
	
	@Override
	public String toString() {
		return "FaqDto [faq_no="+faq_no+", faq_title="+faq_title+", faq_content="+faq_content+", faq_date="+faq_date+", faq_upd_date="+faq_upd_date+", faq_category="+faq_category+"]";
	}
	
	
}
