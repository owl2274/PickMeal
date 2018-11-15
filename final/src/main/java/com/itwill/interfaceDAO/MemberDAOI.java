package com.itwill.interfaceDAO;

import java.util.List;
import java.util.Map;

import com.itwill.dto.Member;

public interface MemberDAOI {
	int addMember(Member member);
	//int addStoreMember(Member member);
	int modifyLoginDate(String id);
	int modifyMember(Member member);
	int modifyPassword(Member member);
	int removeMember(String id);
	Member searchId(Member member);
	Member searchPassword(Member member);
	Member getIdMember(String id);
	List<Member>getSearchMember(Map<String,Object> map);
	List<Member>getSearchStoreMember(Map<String,Object> map);
	List<Member> getAllMember();
	List<Member> getAllStoreMember();
}
