package ex02variable;

public class E01JunsuType {

	public static void main(String[] args) {

		/*
		정수 자료형
		- byte, short, int, long의 4가지 타입
		- 각 자료형의 표현범위는 교안 참조
		- 일반적으로 CPU는 정수형 연산을 할 때 int형을 가장 빠르게 처리
		- 즉 정수형 변수를 사용할 때는 대부분 int형을 사용함
		 */
		
		// int형 변수를 선언한 후 초기값을 할당
		int int1 = 100;
		int int2 = 200;
		// result1의 결과값은 300이 나옴
		int result1 = int1 + int2;
		// int형끼리의 연산은 int형의 결과가 반환됨
		System.out.println("int1 + int2 = " + result1);

		/*
		100/200의 결과는 0이 나옴 (Java에서는 정수와 정수의 연산결과로 정수가 나오게 되기 때문)
		만약 실수 결과를 반환받고 싶다면 형변환(Type casting)을 해야 함
		 */
		result1 = int1 / int2;
		System.out.println("int1 / int2 = " + result1);
		
		/*
		- 동일한 타입의 변수를 2개 이상 선언하는 경우에는 , 사용 가능
		- int형보다 작은 자료형을 연산하면 cpu는 int형으로 변환하여 계산 (정수 연산인 경우 int형에 최적화되어 있기 때문)
		- byte, short형은 게임 캐릭터의 움직임이나 음원파일 등을 표현할 때 주로 사용함
		 */
		
		byte byte1 = 50, byte2 = 55;
		// byte + byte = int
		int result2 = byte1 + byte2;
		System.out.println("byte1 + byte2 = "+ result2);
		
		short short1 = 60, short2 = 70;
		// short + short = int
		int result3 = short1 + short2;
		System.out.println("short1 + short2 = " + result3);
		
		/*
		- 동일 자료형끼리의 연산은 동일 자료형이 되는 것이 기본 원칙
		- 큰 자료형과 작은 자료형을 연산하면 큰 자료형으로 자동 형변환됨 (데이터의 손실(오차)이 발생할 수 있기 때문)
		 */
		long long1 = 1000, long2 = 2000;
		// int + long = long
		long result4 = int1 + long1;
		System.out.println("int1 + long1 = " + result4);
		
		result4 = long1 + long2;
		System.out.println("long1 + long2 = " + result4);
		
		/*
		자바 컴파일러는 정수형 상수를 기본적으로 int형으로 간주하기 때문에 아래 정수를 메모리에 로드하는 순간 에러가 발생함
		이때 접미사에 L 혹은 l을 붙여서 int형이 아닌 long형임을 컴파일러에 알려야 에러가 나지 않음
		할당을 위해 입력되는 숫자도 자료형을 기반으로 메모리에 로드되는데, 이를 리터럴(literal)이라고 함
		
		 */
//		long long3 = 2200000000;
		long long4 = 2200000000L;
		long long5 = 2200000000l;
		
		System.out.println("long4 = " + long4);

	}

}
