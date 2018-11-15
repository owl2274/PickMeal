package com.itwill.interfaceDAO;

import java.util.List;
import java.util.Map;

import com.itwill.dto.Member;

public interface MemberDAOIAdm {
	List<Member> getAllMember();
	Member selectMemberById(String id);
	

	List<Member> selectMemberList(Map<String, Object> map);
	int selectTotalMember(Map<String, Object> map);
	
	int updateMember(Member member);
	
	int deleteMember(String id);
}
