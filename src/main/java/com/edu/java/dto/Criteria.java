package com.edu.java.dto;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
public class Criteria {
	private int page;			// 현재 페이지
	private int amount;			// 한 페이지 당 보여질 게시물 갯수 (perPageNum)
	private int skip;			// 스킵할 게시물 수 ( (pageNum -1) * amount )
	
	
	// 기본 생성자 => 기본 세팅 : pageNum = 1, amount = 10
	public Criteria() {
		this(1,10);
		this.skip = 0;
	}
	
	public void setPage(int page) {
		if(page <= 0) {
			this.page = 1;
			return;
		}
		this.page = page;
	}
	
	public void setAmout(int amount) {
		if(amount <= 0 || amount > 100) {
			this.amount = 10;
			return;
		}
		this.amount = amount;
	}
	
	// 생성자 => 원하는 pageNum, 원하는 amount
	public Criteria(int page, int amount) {
		this.page = page;
		this.amount = amount;
		this.skip = (page-1)*amount;
	}
	

	
}
