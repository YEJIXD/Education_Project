package com.edu.java.dao;

import java.util.List;

import com.edu.java.dto.FaqDto;
import com.edu.java.dto.NoticeDto;
import com.edu.java.dto.QnaDto;

public interface CommunityDao {
	String NAMESPACE = "community.";
	
	List<NoticeDto> notice();
	
	List<QnaDto> qna();
	
	List<FaqDto> faq();
	
}
