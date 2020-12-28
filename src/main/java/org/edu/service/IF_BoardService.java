package org.edu.service;

import java.util.List;

import org.edu.vo.BoardVO;
import org.edu.vo.PageVO;

public interface IF_BoardService {
	public List<BoardVO> selectBoard(PageVO pageVO) throws Exception;
	public int countBoard(PageVO pageVO) throws Exception;
	public BoardVO readBoard(Integer bno) throws Exception;//update까지 처리할것
	public List<String> raadAttach(Integer bno) throws Exception;
}
