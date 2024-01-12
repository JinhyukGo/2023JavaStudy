package ex15usefulclass;

public class E01WrapperClass2 {

	public static void main(String[] args) {

		/*
		parseInt() : 숫자 형식의 문자열을 정수(숫자)로 변경
		parseDouble() : 숫자 형식의 문자열을 실수로 변경
		 */
		String strNumber = "1000";
		// 정수 + 문자열 = 101000
		System.out.println("10 + strNumber = " + (10+strNumber));
		// 정수 + 정수 = 1010
		System.out.println("10 + strNumber를 숫자로 변경 = " + (10+Integer.parseInt(strNumber)));
		// 위와 동일
		System.out.println("10 + strNumber를 숫자로 변경 = " + (10+Integer.valueOf(strNumber)));
		
		/*
		문자열을 숫자로 변경할 때는 반드시 숫자형식만 기술해야 함
		"원"이 숫자가 아니라서 예외 발생
		 */
		String money = "120원";
		// System.out.println("120원 : " + Integer.parseInt(money));
		
		String floatString = "3.14";
		// 실수 형태의 문자열을 숫자로 변경할 때는 parseInt() 사용 불가
		// System.out.println(Integer.parseInt(floatString));
		System.out.println("실수형(Float)형으로 변경 : " + Float.parseFloat(floatString));
		System.out.println("실수형(Double)형으로 변경 : " + Double.parseDouble(floatString));
		
		/*
		codePointAt()
		 */
		System.out.println("ABCD에서 3번째 인덱스 D의 아스키코드");
		System.out.println(Character.codePointAt("ABCD", 3));
		
		/*
		isDigit() : 인수로 전달된 문자가 숫자인지 판단 (숫자가 맞으면 true / 아니면 false)
		 */
		System.out.println("isDigit()을 통한 숫자 판단");
		System.out.println(Character.isDigit('A') ? "숫자" : "숫자 아님");
		System.out.println(Character.isDigit(50) ? "숫자" : "숫자 아님");
		System.out.println(Character.isDigit('7') ? "숫자" : "숫자 아님");
		
		/*
		isLetter() : 인수로 전달된 문자가 문자인지를 판단 (문자가 맞으면 true / 숫자, 특수기호 등 문자가 아니면 false)
		 */
		System.out.println("isLetter() 메서드를 통한 문자 판단");
		System.out.println(Character.isLetter('가'));
		System.out.println(Character.isLetter('A'));
		System.out.println(Character.isLetter('#'));
		System.out.println(Character.isLetter('9'));
		
		/*
		isWhitespace() : 공백문자인지를 판단하는 메서드 / 공백 문자인 경우 true 반환
		 */
		System.out.println("isWhitespace() 메서드를 통한 공백 판단");
		System.out.println(Character.isWhitespace('A'));
		System.out.println(Character.isWhitespace(' '));
		
		/*
		isLowerCase() : 소문자 판단
		isUpperCase() : 대문자 판단
		영문이 아닌 경우에는 무조건 false 반환
		 */
		System.out.println("알파벳 대소문자 판단");
		System.out.println(Character.isLowerCase('A'));
		System.out.println(Character.isUpperCase('z'));
		System.out.println(Character.isLowerCase('a'));
		System.out.println(Character.isUpperCase('Z'));
		System.out.println(Character.isLowerCase('가'));	
		

		String friendWord = "마이 무그따 아이가";
		char[] chArr = whiteString.toCharArray();
		int whiteCnt = 0;
		for(int i=0 l i<chArr.length ; i++) {
			if(Character.isWhitespace(chArr[i])) {
				whiteCnt++;
			}
		}
		System.out.println("총 공백수 : " whiteCnt);
		
		
		
		
		
		
		
		
	}
}
