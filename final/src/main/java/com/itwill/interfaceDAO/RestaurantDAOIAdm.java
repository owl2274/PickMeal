package com.itwill.interfaceDAO;

import java.util.List;
import java.util.Map;

import com.itwill.dto.Restaurant;

public interface RestaurantDAOIAdm {
	Restaurant selectRestaurantByRstNo(int rstNo);
	
	int updateRestaurantRstStatus(Restaurant restaurant);
	

	List<Restaurant> selectRestaurantByKw(Map<String, Object> map);
	int selectTotalRestaurant(Map<String, Object> map);
	
	int deleteRestaurant(String rstNo);
	
	int updateRstDetail(Restaurant restaurant);
}
