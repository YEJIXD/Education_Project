package com.edu.java.dto;

public class EmailDto {
	private String senderName;		// 발신인 이름
	private String senderMail;		// 발신인 이메일 주소
	private String receiveMail;		// 수신인 이메일 주소
	private String subject;			// 이메일 제목
	private String message;			// 이메일 내용
	
	public EmailDto() {
		super();
	}
	
	public EmailDto(String senderName, String senderMail, String receiveMail, String subject, String message) {
		super();
		this.senderName = senderName;
		this.senderMail = senderMail;
		this.receiveMail = receiveMail;
		this.subject = subject;
		this.message = message;
	}
	
	public String getSenderName() {
		return senderName;
	}
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	public String getSenderMail() {
		return senderMail;
	}
	public void setSenderMail(String senderMail) {
		this.senderMail = senderMail;
	}
	public String getReceiveMail() {
		return receiveMail;
	}
	public void setReceiveMail(String receiveMail) {
		this.receiveMail = receiveMail;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	@Override
	public String toString() {
		return "EmailDto [senderName=" + senderName + ", senderMail=" + senderMail + ", receiveMail=" + receiveMail + ", subject=" + subject + ", message" +message + "]";
	}
	
	
}
