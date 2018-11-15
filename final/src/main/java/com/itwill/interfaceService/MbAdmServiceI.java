package com.itwill.interfaceService;

import java.util.List;

import com.itwill.dto.Member;

public interface MbAdmServiceI {
	List<Member> getAllMember();
	String searchId(Member member);
}
