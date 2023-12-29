package ex03operator;

public class E06PrePostFixOperator {

	public static void main(String[] args) {

		/*
		증감연산자 : 변수를 +1 혹은 -1하는 것 등을 반복함
		- 주로 반복문에서 사용함
		- Prefix : 전위(증감) 연산자
		 : 연산자가 변수 앞에 있는 케이스
		 : 변수의 값이 먼저 변경된 후 변경된 값이 다른 코드에 반영됨
		- Postfix : 후위(증감) 연산자
		 : 연산자가 변수 뒤에 있는 케이스
		 : 변수의 값이 먼저 다른 코드에 반영된 후 변수의 값이 변경됨
		 */
		int num1 = 7;
		int num2, num3; // 현재상태 : 7, x, x
		num2 = ++num1; /*
						1. num1의 값이 먼저 증가함 : 8, x, x
						2. 증가된 num1이 num2에 대입됨 : 8, 8, x
		*/
		num3 = -- num1; /*
						1. num1의 값이 먼저 감소함 : 7, 8, x
						2. 증가된 num1이 num3에 대입됨 : 8, 8, 7 => 결과
		*/
		System.out.println("전위증가/감소 시");
		System.out.printf("num1=%d, num2=%d, num3=%d %n%n", num1, num2, num3);
		
		num1 = 7; // 현재상태 : 7, 8, 7
		num2 = num1++; /*
						1. num1의 값이 num2에 먼저 대입됨 : 7, 7, 7
						2. num1의 값이 나중에 증가함 : 8, 7, 7
		*/ 
		num3 = num1--; /*
						1. num1의 값이 num3에 먼저 대입됨 : 8, 7, 8
						2. num1의 값이 나중에 감소함 : 7, 7, 8 => 결과
		*/
		
		System.out.println("후위증가/감소 시");
		System.out.printf("num1=%d, num2=%d, num3=%d", num1, num2, num3);
	}

}
