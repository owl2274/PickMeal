package com.itwill.dto;

import javax.validation.constraints.NotEmpty;

import org.springframework.web.multipart.MultipartFile;

public class Review {
	/*이름         널?       유형             
	---------- -------- -------------- 
	RE_NO      NOT NULL NUMBER(38)     
	RST_NO              NUMBER(4)      
	ID                  VARCHAR2(20)   
	NAME                VARCHAR2(20)   
	RE_SCORE            FLOAT(126)     
	RE_CONTENT          VARCHAR2(4000) 
	RE_IMG              VARCHAR2(200)  
	RE_DATE             DATE           
	RE_STATUS           NUMBER(1)      일반글:1 삭제글:0
	*/
	
	int reNo;
	int rstNo;
	String rstName;
	String id;
	String name;
	double reScore;
	String reContent;
	String reDate;
	int reStatus;
	
	private MultipartFile file;
	String origin;
	String reImg;
	int reCount;  //조인 컬럼
	
	public Review() {
		// TODO Auto-generated constructor stub
	}
	
	public int getReNo() {
		return reNo;
	}
	public void setReNo(int reNo) {
		this.reNo = reNo;
	}
	public int getRstNo() {
		return rstNo;
	}
	public void setRstNo(int rstNo) {
		this.rstNo = rstNo;
	}
	
	
	
	public String getRstName() {
		return rstName;
	}

	public void setRstName(String rstName) {
		this.rstName = rstName;
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
	public double getReScore() {
		return reScore;
	}
	public void setReScore(double reScore) {
		this.reScore = reScore;
	}
	public String getReContent() {
		return reContent;
	}
	public void setReContent(String reContent) {
		this.reContent = reContent;
	}
	public String getReImg() {
		return reImg;
	}
	public void setReImg(String reImg) {
		this.reImg = reImg;
	}
	public String getReDate() {
		return reDate;
	}
	public void setReDate(String reDate) {
		this.reDate = reDate;
	}
	public int getReStatus() {
		return reStatus;
	}
	public void setReStatus(int reStatus) {
		this.reStatus = reStatus;
	}
	
	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public int getReCount() {
		return reCount;
	}

	public void setReCount(int reCount) {
		this.reCount = reCount;
	}
	
	

/*	public String getUpload() {
		return upload;
	}

	public void setUpload(String upload) {
		this.upload = upload;
	}*/


	
	
}
