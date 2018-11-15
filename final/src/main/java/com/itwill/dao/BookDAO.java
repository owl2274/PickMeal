package com.itwill.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.dto.Book;
import com.itwill.interfaceDAO.BookDAOI;
import com.itwill.mapper.BookMapper;
@Repository
public class BookDAO implements BookDAOI {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public int addBooking(Book book) {
		return sqlSession.getMapper(BookMapper.class).addBooking(book);
	}

	@Override
	public int modifyBooking(Book book) {
		return sqlSession.getMapper(BookMapper.class).modifyBooking(book);
	}

	@Override
	public int modifyBookingStatus(Book book) {
		return sqlSession.getMapper(BookMapper.class).modifyBookingStatus(book);
	}

	@Override
	public List<Book> getBookingByRst(int rstNo) {
		return sqlSession.getMapper(BookMapper.class).getBookingByRst(rstNo);
	}

	@Override
	public int getBookingtTotal(int rstNo) {
		return sqlSession.getMapper(BookMapper.class).getBookingtTotal(rstNo);
	}

	@Override
	public List<Book> getBookingById(int startRow,int endRow,String id,Integer bookStatus) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", id);
		map.put("startRow",startRow);
		map.put("endRow", endRow);
		map.put("bookStatus", bookStatus);
		return sqlSession.getMapper(BookMapper.class).getBookingById(map);
	}
	@Override
	public int getTotalBookingById(String id,Integer bookStatus) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", id);
		map.put("bookStatus", bookStatus);
		return sqlSession.getMapper(BookMapper.class).getTotalBookingById(map);
	}

	@Override
	public int getRestSeat(Book book) {
		return sqlSession.getMapper(BookMapper.class).getRestSeat(book);
	}
	
	@Override
	public Book getBookingByBookNo(int bookNo) {
		return sqlSession.getMapper(BookMapper.class).getBookingByBookNo(bookNo);
	}

	@Override
	public int cancelBooking(int bookNo) {
		return sqlSession.getMapper(BookMapper.class).cancelBooking(bookNo);
	}
	
}
