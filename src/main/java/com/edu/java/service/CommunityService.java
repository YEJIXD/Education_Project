package com.edu.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.java.dao.CommunityDao;
import com.edu.java.dto.FaqDto;
import com.edu.java.dto.NoticeDto;
import com.edu.java.dto.QnaDto;

@Service
public class CommunityService {

	@Autowired
	CommunityDao communityDao;
	
	public List<NoticeDto> notice(){
		return communityDao.notice();
	}
	
	public List<QnaDto> qna() {
		return communityDao.qna();
	}
	
	public List<FaqDto> faq() {
		return communityDao.faq();
	}
}