package ex14innerclass;

class A {
	void myFunc() {
		System.out.println("나는 A입니다.");
	}
}
class B {
	@Override
	void myFunc() {
		System.out.println("나는 B입니다.");
	}
}


public class Test {

	public static void main(String[] args) {
		A a = new A() {
			@Override
			void myFunc() {
				System.out.println("나는 익명클래스입니다.");
			}
		};
		a.myFunc();
	}

}
