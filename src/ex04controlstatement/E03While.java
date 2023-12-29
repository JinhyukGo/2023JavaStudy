package ex04controlstatement;

public class E03While {

	public static void main(String[] args) {
		
		/*
		While문 : 반복의 횟수가 명확하게 정해져 있지 않은 경우에 주로 사용하는 반복문
		- 반복을 위한 초기값, 조건식, 증감식을 따로 작성
		- 형식
			반복을 위한 변수의 초기값;
			while(반복의 조건) {
				실행문장;
				증감식; <= 반복문 탈출을 위한 조건을 위해
			}
		 */

		// 1 ~ 10까지의 합을 구하는 프로그램을 while문으로 작성하세요.
		
		// 반복을 위한 변수 i 생성 후 1로 초기화
		int i = 1;
		int sum = 0;
		
		// 반복 조건 : i가 10이하일 때까지만 반복
		while(i<=10) {
			// sum = sum + i와 하단은 동일
			sum += i;
			// i 증가식
			i++;
			System.out.println("i = "+ i);
		}
		System.out.println("합은 " + sum);
	
		
		// 1 ~ 100까지의 정수 중 3의 배수거나 4의 배수인 정수의 합을 구하는 프로그램을 while문으로 작성하세요.
		
		int sum2 = 0;
		int j = 1;
		
		while(j <=100) {
			if(j%3==0 || j%4==0) {
				sum2 += j;
				System.out.println("j는 "+ j);
			}
			j++;

		}
		System.out.println("합은" + sum2);
	
	
		// 구구단을 출력하는 프로그랭믈 while문으로 작성하세요.
		
		// 단을 표현한 변수
		int dan = 2;
		//단에 대한 조건 (2 ~ 9단까지)
		while(dan<=9) {
			int su = 1;
			// 수에 대한 조건 (1 ~ 9까지 단이 고정된 상태에서 증가)
			while(su<=9) {
				// 서식문자를 통해 서식으로 구구단을 출력함
				System.out.printf("%-2d*%-2d=%2d", dan, su, (dan*su));
				System.out.print(" / ");
				// 수를 1씩 증가시킴
				su++;
			}
			System.out.println();
			// 단을 1씩 증가시킴
			dan++;
		}
		System.out.println("\n=====\n");
		
		
		
		
		// ================================================================
		
		/*
		아래와 같은 모양을 출력하는 while문을 작성하세요.
		
			출력결과
				1 0 0 0
				0 1 0 0 
				0 0 1 0 
				0 0 0 1
		 */
		
		// while 안에 while문 반복으로 2중 반복 활용
		int x=1;
		// 행이 고정된 상태에서 열을 4번 반복하기 위한 변수
		while(x<=4) {
			int y = 1;
			while(y<=4) {
				// 행과 열의 번호가 동일할 때만 1을 출력
				if(x==y) {
					System.out.print("1");
				// 번호가 다르면 0을 출력
				} else {
					System.out.print("0");
				}
				y++;
			}
			// y가 4가 되면 줄바꿈
			System.out.println();
			x++;
		}
		
		System.out.println("\n=====\n");		
		
		/*
		아래와 같은 모양을 출력하는 while문을 작성하세요.
		
			출력결과
				0 0 0 1
				0 0 1 0 
				0 1 0 0 
				1 0 0 0
		 */
		int a=1;
		while(a<=4) {
			int b = 1;
			while(b<=4) {
				if(a+b==5) {
					System.out.print("1");
				} else {
					System.out.print("0");
				}
				b++;
			}
			System.out.println();
			a++;
		}		
		
		
	
	}
}
