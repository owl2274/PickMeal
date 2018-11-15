package com.itwill.dao;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import com.itwill.dto.Area;
import com.itwill.mapper.AreaMapper;


@Repository
public class AreaDAO{
	@Autowired
	private SqlSessionTemplate sqlSession;

	
	public List<Area> getAreaList(String city){
		return sqlSession.getMapper(AreaMapper.class).getAreaList(city);
	}
	
	public List<String> getCityList(){ 		
		return sqlSession.getMapper(AreaMapper.class).getCityList();
	}

}
