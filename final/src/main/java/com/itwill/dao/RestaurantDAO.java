package com.itwill.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.dto.Restaurant;
import com.itwill.interfaceDAO.RestaurantDAOI;
import com.itwill.mapper.RestaurantMapper;


@Repository
public class RestaurantDAO implements RestaurantDAOI{
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public int addRestaurant(Restaurant dto) {
		return sqlSession.getMapper(RestaurantMapper.class).addRestaurant(dto);
	}
	@Override
	public Restaurant getRestaurantByRstNo(int rstNo) {
		return sqlSession.getMapper(RestaurantMapper.class).getRestaurantByRstNo(rstNo);
	}
/*	public List<RestaurantDTO> getRestaurantForWant(String id){
		SqlSession sqlSession=getSqlSessionFactory().openSession(true);
		try {
			return sqlSession.getMapper(RestaurantMapper.class).getRestaurantForWant(id);
		} finally {
			sqlSession.close();
		}
	}	*/
	@Override
	public List<Restaurant> getRestaurantByFoodType(int foodTypeNo,int count){
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("foodTypeNo", foodTypeNo);
		map.put("count", count);
		return sqlSession.getMapper(RestaurantMapper.class).getRestaurantByFoodType(map);
	}	
	@Override
	public List<Restaurant> getRestaurantForSearch(int startRow,int endRow,List<Integer> areas,List<Integer> foodTypes,String keyword){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		map.put("areas", areas);
		map.put("foodTypes", foodTypes);
		map.put("keyword", keyword);
		return sqlSession.getMapper(RestaurantMapper.class).getRestaurantForSearch(map);	
	}
	
	@Override
	public int getTotalRestaurantForSearch(List<Integer> areas,List<Integer> foodTypes,String keyword) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("areas", areas);
		map.put("foodTypes", foodTypes);
		map.put("keyword", keyword);
		return sqlSession.getMapper(RestaurantMapper.class).getTotalRestaurantForSearch(map);
		
	}
	@Override
	public List<Restaurant> getRestaurantForWant(int startRow, int endRow, String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		map.put("id", id);
		return sqlSession.getMapper(RestaurantMapper.class).getRestaurantForWant(map);

	}
	@Override
	public int getTotalgetRestaurantForWant(String id) {
		return sqlSession.getMapper(RestaurantMapper.class).getTotalRestaurantForWant(id);
	}
	
	@Override
	public List<Restaurant> getRestaurantAll(){
		return sqlSession.getMapper(RestaurantMapper.class).getRestaurantAll();

	}
	@Override
	public String getFoodTypeName(int rstNo) {
		return sqlSession.getMapper(RestaurantMapper.class).getFoodTypeName(rstNo);
	}
}
