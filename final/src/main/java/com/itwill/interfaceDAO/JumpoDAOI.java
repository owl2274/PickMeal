package com.itwill.interfaceDAO;

import java.util.List;

import com.itwill.dto.Jumpo;

public interface JumpoDAOI {
	List<Jumpo> getJumpoBookList(int rstNo);
	List<Jumpo> getJumpoBookStateList(int iValue, int rstNo);
	int updateJumpoBookState(Jumpo jumpo);

}
