package com.edu.java.dto;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Component
public class UserDto {
	private int user_no;	
	private String user_id;		
	private String user_pw;		
	private String user_name;	
	private String email;	
	private String address;
	private String phone;
	private String user_role;	
	private String enable;	
	private Date reg_date;	
	private Date upd_date;

}
