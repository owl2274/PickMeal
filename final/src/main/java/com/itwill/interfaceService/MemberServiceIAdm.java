package com.itwill.interfaceService;

import java.util.List;
import java.util.Map;

import com.itwill.dto.Member;
import com.itwill.exception.AssociatedRestaurantExistException;

public interface MemberServiceIAdm {
	
	List<Member> getAllMember();
	Member getMemberById(String id);
	
	List<Member> getMemberList(Map<String, Object> map);
	int getTotalMember(Map<String, Object> map);
	
	void modifyMember(Member member);
	
	void removeMember(String[] chkedList) throws AssociatedRestaurantExistException;
	
	void removeMember(String id) throws AssociatedRestaurantExistException;
	
}
