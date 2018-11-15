package com.itwill.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.dto.Member;
import com.itwill.interfaceDAO.MemberDAOIAdm;
import com.itwill.mapper.MemberMapperAdm;

@Repository
public class MemberDAOAdm implements MemberDAOIAdm {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	
	@Override
	public List<Member> getAllMember() {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(MemberMapperAdm.class).getAllMember();
	}
	
	@Override
	public Member selectMemberById(String id) {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(MemberMapperAdm.class).selectMemberById(id);
	}
	
	
	//페이징관련검색
	@Override
	public List<Member> selectMemberList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(MemberMapperAdm.class).selectMemberList(map);
	}
	
	//페이징관련 검색 총계
	@Override
	public int selectTotalMember(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(MemberMapperAdm.class).selectTotalMember(map);
	}
	
	@Override
	public int updateMember(Member member) {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(MemberMapperAdm.class).updateMember(member);
	}

	@Override
	public int deleteMember(String id) {
		return sqlSession.getMapper(MemberMapperAdm.class).deleteMember(id);
	}
}
