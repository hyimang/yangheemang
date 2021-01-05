package org.edu.dao;

import java.util.List;

import org.edu.vo.ReplyVO;

public interface IF_ReplyDAO {
	public List<ReplyVO> select_reply(Integer bno) throws Exception;
	public int count_reply(Integer bno) throws Exception;
	public void insertReply(ReplyVO replyVO) throws Exception;
	public void updateReply(ReplyVO replyVO) throws Exception;
	public void deleteReply(Integer rno) throws Exception;
}
