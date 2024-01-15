package ex16exception;
class A {
	
}
class B extends A {
	
}

public class Test {

	public static void main(String[] args) {

		B b1 = new B();
		A a1 = new A();
		B b2 = (B) a1;
	}
}
