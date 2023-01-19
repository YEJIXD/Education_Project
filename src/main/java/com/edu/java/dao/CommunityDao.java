package com.edu.java.dao;

import java.util.List;

import com.edu.java.dto.FaqDto;
import com.edu.java.dto.NoticeDto;
import com.edu.java.dto.QnaDto;

public interface CommunityDao {
	String NAMESPACE = "community.";
	
	public List<NoticeDto> notice();
	
	public List<QnaDto> qna();
	
	public List<FaqDto> faq();
	
}
