package com.itwill.interfaceDAO;

import java.util.List;

import com.itwill.dto.Faq;

public interface FaqDAOI {
	public int insertFaq(Faq faq);
	public int updateFaq(Faq faq);
	public List<Faq> selectFaqList();
}
