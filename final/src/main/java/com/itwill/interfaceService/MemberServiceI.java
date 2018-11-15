package com.itwill.interfaceService;

import java.util.List;
import java.util.Map;

import javax.security.auth.login.LoginException;

import com.itwill.dto.Member;
import com.itwill.exception.ExistNotMemberException;
import com.itwill.exception.ExistsMemberException;
import com.itwill.exception.LoginFailException;
import com.itwill.exception.MemberFindFailException;
import com.itwill.exception.MemberNotFoundException;
import com.itwill.exception.PasswordFindFailException;
import com.itwill.exception.passwordNotMatchException;

public interface MemberServiceI {
	void addMember(Member member) throws ExistsMemberException;
	//void addStoreMember(Member member)throws ExistsMemberException;
	void modifyLoginDate(String id);
//	void modifyMember(Member member)throws MemberNotFoundException;
	void modifyMember(Member member) throws ExistNotMemberException;
//	void modifyPassword(Member member)throws MemberNotFoundException;
	void modifyPassword(String id, String curPasswd, String newPasswd) throws ExistNotMemberException, passwordNotMatchException;
	void removeMember(String id)throws MemberNotFoundException;
	String searchId(Member member)throws MemberFindFailException;
	String searchPassword(Member member)throws PasswordFindFailException;
	Member getIdMember(String id)throws MemberNotFoundException;
	void login(Member member) throws LoginFailException;
	
	
	List<Member>getSearchMember(Map<String,Object> map);
	List<Member>getSearchStoreMember(Map<String,Object> map);
	List<Member>getAllMember();
	List<Member>getAllStoreMember();
	
}
