package com.itwill.interfaceService;

import java.util.List;

import com.itwill.dto.RestaurantReg;
import com.itwill.exception.ObjectNotFoundException;

public interface RestaurantRegServiceI {
	public int insertRestaurant(RestaurantReg restaurantReg);
	public int updateRestaurant(RestaurantReg restaurantReg) throws ObjectNotFoundException;
	public RestaurantReg selectRestaurant(int rstNo);
	public List<RestaurantReg> selectRestaurantList(String id);
	public RestaurantReg selectRestaurantBybn(double businessNo);
}
