package com.itwill.dto;

public class Menu {
/*
이름           널?       유형            
------------ -------- ------------- 
CODE         NOT NULL NUMBER(10)    
RST_NO       NOT NULL NUMBER(4)     
NAME         NOT NULL VARCHAR2(500) 
CATEGORYCODE NOT NULL NUMBER(10)    
PRICE        NOT NULL VARCHAR2(30)  
MEMO                  VARCHAR2(300) 
*/
	
	private int code;
	private int rstNo;
	private String name;
	private int categorycode;
	private String price;
	private String memo;
	private int orderno;
	
	private String[] nameList;
	private int[] categorycodeList;
	private String[] priceList;
	private String[] memoList;
	private int[] ordernoList;
	
	public Menu() {
		// TODO Auto-generated constructor stub
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getRstNo() {
		return rstNo;
	}

	public void setRstNo(int rstNo) {
		this.rstNo = rstNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCategorycode() {
		return categorycode;
	}

	public void setCategorycode(int categorycode) {
		this.categorycode = categorycode;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public int getOrderno() {
		return orderno;
	}

	public void setOrderno(int orderno) {
		this.orderno = orderno;
	}

	public String[] getNameList() {
		return nameList;
	}

	public void setNameList(String[] nameList) {
		this.nameList = nameList;
	}

	public int[] getCategorycodeList() {
		return categorycodeList;
	}

	public void setCategorycodeList(int[] categorycodeList) {
		this.categorycodeList = categorycodeList;
	}

	public String[] getPriceList() {
		return priceList;
	}

	public void setPriceList(String[] priceList) {
		this.priceList = priceList;
	}

	public String[] getMemoList() {
		return memoList;
	}

	public void setMemoList(String[] memoList) {
		this.memoList = memoList;
	}

	public int[] getOrdernoList() {
		return ordernoList;
	}

	public void setOrdernoList(int[] ordernoList) {
		this.ordernoList = ordernoList;
	}



}
