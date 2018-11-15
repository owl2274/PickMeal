package com.itwill.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.dto.Want;
import com.itwill.interfaceDAO.WantDAOI;
import com.itwill.mapper.WantMapper;


@Repository
public class WantDAO implements WantDAOI{
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public int addWant(Want dto) {
		return sqlSession.getMapper(WantMapper.class).addWant(dto);

	}

	@Override
	public int removeWant(Want dto) {
		
		return sqlSession.getMapper(WantMapper.class).removeWant(dto);
	}

	@Override
	public int hasWant(Want dto) {
		return sqlSession.getMapper(WantMapper.class).hasWant(dto);
	}
	@Override
	public List<Want> getWantForIdRstNos(String id,List<Integer> rstNos) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", id);
		map.put("rstNos", rstNos);
		return sqlSession.getMapper(WantMapper.class).getWantForIdRstNos(map);
	}
	@Override
	public int countWant(int rstNo) {
		return sqlSession.getMapper(WantMapper.class).countWant(rstNo);
	}
}
