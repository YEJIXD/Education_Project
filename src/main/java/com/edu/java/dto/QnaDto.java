package com.edu.java.dto;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class QnaDto {
	private int q_no;			// 문의글 번호
	private String q_title;		// 문의글 제목
	private String q_content;	// 문의글 내용
	private Date q_date;		// 문의글 등록일
	private Date q_upd_date;	// 문의글 수정일
	private String q_status;	// 문의글 답변 여부(대기"W"/완료"F"
	private int q_count;		// 문의글 조회수
	
	public QnaDto() {
		super();
	}
	
	public QnaDto(int q_no, String q_title, String q_content, Date q_date, Date q_upd_date, String q_status,
			int q_count) {
		super();
		this.q_no = q_no;
		this.q_title = q_title;
		this.q_content = q_content;
		this.q_date = q_date;
		this.q_upd_date = q_upd_date;
		this.q_status = q_status;
		this.q_count = q_count;
	}
	
	public int getQ_no() {
		return q_no;
	}
	public void setQ_no(int q_no) {
		this.q_no = q_no;
	}
	public String getQ_title() {
		return q_title;
	}
	public void setQ_title(String q_title) {
		this.q_title = q_title;
	}
	public String getQ_content() {
		return q_content;
	}
	public void setQ_content(String q_content) {
		this.q_content = q_content;
	}
	public Date getQ_date() {
		return q_date;
	}
	public void setQ_date(Date q_date) {
		this.q_date = q_date;
	}
	public Date getQ_upd_date() {
		return q_upd_date;
	}
	public void setQ_upd_date(Date q_upd_date) {
		this.q_upd_date = q_upd_date;
	}
	public String getQ_status() {
		return q_status;
	}
	public void setQ_status(String q_status) {
		this.q_status = q_status;
	}
	public int getQ_count() {
		return q_count;
	}
	public void setQ_count(int q_count) {
		this.q_count = q_count;
	}
	
	@Override
	public String toString() {
		return "QnaDto [q_no="+q_no+", q_title="+q_title+", q_content="+q_content+", q_date="+q_date+", q_upd_date="+q_upd_date+", q_status="+q_status+", q_count="+q_count+"]";
	}
	
	
}
