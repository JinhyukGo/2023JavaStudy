package ex04controlstatement;
import java.io.IOException;
import java.util.Scanner;

public class E04DoWhile {

	public static void main(String[] args) throws IOException {
		
		/*
		do while문 : 반드시 한 번은 실행해야 할 경우에 사용하는 반복문
		- 조건 검사없이 무조건 한 번은 실행됨
			형식
				반복을 위한 변수;
				do {
					실행문;
					증감식;
				} while(조건식); <= 문장의 마지막에 세미콜론 필수
		 */

		/*
		Scenario : 예제의 1 ~ 10까지 더하는 수열 문제를 do while문으로 변경해서 구현해보세요.
		 */
		// 반복을 위한 변수 생성
		int sum = 0;
		int i = 1;
		// 조건없이 무조건 진입해서 실행
		do {
			// 증가하는 변수 i를 누적해서 sum에 더해줌
			sum += i;
			i++;
		// 탈출 조건은 i가 10 이하
		} while(i <= 10);
		System.out.println("1부터 10까지의 누적합 : " + sum);

		
		/*
		Scenario : 1부터 1000까지의 정수 중 4의 배수이거나 7의 배수인 수의 합을 구해보세요.
		 */
		
		int tot = 0;
		int a = 1;
		do {
			// 4의 배수거나 7의 배수인지 확인
			if(a%4==0 || a%7==0) {
				// 증가하는 a를 계속해서 더해줌
				tot += a;
			}
			a++;
		// 탈출조건은 a가 1000 이하
		} while(a <= 1000);
		System.out.println("1부터 1000까지 중 4나 7의 배수인 수들의 합 : " + tot);
		
		/*
		Scenario : 국어, 영어, 수학 점수를 입력 받은 후 평균을 구해 A ~ F를 구해보세요.
		 */
		// 사용자로부터 입력을 받기 위해 Scanner 인스턴스 생성
		Scanner scanner = new Scanner(System.in);
		//점수와 탈출문자 입력을 위한 변수 생성
		int kor, eng, math, avg;
		int exitCode;
		// 조건 확인없이 진입하여 3과목의 점수를 입력받음
		do {
			System.out.print("국어점수 : ");
			kor = scanner.nextInt();
			System.out.print("영어점수 : ");
			eng = scanner.nextInt();
			System.out.print("수학점수 : ");
			math = scanner.nextInt();
			
			// 평균점수의 구간을 정하기 위해 10으로 나누는 연산을 추가
			// switch문은 조건식은 사용할 수 없고, 산술식만 사용 가능
			avg = (kor + eng + math) / (3 * 10);
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
			
			// 사용자로부터 문자 하나를 입력받아 종료
			System.out.println("종료하려면 x(X)를 입력하세요.");
			System.out.println("계속하려면 아무키나 입력하세요.");
			exitCode = System.in.read();
		/*
		x를 입력받는 경우, 
			!(true || false) = !(true) = false
			반복문 탈출
		a를 입력받는 경우,
			!(false || false) = !(false) = true
			반복문 탈출 실패 / 처음부터 다시 반복
		 */
		} while(!(exitCode=='x' || exitCode=='X'));
		
		
		/*
		연습문제) 다음과 같은 피라미드를 출력하는 프로그램을 
			do~while문으로 작성하시오.
		 *****
		 *****
		 *****
		 *****
		 *****
		*/	
		int b = 1;
		do {
			int c=1;
			do {
				System.out.print("* ");
				c++;
			} while(c<=5);
			b++;
			System.out.println();
		} while(b <= 5);
		
		System.out.println("========================");

		
		/*
		연습문제) 다음과 같은 피라미드를 출력하는 프로그램을 
			do~while문으로 작성하시오.
		 *
		 **
		 ***
		 ****
		 *****
		*/

		int d = 1;
		do {
			int e=1;
			do {
				System.out.print("* ");
				e++;
			} while(e<=d);
			d++;
			System.out.println();
		} while(d <= 5);
		
		
	}
}
