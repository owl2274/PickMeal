package com.itwill.exception;

import com.itwill.dto.Member;

public class PasswordFindFailException extends Exception {

	private static final long serialVersionUID = 1L;
	private Member member;
	
	public PasswordFindFailException() {
		// TODO Auto-generated constructor stub
	}
	
	public PasswordFindFailException(Member member, String message) {
		super(message);
		this.member=member;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}
	
	

}
