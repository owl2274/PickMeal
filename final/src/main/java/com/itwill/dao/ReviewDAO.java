package com.itwill.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.dto.Review;
import com.itwill.interfaceDAO.ReviewDAOI;
import com.itwill.mapper.ReviewMapper;


@Repository
public class ReviewDAO implements ReviewDAOI {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public int addReview(Review review) {
		return sqlSession.getMapper(ReviewMapper.class).addReview(review);
	}

	@Override
	public int modifyReview(Review review) {
		return sqlSession.getMapper(ReviewMapper.class).modifyReview(review);
	}

	@Override
	public int removeReview(int reNo) {
		return sqlSession.getMapper(ReviewMapper.class).removeReview(reNo);
	}

	@Override
	public Review getReviewByReNo(int reNo) {
		return sqlSession.getMapper(ReviewMapper.class).getReviewByReNo(reNo);
	}

	@Override
	public List<Review> getReviewByIdList(int startRow,int endRow,String id,String rstName) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		map.put("id", id);
		if(rstName != null) {
			map.put("rstName", rstName);
		}
		return sqlSession.getMapper(ReviewMapper.class).getReviewByIdList(map);
	}
/*	@Override
	public List<Review> getReviewByIdList(int startRow,int endRow,String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		map.put("id", id);
		return sqlSession.getMapper(ReviewMapper.class).getReviewByIdList(map);
	}
*/
	@Override
	public int getTotalReviewById(String id,String rstName) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("id", id);
		if(rstName != null) {
			map.put("rstName", rstName);
		}
		return sqlSession.getMapper(ReviewMapper.class).getTotalReviewById(map);
	}

	@Override
	public List<Review> getReviewList(int rstNo) {
		return sqlSession.getMapper(ReviewMapper.class).getReviewList(rstNo);
	}

	@Override
	public int getTotalReview(int rstNo) {
		return sqlSession.getMapper(ReviewMapper.class).getTotalReview(rstNo);
	}

	@Override
	public double getSumScore(int rstNo) {
		return sqlSession.getMapper(ReviewMapper.class).getSumScore(rstNo);
	}

	@Override
	public double getReviewScore(int reNo) {
		return sqlSession.getMapper(ReviewMapper.class).getReviewScore(reNo);
	}
	
	

}
