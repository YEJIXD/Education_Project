package com.edu.java.dto;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Component
public class CancleDto {
	private int seq;			
	private String title;	
	private String content;	
	private Date input_date;	
	private Date upd_date;
}
