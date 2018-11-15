package com.itwill.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.dto.Member;
import com.itwill.interfaceDAO.MemberDAOI;
import com.itwill.mapper.MemberMapper;
@Repository
public class MemberDAO implements MemberDAOI{
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public int addMember(Member member) {
		
		return sqlSession.getMapper(MemberMapper.class).addMember(member);
	}

	
	@Override
	public int modifyLoginDate(String id) {
		
		return sqlSession.getMapper(MemberMapper.class).modifyLoginDate(id);
	}

	@Override
	public int modifyMember(Member member) {
		
		return sqlSession.getMapper(MemberMapper.class).modifyMember(member);
	}
	
	@Override
	public int modifyPassword(Member member) {
		
		return sqlSession.getMapper(MemberMapper.class).modifyPassword(member);
	}

	@Override
	public int removeMember(String id) {
		
		return sqlSession.getMapper(MemberMapper.class).removeMember(id);
	}

	@Override
	public Member searchId(Member member) {
		
		return sqlSession.getMapper(MemberMapper.class).searchId(member);
	}

	@Override
	public Member searchPassword(Member member) {
		
		return sqlSession.getMapper(MemberMapper.class).searchPassword(member);
	}

	@Override
	public Member getIdMember(String id) {
	
		return sqlSession.getMapper(MemberMapper.class).getIdMember(id);
	}

	@Override
	public List<Member> getSearchMember(Map<String, Object> map) {
		
		return sqlSession.getMapper(MemberMapper.class).getSearchMember(map);
	}

	@Override
	public List<Member> getSearchStoreMember(Map<String, Object> map) {
		
		return sqlSession.getMapper(MemberMapper.class).getSearchStoreMember(map);
	}

	@Override
	public List<Member> getAllMember() {
		
		return sqlSession.getMapper(MemberMapper.class).getAllMember();
	}

	@Override
	public List<Member> getAllStoreMember() {
		
		return sqlSession.getMapper(MemberMapper.class).getAllStoreMember();
	}


	

}
