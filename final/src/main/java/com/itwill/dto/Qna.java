package com.itwill.dto;

public class Qna {
/*
이름      널?       유형             
------- -------- -------------- 
QNA_NO  NOT NULL NUMBER(10)     
FROMID
TOID   
TITLE   NOT NULL VARCHAR2(200)  
CONTENT          VARCHAR2(1000) 
IMG              VARCHAR2(200)  
REPLY            VARCHAR2(1000) 
REGID   NOT NULL VARCHAR2(20)   
REGDATE NOT NULL DATE           
REPID            VARCHAR2(20)   
REPDATE          DATE           
STATUS  NOT NULL NUMBER(1) 

REGNAME
REPNAME
*/
	
	private int qnaNo;
	private String fromid;
	private String toid;
	private String title;
	private String content;
	private String img;
	private String reply;
	private String regid;
	private String regdate;
	private String repid;
	private String repdate;
	private int status;
	private String regname;
	private String repname;
	private String resname;
	
	public Qna() {
		// TODO Auto-generated constructor stub
	}

	public int getQnaNo() {
		return qnaNo;
	}

	public void setQnaNo(int qnaNo) {
		this.qnaNo = qnaNo;
	}

	public String getFromid() {
		return fromid;
	}

	public void setFromid(String fromid) {
		this.fromid = fromid;
	}

	public String getToid() {
		return toid;
	}

	public void setToid(String toid) {
		this.toid = toid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
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

	public String getRepid() {
		return repid;
	}

	public void setRepid(String repid) {
		this.repid = repid;
	}

	public String getRepdate() {
		return repdate;
	}

	public void setRepdate(String repdate) {
		this.repdate = repdate;
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

	public String getRepname() {
		return repname;
	}

	public void setRepname(String repname) {
		this.repname = repname;
	}

	public String getResname() {
		return resname;
	}

	public void setResname(String resname) {
		this.resname = resname;
	}
}
