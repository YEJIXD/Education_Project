package com.edu.java.dto;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class QnaDto {
	private int q_no;			
	private String q_title;		
	private String q_content;	
	private Date input_date;	
	private Date upd_date;	
	private String q_status;
	private String q_public;
}
