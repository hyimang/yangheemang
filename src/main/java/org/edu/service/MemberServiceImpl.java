package org.edu.service;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import javax.inject.Inject;

import org.edu.dao.IF_MemberDAO;
import org.edu.vo.MemberVO;
import org.edu.vo.PageVO;
import org.springframework.stereotype.Service;

/**
 * MemberServiceImpl는 DAO메서드 호출을 구현
 * @author 양희망
 *
 */
@Service
public class MemberServiceImpl implements IF_MemberService {

	@Inject
	IF_MemberDAO memberDAO;//IF_MemberDAO 주입받아서 memberDAO오브젝트 생성
	@Override
	public List<MemberVO> selectMember(PageVO pageVO) throws Exception {
		// 회원정보 조회 DAO클래스의 메서드호출(아래)
		return memberDAO.selectMember(pageVO);
	}
	@Override
	public int countMember(PageVO pageVO) throws Exception {
		// 검색된 회원의 전체 명수 구하기
		return memberDAO.countMember(pageVO);
	}
	@Override
	public MemberVO readMember(String user_id) throws Exception {
		// 선택한 회원의 상세정보 구하기
		return memberDAO.readMember(user_id);
	}
	@Override
	public void deleteMember(String user_id) throws Exception {
		// 선택한 회원을 삭제하기
		memberDAO.deletMember(user_id);
		
	}
	@Override
	public void updateMember(MemberVO memberVO) throws Exception {
		// 선택한 회원 정보 수정하기
		memberDAO.updateMember(memberVO);
		
	}
	@Override
	public void insertMember(MemberVO memberVO) throws Exception {
		// jsp폼에서 입력한 회원정보 등록하기
		memberDAO.insertMember(memberVO);
		
	}
	@Override
	public void herokuJobMethod() throws Exception {
		// 월-금 오전8시부터 오후 11시(미국시간 23,0-14) 헤로쿠앱에 20분간격으로 URL접근
		String urlStr = "http://yangheemang.herokuapp.com";//본인앱주소
		URL url = new URL(urlStr);
		HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();//접속시작
		urlConnection.setUseCaches(false);//기존접속된 정보가 있든지 없든지 무조건 접속
		urlConnection.setReadTimeout(10000);//접속대기시간을 10초.헤로쿠20초
		//개발자확인 코드 
		if(urlConnection !=null && urlConnection.getResponseCode()==HttpURLConnection.HTTP_OK) {
			System.out.println("헤로쿠 앱이 활성화 됐습니다.");
		}else {
			System.out.println("헤로쿠 앱이 비활성화 상태 입니다.");
		}
	}

}
