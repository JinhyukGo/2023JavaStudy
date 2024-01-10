package ex11static;

/*
static 블럭 : 동일 클래스 내 main() 메서드보다 먼저 실행되는 블럭
 - main 메서드의 실행코드가 없어도 먼저 실행됨
 - 생성자보다도 먼저 실행됨
 - 따라서 프로그램에서 전처리를 해야하는 경우 사용
 */

public class E02StaticBlockMain {
	 
	// 인스턴스 멤버
	int instanceVar;
	void instanceMethod() {}
 
	// 정적 멤버
	static int staticVar;
	static void staticMethod() {
		int localVar;
		System.out.println("정적메소드");
	}
 
	// static 블럭 정의
	static {
 
		staticVar = 1000;		
 
		int localVar;
		localVar = 1000;
		System.out.println("localVar="+ localVar);
		
		// static 블럭 내에서는 인스턴스형 멤버를 사용할 수 없음
		// System.out.println("instanceVar="+ instanceVar);  
		// instanceMethod();
 
		// 정적 멤버는 사용 가능
		System.out.println("staticVar="+ staticVar);
		staticMethod();
		
		System.out.println("===static block 끝===");
	}
	
	// 생성자 메서드 정의 : 생성자에서는 정적 멤버에 접근이 가능함 / 일반적인 멤버 변수와 동일
 
	public E02StaticBlockMain() {
 
		staticVar = -1;
		System.out.println("==StaticBlock의 생성자==");
	}
	public static void main(String[] args) {
		
		System.out.println("==메인메소드==");
		// static 블럭 내에서 선언된 변수는 지역변수이므로, main 메서드에서는 사용할 수 없음 / 해당 지역 내에서만 사용 가능
		// System.out.println("localVar="+ localVar);
		 
		// new를 통해 해당 클래스의 인스턴스를 생성
		new E02StaticBlockMain();
	}
}
