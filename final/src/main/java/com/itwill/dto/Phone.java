package com.itwill.dto;

import javax.validation.constraints.Pattern;

public class Phone {
	private String phone1;
	//@Pattern(regexp="^d{3,4}$",message="�ڵ��� ��ȣ�� ���Ŀ� �°� �Է��� �ּ���.")
	private String phone2;
	//@Pattern(regexp="^d{4}$",message="�ڵ��� ��ȣ�� ���Ŀ� �°� �Է��� �ּ���.")
	private String phone3;
	

	public Phone() {
		// TODO Auto-generated constructor stub
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
}
