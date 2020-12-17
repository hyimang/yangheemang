package kr.or.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 *  OpenApi클래스로 HRD-Net에서 제공하는 구직훈련과정API 목록을 출력하는 자바앱
 * @author 양희망
 *
 */
public class OpenApi {
	//외부연계 역할 메서드
	public static void serviceApi() {
		BufferedReader bufferedReader = null;//HRD넷에서 전송받은 데이터를 임시저장하는 공간. 범퍼 중간역할
		String urlStr = "http://www.hrd.go.kr/hrdp/api/apipo/APIPO0101T.do?srchTraEndDt=20210317&pageSize=10&srchTraArea2=44133&srchTraArea1=44&srchTraOrganNm=%ED%9C%B4%EB%A8%BC&srchTraStDt=20201108&sortCol=TR_STT_DT&authKey=yKt63a6Wtxfq282kkIdQAZVXtSlPW5GF&sort=ASC&returnType=XML&outType=1&pageNum=1&srchTraPattern=N1&srchPart=-99&apiRequstPageUrlAdres=/jsp/HRDP/HRDPO00/HRDPOA60/HRDPOA60_1.jsp&apiRequstIp=58.74.90.6\r\n";
		try {
			URL url = new URL(urlStr);
			try {
				HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
				urlConnection.setRequestMethod("GET");//URL쿼리스트링으로 파라미터를 보낸다.
				bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(),"euc-kr"));
				String result="";
				String line;
				int cnt = 0;
				//while 반복문 시작
				while((line=bufferedReader.readLine()) !=null) {
					cnt = cnt+1;
					result = result + line + "\n"; //\n ==Newline나타내는 기호,결과는 엔터
				}
				System.out.println("버퍼리더로 읽어들인 최종 결과값은 아래입니다. while 반복회수는"+cnt);
				//System.out.println(result);//2줄로 읽어서 끝
				//XmlUtils.java클래스를 이용해서 xml태그내용을 이쁘게 출력
				String result_xmlUtils = XmlUtils.formatXml(result);
				System.out.println(result_xmlUtils);
			} catch (IOException e) {
				// Http 웹전근에러상황 발생
				System.out.println("Http 웹전근 에러입니다. 왜냐하면" + e.toString());
			}
			
		} catch (MalformedURLException e) {
			// 외부연계URL주소형식이 잘못됐을때 에러상황 발생
			System.out.println("URL주소형식이 잘못됐습니다. 왜냐하면" + e.toString());
		}finally {
			//콘솔화면에 현재 PC시간을 표시해서 진짜 5초단위로 스케쥴대로 작동되는지 확인
			Calendar calendar =Calendar.getInstance();
			System.out.println(calendar.getTime());
		}
		
	}
	
	//static 메서드는 new키워드로 객체오브젝트 생성없이 바로 접근이 가능한 메서드를 말합니다.
	public static void main(String[] args) {
		//메인스레드는 1개 다른스레드를 추가로 실행할때, Runnable메서드를 사용함
		//추가스레드를 스케줄로 실행할 때 실행간격 변수(5초)
		int sleepSec = 5;
		//주기적인 스레드 작업을 위한 코딩: exec변수 new키워드로 실행가능 한 오브젝트 변수exec변수 생성.
		//final 인 현재클래스에서만 사용하겠다는 명시적인 의미
		final ScheduledThreadPoolExecutor exec = new ScheduledThreadPoolExecutor(1);
		exec.scheduleAtFixedRate(new Runnable(){
			public void run() {//스레드를 이용해서 5초단위로 메서드 반복실행
				serviceApi();
			}
		}, 0, sleepSec, TimeUnit.SECONDS);
		
		// 일반메스드와 스태틱메서드의 호출차이 
		//StaticTest staticTest = new StaticTest();
		//staticTest.test2();//노스태틱은 오브젝트생성 후 접근이 가능
		//StaticTest.test();//스태틱메서드는 오브젝트 생성없이 클래스로 바로 접근 가능.메서드,변수도 가능
		/*
		int sum = 0;
		while(sum<10) {
			sum=sum+1;//sum=sum+1 누적로직을 확인
			System.out.println("지금까지 누적된 값은" +sum);
		}
		*/
	}

}
class StaticTest {//메서드뿐만 아니라 변수에도 해당되는 이론
	public static void test() {//클래스를 읽어들이는 순간 실행이 가능
		//스태틱메서드는 클래스를 읽어들이는 순간, 고정메모리 할당받음=실행가능
		System.out.println("스태틱테스트");
	}
	public void test2() {//일반메서드는 new키워드로 오브젝트를 생성할때 메모리 할당받음.(실행가능)	
		System.out.println("일반테스트2");
	}
	
}