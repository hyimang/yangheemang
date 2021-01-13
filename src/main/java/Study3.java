/**두자리 정수 num 선언
만약 두자리 정수 num이 짝수이고, num의 앞자리수와 뒷자리 수의 합이 7이면 Lucky!출력 아니면 Bad! 출력
**/
public class Study3 {
	public static void main(String[] args) {

		int num = 62;
		
		if(num % 2 ==0 && (num/10) + (num%10) ==7) {
			System.out.println("Lucky!");
		} else {
			System.out.println("Bad!");
		}
	
		
		
	}
	}


