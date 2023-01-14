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
	private int seq;			
	private int user_no;			
	private String title;		
	private String content;	
	private Date input_date;			
	private Date upd_date;		
}
