package kr.or.test;

import java.util.function.IntSupplier;

public class LambdaApp {
	//static 현재클래스에서 유일한 메서드로 사용하겠다는 의미
	public static int method(int x, int y) {
		//IntSupplier 클래스는 계산된 결과값을 반환할때 int타입으로 반환하는 명세가 모여있는 인터페이스 
		//인터페이스로 메서드명만 있고 구현내용이 없는 영역
				//람다식 적용전
		IntSupplier intSupplier = new IntSupplier() {

			@Override
			public int getAsInt() {
				int sum = x+y;
				return sum;
			}
			
		};
		//위 intSupplier오브젝트를 호출해야만 실행이 됩니다.
		int result = intSupplier.getAsInt();
		//람다식 적용후
		IntSupplier intSupplier2 = () -> {//구현내용시작:->에로우함수추가, new,메서드명,@오버라이드 생략됨.
				int sum = x+y;
				return sum;
			
						
		};
		int result2 = intSupplier2.getAsInt();
		
		return result2;
	}
	public static void main(String[] args) {
		// 자바 애플리케이션의 진입 실행함수
		System.out.println("람다식 테스트용 메서드 반환값 출력="+method(3,5));

	}

}

