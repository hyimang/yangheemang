package org.edu.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public List<HashMap<String,Object>> readAttach(Integer bno) throws Exception {
		// 게시물에 딸리 첨부파일 보기 매퍼쿼리 연결 해시#
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
		// 위쪽의 매서드인 updateBoard매서드의 매개변수 해석(아래) BoardVO클래스는 개발자가 생성한 참조형 데이터 타입
		// jsp에서 updateBoard태그에서 전송된 값  boardVO클래스에 담겨서 데이터를 받습니다.
		// 함수는 오브젝트 생성해야지만 사용 가능함. 자바에선 new, 스프링에선 Inject.
		// BoardVO는 개발자가 선언한 클래스, 데이터클래스, 오브젝트 클래스 /자료형
		// String 자바가 선언한 클래스 /자료형
		sqlSession.update("boardMapper.updateBoard", boardVO);
		
	}


	@Override
	public void insertAttach(String save_file_name, String real_file_name) throws Exception {
		// 첨부파일 입력 매퍼쿼리 연결(아래)
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("save_file_name", save_file_name);
		paramMap.put("real_file_name", real_file_name);
		sqlSession.insert("boardMapper.insertAttach", paramMap);
		
	}


	@Override
	public void deleteAttach(String save_file_name) throws Exception {
		// 첨부파일 1개 삭제 매퍼쿼리 연결
		sqlSession.delete("boardMapper.deleteAttach", save_file_name);
	}


	@Override
	public void deleteAttachAll(Integer bno) throws Exception {
		// 해당게시물의 모든 첨부파일 삭제 매퍼쿼리 연결
		sqlSession.delete("boardMapper.deleteAttachAll", bno);
	}

}
