package ex13interface;

/* 
추상 클래스
 - 상속을 목적으로 제작되므로 인스턴스 생성은 허용하지 않음
 - 추상클래스는 대부분 추상 메서드를 포함하고 있으므로, 이를 상속받는 클래스는 반드시 추상메서드를 오버라이딩 해야 함
 - 클래스의 상속관계에서 설계도와 같은 역할
 - 인스턴스 생성은 할 수 없지만 그 외 참조변수, 상속 등의 모든 기능은 사용 가능
 
추상 메서드
 - 오버라이딩의 목적으로 제작
 - 메서드의 실행부가 없으므로 중괄호 대신 세미콜론으로 마무리 
*/

// 추상클래스1 : 추상 메서드를 포함하지 않은 클래스
abstract class AbsClass1 {
	// int형으로 표현할 수 있는 최대값을 정적상수로 선언
	public static final int MAX_INT = Integer.MAX_VALUE;
	
	// 일반적인 멤버 메서드
	void instanceMethod() {}
	// 정적 메서드
	static void staticMethod() {}
}
// 추상 메서드를 포함하지 않은 추상 클래스를 상속하면 오버라이딩은 강제사항이 아닌 선택사항
// 즉 필요한 경우에만 오버라이딩하면 됨
// 따라서 아래 오버라이딩 메서드는 삭제해도 에러가 발생하지 않음
class AbsClassChild1 extends AbsClass1 {
	@Override
	void instanceMethod() {
		System.out.println("선택적 오버라이딩");
	}
}
// 추상 클래스2 : 추상 메서드를 포함한 클래스
// 추상 메서드를 멤버로 포함한 클래스는 반드시 abstract로 선언해야 함 그렇지 않으면 에러 발생
abstract class AbsClass2 {
	abstract void absMethod(int number);
}
/*
위 클래스를 상속하면 부모가 가진 추상 메서드를 그대로 상속하게 되므로 해당 클래스도 abstract로 선언해야 함
단, 이 경우 해당 클래스로도 인스턴스를 생성할 수 없게 됨
따라서 인스턴스를 생성하기 위해서는 부모의 추상 메서드를 자식쪽에서 오버라이딩해야 함
 */
class AbsClassChild2 extends AbsClass2 {
	// 오버라이딩은 부모쪽의 메서드를 재정의하는 것이므로 해당 클래스는 추상 메서드를 포함하지 않은 상태가 됨
	// 따라서 인스턴스 생성이 가능해짐
	@Override
	void absMethod(int number) {
		System.out.println("필수 오버라이딩");
	}
	void newMethod() {
		System.out.println("확장한 메서드");
	}
}

public class E01AbstractMain {

	public static void main(String[] args) {

		// 추상 클래스는 인스턴스를 생성할 수 없음
		// AbsClass1 absClass1 = new AbsClass1();
		
		// 추상 클래스를 상속한 하위 클래스는 인스턴스 생성을 할 수 있음
		AbsClassChild1 absClassChild1 = new AbsClassChild1();
		
		// 추상 클래스는 인스턴스 생성은 안 되지만, 참조 변수로 사용은 가능
		AbsClass2 absClass2 = new AbsClassChild2();
		// 부모쪽의 멤버 메서드는 호출할 수 있음
		absClass2.absMethod(100);
		// 자식쪽은 접근할 수 없으므로 다운캐스팅을 해야 함
		((AbsClassChild2)absClass2).newMethod();
		
		// 추상 클래스 내에 선언된 정적 메서드는 오버라이딩의 대상이 될 수 없으므로 static의 기본 규칙을 따름
		// 별도의 생성 절차 없이 클래스명으로 바로 접근할 수 있음
		AbsClass1.staticMethod();
		AbsClassChild1.staticMethod();
		System.out.println("int형의 최대값 : " + AbsClass1.MAX_INT);
	}
}
