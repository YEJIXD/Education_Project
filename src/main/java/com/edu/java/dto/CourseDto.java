package com.edu.java.dto;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
@Component
public class CourseDto {
	private int seq;					
	private int user_no;				
	private String title;				
	private String category;			
	private String type;			
	private int class_hour;	
	private String detail;
	private int ent_personnel;		
	private int app_personnel;
	private String start_date;
	private  String expire_date;
	private String start_time;		
	private String app_start_date;		 
	private String app_expire_date;	
	private String input_date;
	private String upd_date;
}
