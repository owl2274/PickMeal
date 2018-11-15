package com.itwill.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.dto.Review;
import com.itwill.dto.ReviewAdm;
import com.itwill.interfaceDAO.ReviewDAOIAdm;
import com.itwill.mapper.ReviewMapperAdm;
@Repository
public class ReviewDAOAdm implements ReviewDAOIAdm{
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	
	
	@Override
	public Review selectReviewByReNo(int reNo) {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(ReviewMapperAdm.class).selectReviewByReNo(reNo);
	}



	@Override
	public List<ReviewAdm> selectReviewList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(ReviewMapperAdm.class).selectReviewList(map);
	}



	@Override
	public int selectTotalReview(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(ReviewMapperAdm.class).selectTotalReview(map);
	}



	@Override
	public int updateReviewAdm(Review review) {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(ReviewMapperAdm.class).updateReviewAdm(review);
	}



	@Override
	public int deleteReviewAdm(String reNo) {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(ReviewMapperAdm.class).deleteReviewAdm(reNo);
	}
}
