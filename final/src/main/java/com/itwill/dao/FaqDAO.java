package com.itwill.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.dto.Faq;
import com.itwill.interfaceDAO.FaqDAOI;
import com.itwill.mapper.FaqMapper;

@Repository
public class FaqDAO implements FaqDAOI{
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public int insertFaq(Faq faq) {
		return sqlSession.getMapper(FaqMapper.class).insertFaq(faq);
	}

	@Override
	public int updateFaq(Faq faq) {
		return sqlSession.getMapper(FaqMapper.class).updateFaq(faq);
	}

	@Override
	public List<Faq> selectFaqList() {
		return sqlSession.getMapper(FaqMapper.class).selectFaqList();
	}
	
	
}
