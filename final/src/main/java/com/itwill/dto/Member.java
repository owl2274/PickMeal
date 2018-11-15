package com.itwill.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class Member {
	/*이름         널?       유형           
	---------- -------- ------------ 
	ID         NOT NULL VARCHAR2(30) 
	PASSWORD   NOT NULL VARCHAR2(20) 
	NAME       NOT NULL VARCHAR2(30) 
	PHONE      NOT NULL VARCHAR2(20) 
	EMAIL      NOT NULL VARCHAR2(50) 
	STATUS     NOT NULL NUMBER(1)    일반회원 1, 점포회원 2, 탈퇴회원 5,관리자 9  
	JOIN_DATE  NOT NULL DATE         
	LOGIN_DATE          DATE  */
	
	@Pattern(regexp="^[a-zA-Z]\\w{5,19}$", message="아이디를 형식에 맞게 입력 해 주세요.")
	private String id;
	@Pattern(regexp="^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[~!@#$%^&*_-]).{6,20}$",message="형식에맞는 비밀번호를 입력하세요")
	private String password;
	@NotEmpty(message="이름을 반드시 입력해 주세요.")
	private String name;
	//private Phone phone;
	@Pattern(regexp="^01([0|1|6|7|8|9]?)-?([0-9]{3,4})-?([0-9]{4})$",message="핸드폰 번호를 형식에 맞게 입력해 주세요.")
	private String phone;
	private String phone1;
	@Pattern(regexp="^\\d{3,4}$",message="핸드폰 번호를 형식에 맞게 입력해 주세요.")
	private String phone2;
	@Pattern(regexp="^\\d{4}$",message="핸드폰 번호를 형식에 맞게 입력해 주세요.")
	private String phone3;
	@NotEmpty(message="이메일을 반드시 입력해 주세요.")
	@Email(message="이메일을 형식에 맞게 입력해 주세요.")
	private String email;
	private int status;
	private String joinDate;
	private String loginDate;
	private String codeName;  //회원구분텍스트얻어오기위해추가한필드
	
	static private String passwordReg = "^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[~!@#$%^&*_-]).{6,20}$";
	public Member() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
/*	
	public Phone getPhone() {
		return phone;
	}
	
	public void setPhone(Phone phone) {
		this.phone = phone;
	}
*/	
	public void splitPhone() {
		String [] phones = phone.split("-");
		setPhone1(phones[0]);
		setPhone2(phones[1]);
		setPhone3(phones[2]);
	}
	public void combinePhone() {
		setPhone(getPhone1()+"-"+getPhone2()+"-"+getPhone3());
	}
	
	public String getPhone1() {
		return phone1;
	}
	
	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}
	
	public String getPhone2() {
		return phone2;
	}
	
	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}
	
	public String getPhone3() {
		return phone3;
	}
	
	public void setPhone3(String phone3) {
		this.phone3 = phone3;
	}
	
	
	
	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}

	public String getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(String loginDate) {
		this.loginDate = loginDate;
	}
	
	static public String regRexPassword() {
		return passwordReg;
	}

	public String getCodeName() {
		return codeName;
	}

	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}
	
	

}
