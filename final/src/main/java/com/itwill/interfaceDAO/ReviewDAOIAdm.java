package com.itwill.interfaceDAO;

import java.util.List;
import java.util.Map;

import com.itwill.dto.Review;
import com.itwill.dto.ReviewAdm;

public interface ReviewDAOIAdm {
	List<ReviewAdm> selectReviewList(Map<String, Object> map);
	int selectTotalReview(Map<String, Object> map);
	Review selectReviewByReNo(int reNo);
	
	//review detail ���������� ����� �̹��� ����
	int updateReviewAdm(Review review);
	
	//����Ʈ���� ����
	int deleteReviewAdm(String reNo);
}
