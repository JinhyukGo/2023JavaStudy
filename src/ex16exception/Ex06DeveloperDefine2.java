package ex16exception;

import java.util.InputMismatchException;
import java.util.Scanner;

class AgeErrorException2 extends Exception {
	public AgeErrorException2() {
		super("나이 입력이 개잘못되었어요.");
	}
}
public class Ex06DeveloperDefine2 {

	public static void main(String[] args) {

		// main 메서드에서는 나이를 입력받기 위한 메서드를 단순히 호출만 하는 형태로 수정
		System.out.println("나이를 입력하세요. : ");
		int age = readAge();
		System.out.println("당신의 나이는 "+ age + " 입니다.");
	}
	
	/*
	1차 버전에서는 발생된 예외를 main 함수 쪽으로 throws 했음
	2차 수정 버전에서는 던지기를 하지 않고 해당 메서드에서 직접 예외처리를 함
	 */
	public static int readAge() {
		Scanner sc = new Scanner(System.in);
		int inputAge = 0;

		try {
			inputAge = sc.nextInt();
		} catch(InputMismatchException e) {
			e.printStackTrace();

			System.exit(0);
		}

		/*
		개발자가 직접 예외상황을 if문으로 확인한 후 예외클래스의 인스턴스를 만들어 프로그램으로 throw함
		그 즉시 에러가 발생하게 되므로 호출한 지점으로 "예외던지기"를 하지 않고 여기서 직접 "예외 처리"함
		 */
		try {
			if(inputAge < 0) {
				AgeErrorException2 ex = new AgeErrorException2();
				throw ex;
			}
		} catch(AgeErrorException2 e) {
			System.out.println(e.getMessage());
			System.out.println("개발자정의 예외 발생됨");
		}
		return inputAge;
	}
}