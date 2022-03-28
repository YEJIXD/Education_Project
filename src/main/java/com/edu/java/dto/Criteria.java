package com.edu.java.dto;

import lombok.ToString;

@ToString
public class Criteria {			// 특정 페이지 조회를 위한 클래스 (게시글 조회 쿼리에 전달될 파라미터를 담게 될 클래스 -> VO라고 생각하면 쉽다)
	private int page;			// 현재 페이지
	private int amount;			// 한 페이지 당 보여질 게시물 갯수 (perPageNum)
	//private int skip;			// 스킵할 게시물 수 ( (page -1) * amount )
	private int pageStart;		// 특정 페이지의 게시글 시작 번호, 게시글 시작 행 번호
	
	// 기본 생성자 => 기본 세팅 : pageNum = 1, amount = 10
	public Criteria() {
		this(1,10);
		//this.skip = 0;
	}
	
	// 생성자 => 원하는 pageNum, 원하는 amount
	public Criteria(int page, int amount) {
		this.page = page;
		this.amount = amount;
		//this.skip = (page-1)*amount;
		this.pageStart = (this.page-1)*amount;
	}
	
	public int getPage() {
		return page;
	}
	
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
	
	public void setAmount(int pageCount) {
		int cnt = this.amount;
	    
		if(pageCount != cnt) {
	    	this.amount = cnt;
		} else {
	    	this.amount = pageCount;
		}
	}

//	public int getSkip() {
//		return skip;
//	}
//
//	public void setSkip(int skip) {
//		this.skip = skip;
//	}
	
	public int getPageStart() {
		return (this.page-1)*amount;
	}
	
	public void setPageStart(int pageStart) {
		this.pageStart = pageStart;
	}
}
