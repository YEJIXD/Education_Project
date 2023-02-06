package com.edu.java.dao;

import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edu.java.dto.FaqDto;
import com.edu.java.dto.NoticeDto;
import com.edu.java.dto.QnaDto;

@Slf4j
@Repository
public class CommunityDaoImpl implements CommunityDao{

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<NoticeDto> noticeList(){
		List<NoticeDto> noticeList = new ArrayList<>();
		
		try {
			noticeList = sqlSession.selectList(NAMESPACE + "noticeList");
		} catch (Exception e) {
			System.out.println("[error] : notice list");
			e.printStackTrace();
		}
		return noticeList;
	}

	@Override
	public NoticeDto noticeDetail(int notice_seq) {
		NoticeDto selectOne = new NoticeDto();

		try {
			selectOne = sqlSession.selectOne(NAMESPACE + "noticeDetail");
		}catch (Exception e) {
			log.debug("[ Error ] notice Detail "+e.getMessage());
		}
		return selectOne;
	}

	@Override
	public List<QnaDto> qnaList(){
		List<QnaDto> qna = new ArrayList<>();
		
		try {
			qna = sqlSession.selectList(NAMESPACE + "qnaList");
		} catch (Exception e) {
			System.out.println("[error] : qna list");
			e.printStackTrace();
		}
		return qna;
	}
	
	@Override
	public List<FaqDto> faqList(){
		List<FaqDto> faq = new ArrayList<>();
		
		try {
			faq = sqlSession.selectList(NAMESPACE + "faqList");
		} catch (Exception e) {
			System.out.println("[error] : faq list");
			e.printStackTrace();
		}
		return faq;
	}
}
