package com.edu.java.dto;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class ReviewDto {
	private int r_no;					// 수강후기_번호
	private String r_title;				// 수강후기_제목
	private String r_content;			// 수강후기_내용
	private int r_star;					// 수강후기_별점
	private Date r_date;				// 수강후기_등록일
	private Date r_upd_date;			// 수강후기_수정일
	private String certificate_status;	// 수료증 발급 여부(발급완료"Y"/ 미발급"N")
	
}
