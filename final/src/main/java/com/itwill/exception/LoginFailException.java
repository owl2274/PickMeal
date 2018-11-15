package com.itwill.exception;

//로그인시 아이디 또는 비밀번호가 맞지않을 경우 예외를 발생하여 처리하는 클래스
//=> 아이디 및 메세지 전달
public class LoginFailException extends Exception{

	private static final long serialVersionUID = 1L;
	private String id;
	public LoginFailException() {
		// TODO Auto-generated constructor stub
	}
	
	public LoginFailException(String id,String message) {
		super(message);
		this.id=id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	

}
