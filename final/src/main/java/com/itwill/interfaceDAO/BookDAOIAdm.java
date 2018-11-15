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
	
	//����Ʈ ����¡
	List<BookAdm> selectBookingByKw(Map<String, Object> map);
	int selectTotalBooking(Map<String, Object> map);
	//�������
	int updateBooking(Book book);
	
	//����
	int deleteBooking(String bookNo);
	
}
