package com.edu.java.dto;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@ToString
@Getter
@NoArgsConstructor
public class FaqDto {
	private int faq_seq;
	private int user_no;
	private String faq_title;
	private String faq_category;
	private String faq_content;
	private Date input_date;
	private Date faq_upd_date;
}
