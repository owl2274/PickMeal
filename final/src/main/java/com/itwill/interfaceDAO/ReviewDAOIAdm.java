package com.itwill.interfaceDAO;

import java.util.List;
import java.util.Map;

import com.itwill.dto.Review;
import com.itwill.dto.ReviewAdm;

public interface ReviewDAOIAdm {
	List<ReviewAdm> selectReviewList(Map<String, Object> map);
	int selectTotalReview(Map<String, Object> map);
	Review selectReviewByReNo(int reNo);
	
	//review detail 페이지에서 내용과 이미지 변경
	int updateReviewAdm(Review review);
	
	//리스트에서 삭제
	int deleteReviewAdm(String reNo);
}
