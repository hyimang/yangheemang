package org.edu.dao;

import java.util.List;

import org.edu.vo.MemberVO;

/**
 * 회원관리 DAO 메서드 명세(목차) 인터페이스.
 * @author 양희망
 *
 */
public interface IF_MemberDAO {
	public List<MemberVO> selectMember() throws Exception;//jsp 향상된 forEach문 사용 jstl태그
	public void insertMember(MemberVO memberVO) throws Exception;
	public void deletMember(String user_id) throws Exception;
	//throws 스프링을 예외보내면, 나중에 예외처리 전용 error.jsp를 만들어서 에러메세지를 뿌리는 사용자단을 사용
	//회원상세보기에 대한 결과용, 레코드1개만 필요해서 MemberVO만 있어도 됨 
	public MemberVO readMember(String user_id) throws Exception;
}