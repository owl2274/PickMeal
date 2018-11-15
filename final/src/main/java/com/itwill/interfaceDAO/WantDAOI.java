package com.itwill.interfaceDAO;

import java.util.List;

import com.itwill.dto.Want;

public interface WantDAOI {
	int addWant(Want dto);
	int removeWant(Want dto);
	int hasWant(Want dto);
	List<Want> getWantForIdRstNos(String id, List<Integer> rstNos);
	int countWant(int rstNo);
}
