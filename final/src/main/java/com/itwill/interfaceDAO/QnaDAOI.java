package com.itwill.interfaceDAO;

import java.util.List;

import com.itwill.dto.Qna;

public interface QnaDAOI {
	public List<Qna> getQnaList(Qna qna);
	public Qna getQna(int qnaNo);
	public int insertQna(Qna qna);
	public int modifyQna(Qna qna);
	public int replyQna(Qna qna);
	public int deleteQna(int qnaNo);
	public int getOwnerCheck(Qna qna);
	public List<Qna> getQnaListAdmin(Qna qna);
}

