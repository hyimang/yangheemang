/**두자리 정수 num 선언
만약 두자리 정수 num이 짝수이고, num의 앞자리수와 뒷자리 수의 합이 7이면 Lucky!출력 아니면 Bad! 출력
**/
public class Study4 {
	public static void main(String[] args) {
		//num이 1이면 1입니다. 2면 2입니다. 3입니다. 그외 나머지는 123이 아닙니다.
		int num = 2;
		switch(num) {
		 case 1:
			 System.out.println("1입니다.");
			 break;
		 case 2:
			 System.out.println("2입니다.");
			 break;
		 case 3:
			 System.out.println("3입니다.");
			 break;
		 default:
			System.out.println("123이 아닙니다.");
		}
		
		
	}
}


