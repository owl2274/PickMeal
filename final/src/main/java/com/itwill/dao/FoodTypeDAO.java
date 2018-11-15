package com.itwill.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.dto.FoodType;
import com.itwill.interfaceDAO.FoodTypeDAOI;
import com.itwill.mapper.FoodTypeMapper;

@Repository
public class FoodTypeDAO implements FoodTypeDAOI{
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<FoodType> getFoodTypeAll(){
		System.out.println(sqlSession);
		return sqlSession.getMapper(FoodTypeMapper.class).getFoodTypeAll();

	}
	
}
