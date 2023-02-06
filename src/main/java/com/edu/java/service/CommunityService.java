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
	
	public List<NoticeDto> noticeList(){
		return communityDao.noticeList();
	}

	public NoticeDto noticeDetail(int notice_seq) {
		return communityDao.noticeDetail(notice_seq);
	}
	
	public List<QnaDto> qna() {
		return communityDao.qnaList();
	}
	
	public List<FaqDto> faq() {
		return communityDao.faqList();
	}
}
