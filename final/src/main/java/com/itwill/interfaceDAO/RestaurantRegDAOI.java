package com.itwill.interfaceDAO;

import java.util.List;

import com.itwill.dto.RestaurantReg;

public interface RestaurantRegDAOI {
	public int insertRestaurant(RestaurantReg restaurantReg);
	public int updateRestaurant(RestaurantReg restaurantReg);
	public RestaurantReg selectRestaurant(int rstNo);
	public List<RestaurantReg> selectRestaurantList(String id);
	public RestaurantReg selectRestaurantBybn(double businessNo);
}
