package ex16exception;

import java.util.Scanner;
import java.util.InputMismatchException;

/* finally 절 : 예외 발생과 상관없으 try문으로 진입했을 때 반드시 실행해야 할 코드가 있는 경우 기술하는 블럭
단 필수사항은 아니므로 필요한 경우에만 작성
1. try ~ catch : 예외를 직접 처리할 때
2. try ~ catch ~ finally : 예외를 직접 처리한 후 실행할 문장이 있을 때
3. try ~ finally : 예외는 외부로 던지고, 예외 발생과 상관없이 실행할 문장이 있을 때
*/

public class Ex05Finally {
	
	/*
	런타임 예외가 발생되는 메서드로 예외가 발생되면 호출한 지점으로 예외던지기를 함 (즉 예외를 무시함)
	 */
	static void runtime() throws NumberFormatException {
		Integer.parseInt("백");
	}
	static void tryCatchFinally() {
		Scanner scan = new Scanner(System.in);
		System.out.println("나이를 입력하세요. : ");
		int age = -1;
		try {
			// "10살" 처럼 입력하면 예외발생
			// 그러면 아래 코드는 실행되지 않고, catch절로 넘어감
			age = scan.nextInt();
			System.out.println("당신은 5년 후 " + (age+5) + "살입니다.");
			// 앞에서 정상적인 값을 입력하더라도 return이 실행됨
			// 일반적으로 return은 메서드의 종료를 의미하지만 finally절이 있다면 해당 구문이 실행된 후 종료됨
			return;
		} catch(InputMismatchException e) {
			System.out.println("나이는 숫자로만 작성하세요.");
		} finally {
			// try절에서 예외가 발생하거나 return을 만나게 되더라도 항상 finally절은 실행됨
			System.out.println("항산 실행되는 finally절입니다.");
			// 해당 명령은 프로그램 실행 자체를 종료함 / 즉 콘솔창의 터미네이트 버튼을 누르는 것과 동일하게 동작
			// try절에서 해당 명령을 만나게 되면 finally절은 실행되지 않음
			// System.exit(0);
		}
	}

	public static void main(String[] args) {
		/*
		NumberFormatException과 같은 예외는 발생된 지점에서 예외던지기를 하는 것은 가능하나 반드시 예외처리를 해야만 프로그램이 종료되지 않음
		즉 예외객체에 따라 무시할 수 있느 ㄴ것도 있지만, 이처럼 반드시 예외처리를 해야 하는 것도 존재함
		만약 main 메서드에 throws를 선언하면 프로그램이 비정상적으로 종료됨
		 */

		try {
			runtime();
		} catch(NumberFormatException e) {
			e.printStackTrace();
		}
		
		tryCatchFinally();
		System.out.println("메인 메서드 끝");
	}
}
