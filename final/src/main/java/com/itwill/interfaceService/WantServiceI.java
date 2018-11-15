package com.itwill.interfaceService;

import java.util.List;

import com.itwill.dto.Want;

public interface WantServiceI {
	int addWant(Want dto);
	int removeWant(Want dto);
	int hasWant(Want dto);
	List<Want> getWantForIdRstNos(String id, List<Integer> rstNos);
	int countWant(int rstNo);
}
