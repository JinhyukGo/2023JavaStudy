package ex03operator;

public class E02BokhapOperator {

	public static void main(String[] args) {
		
		/*
		복합대입연산자 : 산술연산자와 대입연산자를 연결해놓은 형태로 좌우측의 값을 연산하여 좌측의 변수에 대입하는 구조
		- 문법의 구조상 항상 현재의 타입을 유지하는 특성		
		 */

		double e = 3.1;
		e += 2.1; // 5.2
		e *= 2; // 10.4
		e += e; // 20.8
		System.out.println("e의 결과값:"+e);
		
		int n = 5;
		// 정수와 실수를 연산하면 실수의 결과가 나오므로 int가 되지 못해 에러가 발생함
		// n = n * 2.7;
		// 에러를 발생하지 않게 하기 위해 아래처럼 강제 형변환을 함 / 대신 소수점이 절삭됨 - 값이 달라질 수 있음
		n = (int)(n * 2.7);
		// 강제형변환을 하지 않고도 하단의 복합대입연산자를 사용하면 해결됨
		n *= 2.7;
		System.out.println("n의 결과값:"+ n);
	}

}
