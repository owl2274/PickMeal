package com.itwill.interfaceService;

import java.util.List;

import com.itwill.dto.Book;

public interface BookServiceI {
	int addBooking(Book book);
	int modifyBooking(Book book);
	int modifyBookingStatus(Book book);
	List<Book>getBookingByRst(int rstNo);
	int getBookingtTotal(int rstNo);
//	List<Book>getBookingById(String id);
//	List<Book> getBookingById(int pageNum, int pageSize, String id);
	List<Book> getBookingById(int pageNum, int pageSize, String id, Integer bookStatus);
//	int getTotalBookingById(String id);
	int getTotalBookingById(String id, Integer bookStatus);
	int getRestSeat(Book book);
	Book getBookingByBookNo(int bookNo);
	int cancelBooking(int bookNo);
	
}
