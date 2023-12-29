package ex02variable;

public class E07TypeCasting {

	public static void main(String[] args) {
		
		/*
		자동형변환 : 작은 자료형의 데이터를 큰 자료형에 대입하면 자동으로 형변환이 일어나는 것
		 */
		byte b1 = 65;
		short s1;
		// byte가 short보다 작은 자료형이므로 자동 형변환됨
		s1 = b1;
		System.out.printf("b1은 %d, s1은 %d%n", b1, s1);
		
		/*
		하단은 자동 형변환이 아님
		- int보다 작은 자료를 연산할 때는 int로 간주하여 진행하므로 결과도 int로 반환됨
		- 따라서 int형에 최적화된 CPU의 특성이라고 보면 됨
		 */
		int num1 = b1 + s1;
		System.out.println("num1은 "+ num1);
		
		// char형(문자 타입)에 byte형(정수타입)을 바로 대입할 수는 없으므로 강제 형변환이 필요함
		// char ch1 = b1;
		char ch2 = (char)b1;
		System.out.println("b1=" + b1 +", ch2="+ ch2);
		
		/*
		명시적 형변환 : 큰 상자의 자료를 작은 상자의 자료형에 할당해야 할 때 사용함
		- 단 자료의 손실이 있을 수 있으므로 꼭 필요한 경우에만 사용
		- 표현할 수 있는 안에서만 표현이 됨
		ex) byte의 경우 -127에서 128까지만 표현할 수 있으므로, 129가 나오면 한 바퀴 돌아서 -127로 표현됨
		 */
		short s2 = 100;
		byte b2 = (byte)s2;
		System.out.printf("데이터미손실:b2=%d, s2=%d\n", b2, s2);
		
		/*
		소수점 아래 부분이 버려지므로 데이터 손실이 있음
		- 원 단위 절삭 등의 형태에서 사용
		 */		
		int num3;
		double dl = 3.14;
		num3 = (int)dl;
		// %.2f는 정수부 모두 출력 + 소수부 2자리까지만 출력
		System.out.printf("데이터손실:num3=%d, dl=%.2f %n", num3, dl);
		
		/*
		문자는 메모리에 저장 시 아스키코드로 저장되므로 int와의 연산을 진행한 후 문자로 표현하고 싶다면 char로 강제 형변환해야 함
		 */
		char ch3 = 'A', ch4;
		int num4 = 2;
		// ch4 = ch3 + num4;
		ch4 = (char)(ch3 + num4);
		System.out.println("ch4="+ ch4);
		
	}

}
