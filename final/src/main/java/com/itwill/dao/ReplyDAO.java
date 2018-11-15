package com.itwill.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.dto.Reply;
import com.itwill.interfaceDAO.ReplyDAOI;
import com.itwill.mapper.ReplyMapper;
@Repository
public class ReplyDAO implements ReplyDAOI {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public int addReply(Reply reply) {
		return sqlSession.getMapper(ReplyMapper.class).addReply(reply);
	}

	@Override
	public int modifyReply(Reply reply) {
		return sqlSession.getMapper(ReplyMapper.class).modifyReply(reply);
	}

	@Override
	public int removeReply(int repNo) {
		return sqlSession.getMapper(ReplyMapper.class).removeReply(repNo);
	}

	@Override
	public List<Reply> getReplyList(int rstNo) {
		return sqlSession.getMapper(ReplyMapper.class).getReplyList(rstNo);
	}

	@Override
	public Reply getReply(int repNo) {
		return sqlSession.getMapper(ReplyMapper.class).getReply(repNo);
	}
	
	
	
}
