package com.itwill.exception;

import com.itwill.dto.Member;

//회원가입시 시용자가(아이디) 이미 존재할 경우 예외를 발생하여 처리하는 클래스
//=> 회원정보 및 메세지 전달
public class ExistsMemberException extends Exception{

	private static final long serialVersionUID = 1L;
	private Member member;
	
	public ExistsMemberException() {
		// TODO Auto-generated constructor stub
	}
	
	public ExistsMemberException(Member member,String message) {
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
