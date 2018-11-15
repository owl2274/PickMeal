package com.itwill.interfaceService;

import java.util.List;
import java.util.Map;

import com.itwill.dto.Book;
import com.itwill.dto.BookAdm;

public interface BookServiceIAdm {
	//List<Book> getBookingList();
	//List<BookAdm> getBooking();
	List<BookAdm> getBookingList();
	BookAdm getBookingByBookNo(int bookNo);
	
	//예약 리스트 페이지 - 검색조건 페이징
	Map<String, Object> searchBookingByKw(Map<String, Object> map);
	void getTotalBooking(Map<String, Object> map);
	
	//예약 수정
	void modifyBooking(Book book);
	
	//예약삭제
	void removeBooking(String[] chkedList);
}
