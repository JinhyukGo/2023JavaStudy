package ex13interface;

interface MyInterface1 {
	// public MyInterface1() {}
	
	public static final int MAX_INT = Integer.MAX_VALUE;
	double MAX_DBL = Double.MAX_VALUE;
	
	public abstract void absFunc1();
	void absFunc2();
}
interface MyInterface2 {
	void absFunc2();
}
class SimpleClass {
	int simple = 1;
	void mySimple() {
		System.out.println("simple = " + simple);
	}
}
class MyClass extends SimpleClass implements MyInterface1, MyInterface2 {
	@Override
	public void absFunc1() {
		System.out.println("absFunc1() 호출됨");
	}
	@Override
	public void absFunc2() {
		System.out.println("absFunc2() 호출됨");
	}
}

public class E03InterfaceMain {

	public static void main(String[] args) {

		MyInterface1 my1 = new MyClass();
		my1.absFunc1();
		my1.absFunc2();
		((SimpleClass)my1).mySimple();
	}
}
