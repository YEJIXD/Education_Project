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
	
	@Override
	public List<NoticeDto> notice(){
		List<NoticeDto> notice = new ArrayList<>();
		
		try {
			notice = sqlSession.selectList(NAMESPACE + "notice");
		} catch (Exception e) {
			System.out.println("[error] : notice list");
			e.printStackTrace();
		}
		return notice;
		
	}
	
	@Override
	public List<QnaDto> qna(){
		List<QnaDto> qna = new ArrayList<>();
		
		try {
			qna = sqlSession.selectList(NAMESPACE + "qna");
		} catch (Exception e) {
			System.out.println("[error] : qna list");
			e.printStackTrace();
		}
		return qna;
	}
	
	@Override
	public List<FaqDto> faq(){
		List<FaqDto> faq = new ArrayList<>();
		
		try {
			faq = sqlSession.selectList(NAMESPACE + "faq");
		} catch (Exception e) {
			System.out.println("[error] : faq list");
			e.printStackTrace();
		}
		return faq;
	}
}
