package com.itwill.exception;



//ȸ������ ����� �ÿ��ڰ�(���̵�) �̹� ������ ��� ���ܸ� �߻��Ͽ� ó���ϴ� Ŭ����
//=>�޼��� ����
public class MemberNotFoundException extends Exception{

	private static final long serialVersionUID = 1L;
	public MemberNotFoundException() {
		// TODO Auto-generated constructor stub
	}
	
	public MemberNotFoundException(String message) {
		super(message);
	}
	
	
	
}
