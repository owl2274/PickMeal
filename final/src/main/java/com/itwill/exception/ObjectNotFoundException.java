package com.itwill.exception;

//수정 혹은 삭제 하고자 하는 객체가 존재하지 않을 때 발생하는 예외를 처리하는 클래스
public class ObjectNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public ObjectNotFoundException() {
		// TODO Auto-generated constructor stub
	}

	public ObjectNotFoundException(String message) {
		super(message);
	}

}
