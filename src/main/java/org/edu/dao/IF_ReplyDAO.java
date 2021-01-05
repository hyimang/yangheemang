package org.edu.dao;

import java.util.List;

import org.edu.vo.ReplyVO;

public interface IF_ReplyDAO {
	public List<ReplyVO> select_reply(Integer bno);
	public int count_reply(Integer bno);
	public void insertReply(ReplyVO replyVO);
	public void updateReply(ReplyVO replyVO);
	public void deleteReply(Integer rno);
}
