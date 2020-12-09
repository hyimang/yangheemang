package kr.or.member;

import kr.or.member.MemberVO;

public class MemberService {
	public void printMember(MemberVO[] members) {// members는 레코드가 여러개=여러줄
		// 서비스 구현메서드 내용 향상된 for 반복문 사용
		int cnt = 0;
		for (MemberVO member : members) {// members 여러 레코드 중 1개의 레코드를 member 오브젝트 객체로 대입
			cnt = cnt + 1;//0번째 할수 없으니 +1 붙임
			System.out.println(cnt + " 번째 레코드는" + member.toString());
		}
		//비즈니스 로직에서 처리하는 내용 = 데이터를 가공한다
		//데이터 select가져오기, insert입력하기, update수정하기,delete삭제하기
		//=>CRUD를 구현하는 내용
	}
}
