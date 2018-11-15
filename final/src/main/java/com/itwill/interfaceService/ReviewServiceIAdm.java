package com.itwill.interfaceService;

import java.util.List;
import java.util.Map;

import com.itwill.dto.Review;

public interface ReviewServiceIAdm {
	Map<String, Object> getReviewList( Map<String, Object> map); // ��ü�˻�/���ǰ˻� -��ü �� �Ѱ����� ���ް����� �����ؼ� ��ü�˻���
	
	Review getReviewByReNo(int reNo);
	
	void modifyReviewAdm(Review review);
	
	void removeReviewAdm(String[] chkedList);
}
