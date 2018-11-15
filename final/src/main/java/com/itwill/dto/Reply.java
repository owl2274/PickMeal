package com.itwill.dto;

public class Reply {
	/*이름          널?       유형             
	----------- -------- -------------- 
	REP_NO      NOT NULL NUMBER(4)      
	RE_NO                NUMBER(4)      
	ID                   VARCHAR2(20)   
	NAME                 VARCHAR2(20)   
	REP_CONTENT          VARCHAR2(1000) 
	REP_DATE             DATE           
	REP_STATUS           NUMBER(1) 일반글:1 삭제글:0 */
	
	int repNo;
	int reNo;
	String id;
	String name;
	String repContent;
	String repDate;
	int repStatus;
	int rstNo;//조인
	
	public Reply() {
		// TODO Auto-generated constructor stub
	}

	public int getRepNo() {
		return repNo;
	}

	public void setRepNo(int repNo) {
		this.repNo = repNo;
	}

	public int getReNo() {
		return reNo;
	}

	public void setReNo(int reNo) {
		this.reNo = reNo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRepContent() {
		return repContent;
	}

	public void setRepContent(String repContent) {
		this.repContent = repContent;
	}

	public String getRepDate() {
		return repDate;
	}

	public void setRepDate(String repDate) {
		this.repDate = repDate;
	}

	public int getRepStatus() {
		return repStatus;
	}

	public void setRepStatus(int repStatus) {
		this.repStatus = repStatus;
	}

	public int getRstNo() {
		return rstNo;
	}

	public void setRstNo(int rstNo) {
		this.rstNo = rstNo;
	}
	
	
	
	
}
