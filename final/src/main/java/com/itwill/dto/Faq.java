package com.itwill.dto;

public class Faq {
/*
FAQ_NO  NOT NULL NUMBER(10)     
CONTENT NOT NULL VARCHAR2(1000) 
REPLY   NOT NULL VARCHAR2(1000) 
REGID   NOT NULL VARCHAR2(20)   
REGDATE NOT NULL DATE           
STATUS  NOT NULL NUMBER(1)      
*/
	private int faqNo;
	private String content;
	private String reply;
	private String regid; 
	private String regdate;
	private int status;
	
	private String regname;
	
	public Faq() {
		// TODO Auto-generated constructor stub
	}

	public int getFaqNo() {
		return faqNo;
	}

	public void setFaqNo(int faqNo) {
		this.faqNo = faqNo;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

	public String getRegid() {
		return regid;
	}

	public void setRegid(String regid) {
		this.regid = regid;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getRegname() {
		return regname;
	}

	public void setRegname(String regname) {
		this.regname = regname;
	}
	
	
}
