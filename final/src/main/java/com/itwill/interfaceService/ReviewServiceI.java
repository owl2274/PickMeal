package com.itwill.interfaceService;

import java.util.List;

import com.itwill.dto.Review;

public interface ReviewServiceI {
	int addReview(Review review);
	int modifyReview(Review review);
	int removeReview(int reNo);
	//List<Review> getReviewById(String id);
	Review getReviewByReNo(int reNo);
	//List<Review>getReviewByIdList(String id);
//	List<Review> getReviewByIdList(int pageNum, int pageSize, String id);
	List<Review> getReviewByIdList(int pageNum, int pageSize, String id, String rstName);
//	int getTotalReviewById(String id);
	int getTotalReviewById(String id, String rstName);
	List<Review> getReviewList(int rstNo);
	int getTotalReview(int rstNo);
	double getSumScore(int rstNo);
	double getReviewScore(int reNo);
}
