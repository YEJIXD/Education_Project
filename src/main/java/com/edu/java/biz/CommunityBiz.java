package com.edu.java.biz;

import java.util.List;

import com.edu.java.dto.FaqDto;
import com.edu.java.dto.NoticeDto;
import com.edu.java.dto.QnaDto;

public interface CommunityBiz {

/* 공 지 사 항 */
	public List<NoticeDto> noticeList();
	
/* Q N A */
	public List<QnaDto> qnaList();
	
/* F A Q */
	public List<FaqDto> faqList();
}
