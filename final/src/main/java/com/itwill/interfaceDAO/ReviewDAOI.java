package com.itwill.interfaceDAO;

import java.util.List;

import com.itwill.dto.Review;


public interface ReviewDAOI {
	int addReview(Review review);
	int modifyReview(Review review);
	int removeReview(int reNo);
	//List<Review> getReviewById(String id);
	Review getReviewByReNo(int reNo);
	//List<Review>getReviewByIdList(String id);
//	List<Review> getReviewByIdList(int startRow, int endRow, String id);
	List<Review> getReviewByIdList(int startRow, int endRow, String id, String rstName);
//	int getTotalReviewById(String id);
	int getTotalReviewById(String id, String rstName);
	List<Review> getReviewList(int rstNo);
	int getTotalReview(int rstNo);
	double getSumScore(int rstNo);
	double getReviewScore(int reNo);
}
