package com.itwill.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.dto.Jumpo;
import com.itwill.interfaceDAO.JumpoDAOI;
import com.itwill.mapper.JumpoMapper;

@Repository
public class JumpoDAO implements JumpoDAOI{
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<Jumpo> getJumpoBookList(int rstNo) {
		return sqlSession.getMapper(JumpoMapper.class).getJumpoBookList(rstNo);
	}

	@Override
	public List<Jumpo> getJumpoBookStateList(int iValue, int rstNo) {
		
		return sqlSession.getMapper(JumpoMapper.class).getJumpoBookStateList(iValue, rstNo);
	}


	@Override
	public int updateJumpoBookState(Jumpo jumpo) {
		return sqlSession.getMapper(JumpoMapper.class).updateJumpoBookState(jumpo);
	}
	


	

	

	

	
	
}
