package com.itwill.dto;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class RestaurantReg {
/*
이름             널?       유형             
-------------- -------- -------------- 
RST_NO         NOT NULL NUMBER(4)      
BUSINESS_NO    NOT NULL NUMBER(4)      
RST_NAME       NOT NULL VARCHAR2(50)   
ADDRESS1                VARCHAR2(50)   
ADDRESS2                VARCHAR2(100)  
RST_PHONE               VARCHAR2(20)   
ID             NOT NULL VARCHAR2(30)   
NAME                    VARCHAR2(20)   
AREANO         NOT NULL NUMBER(38)     
HOLIDAY                 VARCHAR2(200)  
FOOD_TYPE_NO   NOT NULL NUMBER         
BUDGET                  VARCHAR2(20)   
MAIN_IMG                VARCHAR2(50)   
DETAIL_IMG              VARCHAR2(500)  
TIP                     VARCHAR2(1000) 
DETAIL_TEXT             VARCHAR2(1000) 
ADD_INFO                VARCHAR2(1000) 
WANT                    NUMBER(4)      
SEAT                    NUMBER(2)      
RST_STATUS              NUMBER(1)      
SCORE          NOT NULL NUMBER(4,2)    
LATITUDE                NUMBER(8,6)    
LONGITUDE               NUMBER(8,6)    
WEEKDAY_TIME            DATE           
WEEKEND_TIME            DATE           
FOOD_TYPE_MEMO          VARCHAR2(300)

*/
	
	private int rstNo;
	private double businessNo;
	private String rstName;
	private String address1;
	private String address2;
	private String rstPhone;
	private String id;
	private String name;
	private int areano;
	private String holiday;
	private int foodTypeNo;
	private String budget;
	private String mainImg;
	private String detailImg;
	private String tip;
	private String detailText;
	private String addInfo;
	private int want;
	private int seat;
	private int rstStatus;
	private double score;
	private double latitude;
	private double longitude;
	private String weekdayTime;
	private String weekendTime;
	private String foodTypeMemo;
	
	private String areanm;
	private int cnt;
	private String regdate;
	private String chgdate;
	private String cityname;
	
	private MultipartFile file;
	private List<MultipartFile> files;
	
	public RestaurantReg() {
		// TODO Auto-generated constructor stub
	}

	public int getRstNo() {
		return rstNo;
	}

	public void setRstNo(int rstNo) {
		this.rstNo = rstNo;
	}

	public double getBusinessNo() {
		return businessNo;
	}

	public void setBusinessNo(double businessNo) {
		this.businessNo = businessNo;
	}

	public String getRstName() {
		return rstName;
	}

	public void setRstName(String rstName) {
		this.rstName = rstName;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getRstPhone() {
		return rstPhone;
	}

	public void setRstPhone(String rstPhone) {
		this.rstPhone = rstPhone;
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

	public int getAreano() {
		return areano;
	}

	public void setAreano(int areano) {
		this.areano = areano;
	}

	public String getHoliday() {
		return holiday;
	}

	public void setHoliday(String holiday) {
		this.holiday = holiday;
	}

	public int getFoodTypeNo() {
		return foodTypeNo;
	}

	public void setFoodTypeNo(int foodTypeNo) {
		this.foodTypeNo = foodTypeNo;
	}

	public String getBudget() {
		return budget;
	}

	public void setBudget(String budget) {
		this.budget = budget;
	}

	public String getMainImg() {
		return mainImg;
	}

	public void setMainImg(String mainImg) {
		this.mainImg = mainImg;
	}

	public String getDetailImg() {
		return detailImg;
	}

	public void setDetailImg(String detailImg) {
		this.detailImg = detailImg;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public String getDetailText() {
		return detailText;
	}

	public void setDetailText(String detailText) {
		this.detailText = detailText;
	}

	public String getAddInfo() {
		return addInfo;
	}

	public void setAddInfo(String addInfo) {
		this.addInfo = addInfo;
	}

	public int getWant() {
		return want;
	}

	public void setWant(int want) {
		this.want = want;
	}

	public int getSeat() {
		return seat;
	}

	public void setSeat(int seat) {
		this.seat = seat;
	}

	public int getRstStatus() {
		return rstStatus;
	}

	public void setRstStatus(int rstStatus) {
		this.rstStatus = rstStatus;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getWeekdayTime() {
		return weekdayTime;
	}

	public void setWeekdayTime(String weekdayTime) {
		this.weekdayTime = weekdayTime;
	}

	public String getWeekendTime() {
		return weekendTime;
	}

	public void setWeekendTime(String weekendTime) {
		this.weekendTime = weekendTime;
	}

	public String getFoodTypeMemo() {
		return foodTypeMemo;
	}

	public void setFoodTypeMemo(String foodTypeMemo) {
		this.foodTypeMemo = foodTypeMemo;
	}

	public String getAreanm() {
		return areanm;
	}

	public void setAreanm(String areanm) {
		this.areanm = areanm;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public String getRegdate() {
		if(regdate!=null) {
			regdate=regdate.substring(0, 10);
		}
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getChgdate() {
		if(chgdate!=null) {
			chgdate=chgdate.substring(0, 10);
		}
		return chgdate;
	}

	public void setChgdate(String chgdate) {
		this.chgdate = chgdate;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public List<MultipartFile> getFiles() {
		return files;
	}

	public void setFiles(List<MultipartFile> files) {
		this.files = files;
	}

	public String getCityname() {
		return cityname;
	}

	public void setCityname(String cityname) {
		this.cityname = cityname;
	}


}
