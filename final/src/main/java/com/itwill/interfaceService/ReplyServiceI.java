package com.itwill.interfaceService;

import java.util.List;

import com.itwill.dto.Reply;

public interface ReplyServiceI {
	int addReply(Reply reply);
	int modifyReply(Reply reply);
	int removeReply(int repNo);
	List<Reply>getReplyList(int rstNo);
	Reply getReply(int repNo);
}
