package com.itwill.interfaceService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.dto.Want;
import com.itwill.interfaceDAO.WantDAOI;

@Service
public class WantService implements WantServiceI {

	@Autowired
	private WantDAOI wantDAO;
	
	@Override
	public int addWant(Want dto) {
		return wantDAO.addWant(dto);
	}

	@Override
	public int removeWant(Want dto) {
		return wantDAO.removeWant(dto);
	}

	@Override
	public int hasWant(Want dto) {
		return wantDAO.hasWant(dto);
	}
	
	@Override
	public List<Want> getWantForIdRstNos(String id, List<Integer> rstNos){
		return wantDAO.getWantForIdRstNos(id, rstNos);
	}
	@Override
	public int countWant(int rstNo) {
		return wantDAO.countWant(rstNo);
	}
}
