package com.edu.java.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PageDto{
	// Search
	private String searchType;			// 검색 타입
	private String keyword = "";		// 키워드

	// Paging
	private Criteria cri;				// Criteria 객체 (현재 페이지, 페이지당 게시물 표시수 정보 => page(현재 페이지), amount 값을 얻기 위해 선언)
	private int startPage;				// 시작 페이지	
	private int endPage;				// 끝 페이지
	private boolean prev, next;			// 이전, 다음 페이지 유무
	private int total;					// 전체 게시글 수
	private int displayPageNum = 10;	// 화면 하단에 보여지는 페이지 버튼 수
	
	public PageDto() {
		super();
	}
	
	public PageDto(int startPage, int endPage, boolean prev, boolean next, String searchType, String keyword, int total,
			Criteria cri, int displayPageNum) {
		super();
		this.startPage = startPage;
		this.endPage = endPage;
		this.prev = prev;
		this.next = next;
		this.searchType = searchType;
		this.keyword = keyword;
		this.total = total;
		this.cri = cri;
		this.displayPageNum = displayPageNum;
	}
	
	public void setTotal(int total) { 
		this.total = total; 
		calcData();			// 총 게시글 수를 세팅할 때 calcData()메서드를 호출하여 페이징 관련 버튼을 계산함
	}
	
	// 게시글의 전체 갯수가 결정되면 calcData 메소드를 호출하여 계산 실행 => 페이징 버튼들을 생성하는 계산식 작성
	private void calcData() { 
		//끝 페이지 번호 = (현재 페이지 번호 / 화면에 보여질 페이지 번호의 갯수) * 화면에 보여질 페이지 번호의 갯수
		endPage = (int)(Math.ceil(cri.getPage() / (double) displayPageNum) * displayPageNum); 
		//endPage = (((cri.getPage()-1)/displayPageNum) +1) * displayPageNum;

		//시작 페이지 번호 = (끝 페이지 번호 - 화면에 보여질 페이지 번호의 갯수) + 1
		startPage = (endPage - displayPageNum) + 1; 
		
		//마지막 페이지 번호 = 총 게시글 수 / 한 페이지당 보여줄 게시글의 갯수
		int tempEndPage = (int)(Math.ceil(total / (double) cri.getAmount())); 
		
		if (endPage > tempEndPage) endPage = tempEndPage; 
		
		//이전 버튼 생성 여부 = 시작 페이지 번호 == 1 ? false : true
		prev = (startPage == 1 ? false : true); 
		
		//다음 버튼 생성 여부 = 끝 페이지 번호 * 한 페이지당 보여줄 게시글의 갯수 < 총 게시글의 수 ? true: false
		next = (endPage * cri.getAmount() >= total ? false : true); 
	}
	
	public PageDto(Criteria cri, int total) {
		this.cri = cri;
		this.total = total;
		
		// endPage는 page(현재 페이지), displayPageNum, total 세 가지 값에 의존
		this.endPage = (int)(Math.ceil(cri.getPage() / 10.0)) * 10;		// 49행에 작성한 코드랑 같은 코드
		
		this.startPage = this.endPage - 9;
		
		// 실제 끝 페이지
		int realEnd = (int)(Math.ceil((total * 1.0)) / cri.getAmount());
		
		// 실제 끝 페이지(realEnd)가 끝 페이지(endPage)보다 작으면 endPage를 realEnd페이지 값으로 변경 
		if(realEnd <= this.endPage) {
			this.endPage = realEnd;
		}
		
		// 시작 페이지가 1페이지보다 크면 prev가 true 
		//(prev는 currentPage로 구한 startPage가 1인 경우 false, 나머지 경우는 모두 true)
		this.prev = this.startPage > 1;
		// prev = (startPage == 1) ? false : true
		
		// 끝 페이지가 실제 끝페이지(realEnd)보다 작으면 next가 true 
		//(next는 currentPage로 구한 endPage가 total(모든 페이지 개수)인 경우 false, 나머지 경우는 모두 true)
		this.next = this.endPage < realEnd;
		//next = (endPage == total) ? false : true
		// => 즉, prev와 next 값은 startPage, endPage, totalPages에 의존
	}

}
