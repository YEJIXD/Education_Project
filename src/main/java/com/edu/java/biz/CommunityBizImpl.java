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
	@Override
	public List<NoticeDto> noticeList(){
		return communityDao.noticeList();
	}
	
/* Q N A */
	@Override
	public List<QnaDto> qnaList(){
		return communityDao.qnaList();
	}
	
/* F A Q */
	@Override
	public List<FaqDto> faqList(){
		System.out.println("USER FAQ LIST");
		return communityDao.faqList();
	}
}
