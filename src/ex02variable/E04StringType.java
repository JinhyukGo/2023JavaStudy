package ex02variable;

public class E04StringType {

	public static void main(String[] args) {
		
		/*
		String 클래스 : 참조형 변수로, 기본 자료형이 아닌 클래스로 문자열을 저장하고 조작하는 기능
		- 표현할 때는 ""를 사용함
		- 연결 시에는 +를 사용함
		 */
		
		int number;
		number = 99;
		
		/*
		클래스를 통해 생성한 참조형 변수와 기본 자료형 변수 사이에서는 형변환 불가능 (서로 사용하는 메모리 공간이 다르기 때문)
		- 기본 자료형 : 스택(Stack) 영역을 사용
		- 참조형(클래스) 변수 : 힙(Heap) 영역을 사용
		int와 String 사이에서는 형변환이 되지 않으므로 아래의 두 문장은 모두 에러 발생
		 */
//		int stringNumber1 = (int)"100";
//		String stringNumber2 = (String)100;
		
		// String + int : 단순 연결만 되어 출력됨
		String strNumber = "100";
		System.out.println(strNumber + number);
		
		// String은 클래스이므로 new를 사용해서 변수를 생성함		
		String newString = new String("new 키워드 사용");
		System.out.println(newString);
		
		// String 변수는 주로 더블 쿼테이션을 이용하여 생성
		String stringBasic = "클래스지만";
		String plusString = "기본자료형처럼 사용";
		System.out.println(stringBasic + "" + plusString);
		
		int kor=100, eng=99, math=98;
		// ()가 없으므로 String + int + int + int 형태로 인식됨 => 모두 더해진 문자 형태
		System.out.println("총점 : " + kor + eng + math);
		// ()가 있으므로 String + (int + int + int) 형태로 인식됨 => String + int끼리의 합 문자 형태
		System.out.println("총점 : " + (kor + eng + math));

	}

}
