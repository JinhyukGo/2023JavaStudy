package ex12inheritance;

// 부모 클래스
class Parent {
	int parentMember;
	void parentMethod() {
		System.out.println("부모의 메소드 : parentMethod()");
	}
}
// 자식 클래스
class Child extends Parent {
	int childMember;
	void childMethod() {
		System.out.println("자식의 메소드 : childMethod()");
	}
	// 부모에서 정의한 메서드를 오버라이딩해서 재정의한 메서드
	@Override
	void parentMethod() {
		System.out.println("자식에서 Overriding한 메소드" + "parentMEthod()");
	}
	// 메서드명은 동일하지만 매개변수가 다르므로 오버로딩으로 정의된 메서드 / 따라서 자식에서 확장한 멤버가 됨
	void parentMethod(int childMember) {
		this.childMember = childMember;
		System.out.println("Overloading : 자식에서 확장한 메서드" + " : parentMethod(int childMember)");
	}
}

public class E11Polymorphism {

	public static void main(String[] args) {

		// 동질화 : 참조변수와 인스턴스의 타입이 동일
		System.out.println("[자식으로 자식객체 참조 - 동질화]");
		Child homeChild = new Child();
		homeChild.childMember = 10;
		homeChild.parentMember = 100;
		homeChild.childMethod();
		homeChild.parentMethod(1000); // 오버로딩
 		homeChild.parentMethod(); // 오버라이딩
		
 		// 이질화 : 부모타입의 변수로 자식인스턴스를 참조하는 것
 		// 이 경우 자식 클래스에서 새롭게 정의한 멤버는 접근할 수 없음
 		// 만약 접근해야 한다면 자식타입으로 강제 형변환(다운캐스팅)해야 함
		System.out.println("[부모로 자식객체 참조 - 이질화");
		Parent parent1 = homeChild;
		parent1.parentMember = 1;
		// 부모타입으로 자식인스턴스에 접근할 수 없어 에러 발생
		// parent1.childMember = 1;
		// 오버라이딩한 메서드이므로 자식쪽이 호출됨
		parent1.parentMethod();
		
		// 부모 참조변수로 자식 인스턴스를 참조한 두 번째 변수 생성
		Parent parent2 = new Child();
		parent2.parentMember = 1;
		parent2.parentMethod();
		
		// 부모 참조변수로 접근하려면 강제형변환이 필요함 / 하지만 애라와 같이 기술하면 에러 발생
		// (Child)parent2.childMember
		// 소괄호를 하나 더 추가해서 parent2를 자식타입으로 형변환 후 멤버에 접근해야 함
		((Child)parent2).childMember = 1;
		((Child)parent2).childMethod();
		((Child)parent2).parentMethod();
		
		// 자식타입으로 형변환 이후에 해당 참조변수를 통해 자식 멤버에 접근 (위와 동일한 방법)
		Child child2 = (Child)parent2;
		child2.childMember = 1;
		child2.childMethod();
		child2.parentMethod(1);
		
		// Java에서 생성한 모든 클래스는 Object클래스를 상속함 / 따라서 모든 인스턴스는 Object의 참조변수로 참조가 가능
		// 또한 Object클래스에 정의된 모든 메서드를 별도의 선언없이 사용할 수 있고, 필요하다면 오버라이딩도 가능
		System.out.println("[클래스의 끝판왕 Object]");
		Object object = new Child();
		((Parent)object).parentMethod();
		
	}

}
