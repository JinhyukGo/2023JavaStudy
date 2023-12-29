package ex05method;

/*
재귀메서드(Recursive method) : 하나의 메서드에서 자신을 재귀적으로 호출하여 작업을 수행하는 방식
- 반복문의 형태로 동작
- 순환호출이라고 표현하기도 함
 */

public class E08RecursiveMethod {

	static int factorial(int number) {
		int result;
		if(number == 1) {
			// 매개변수의 값이 1인 경우, 1을 반환 (더이상 재귀호출하지 않음)
			result = 1;
		} else {
			// 1이 아닌 경우에는 자신의 메서드를 재귀호출함
			result = number * factorial(number - 1);
		}
		System.out.println("계산 과정 : number = " + number + ", result = " + result);
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println("재귀함수를 이용한 팩토리얼 구하기");
		System.out.println("4factorial : " + factorial(4));
		System.out.println("10factorial : " + factorial(10));

	}

}
