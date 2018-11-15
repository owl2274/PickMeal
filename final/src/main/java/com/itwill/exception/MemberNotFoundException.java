package com.itwill.exception;



//회원전보 변경시 시용자가(아이디) 이미 존재할 경우 예외를 발생하여 처리하는 클래스
//=>메세지 전달
public class MemberNotFoundException extends Exception{

	private static final long serialVersionUID = 1L;
	public MemberNotFoundException() {
		// TODO Auto-generated constructor stub
	}
	
	public MemberNotFoundException(String message) {
		super(message);
	}
	
	
	
}
