package com.itwill.dto;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;

//import org.apache.tomcat.util.buf.StringUtils;
/*이름             널?       유형             
-------------- -------- -------------- 
RST_NO         NOT NULL NUMBER(4)      
BUSINESS_NO    NOT NULL NUMBER         
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
LATITUDE                FLOAT(100)     
LONGITUDE               FLOAT(100)     
WEEKDAY_TIME            VARCHAR2(100)  
WEEKEND_TIME            VARCHAR2(100)  
FOOD_TYPE_MEMO          VARCHAR2(300)  
REGDATE                 DATE           
CHGDATE                 DATE           
*/
public class Restaurant {
	int rstNo;
	double businessNo;
	String rstName;
	String address1;
	String address2;
	String rstPhone;
	String id;
	String name;
	int areaNo;
	String city;   //join용 필드- admin
	String dong;   //join용 필드- admin
	String holiday;
	int foodTypeNo;
	String foodTypeName; //join용 필드- admin
	String budget;
	String mainImg;
	String detailImg;
	String tip;
	String detailText;
	String addInfo;
	int want;
	int seat;
	int rstStatus;
	double score;
	double latitude;
	double longitude;
	String openTime;
	String closeTime;
	String weekdayTime;
	String weekendTime;
	double reScore;
	
	
	public Restaurant() {
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
	public int getAreaNo() {
		return areaNo;
	}
	public void setAreaNo(int areaNo) {
		this.areaNo = areaNo;
	}
	
	//join용 필드
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDong() {
		return dong;
	}
	public void setDong(String dong) {
		this.dong = dong;
	}
	//여기까지
	
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
	//join용 필드
	public String getFoodTypeName() {
		return foodTypeName;
	}
	public void setFoodTypeName(String foodTypeName) {
		this.foodTypeName = foodTypeName;
	}
	//여기까지
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
	
	
	public List<String> transDetailImgForList() {
		return Arrays.asList(detailImg.split(":"));
	}
	public void transDetailImgForList(List<String> detailImg) {		
		this.detailImg = StringUtils.join(detailImg, ':');
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
	public String getOpenTime() {
		return openTime;
	}
	public void setOpenTime(String openTime) {
		this.openTime = openTime;
	}
	public String getCloseTime() {
		return closeTime;
	}
	public void setCloseTime(String closeTime) {
		this.closeTime = closeTime;
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



	public double getReScore() {
		return reScore;
	}



	public void setReScore(double reScore) {
		this.reScore = reScore;
	}

}
