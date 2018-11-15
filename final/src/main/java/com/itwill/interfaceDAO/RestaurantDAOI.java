package com.itwill.interfaceDAO;

import java.util.List;

import com.itwill.dto.Restaurant;


public interface RestaurantDAOI {
	int addRestaurant(Restaurant dto);
	List<Restaurant> getRestaurantByFoodType(int foodTypeNo,int count);
	
	List<Restaurant> getRestaurantForWant(int startRow,int endRow,String id);
	int getTotalgetRestaurantForWant(String id);
	
	List<Restaurant> getRestaurantForSearch(int startRow,int endRow,List<Integer> areas,List<Integer> foodTypes,String keyword);
	int getTotalRestaurantForSearch(List<Integer> areas,List<Integer> foodTypes,String keyword);
	
	List<Restaurant> getRestaurantAll();
	Restaurant getRestaurantByRstNo(int rstNo);
	
	String getFoodTypeName(int rstNo);
	
	
	
	
}
