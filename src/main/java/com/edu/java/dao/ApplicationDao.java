package com.edu.java.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.edu.java.dto.ApplicationDto;

@Mapper
public interface ApplicationDao {
	String NAMESPACE = "application.";
	
	List<ApplicationDto> courseList();
}
