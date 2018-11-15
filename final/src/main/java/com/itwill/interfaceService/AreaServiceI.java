package com.itwill.interfaceService;

import java.util.List;

import com.itwill.dto.Area;

public interface AreaServiceI {
	List<Area> getAreaList(String city);
	List<String> getCityList();
}
