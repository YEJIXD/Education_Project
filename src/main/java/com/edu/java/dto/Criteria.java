package com.edu.java.dto;

import lombok.ToString;

@ToString
public class Criteria {
	private int page;			// 현재 페이지
	private int amount;			// 한 페이지 당 보여질 게시물 갯수 (perPageNum)
	private int skip;			// 스킵할 게시물 수 ( (page -1) * amount )
	
	
	// 기본 생성자 => 기본 세팅 : pageNum = 1, amount = 10
	public Criteria() {
		this(1,10);
		this.skip = 0;
	}
	
	// 생성자 => 원하는 pageNum, 원하는 amount
	public Criteria(int page, int amount) {
		this.page = page;
		this.amount = amount;
		this.skip = (page-1)*amount;
	}
	
	public int getPage() {
		return page;
	}

//	public void setPage(int page) {
//		this.skip= (page-1)*this.amount;
//		this.page = page;
//	}
	
	public void setPage(int page) { 
		if(page <= 0) { 		// 페이지가 음수 값이 되지 않도록 설정 => 음수 값이 되면 1페이지를 나타낸다.
			this.page = 1; 
			return; 
	 	}
	 		this.page = page; 	
	 	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.skip= (this.page-1)*amount;
		this.amount = amount;
	}
	
	/*
	 * public void setPerPageNum(int pageCount) {
	        int cnt = this.perPageNum;
	        if(pageCount != cnt) {
	            this.perPageNum = cnt;
	        } else {
	            this.perPageNum = pageCount;
	        }
    	}
	 * */

	public int getSkip() {
		return skip;
	}

	public void setSkip(int skip) {
		this.skip = skip;
	}
	
	/*
	 * public void setAmount(int amount) { if(amount <= 0 || amount > 100) {
	 * this.amount = 10; return; } this.amount = amount; }
	 */
	
}
