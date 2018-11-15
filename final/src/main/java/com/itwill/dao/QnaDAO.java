package com.itwill.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.dto.Qna;
import com.itwill.interfaceDAO.QnaDAOI;
import com.itwill.mapper.QnaMapper;

@Repository
public class QnaDAO implements QnaDAOI {
	
	@Autowired
	private SqlSessionTemplate sqlsession;

	@Override
	public List<Qna> getQnaList(Qna qna) {
		return sqlsession.getMapper(QnaMapper.class).getQnaList(qna);
	}

	@Override
	public Qna getQna(int qnaNo) {
		return sqlsession.getMapper(QnaMapper.class).getQna(qnaNo);
	}

	@Override
	public int insertQna(Qna qna) {
		return sqlsession.getMapper(QnaMapper.class).insertQna(qna);
	}

	@Override
	public int modifyQna(Qna qna) {
		return sqlsession.getMapper(QnaMapper.class).modifyQna(qna);
	}

	@Override
	public int replyQna(Qna qna) {
		return sqlsession.getMapper(QnaMapper.class).replyQna(qna);
	}

	@Override
	public int deleteQna(int qnaNo) {
		return sqlsession.getMapper(QnaMapper.class).deleteQna(qnaNo);
	}

	@Override
	public int getOwnerCheck(Qna qna) {
		return sqlsession.getMapper(QnaMapper.class).getOwnerCheck(qna);
	}

	@Override
	public List<Qna> getQnaListAdmin(Qna qna) {
		return sqlsession.getMapper(QnaMapper.class).getQnaListAdmin(qna);
	}

	
}
