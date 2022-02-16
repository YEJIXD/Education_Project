package com.edu.java.dto;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class ReviewDto {
	private int r_no;					// 수강후기_번호
	private String r_title;				// 수강후기_제목
	private String r_content;			// 수강후기_내용
	private int r_star;					// 수강후기_별점
	private Date r_date;				// 수강후기_등록일
	private Date r_upd_date;			// 수강후기_수정일
	private String certificate_status;	// 수료증 발급 여부(발급완료"Y"/ 미발급"N")
	
	public ReviewDto() {
		super();
	}
	
	public ReviewDto(int r_no, String r_title, String r_content, int r_star, Date r_date, Date r_upd_date,
			String certificate_status) {
		super();
		this.r_no = r_no;
		this.r_title = r_title;
		this.r_content = r_content;
		this.r_star = r_star;
		this.r_date = r_date;
		this.r_upd_date = r_upd_date;
		this.certificate_status = certificate_status;
	}
	
	public int getR_no() {
		return r_no;
	}
	public void setR_no(int r_no) {
		this.r_no = r_no;
	}
	public String getR_title() {
		return r_title;
	}
	public void setR_title(String r_title) {
		this.r_title = r_title;
	}
	public String getR_content() {
		return r_content;
	}
	public void setR_content(String r_content) {
		this.r_content = r_content;
	}
	public int getR_star() {
		return r_star;
	}
	public void setR_star(int r_star) {
		this.r_star = r_star;
	}
	public Date getR_date() {
		return r_date;
	}
	public void setR_date(Date r_date) {
		this.r_date = r_date;
	}
	public Date getR_upd_date() {
		return r_upd_date;
	}
	public void setR_upd_date(Date r_upd_date) {
		this.r_upd_date = r_upd_date;
	}
	public String getCertificate_status() {
		return certificate_status;
	}
	public void setCertificate_status(String certificate_status) {
		this.certificate_status = certificate_status;
	}
	
	@Override
	public String toString() {
		return "ReviewDto [r_no="+r_no+", r_title="+r_title+", r_content="+r_content+", r_star="+r_star+", r_date="+r_date+", r_upd_date="+r_upd_date+", certificate_status="+certificate_status+"]";
	}
	
	
}
