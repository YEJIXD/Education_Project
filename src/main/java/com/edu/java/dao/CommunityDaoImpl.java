package com.edu.java.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edu.java.dto.FaqDto;
import com.edu.java.dto.NoticeDto;
import com.edu.java.dto.QnaDto;

@Repository
public class CommunityDaoImpl implements CommunityDao{
	@Autowired
	private SqlSessionTemplate sqlSession;
	
/* 공 지 사 항 */
	/* List */
	@Override
	public List<NoticeDto> noticeList() throws Exception{
		List<NoticeDto> noticeList = new ArrayList<NoticeDto>();
		
		try {
			noticeList = sqlSession.selectList(NAMESPACE + "noticeList");
		} catch (Exception e) {
			System.out.println("[error] : notice list");
			e.printStackTrace();
		}
		return noticeList;
		
	}
	
	/* Select One(Detail Page) */
	
	/* Insert */
	
	/* Update */
	
/* Q N A */
	/* List */
	@Override
	public List<QnaDto> qnaList() throws Exception{
		List<QnaDto> qnaList = new ArrayList<QnaDto>();
		
		try {
			qnaList = sqlSession.selectList(NAMESPACE + "qnaList");
		} catch (Exception e) {
			System.out.println("[error] : qna list");
			e.printStackTrace();
		}
		return qnaList;
	}
	/* Insert */
	
	/* Update */
	
/* F A Q */
	/* List */
	@Override
	public List<FaqDto> faqList() throws Exception{
		List<FaqDto> faqList = new ArrayList<FaqDto>();
		
		try {
			faqList = sqlSession.selectList(NAMESPACE + "faqList");
		} catch (Exception e) {
			System.out.println("[error] : faq list");
			e.printStackTrace();
		}
		return faqList;
	}
	/* Insert */
	
	/* Update */
}
