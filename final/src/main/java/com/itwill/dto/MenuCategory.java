package com.itwill.dto;

public class MenuCategory {
/*
이름           널?       유형            
------------ -------- ------------- 
CATEGORYCODE NOT NULL NUMBER(10)    
RST_NO                NUMBER(4)     
CATEGORYNAME          VARCHAR2(500) 
*/
	
	private int categorycode;
	private int rstNo;
	private String categoryname;
	
	public MenuCategory() {
		// TODO Auto-generated constructor stub
	}

	public int getCategorycode() {
		return categorycode;
	}

	public void setCategorycode(int categorycode) {
		this.categorycode = categorycode;
	}

	public int getRstNo() {
		return rstNo;
	}

	public void setRstNo(int rstNo) {
		this.rstNo = rstNo;
	}

	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}
	
	
}
