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
	
	//���� ����Ʈ ������ - �˻����� ����¡
	Map<String, Object> searchBookingByKw(Map<String, Object> map);
	void getTotalBooking(Map<String, Object> map);
	
	//���� ����
	void modifyBooking(Book book);
	
	//�������
	void removeBooking(String[] chkedList);
}
