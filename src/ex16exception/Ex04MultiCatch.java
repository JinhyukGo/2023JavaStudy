package ex16exception;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
예외처리를 할 때 필요에 따라 여러 개의 catch 블럭을 사용할 수 있음
이 경우 반드시 자식 예외 클래스부터 catch 블럭을 추가해야 함
Exception 클래스는 모든 예외를 처리할 수 있으므로 반드시 마지막 블럭에 작성해야 함
 */

public class Ex04MultiCatch {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		// 크기가 3인 배열을 생성
		int array[] = new int[3];
		try {
			// 3개의 문자열을 입력받음
			for(int i=0 ; i<array.length ; i++) {
				//입력한 문자열을 정수로 변경한 후 배열에 저장
				만약 숫자 형식이 아닌 문자를 입력하면 정수로 변환할 수 없으므로 예외가 발생함
				System.out.println("array [" + i + "]에 저장할 숫자 입력");
				array[i] = Integer.parseInt(scanner.nextLine());
			}
			
			// 두 번째 숫자로 0을 입력하면 나눗셈 연산이 불가능해지므로 예외가 발생함
			System.out.println("배열에 저장된 두 숫자 나누기 : " + array[0]/array[1]);
			
			// 나이 입력시 문자를 입력하면 예외 발생
			System.out.print("나이를 입력하세요. : ");
			int age = scanner.nextInt();
			System.out.println("당신의 나이는 : " + age);
			
			// 배열의 크기가 3이므로 인덱스는 2까지만 존재하므로 아래에서도 예외가 발생
			array[3] = age;
		} catch(InputMismatchException e) {
			System.out.println("숫자로만 입력해야 합니다.");
		} catch(ArithmeticException e) {
			System.out.println("산술 연산이 불가능합니다.");
		} catch(NumberFormatException e) {
			System.out.println("숫자 형태의 문자만 입력가능합니다.");
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("배열의 인덱스를 초과하였습니다.");
		} catch(Exception e) {
			// Exception 클래스는 모든 예외 클래스의 부모이므로 catch절의 마지막에 기술해야 함.
			// 해당 클래스가 다른 Exception 클래스보다 위에 위치할 경우 에러 발생 - 해당 클래스로 다른 모든 Exception을 처리할 수 있으므로
			System.out.println("예외가 발생하였습니다.");
			System.out.println(e.getMessage());
			e.printStackTrace();
		} 
		
		/*
		앞에서 예외가 발생하더라도 예외처리를 했으므로 프로그램은 끝까지 실행된 후 정상적으로 종료됨
		이처럼 실행의 흐름이 마지막까지 이어지게 하는 것이 "예외처리"의 목적
		 */
		System.out.println("===== 프로그램 끝 =====");
	}
}
