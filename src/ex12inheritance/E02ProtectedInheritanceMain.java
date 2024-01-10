package ex12inheritance;

// 부모 클래스와 다른 패키지에 선언되었으므로 import 해야 함
// 클래스 앞에 선언할 수 있는 건 default / public 두 가지 뿐이며, public으로 선언해야만 import 가능
import ex12inheritance.map.Korea;

// 자식 클래스에서 Korea를 상속
class Seoul extends Korea {
	
	// 멤버 변수와 생성자 정의
	private String city;
	public Seoul(String name, String city) {
		// 자식 클래스에서는 반드시 부모 클래스의 생성자 호출을 통해 먼저 인스턴스를 생성
		// 그 후 자식 인스턴스가 메모리에 생성됨
		super(name); // 부모 생성자 호출
		this.city = city;
	}
	
	// 4개의 접근 지정자를 통해 정의한 메서드를 호출
	// 단 부모 클래스가 다른 패키지에 선언되었으므로 default, private 멤버는 호출할 수 없음
	public void callMethod() {
		super.publicMethod("callMethod->");
		super.protectedMethod("callMethod->");
		// 직접 접근할 수 없는 메서드는 접근 가능한 멤버 메서드를 통해 간접 호출하면 됨
		// super.defaultMethod();
		// super.privateMethod();
	}
}

public class E02ProtectedInheritanceMain {

	public static void main(String[] args) {

		Seoul seoul = new Seoul("대한민국", "서울");
		seoul.callMethod();
	}
}
