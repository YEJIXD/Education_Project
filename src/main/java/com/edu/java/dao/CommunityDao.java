package com.edu.java.dao;

import java.util.List;

import com.edu.java.dto.FaqDto;
import com.edu.java.dto.NoticeDto;
import com.edu.java.dto.QnaDto;

public interface CommunityDao {
	String NAMESPACE = "community.";
	
/* 공 지 사 항 */
	public List<NoticeDto> noticeList();
	//public NoticeDto noticeSelectOne(int noti_no);
	
/* Q N A */
	public List<QnaDto> qnaList();
	
/* F A Q */
	public List<FaqDto> faqList();
	
}
