package com.itwill.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.dto.Book;
import com.itwill.dto.BookAdm;
import com.itwill.interfaceDAO.BookDAOIAdm;
import com.itwill.mapper.BookMapperAdm;
@Repository
public class BookDAOAdm implements BookDAOIAdm{
	@Autowired
	private SqlSessionTemplate sqlSession;
	/*
	@Override
	public List<Book> selectBookingList() {
		
		return sqlSession.getMapper(BookMapperAdm.class).selectBookingList();
	}
	*/
	@Override
	public List<BookAdm> selectBookingList() {
		
		return sqlSession.getMapper(BookMapperAdm.class).selectBookingList();
	}
	
	@Override
	public BookAdm selectBookingByBookNo(int bookNo) {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(BookMapperAdm.class).selectBookingByBookNo(bookNo);
	}

	@Override
	public List<BookAdm> selectBookingByKw(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(BookMapperAdm.class).selectBookingByKw(map);
	}

	@Override
	public int selectTotalBooking(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(BookMapperAdm.class).selectTotalBooking(map);
	}

	@Override
	public int updateBooking(Book book) {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(BookMapperAdm.class).updateBooking(book);
	}

	@Override
	public int deleteBooking(String bookNo) {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(BookMapperAdm.class).deleteBooking(bookNo);
	}
}
