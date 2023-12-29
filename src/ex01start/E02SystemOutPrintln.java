package ex01start;

/*
println() : 내용을 출력한 후 자동으로 줄바꿈 처리
print() : 출력 후 줄바꿈 처리를 하지 않음 / 줄바꿈이 필요한 경우, \n을 추가
printf() : 출력 내용을 서식에 맞춰서 출력 / \n 혹은 %n을 이용해서 줄바꿈 처리
           변수를 출력하는 서식문자에는 %d, %f 등이 있으며, %n은 printf()에서만 사용 가능
 */

public class E02SystemOutPrintln {

	public static void main(String[] args) {

		// 정수형 변수를 선언한 후, 100으로 초기화함
		int num1 = 100;
		
		// 문자열과 정수형 변수를 + 기호를 통해 연결한 후 출력
		System.out.println("num1=" + num1);
		System.out.print("num1="+ num1 +"\n");
		System.out.printf("num1=%d%n", num1);
		
		// 정수, 실수를 단순히 출력함
		System.out.println(7);
		System.out.println(3.14);
		
		/*
		print()문에서 +기호의 역할
		1. 숫자(정수 혹은 실수)끼리는 실제 덧셈 연산을 함
		2. 문자열, 숫자 등 서로 자료형이 다른 데이터끼리는 단순 연결만 함
		 */
		
		// 모두 정수이므로 + 연산
		System.out.println(3 + 5);//8
		System.out.println(3.5 + 5.1);//8.6
		
		// 숫자 + 문자열의 형태이므로, 단순 연결하여 출력함
		System.out.println("3+5="+ 8);
		System.out.println(3.15 +"는 실수입니다.");
		System.out.println("3.5" + " 의 연산결과는 8입니다.");
		
		/*
		앞에서 정수형으로 선언한 변수를 이용하여 값을 출력함
		문자열 + 정수 + 문자열이므로 연결되어 출력됨
		 */
		
		System.out.println("num1 은 "+ num1 +"입니다.");

	}

}
