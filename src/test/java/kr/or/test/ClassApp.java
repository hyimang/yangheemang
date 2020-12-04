package kr.or.test;
//오리지널 자바프로그램 형식, 스프링웹프로그램과 다른 형식
public class ClassApp {

	public static void main(String[] args) {
		// 클래스의 진입메서드 main 실행
		Circle c = new Circle(5);//c라는 인스턴스(클래스)변수 c 생성, new 키워드 생성자 circle(반지름값5)
		//위에서 new키워드는 메모리에 프로그램 실행공간을 새로 할당하는 얘기
		Circle c2 = new Circle(10);
		//Circle클래스를 c이름으로 prefix해서 사용하는 것
		//자바프로그램의 특징은 OOP프로그래밍의 대표적인 사례, Object=위에서 new키워드로 생성한 c 오브젝트
		//자바에서 OOP를 사용방식을 설명하는 예, 스프링에서 new키워드 대신@Inject를 주로 사용
		double print_result = c.getyangheemang();
		//System.out.println("첫번째 원의 넓이는" + print_result + "입니다.");
		double print_result2 = c2.getyangheemang();
		//System.out.println("두번째 원의 넓이는" + print_result2 + "입니다.");
		//아래 new키워드 생성자를 이용해서 오브젝트를 2개 만들었음
		Employee employee = new Employee();
		Salesman salesman = new Salesman();
		Development development = new Development();
		//employee.doJob();
		//salesman.doJob();
		//development.doJob();
		GraphicObject graphicObject = new Triangle();
		graphicObject.draw();
	}

}


//메서드 오버라이드(메서드이름이 같은 것을 실행-상속관계) 와
//메서드 오버로드(한개의 클래스에서 매서드 이름은 고유값이라서 중복해서 사용할 수 없음. 단, 매개변수(인자값)이 다르면 가능합니다

//추상클래스에 대한 연습
//추상클래스 또는 인터페이스를 사용하는 목적은 두꺼운 책에서 목차를 만드는것과 독같은 역할
abstract class GraphicObject {
	int x,y;//그래픽오브젝트 클래스 멤버변수 선언
	abstract void draw();//명세표만 있고 구현내용이 없는(인터페이스) 추상메서드 선언
	//다른 해석하면, 책에서 목차만 잇고, 내용이 없는 구조. 내용은 별도의 클래스에 있음
}
class Triangle extends GraphicObject {

	@Override
	void draw() {
		System.out.println("  *");
		System.out.println(" * * ");
		System.out.println("*****");
		
	}
	
}

//클래스 상속에 대한 연습
class Employee {//회사의 모든 직원들 클래스
	int nSalary;//회사직원 봉급변수 멤버변수
	String szDept;//회사직원의 부서명 멤버변수
	public void doJob() {
		System.out.println("환영합니다. 직원분들!");
	}
}
class Salesman extends Employee {
	public Salesman() {//클래스명과 똑같은 메서드를 생성자 메서드입니다.
		szDept = "판매부서";//부모클래스 Employee의 szDept 멤버 변수를 자식클래스에서도 사용가능
	}
	public void doJob() {
		System.out.println("환영합니다." + szDept + "입니다.");
	}
}
class Development extends Employee {
	public Development() {szDept="개발부서";}
	public void doJob() {
		System.out.println("환영합니다." + szDept + "입니다.");
	}
}

class Circle {
	int r;//멤버 변수 반지름
	public Circle(int a) {
		r = a;
	}
	public double getyangheemang() {
		return r*r*3.14;//원의 넓이를 반환
	}
}