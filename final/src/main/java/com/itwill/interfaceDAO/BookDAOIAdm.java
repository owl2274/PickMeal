package com.itwill.interfaceDAO;

import java.util.List;
import java.util.Map;

import com.itwill.dto.Book;
import com.itwill.dto.BookAdm;

public interface BookDAOIAdm {
	//List<Book> selectBookingList();
	//List<BookAdm> selectBooking();
	List<BookAdm> selectBookingList();
	BookAdm selectBookingByBookNo(int bookNo);
	
	//리스트 페이징
	List<BookAdm> selectBookingByKw(Map<String, Object> map);
	int selectTotalBooking(Map<String, Object> map);
	//예약수정
	int updateBooking(Book book);
	
	//삭제
	int deleteBooking(String bookNo);
	
}
