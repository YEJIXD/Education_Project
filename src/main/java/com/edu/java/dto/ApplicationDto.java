package com.edu.java.dto;

import java.util.Date;

import org.springframework.stereotype.Component;

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
	
	public ApplicationDto() {
		super();
	}
	
	public ApplicationDto(int app_no, Date app_date, Date app_schedule, String app_type, String app_tuition,
			String app_status, String app_cancle_title, String app_cancle_content, Date app_cancle_regdate,
			Date app_cancle_upd_date) {
		super();
		this.app_no = app_no;
		this.app_date = app_date;
		this.app_schedule = app_schedule;
		this.app_type = app_type;
		this.app_tuition = app_tuition;
		this.app_status = app_status;
		this.app_cancle_title = app_cancle_title;
		this.app_cancle_content = app_cancle_content;
		this.app_cancle_regdate = app_cancle_regdate;
		this.app_cancle_upd_date = app_cancle_upd_date;
	}
	
	public int getApp_no() {
		return app_no;
	}
	public void setApp_no(int app_no) {
		this.app_no = app_no;
	}
	public Date getApp_date() {
		return app_date;
	}
	public void setApp_date(Date app_date) {
		this.app_date = app_date;
	}
	public Date getApp_schedule() {
		return app_schedule;
	}
	public void setApp_schedule(Date app_schedule) {
		this.app_schedule = app_schedule;
	}
	public String getApp_type() {
		return app_type;
	}
	public void setApp_type(String app_type) {
		this.app_type = app_type;
	}
	public String getApp_tuition() {
		return app_tuition;
	}
	public void setApp_tuition(String app_tuition) {
		this.app_tuition = app_tuition;
	}
	public String getApp_status() {
		return app_status;
	}
	public void setApp_status(String app_status) {
		this.app_status = app_status;
	}
	public String getApp_cancle_title() {
		return app_cancle_title;
	}
	public void setApp_cancle_title(String app_cancle_title) {
		this.app_cancle_title = app_cancle_title;
	}
	public String getApp_cancle_content() {
		return app_cancle_content;
	}
	public void setApp_cancle_content(String app_cancle_content) {
		this.app_cancle_content = app_cancle_content;
	}
	public Date getApp_cancle_regdate() {
		return app_cancle_regdate;
	}
	public void setApp_cancle_regdate(Date app_cancle_regdate) {
		this.app_cancle_regdate = app_cancle_regdate;
	}
	public Date getApp_cancle_upd_date() {
		return app_cancle_upd_date;
	}
	public void setApp_cancle_upd_date(Date app_cancle_upd_date) {
		this.app_cancle_upd_date = app_cancle_upd_date;
	}
	
	@Override
	public String toString() {
		return "ApplicationDto [app_no="+ app_no + ", app_date="+app_date+", app_schedule="+app_schedule+", app_type="+app_type+", app_tuition="+app_tuition+", app_status="+app_status
				+", app_cancle_title="+app_cancle_title+", app_cancle_content="+app_cancle_content+", app_cancle_regdate="+app_cancle_regdate+", app_cancle_upd_date="+app_cancle_upd_date+"]";
	}
	
	
	
}
