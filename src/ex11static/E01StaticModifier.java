package ex11static;

/*
static variable (정적 변수 혹은 메서드)
- 멤버 변수에 static 키워드를 붙이면 정적 변수가 됨
- 정적 변수는 JVM(자바 가상 머신)에 의해 프로그램이 시작되는 시점에 초기화됨
- main() 메서드가 실행되기 전에 초기화되므로 main() 메서드 실행 시 별도의 인스턴스 선언없이 변수 사용 가능

접근 방법
- 클래스 내부 : 변수명으로 접근할 수 있음 / 일반적인 멤버 변수와 동일하게 접근
- 클래스 외부
 1. 인스턴스 변수를 통해 접근 (권장사항 아님)
 2. 인스턴스 생성없이 클래스명으로 직접 접근 (권장사항)
- 메서드 앞에 static을 붙이면 정적 메서드가 됨 / 정적 변수와 모든 특성 동일
 */

class MyStatic {
	/*
	멤버 변수 : 인스턴스형 멤버 변수는 반드시 클래스의 인스턴스를 생성한 후 참조 변수를 통해 접근해야 함
	 - 즉 일반적인 멤버 변수는 인스턴스를 생성하는 시점에 메모리에 로드됨
	 (멤버 변수는 stack 영역에, 인스턴스는 Heap 영역에 생성됨)
	 */
	
	int instanceVar;
	
	/*
	정적 멤버 변수 : 인스턴스를 생성할 필요 없이 클래스명으로 바로 접근 가능
	 - JVM(자바 가상 머신)이 프로그램을 시작할 때 이미 메모리(Method 영역)에 로드됨
	 */
	static int staticVar;
	
	// 인스턴스형 멤버 메서드 : 인스턴스형 메서드에서는 모든 멤버를 사용 가능
	// 인스턴스형 멤버, 정적 멤버 둘 다 접근 가능
	void instanceMethod() {
		System.out.println("instanceVar=" + instanceVar);
		System.out.println("staticVar=" + staticVar);
		staticMethod();
	}
	// 정적 멤버 메서드 : 정적 메서드 내부에서는 인스턴스형 멤버에 접근할 수 없음 / 정적 멤버에만 접근 가능
	// ex) main 메서드에서는 static으로 선언된 메서드만 호출할 수 있었음
	static void staticMethod() {
		// 에러 발생 
		// System.out.println("instanceVar=" + instanceVar);
		System.out.println("staticVar=" + staticVar);
		// 에러 발생
		// instanceMethod();
	}
}

public class E01StaticModifier {

	public static void main(String[] args) {
		
		// 일반적인 멤버 변수에 접근하는 방법 : MyStatic 클래스의 인스턴스를 생성한 후 참조변수를 통해 접근
		MyStatic myStatic = new MyStatic();
		myStatic.instanceVar = 100;
		System.out.println("myStatic.instanceVar=" + myStatic.instanceVar);
		
		// static(정적) 멤버 변수 접근 방법 : 클래스명을 통해 직접 접근
		// 인스턴스를 생성하지 않고 즉시 접근 가능
		MyStatic.staticVar = 200;
		System.out.println("myStatic.staticVar=" + myStatic.staticVar);

		// The static field MyStatic.staticVar should be accessed in a static way
		// 정적 변수도 일반적인 멤버 변수처럼 참조 변수를 통해 접근할 수는 있지만 Java에서는 권장하지 않음
		// 참조 변수를 통해 접근할거면 굳이 정적 변수를 사용할 이유가 없기 때문
		myStatic.staticVar = 300;
		System.out.println("myStatic.staticVar=" + myStatic.staticVar);
		
		// 2개의 인스턴스를 생성 / 메모리(Heap 영역)에는 ms1, ms2가 각각 생성됨
		MyStatic ms1 = new MyStatic();
		MyStatic ms2 = new MyStatic();
		
		// 각 인스턴스 내부에 존재하는 변수를 아래와 같이 초기화함
		ms1.instanceVar = 100;
		ms2.instanceVar = 1000;
		// 아래 2개의 값은 서로 다르게 출력됨
		System.out.println("ms1.instanceVar=" + ms1.instanceVar); // 100
		System.out.println("ms2.instanceVar=" + ms2.instanceVar); // 1000

		// 하지만 정적 변수는 메모리(Method 영역)에 딱 하나만 생성되므로 어떤 인스턴스 변수로 접근하든 동일한 메모리가 됨
		// 따라서 값을 공유하게 되므로 동일한 결과를 출력하게 됨
		ms1.staticVar = 800;
		ms2.staticVar = 900;
		System.out.println("ms1.staticVar=" + ms1.staticVar); // 900
		System.out.println("ms2.staticVar=" + ms2.staticVar); // 900
		
		// 입력 시에는 각각의 참조 변소를 사용했지만, 하나의 정적 변수에 값을 입력하 결과가 되므로 정적 변수에 접근 시에는 참조 변수를 사용하지 않고 클래스명을 사용해야 함
		
		// 정적 멤버 메서드에 접근하는 방법은 정적 변수와 동일함
		// 참조 변수를 통해서는 인스턴스형, 정적형 둘 다 접근 가능
		myStatic.instanceMethod();
		myStatic.staticMethod(); // 권장사항 아님
		
		// MyStatic.instanceMethod(); // 에러 발생		
		MyStatic.staticMethod();
		
		// 결론 : 일반적인 인스턴스형 멤버는 인스턴스 참조 변수를 통해 접근
		// 정적(static) 멤버는 클래스명을 통해 인스턴스 생성없이 접근함
		
		
	}

}
