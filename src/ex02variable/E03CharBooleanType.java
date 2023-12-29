package ex02variable;

public class E03CharBooleanType {

	public static void main(String[] args) {
		
		/*
		char형 : 하나의 문자를 저장할 수 있는 자료형으로 값을 저장할 때 ''(Single Quotation)으로 감싸서 표현함
		        ""(Double Quotation)으로 감쌀 경우, 문자열로 인식되므로 이때는 String으로 선언해야 함
		 */
		char ch1 = '가';
		// 문자열이므로 char로 선언 시 에러 발생
//		char chStr = '가나다라';
		String chStr = "가나다라";
		System.out.println("ch1 = " + ch1);
		System.out.println("chStr = " + chStr);
		
		/*
		아스키 코드 : 1byte로 표현할 수 있는 문자
		- 영문, 숫자를 십진수로 정의한 것을 의미함
		ex) A : 65 / a : 97
		유니코드 : 1byte로 표현할 수 없는 문자
		- 영문, 숫자를 제외한 모든 문자
		- 한글, 한자 등
		- 보통 숫자가 크기 때문에 16진수로 표현함
		 */
		
		char ch2 = 'A'; // 메모리에는 65로 저장됨
		int num1 = 2; // 정수형 변수를 선언
		// 문자 + 정수의 형태이나 아스키코드로 저장되므로 연산 가능
		int num2 = ch2 + num1; 
		// 정수로 출력하면 67
		System.out.println("num2 =" + num2);
		// 문자로 출력하면 C
		System.out.println("(char)num2 = " + (char)num2);
		
		// (char)(char+int : int) => char형으로 강제 형변환
		char ch3 = (char)(ch2 + num1);
		System.out.println("ch3(문자출력) => " + ch3);
		System.out.println("ch3(아스키코드 출력) => " + (int)ch3);
		
		// 문자1 = 아스키코드 49
		char ch4 = '1';
		// 49 + 1 = 50이므로 이에 해당하는 문자는 2
		char ch4_1 = '1' + 1;
		// 문자 2와 정수 50이 출력됨
		System.out.println("ch4 = " + ch4 + ", ch4_1 = " + ch4_1 + ", ch4_1 =" + (int)ch4_1);

		/*
		boolean 타입 : true 혹은 false의 두 가지 값만 가질 수 있는 자료형으로 산술연산(+,-), 비교연산(<,<=)에서는 사용할 수 없고, 오직 논리연산에서만 사용 가능
		 */
		boolean bn1 = true;
		boolean bn2 = false;
		System.out.println("bn1 = " + bn1 + ", bn2 = " + bn2);
		
		// && : 논리 And / 양쪽 모두 참일 때만 참을 반환 그 외는 모두 거짓을 반환
		// || : 논리 Or / 둘 중 하나만 참이어도 참을 반환, 둘 다 거짓인 경우에는 거짓을 반환
		boolean bn3 = bn1 && bn2;
		System.out.println("bn3(And) = " + bn3);
		bn3 = bn1 || bn2;
		System.out.println("bn3(Or) = " + bn3);
		
		// 문자 '가'는 유니코드 44032로 표현되므로 true
		bn3 = '가' > 30000;
		System.out.println("bn3 = " + bn3);

	}

}
