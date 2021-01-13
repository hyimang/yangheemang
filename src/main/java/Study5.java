/**switch로
만약에 position이 부장이면 700만원, 과장이면 500만원, 사원이면 300만원, 그외 측정불가능
**/
public class Study5 {
	public static void main(String[] args) {
		
		String position = "사장"; 
		switch(position) {
		 case "부장":
			 System.out.println("700만원");
			 break;
		 case "과장":
			 System.out.println("500만원");
			 break;
		 case "사원":
			 System.out.println("300만원");
			 break;
		 default:
			System.out.println("측정불가능");
		}
		
		
	}
}


