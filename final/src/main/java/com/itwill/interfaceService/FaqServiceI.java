package com.itwill.interfaceService;

import java.util.List;

import com.itwill.dto.Faq;

public interface FaqServiceI {
	public int insertFaq(Faq faq);
	public int updateFaq(Faq faq);
	public List<Faq> selectFaqList();
}
