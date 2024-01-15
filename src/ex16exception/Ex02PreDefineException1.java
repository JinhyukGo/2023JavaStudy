package ex16exception;

import java.util.InputMismatchException;

public class Ex02PreDefineException1 {

	public static void main(String[] args) {

		// 배열의 인덱스를 벗어난 경우 발생
		System.out.println("### ArrayIndexOutOfBoundsException ###");
		
		// 크기가 2인 배열을 생성
		int[] intArr = new int[2];
		
		/*
		예외가 발생할 수 있는 지역을 try문으로 먼저 묶어줌
		예외가 발생하면 JVM(자바 가상 머신)은 해당 예외에 관련된 인스턴스를 만들어 프로그램 쪽으로 전달
		이때 catch절에서 예외 인스턴스를 잡아주는 것을 "예외처리"라고 함
		 */
		try {
			intArr[0] = 100;
			System.out.println("0번 방은 : " + intArr[0]);
			intArr[1] = 200;
			System.out.println("1번 방은 : " + intArr[1]);
			
			/*
			예외가 발생되는 지점
			해당 코드가 실행될 때 예외가 발생하게 되고 JVM이 예외객체를 생성해서 프로그램쪽으로 던짐(throw)
			 */
			intArr[2] = 300;
			// 이 부분은 실행되지 않음
			System.out.println("?번 방은 : " + intArr[2]);			
		}
		catch(ArrayIndexOutOfBoundsException e) {
			/*
			JVM이 throw한 예외객체를 catch절에서 잡아서 처리함
			그러면 예외가 발생되어도 프로그램의 실행은 유지됨
			 */
			// 예외메세지1 : 개발자가 임읠 메세지를 출력
			System.out.println("예외 발생");
			// 메세지2 : 간략한 설명을 출력
			System.out.println("예외 메세지 : " + e.getMessage());
			// 메세지3 : 디테일한 메세지를 출력
			e.printStackTrace();
		}
		
		/*
		예외 처리를 통해 실행의 흐름이 중단되지 않으므로 아래 문장은 정상적으로 출력된 후 프로그램이 종료됨
		 */
		System.out.println("0번 방 재출력 : " + intArr[0]);
		System.out.println("### ArrayIndexOutOfBoundsException 발생 후 ###");
	} //// end of main
}
