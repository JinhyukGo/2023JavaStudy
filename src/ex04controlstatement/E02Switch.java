package ex04controlstatement;

import java.util.Scanner;

public class E02Switch {

	public static void main(String[] args) {
		
		/*
		switch문 : if문처럼 조건에 따라 분기하는 제어문으로, 정수식의 값과 동일한 부분을 찾아 실행하는 형태
		형식
			switch(산술식 혹은 정수식) {
			case 값1:
				실행문;
				break;
			case 값2:
				실행문;
				break;
			default:
				위에서 매칭되지 않았을 때 실행되는 문장 (if문의 else와 비슷)
			}
		- switch문 내부에서 break문을 만나면 실행이 중지되고 밖으로 탈출하게 됨
		- 만약 break문이 없다면 아래의 모든 실행문이 실행됨	
		
		 */
		
		// Scanner클래스 : 사용자로부터 입력값을 받기 위한 클래스로, 해당 클래스의 메서드가 실행되면 잠깐 실행이 중지되고 입력을 기다림
		// nextLine() : 문자열을 입력받음
		// nextInt() : 정수를 입력받음
		Scanner scanner = new Scanner(System.in);
		System.out.print("숫자를 입력하세요.");
		int iNum = scanner.nextInt();
		System.out.println("입력한 숫자는:"+ iNum);
		
		// 정수를 3으로 나누면 나머지는 0, 1, 2만 남음
		int remain = iNum % 3;
		switch (remain) {
		case 0:
			System.out.println("나머지는 0입니다.");
			break;
		case 1:
			System.out.println("나머지는 1입니다.");
			break;
		// default는 이후에 실행할 문장이 없으니 break가 없음
		default:
			System.out.println("나머지는 2입니다.");
		}

		// Cannot switch on a value of type long. Only convertible int values, strings or enum variables are permitted
		// switch문 사용 시 주의사항 : long 타입은 사용할 수 없음
		// byte, short, int, char, String만 사용 가능
		// 논리식, 조건식 사용 불가능
		long ln = 100;
//		switch(ln) {
//		case 100:
//			System.out.println("long타입 사용??");
//		default:
//			System.out.println("안됨");
//		}

		// 조건식은 사용할 수 없으므로 에러 발생
//		switch(iNum%3==0) {
//		System.out.print("논리식도 안됨");
//		}
		
		// 문자열이나 문자는 사용 가능
		String title = "자바";
		switch(title) {
		case "자바": System.out.println("자바 좋아");
			break;
		case "JAVA": System.out.println("JAVA Gooood");
			break;
		}
		
		// 여러 케이스를 동시에 처리할 때는 break문 없이 case를 나열하면 됨
		// if문에서 ||를 사용하는 것과 동일함
		int season = 8;
		switch(season) {
		case 3:case 4:case 5:
		// if(season == 3 || season == 4 || season == 5)
			System.out.println("Spring!");
			break;
		case 6:case 7:case 8:case 9:
			System.out.println("Summer!");
			break;
		case 10:
			System.out.println("Autumn!");
			break;
		case 11:case 12:case 1:case 2:
			System.out.println("Winter!");
			break;
		}		
		
		/*
		시나리오] 국,영,수 점수의 평균값을 구하여 학점을 출력하는
			프로그램을 작성하시오. 90점이상은 A학점...
			60점 미만은 F학점을 출력하면 된다. 
			단, switch문으로 작성하시오. 
		 */
		
		int kor = 100, eng = 100, math = 100;
		int avg = ((kor + eng + math) / 3) / 10;
		System.out.println("avg = " + avg);
		
		switch(avg) {
		case 10:case 9:
			System.out.println("A학점");
			break;
		case 8:
			System.out.println("B학점");
			break;
		case 7:
			System.out.println("C학점");
			break;
		case 6:
			System.out.println("D학점");
			break;
		default:
			System.out.println("F학점");		
		}
		
	}
}
