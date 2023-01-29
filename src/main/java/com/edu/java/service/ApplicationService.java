package com.edu.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.java.dao.ApplicationDao;
import com.edu.java.dto.ApplicationDto;

@Service
public class ApplicationService {

	@Autowired
	ApplicationDao applicationDao;
	
	public List<ApplicationDto> getCourse(){
		return applicationDao.getCourse();
	}
}
