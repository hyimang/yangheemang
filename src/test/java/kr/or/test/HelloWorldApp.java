package kr.or.test;

public class HelloWorldApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//위main()메서드는 자바프로그램의 실행 진입지점입니다.
		System.out.println("헬로우 월드!");
		MemberVO memberVO = new MemberVO();
		sumFunc(memberVO,4);//플러스함수를 실행할때 매겨변수 값을 줍니다
		sumFunc(3,4);//메서드의 특징, 위와 같이 같은 메서드명 로드된 매개변수가 다른 방식 오버로드된 메서드

	}
	//메서드의 매개변수에 대해서
	public static void sumFunc(MemberVO memberVO, int b) {
		System.out.println("매개변수 memberVO + b = "+ (memberVO.toString()+b) +"입니다");
	}
	
	public static void sumFunc(int a, int b) {
		System.out.println("매개변수 a + b = "+ (a+b) +"입니다");
	}
}
