package com.itwill.interfaceService;

import java.util.List;
import java.util.Map;

import com.itwill.dto.Review;

public interface ReviewServiceIAdm {
	Map<String, Object> getReviewList( Map<String, Object> map); // 전체검색/조건검색 -전체 글 총갯수를 전달값으로 전달해서 전체검색함
	
	Review getReviewByReNo(int reNo);
	
	void modifyReviewAdm(Review review);
	
	void removeReviewAdm(String[] chkedList);
}
