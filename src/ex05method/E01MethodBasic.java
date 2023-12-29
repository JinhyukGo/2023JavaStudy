package ex05method;

import java.util.Scanner;

/*
메서드(함수)의 규칙
- Java에서 main 메서드는 무조건 public static void로 선언
- static으로 선언된 메서드는 static으로 선언된 메서드만 호출 가능
- 메서드 호출 후 반환값은 호출한 위치로 반환됨 / 이때 메서드는 메모리에서 소멸됨
- 반환값이 없는 void형 메서드도 실행이 완료되면 호출한 위치로 실행의 흐름이 돌아옴
 */

public class E01MethodBasic {

	/*
	메서드1 : 반환값 있음, 매개변수 있음 형태
	- 매개변수로 2개의 정수를 받아 합의 결과를 반환함
	- 반환값은 호출한 지점으로 반환됨
	 */
	public static int simpleFunc(int a, int b) 
	{
		int sum = a + b;
		return sum;
	}

	/*
	메서드2 : 반환값 없음, 매개변수 없음 형태
	- 전달받는 값없이 이름을 입력받은 후, namePrint()를 호출함
	- 이와 같이 반환값이 없는 경우에는 void를 명시해야 함
	 */
	public static void menuPrint()
	{
		System.out.println("당신의 이름은 무엇인가요?");
		Scanner scanner = new Scanner(System.in);
		String name = scanner.nextLine();
		namePrint(name);
	}
	
	/*
	메서드3 : 반환값 없음, 매개변수 있음 형태
	- 문자열을 인수로 전달받아 단순히 출력만하는 함수
	- 반환값이 없는 경우에는 실행이 종료되면 호출했던 지점으로 실행의 흐름이 이동됨
	 */
	public static void namePrint(String n)
	{
		System.out.println("제 이름은 : " + n + " 입니다.");
	}
	
	/*
	main 메서드는 Java에서 출발점(Entry point)의 역할
	- 직접 호출하지 않아도 자동으로 호출되어 프로그램이 실행됨
	 */
	public static void main(String[] args)
	{
		/*
		메서드를 호출할 때는 함수의 원형을 그대로 기술하면 됨
		매개변수가 있다면 개수만큼 포함
		개수가 다르거나 타입이 다르면 에러 발생
		 */
		// 반환값이 있는 메서드이므로 우측항 혹은 print()의 일부로 작성
		int result = simpleFunc(1, 2);
		System.out.println("1과 2를 전달한 결과 : " + result);
		System.out.println("10과 20을 전달한 결과 : " + simpleFunc(10, 20));
		
		// 반환값이 없는 메서드는 보통 단독 작성
		menuPrint();
		
		// main함수의 종료는 해당 프로그램의 종료로 이어짐
	}
}
