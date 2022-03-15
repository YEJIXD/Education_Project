package com.edu.java.biz;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.edu.java.dao.CommunityDao;
import com.edu.java.dto.FaqDto;
import com.edu.java.dto.NoticeDto;
import com.edu.java.dto.QnaDto;

@Service
public class CommunityBizImpl implements CommunityBiz{
	@Inject
	CommunityDao communityDao;
	
	
/* 공 지 사 항 */
	/* List */
	@Override
	public List<NoticeDto> noticeList() throws Exception{
		return communityDao.noticeList();
	}
	/* Select One(Detail Page) */
	
	/* Insert */
	
	/* Update */
	
/* Q N A */
	/* List */
	public List<QnaDto> qnaList() throws Exception{
		return communityDao.qnaList();
	}
	/* Insert */
	
	/* Update */
	
/* F A Q */
	/* List */
	public List<FaqDto> faqList() throws Exception{
		return communityDao.faqList();
	}
	/* Insert */
	
	/* Update */
}
