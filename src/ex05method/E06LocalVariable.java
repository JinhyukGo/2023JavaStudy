package ex05method;

public class E06LocalVariable {
	
	/*
	지역 변수(local variable)
	- 변수는 사용범위(scope)를 가지고 있고, 해당 지역 내에서만 사용 가능
	- 해당 지역을 벗어나면 즉시 메모리에서 소멸됨
	- 기본 자료형은 스택(stack)이라는 메모리를 사용
	- stack은 입구가 하나만 있는 컵과 같은 형태이며, 선입후출의 특성
	- 또한 스택은 CPU가 메모리의 생성 및 소멸을 주관
	 */

	public static void main(String[] args) {

		boolean scope = true;
		
		// main 지역에서 num을 선언하면 그보다 좁은 지역인 if문에서는 같은 이름의 변수를 선언할 수 없음
		// 큰 지역에서 이미 선언되어 메모리에 상주하고 있기 때문
		// int num = 9; => 아래 코드에서 에러 발생하여 주석 처리
		
		// main보다 좁은 지역인 if문의 블럭을 생성한 후 변수 num을 선언함
		// 단 if문과 else문은 서로 다른 지역이므로 동일한 이름의 변수 선언 가능
		if(scope) {
			// Duplicate local variable num
			int num = 1;
			num++;
			System.out.println("첫 번째 if문 지역 : " + num);
		} else {
			int num = 5;
			System.out.println("첫 번째 if문의 else 지역 : " + num);
		}
		
		// if문의 블럭에서 선언된 변수 num은 해당 블럭을 벗어나는 순간 메모리에서 소멸되므로 아래에서 num을 새롭게 선언할 수 있음
		int num = 100;
		System.out.println("main 메소드 지역 : " + num);
		
		simpleFunc();
		
		System.out.println("main 메소드 끝");
	}
	
	// main에서 선언한 변수 num은 메모리에 아직 상주하고 있지만 해당 메서드는 크기가 동일한 서로 다른 지역에서 정의되었으므로 같은 이름의 변수 선언 가능
	// 앞의 main 메서드의 if ~ else문의 블럭도 같은 개념
	static void simpleFunc() {
		int num = 1000;
		System.out.println("simple 메소드 지역 : " +  num);
	}

}
