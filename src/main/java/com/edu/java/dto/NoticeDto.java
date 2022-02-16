package com.edu.java.dto;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class NoticeDto {
	private int noti_no;			// 공지사항_번호
	private String noti_title;		// 공지사항_제목
	private String noti_content;	// 공지사항_내용
	private Date noti_date;			// 공지사항_등록일
	private Date noti_upd_date;		// 공지사항_수정일
	private int noti_count;			// 공지사항_조회수
	
	public NoticeDto() {
		super();
	}
	
	public NoticeDto(int noti_no, String noti_title, String noti_content, Date noti_date, Date noti_upd_date,
			int noti_count) {
		super();
		this.noti_no = noti_no;
		this.noti_title = noti_title;
		this.noti_content = noti_content;
		this.noti_date = noti_date;
		this.noti_upd_date = noti_upd_date;
		this.noti_count = noti_count;
	}
	
	public int getNoti_no() {
		return noti_no;
	}
	public void setNoti_no(int noti_no) {
		this.noti_no = noti_no;
	}
	public String getNoti_title() {
		return noti_title;
	}
	public void setNoti_title(String noti_title) {
		this.noti_title = noti_title;
	}
	public String getNoti_content() {
		return noti_content;
	}
	public void setNoti_content(String noti_content) {
		this.noti_content = noti_content;
	}
	public Date getNoti_date() {
		return noti_date;
	}
	public void setNoti_date(Date noti_date) {
		this.noti_date = noti_date;
	}
	public Date getNoti_upd_date() {
		return noti_upd_date;
	}
	public void setNoti_upd_date(Date noti_upd_date) {
		this.noti_upd_date = noti_upd_date;
	}
	public int getNoti_count() {
		return noti_count;
	}
	public void setNoti_count(int noti_count) {
		this.noti_count = noti_count;
	}
	
	@Override
	public String toString() {
		return "NoticeDto [noti_no="+ noti_no+", noti_title="+noti_title+", noti_content="+noti_content+", noti_date="+noti_date+", noti_upd_date="+noti_upd_date+", noti_count="+noti_count+"]";
	}
	
	
}
