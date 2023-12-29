package ex03operator;

public class E01ArithOperator {

	public static void main(String[] args) {
		
		int num1 = 7;
		int num2 = 3;
		// double num2 = 3;
		
		System.out.println("덧셈:"+(num1+num2)); //10
		System.out.println("덧셈:"+(num1+num2)); //4
		System.out.println("뺄셈:"+(num1-num2)); //21
		/*
		나눗셈 연산이라도 정수와 정수의 연산 결과는 정수가 나옴
		- 실수 결과를 얻기 위해서는 실수와 연산을 하거나 강제 형변환이 필요함
		- 실제로 위의 num2를 double로 형변환 후 나눗셈을 실행시키면 몫은 2.33333333333333335가 나옴
		 */
		System.out.println("나눗셈(몫):"+(num1/num2)); //2
		System.out.println("나눗셈(나머지):"+(num1%num2)); //1

		// 곱셈과 나눗셈이 덧셈과 뺄셈보다 우선순위가 높음
		int result = 3 * 2 + 5 % 2 - 6 / 3 * 5;
		System.out.println("결과는?"+ result); //-3
	}

}
