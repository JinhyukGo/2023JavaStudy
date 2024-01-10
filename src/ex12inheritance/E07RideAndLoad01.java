package ex12inheritance;

/*
상속 관계에서 오버로딩 vs 오버라이딩
오버로딩 : 메서드명은 같지만 매개변수의 개수, 타입, 순서가 다른 경우
 - 즉 서로 다른 메서드이므로 상속받은 하위클래스에서는 오버로딩된 모든 메서드가 포함됨
오버라이딩 : 메서드명, 매개변수, 반환타입까지 모두 동일한 메서드를 상속관계에 있는 하위클래스에서 재정의한 것
 - 이 경우 하위 클래스에서 정의한 메서드가 상위 클래스의 메서드를 가리게 되므로 항상 최하의 클래스의 메서드가 호출됨
 - 즉 오버라이딩은 참조 변수의 타입에 영향을 받지 않음
 */
class A {
	public void rideMethod() {
		System.out.println("A의 rideMethod");
	}
	public void loadMethod() {
		System.out.println("A의 loadMethod");
	}
}
class B extends A {
	// 오버라이딩으로 재정의된 메서드
	@Override
	public void rideMethod() {
		System.out.println("B의 rideMethod");
	}
	// 오버로딩으로 정의된 메서드 - 부모 클래스와 매개변수의 개수가 다름
	public void loadMethod(int num) {
		System.out.println("B의 loadMethod");
	}
}
class C extends B {
	// rideMethod()는 오버라이딩된 메서드로 상위 클래스에 정의된 멤버 메서드와 반환타입, 메서드명, 매개변수의 개수 및 타입이 모두 동일 : 똑같은 메서드
	@Override
	public void rideMethod() {
		System.out.println("C의 rideMethod");
	}
	// loadMethod()는 오버로딩된 메서드로 상위클래스에 정의된 멤버 메서드와 메서드명만 동일할 뿐 매개변수의 타입, 개수 등이 다르게 정의됨 : 다른 메서드
	public void loadMethod(double num) {
		System.out.println("C의 loadMethod");
	}
	/*
	따라서 C클래스로 인스턴스를 생성하면 오버라이딩된 메서드는 모두 가려지게 되어 C클래스에 정의된 메서드 하나만 남게 됨
	오버로딩된 메서드는 서로 다르므로 3개 모두 남게 됨
	 */
}

public class E07RideAndLoad01 {

	public static void main(String[] args) {

		// 부모 타입의 참조 변수로 자식 인스턴스를 참조할 수 있으므로 아래 문장은 모두 성립
		A ref1 = new C();
		B ref2 = new C();
		C ref3 = new C();
		
		/*
		기본 자료형의 경우에는 작은 타입이 큰 타입으로 자동 형변환되므로 아래와 같이 작성 가능
		클래스도 이와 마찬가지로 부모타입(큰 타입)으로 자식인스턴스(작은 타입)를 참조할 수 있음
		int a = 10;
		double b = 3.14;
		double c = 20; => 20(int)가 double로 자동형변환되어 할당됨
		*/

		// 참조변수에 관계없이 항상 최하위에 오버라이딩된 메서드가 호출됨
		// 즉 아래 부분은 모두 C클래스에 정의된 rideMethod()가 호출됨
		// 오버라이딩은 참조 변수의 영향을 받지 않음
		System.out.println("오버라이딩 처리된 메서드");
		ref1.rideMethod(); // 0
		ref2.rideMethod(); // 0
		ref3.rideMethod(); // 0
		
		// 부모로 자식을 참조하면 부모의 타입까지만 참조 가능
		System.out.println("오버라이딩 처리된 메서드");
		// C타입의 참조 변수를 통해서 인스턴스를 참조하면 모든 영역에 접근 가능 -> 모두 실행됨
		ref3.loadMethod();
		ref3.loadMethod(1);
		ref3.loadMethod(1.1);
		
		// B타입의 참조 변수를 통해서 인스턴스를 참조하면 B영역까지만 접근 가능 -> C영역은 에러 발생
		ref2.loadMethod();
		ref2.loadMethod(1);
		// ref2.loadMethod(1.1);

		// A타입의 참조 변수를 통해서 인스턴스를 참조하면 A영역까지만 접근 가능 -> B, C영역은 에러 발생
		ref1.loadMethod();
		// ref1.loadMethod(1);
		// ref1.loadMethod(1.1);
		
		///////////////////////////////////////////////////////////////////////////
		
		// 부모의 참조변수로 자식의 인스턴스를 참조할 수 있음
		// 좌측은 부모, 우측은 자식이므로 모두 가능한 문장
		A refNum1 = new B();
		A refNum2 = new C();
		B refNum3 = new C();

		// 같은 타입이므로 참조 가능
		C refAddr1 = new C();
		// B타입 -> C타입을 참조하므로 가능
		A refAddr2 = refAddr1;
		// A타입 -> C타입을 참조하므로 가능
		A refAddr3 = refAddr1;

		// A -> C 참조이므로 가능
		A refId1 = new C();
		// B -> A 참조이므로 불가능
		// B refId2 = refId1;
		// C -> A 참조이므로 불가능
		// C refId3 = refId1;

		// 자식으로 부모인스턴스를 참조하는 것은 기본적으로 불가능
		// 하지만 다운캐스팅(강제형변환)을 하면 참조 가능 (부모타입을 자식타입으로 변경하는 것)
		// 이는 클래스가 상속 관계에 있기 때문에 가능하고, 방식은 기본 자료형과 동일하게 소괄호를 이용
		B refId2 = (B)refId1;
		C refId3 = (C)refId1;
	}
}
