/**
for(초기화;조건식;증감식){}
1~10까지의 모든합 구하기
**/
public class Study6 {
	public static void main(String[] args) {
		int sum =0;
		for(int i = 1; i < 11; i++) {
			sum += i;
		}
		System.out.println("1부터 10까지의 합:" + sum);
	}
}


