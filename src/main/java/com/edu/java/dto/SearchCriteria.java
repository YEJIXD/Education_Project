package com.edu.java.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
public class SearchCriteria{
	private String searchType;		// 검색 타입
	private String keyword;			// 키워드
	
}
