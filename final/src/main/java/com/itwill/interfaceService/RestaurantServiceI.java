package com.itwill.interfaceService;

import java.util.List;

import com.itwill.dto.Restaurant;
import com.itwill.exception.RestautantNotFoundException;
import com.itwill.mapper.RestaurantMapper;

public interface RestaurantServiceI {
	List<Restaurant> getRestaurantForWant(int pageNum,int pageSize,String id);
	List<Restaurant> getRestaurantForSearch(int pageNum,int pageSize,List<Integer> areas,List<Integer> foodTypes,String keyword);
	int getTotalRestaurantForSearch(List<Integer> areas,List<Integer> foodTypes,String keyword);
	List<Restaurant> getRestaurantByFoodType(int foodTypeNo,int count);

	int addRestaurant(Restaurant dto);
	
	int getTotalgetRestaurantForWant(String id);
	
	
	List<Restaurant> getRestaurantAll();
	Restaurant getRestaurantByRstNo(int rstNo)throws RestautantNotFoundException;
	
	String getFoodTypeName(int rstNo)throws RestautantNotFoundException;
}
