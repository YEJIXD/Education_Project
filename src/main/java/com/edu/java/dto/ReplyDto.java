package com.edu.java.dto;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Component
public class ReplyDto {
	
	private UserDto uDto;
	
	private int seq;		
	private String content;
	private String writer;
	private Date input_date;	
	private Date upd_date;	
}
