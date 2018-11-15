package com.itwill.exception;

import com.itwill.dto.Member;

//ȸ�����Խ� �ÿ��ڰ�(���̵�) �̹� ������ ��� ���ܸ� �߻��Ͽ� ó���ϴ� Ŭ����
//=> ȸ������ �� �޼��� ����
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
