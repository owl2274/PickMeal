package com.itwill.exception;

//�α��ν� ���̵� �Ǵ� ��й�ȣ�� �������� ��� ���ܸ� �߻��Ͽ� ó���ϴ� Ŭ����
//=> ���̵� �� �޼��� ����
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
