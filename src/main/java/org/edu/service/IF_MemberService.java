package org.edu.service;

import java.util.List;

import org.edu.vo.MemberVO;

/**
 * IF_MemberService클래스는 DAO를 호출하는 역할
 * @author 양희망
 *
 */
public interface IF_MemberService {
	public List<MemberVO> selectMember() throws Exception;
	
}