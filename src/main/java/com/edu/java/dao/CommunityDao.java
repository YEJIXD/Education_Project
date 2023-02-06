package com.edu.java.dao;

import java.util.List;

import com.edu.java.dto.FaqDto;
import com.edu.java.dto.NoticeDto;
import com.edu.java.dto.QnaDto;
import com.mysql.cj.protocol.x.Notice;

public interface CommunityDao {
	String NAMESPACE = "community.";
	
	List<NoticeDto> noticeList();

	NoticeDto noticeDetail(int notice_seq);

	List<QnaDto> qnaList();
	
	List<FaqDto> faqList();
	
}
