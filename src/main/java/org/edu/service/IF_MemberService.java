package org.edu.service;

import java.util.List;

import org.edu.vo.MemberVO;
import org.edu.vo.PageVO;

/**
 * IF_MemberService클래스는 DAO를 호출하는 역할
 * @author 양희망
 *
 */
public interface IF_MemberService {
	public int countMember(PageVO pageVO) throws Exception;
	public List<MemberVO> selectMember(PageVO pageVO) throws Exception;
	public MemberVO readMember(String user_id) throws Exception;
	public void deleteMember(String user_id) throws Exception; //반환값이 없는 이유는 삭제하면 받을 값이 없기때문에
	//업데이트 후 member_view.jsp로 이동
	public void updateMember(MemberVO memberVO) throws Exception;
	public void insertMember(MemberVO memberVO) throws Exception;
	//스프링스케줄 모듈을 이용해서 실행 메서드 생성(아래)
	public void herokuJobMethod() throws Exception;
}
