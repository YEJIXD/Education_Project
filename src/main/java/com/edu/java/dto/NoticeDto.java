package com.edu.java.dto;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class NoticeDto {
	private int noti_no;			// 공지사항_번호
	private int user_no;			// 사용자 번호
	private String noti_title;		// 공지사항_제목
	private String noti_content;	// 공지사항_내용
	private Date noti_date;			// 공지사항_등록일
	private Date noti_upd_date;		// 공지사항_수정일
	private int noti_count;			// 공지사항_조회수
	private String img_path;		// 공지사항_이미지
}
