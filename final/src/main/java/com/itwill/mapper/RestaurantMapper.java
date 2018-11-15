package com.itwill.mapper;

import java.util.List;
import java.util.Map;

import com.itwill.dto.Restaurant;


public interface RestaurantMapper {
	int addRestaurant(Restaurant dto);
	Restaurant getRestaurantByRstNo(int rstNo);
	List<Restaurant> getRestaurantByFoodType(Map<String, Integer> map);
	
	List<Restaurant> getRestaurantForWant(Map<String, Object> map);
	int getTotalRestaurantForWant(String id);
	
	List<Restaurant> getRestaurantForSearch(Map<String, Object> map);
	int getTotalRestaurantForSearch(Map<String,Object> map);
	
	List<Restaurant> getRestaurantAll();
	
	String getFoodTypeName(int rstNo);
	
}
