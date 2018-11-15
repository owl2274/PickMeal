package com.itwill.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.dto.Member;
import com.itwill.interfaceDAO.MbAdmDAOI;
import com.itwill.mapper.MemberMapper;

@Repository
public class MbAdmDAO implements MbAdmDAOI{
	
	private SqlSessionTemplate sqlSession;
	@Override
	public List<Member> getAllMember() {
		return sqlSession.getMapper(MemberMapper.class).getAllMember();
	}
}
