package ex13interface;

/*
인터페이스(interface)
 - 클래스가 객체의 설계도라면 인터페이스는 클래스간의 설계도라 할 수 있음
 - 자바는 단일 상속을 원칙으로 하지만, 인터페이스는 다중 상속을 구현 가능
 - 추상클래스와 동일하게 상속을 목적으로 제작되므로 구현받은 하위클래스에서는 추상메서드를 반드시 오버라이딩해야 함
 - 멤버로는 추상메서드와 정적상수만 선언 가능
  메서드 : public abstract
  상수 : public static final
 - 인터페이스는 생성자를 선언할 수 없음
 */

interface MyInterface1 {
	// 생성자 사용 불가
	// public MyInterface1() {}
	
	/*
	멤버상수 : 인터페이스에 선언되는 변수는 상수로 선언됨
	따라서 반드시 대문자로 작성해야 함
	public static final은 써도 관계없으나, 생략가능하므로 생략하는 것이 좋음
	 */
	// public static final int MAX_INT = Integer.MAX_VALUE;
	int MAX_INT = Integer.MAX_VALUE;
	double MAX_DBL = Double.MAX_VALUE;
	
	/*
	멤버메서드 : 인터페이스에 선언되는 메서드는 추상메서드로 선언됨
	따라서 public abstract는 생략가능하므로 생략하는 것이 좋음
	 */
	// public abstract void absFunc1();
	void absFunc1();
	void absFunc2();
}
interface MyInterface2 {
	void absFunc2();
}
// 일반적인 클래스 선언
class SimpleClass {
	int simple = 1;
	void mySimple() {
		System.out.println("simple = " + simple);
	}
}
/*
인터페이스는 콤마를 이용해서 여러 개의 인터페이스를 "구현"할 수 있음
또한 "상속"과 "구현"을 동시에 사용할 수도 있음
 */
class MyClass extends SimpleClass implements MyInterface1, MyInterface2 {
	/*
	인터페이스에 동일한 이름의 추상메서드가 존재하는 경우 하나만 오버라이딩하면 됨
	오버라이딩은 항상 자식쪽의 메서드가 호출되므로 아무런 문제도 발생하지 않음
	 */
	@Override
	public void absFunc1() {
		System.out.println("absFunc1() 호출됨");
	}
	@Override
	public void absFunc2() {
		System.out.println("absFunc2() 호출됨");
	}
	
	/*
	SimpleClass 클래스의 멤버메서드는 오버라이딩이 필수가 아니므로 필요한 경우에만 하면 됨
	 */
}

public class E03InterfaceMain {

	public static void main(String[] args) {

		/*
		"구현"한 인터페이스를 통해 참조변수로 선언 가능
		즉 "상속", "구현" 모두 해당 클래스의 부모클래스가 되므로 아래와 같이 참조변수로 선언할 수 있음
		 */
		MyInterface1 my1 = new MyClass();
		// MyInterface1 my2 = new MyClass();
		// SimpleClass my3 = new MyClass();

		// 오버라이딩한 메서드는 항상 자식클래스에 정의한 것이 호출됨
		my1.absFunc1();
		my1.absFunc2();
		// 다른 부모클래스의 멤버에 접근하려면 캐스팅(형 변환) 후 호출해야 함
		((SimpleClass)my1).mySimple();
		
		// MyClass의 부모는 모두 3개이므로 아래는 모두 참조가능
		MyInterface2 my2 = new MyClass();
		SimpleClass simpleClass = new MyClass();		
	}
}
