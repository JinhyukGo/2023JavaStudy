package ex16exception;

import java.io.IOException;

public class Ex01ExceptionBasic1 {

	public static void main(String[] args) throws IOException {

		/*
		Syntax 에러(구문 에러) : 실행 자체가 되지 않는 코드로 오류를 수정해야지만 정상적으로 실행됨
		즉 코드에 문법적인 오류가 있는 상태
		 */
		// Int number = 10;
		// if(true);
		// {}
		// else
		// {}
		
		int number = 10;
		if(true) {
			System.out.println("참");
		} else {
			System.out.println("거짓");
		}
		
		/*
		외부 자원을 사용할 때 발생하는 예외
		처리방법1] 예외 던지기를 수행
			main 메서드에서 throws를 이용해서 발생되는 예외객체를 외부로 던져서 무시하겠다는 의미로 사용됨
		처리방법2] 예외가 발생한 지점을 try ~ catch로 감싸줌
		 */
		System.out.println("문자 하나를 입력하세요.");
		try {
			int iChar = System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
