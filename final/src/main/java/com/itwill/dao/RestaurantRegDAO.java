package com.itwill.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.dto.RestaurantReg;
import com.itwill.interfaceDAO.RestaurantRegDAOI;
import com.itwill.mapper.RestaurantRegMapper;

@Repository
public class RestaurantRegDAO implements RestaurantRegDAOI{
	@Autowired
	private SqlSessionTemplate sqlsession;

	@Override
	public int insertRestaurant(RestaurantReg restaurantReg) {
		return sqlsession.getMapper(RestaurantRegMapper.class).insertRestaurant(restaurantReg);
	}

	@Override
	public int updateRestaurant(RestaurantReg restaurantReg) {
		return sqlsession.getMapper(RestaurantRegMapper.class).updateRestaurant(restaurantReg);
	}

	@Override
	public RestaurantReg selectRestaurant(int rstNo) {
		return sqlsession.getMapper(RestaurantRegMapper.class).selectRestaurant(rstNo);
	}

	@Override
	public List<RestaurantReg> selectRestaurantList(String id) {
		return sqlsession.getMapper(RestaurantRegMapper.class).selectRestaurantList(id);
	}

	@Override
	public RestaurantReg selectRestaurantBybn(double businessNo) {
		return sqlsession.getMapper(RestaurantRegMapper.class).selectRestaurantBybn(businessNo);
	}
	
	
}
