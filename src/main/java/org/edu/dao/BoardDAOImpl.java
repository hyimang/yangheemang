package org.edu.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.edu.vo.BoardVO;
import org.edu.vo.PageVO;
import org.springframework.stereotype.Repository;

@Repository//아래 DAO만클래스를 레포지터리(저장소)애노테이션으로 감싸줌으로써 여러 내용 사용가능함
public class BoardDAOImpl implements IF_BoardDAO {

	@Inject //sql세션템플릿을 주입 인젝션 받아서 변수로 지정
	private SqlSession sqlSession;
	
	
	@Override
	public List<BoardVO> selectBoard(PageVO pageVO) throws Exception {
		// sql세션 템플릿(select,update,delete 같은 메서드가 포함)매페쿼리 지정(아래)
		//sql세션 템플릿? root-context.xml안에 지정한 템플릿
		//매퍼쿼리(위쿼리+insert등)을 실행할때 개발자가 DB커넥션, 디스커넥션 생각할 필요없이 사용가능한
		//매서드 집합을 구성해 놓은 것이  sql 세션템플릿입니다.
		return sqlSession.selectList("boardMapper.selectBoard", pageVO);
	}


	@Override
	public int countBoard(PageVO pageVO) throws Exception {
		// sql세션템플릿 사용해서 게시물 개수 구하기 매퍼쿼리 연결
		return sqlSession.selectOne("boardMapper.countBoard", pageVO);
	}


	@Override
	public BoardVO readBoard(Integer bno) throws Exception {
		// 게시물 상세보기 매퍼쿼리 연결
		return sqlSession.selectOne("boardMapper.readBoard", bno);
	}


	@Override
	public List<String> readAttach(Integer bno) throws Exception {
		// 게시물에 딸리 첨부파일 보기 매퍼쿼리 연결
		return sqlSession.selectList("boardMapper.readAttach", bno);
	}


	@Override
	public void updateViewCount(Integer bno) throws Exception {
		// 게시물 상세보기 시 조회수+1 업데이트 처리 매퍼쿼리 연결
		sqlSession.update("boardMapper.updateViewCount", bno);
	}


	@Override
	public void insertBoard(BoardVO boardVO) throws Exception {
		// 게시물 등록 매퍼쿼리 연결
		sqlSession.insert("boardMapper.insertBoard", boardVO);
		
	}


	@Override
	public void deleteBoard(Integer bno) throws Exception {
		// 게시물 삭제 매퍼 쿼리 연결
		sqlSession.delete("boardMapper.deleteBoard", bno);
		
	}


	@Override
	public void updateBoard(BoardVO boardVO) throws Exception {
		// 게시물 수정 매퍼쿼리 연결
		sqlSession.update("boardMapper.updateBoard", boardVO);
		
	}

}
