package com.itwill.interfaceService;

import java.util.List;

import com.itwill.dto.Jumpo;

public interface JumpoServiceI {
	List<Jumpo> getJumpoBookList(int rstNo);
	List<Jumpo> getJumpoBookStateList(int iValue, int rstNo);
	int modifyJumpoBookState(Jumpo jumpo);

}
