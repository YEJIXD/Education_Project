package com.edu.java.biz;

import java.util.List;

import com.edu.java.dto.FaqDto;
import com.edu.java.dto.NoticeDto;
import com.edu.java.dto.QnaDto;

public interface CommunityBiz {

/* 공 지 사 항 */
	/* List */
	public List<NoticeDto> noticeList() throws Exception;
	/* Select One(Detail Page) */
	
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
