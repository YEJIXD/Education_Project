package com.edu.java.dao;

import java.util.List;

import com.edu.java.dto.FaqDto;
import com.edu.java.dto.NoticeDto;
import com.edu.java.dto.QnaDto;

public interface CommunityDao {
	String NAMESPACE = "community.";
	
/* 공 지 사 항 */
	/* List */
	public List<NoticeDto> noticeList() throws Exception;
	/* Select One(Detail Page) */
	//public NoticeDto noticeSelectOne(int noti_no);
	/* Insert */
	
	/* Update */
	
/* Q N A */
	/* List */
	public List<QnaDto> qnaList() throws Exception;
	/* Insert */
	
	/* Update */
	
/* F A Q */
	/* List */
	public List<FaqDto> faqList() throws Exception;
	/* Insert */
	
	/* Update */
	
}
