package com.itwill.interfaceService;

import java.util.List;
import java.util.Map;

import com.itwill.dto.Restaurant;

public interface RestaurantServiceIAdm {
	Restaurant getRestaurantByRstNo(int rstNo);
	
	void modifyRestaurantRstStatus(Restaurant restaurant);
	
	List<Restaurant> searchRestaurantList(Map<String, Object> map);
	int searchTotalRestaurant(Map<String, Object> map);
	
	void removeRestaurant(String[] chkedList);
	
	void modifyRstDetail(Restaurant restaurant);
}
