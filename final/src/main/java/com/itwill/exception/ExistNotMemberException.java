package com.itwill.exception;

import com.itwill.dto.Member;

public class ExistNotMemberException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public ExistNotMemberException() {
		// TODO Auto-generated constructor stub
	}
	
	public ExistNotMemberException(String message) {
		super(message);
	}

}
