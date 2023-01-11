package com.edu.java.dto;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Component
@ToString
@Getter
@NoArgsConstructor
public class NoticeDto {
	private int noti_no;			
	private int user_no;			
	private String noti_title;		
	private String noti_content;	
	private Date noti_date;			
	private Date noti_upd_date;		
	private int noti_count;			
	private String img_path;		
}
