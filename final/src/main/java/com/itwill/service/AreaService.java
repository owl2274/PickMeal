package com.itwill.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.dao.AreaDAO;
import com.itwill.dto.Area;
import com.itwill.interfaceService.AreaServiceI;
@Service
public class AreaService implements AreaServiceI{
	@Autowired
	private AreaDAO areaDAO;

	@Override
	public List<Area> getAreaList(String city) {
		
		return areaDAO.getAreaList(city);
	}

	@Override
	public List<String> getCityList() {
		
		return areaDAO.getCityList();
	}
	
	

}
