package com.edu.java.dto;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Component
@ToString
@Getter
@NoArgsConstructor
public class NoticeDto {
	private int notice_seq;
	private int user_no;			
	private String notice_title;
	private String notice_content;
	private Date input_date;			
	private Date upd_date;		
}
