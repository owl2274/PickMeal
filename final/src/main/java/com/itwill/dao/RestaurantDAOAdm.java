package com.itwill.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.dto.Restaurant;
import com.itwill.interfaceDAO.RestaurantDAOIAdm;
import com.itwill.mapper.RestaurantMapperAdm;
@Repository
public class RestaurantDAOAdm implements RestaurantDAOIAdm {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public Restaurant selectRestaurantByRstNo(int rstNo) {
		return sqlSession.getMapper(RestaurantMapperAdm.class).selectRestaurantByRstNo(rstNo);
	}
	
	@Override
	public int updateRestaurantRstStatus(Restaurant restaurant) {
		return sqlSession.getMapper(RestaurantMapperAdm.class).updateRestaurantRstStatus(restaurant);
	}
	
	@Override
	public List<Restaurant> selectRestaurantByKw(Map<String, Object> map) {
		return sqlSession.getMapper(RestaurantMapperAdm.class).selectRestaurantByKw(map);
	}
	
	@Override
	public int selectTotalRestaurant(Map<String, Object> map) {
		return sqlSession.getMapper(RestaurantMapperAdm.class).selectTotalRestaurant(map);
	}

	@Override
	public int deleteRestaurant(String rstNo) {
		return sqlSession.getMapper(RestaurantMapperAdm.class).deleteRestaurant(rstNo);
	}

	@Override
	public int updateRstDetail(Restaurant restaurant) {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(RestaurantMapperAdm.class).updateRstDetail(restaurant);
	}
	
	
}
