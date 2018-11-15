package com.itwill.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.dto.BookStatus;
import com.itwill.mapper.BookStatusMapper;

@Repository
public class BookStatusDAO {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public BookStatus getBookStatusByNo(int bookStatus) {
		return sqlSession.getMapper(BookStatusMapper.class).getBookStatusByNo(bookStatus);
		
	}
	public List<BookStatus> getBookStatusAll(){
		return sqlSession.getMapper(BookStatusMapper.class).getBookStatusAll();
	}
}
