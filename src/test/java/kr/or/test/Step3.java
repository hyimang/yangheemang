package kr.or.test;

import java.util.Calendar;

/**
 * 외부Enum클래스를 이용해서 열거형 자료형 테스트
 * @author 양희망
 *
 */
public class Step3 {

	public static void main(String[] args) {
		// 메인 메서드-스레드 시작
		Week today = null;//Week자료형용 today변수 생성/선언
		//String today2 = null; String 자료형용 today2 변수생성
		//MemberVO memberVO = new MemberVO();객체선언과 같은 사용법
		//현재날짜가 무슨요일인지 한글로 확인하는 프로그램
		Calendar calendar = Calendar.getInstance();//객체선언
		//calendar오브젝트에서 현재 요일을 반환받기(1~7까지 반환)
		int intWeek = calendar.get(Calendar.DAY_OF_WEEK);//calendar객체, Calendar클래스
		//스위치 조건문으로 1~7까지 반환값을 한글로 변환
		switch(intWeek) {//스위치로 조건을 판단, switch 조건문
		case 1:			//개발자가 if문, switch문을 사용할지 결정
			today = Week.일; break;//break: case문장을 빠져나가는 명령
		case 2:
			today = Week.월; break;//Week자료형에 바로접근하는 방법 Week.
		case 3:
			today = Week.화; break;
		case 4:
			today = Week.수; break;
		case 5:
			today = Week.목; break;
		case 6:
			today = Week.금; break;
		case 7:
			today = Week.토; break;
		
		}
		System.out.println("PC의 오늘 요일은:" + today +"요일입니다.");
		
		if(today == Week.수) {//if 조건문을 사용
			System.out.println("수요일에는 축구를 합니다.");
		} else {
			System.out.println("열심히 자바 공부를 합니다.");
		}
		//Calendar클래스는 달력에서 날짜, 본인 컴퓨터 날짜라서 데이터가 훼손될 가능성이 있음
		//해결책은 서버시간을 가져와서 출력하면 사용자가 날짜를 수정 못함

	}

}
