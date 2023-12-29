package ex02variable;

public class E02SilsuType {

	public static void main(String[] args) {
		
		/*
		실수 자료형
		- 정수형보다는 실수형이 더 큰 자료형 (0과 1사이에 무수히 많은 실수가 있기 때문)
		- 따라서 long + float = float
		 */
		
		long long1 = 100;
		float float1 = 200;
		// 실수형으로 자동 형변환됨 / 결과는 300.0
		float result1 = long1 + float1;
		System.out.println("long1 + float1 = " + result1);
		
		/*
		float(실수형)과 long(정수형)의 연산 결과를 long형으로 받고 싶다면
		1. float을 long으로 강제형변환 후 연산
		2. 계산 결과를 long으로 강제형변환
		 */	
		long result2 = long1 + (long)float1;
		System.out.println("형변환 후 연산 = " + result2);
		long result3 = (long)(long1 + float1);
		System.out.println("계산 후 형변환 = " + result3);
		
		/*
		- 실수형의 기본은 double
		- 소수점이 있는 데이터를 컴파일러는 무조건 double로 인식함
		- 단 소수점이 없는 데이터는 float에 대입 가능
		- 소수점이 있는 데이터를 float에 대입하려면 접미사 F 혹은 f를 붙여야 함
		- 형변환 후 대입도 가능하지만 권장하지 않음
		 */
		float f3 = 100;
		// 3.14는 double로 인식되므로 에러가 발생함
//		float f4 = 3.14;
		
		// 강제 형변환 후 대입할 수는 있으나 권장하지는 않음
		float f4 = (float)3.14;
		System.out.println("f4 = " + f4);

		// 접미사를 통해 float형 자료임을 명시하는 것을 권장
		float f5 = 3.14F;
		System.out.println("f5 = " + f5);

		// float형끼리의 연산은 기본 규칙을 따름
		float f6 = f3 + f4;
		System.out.println("f6 = " + f6);

		// float + double => double형의 결과가 반환됨 (더 큰 자료형을 따라가는 방식)
		double d1 = 3.14;
		double d2 = f6 + d1;
		System.out.println("d2 = " + d2);
		
		/*
		- CPU는 실수 계산에 있어 기본적인 오차를 가지고 있음
		- Java의 문제가 아니라 컴퓨터 자체의 문제이므로 정확한 계산을 위해서는 약간의 보정이 필요함
		 */
	}

}
