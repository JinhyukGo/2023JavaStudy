package ex04controlstatement;

public class E05For {

	public static void main(String[] args) {
		
		/*
		for문 : while문과 같은 반복문으로 초기값, 조건식, 증감식이 한줄에 있어서 반복의 횟수를 명확히 알 수 있음
		- 반복의 횟수가 정해져 있는 경우에 주로 사용함
		- 형식
			for(초기값 ; 조건식 ; 증감식) {
				실행문;
			}
		 */

		// 변수 i가 1부터 5까지 1씩 증가하므로 5번 반복됨
		for(int i = 1; i <= 5 ; i++) {
			System.out.println("i = "+ i);
		}
		
		// Scenario 1부터 100까지의 합을 구해봐
		// 누적합 저장용 변수
		int sum = 0;
		// 1부터 100까지의 구간을 정한 후 변수를 1씩 증가시킴
		for(int a=1 ; a <= 100 ; a++) {
			// 증가하는 a를 누적해서 더함
			sum += a;
		}
		System.out.println("1부터 100까지의 합 : "+ sum);
		
		System.out.println("==========");

		// Scenario for문을 이용하여 1부터 10까지의 정수 중 2의 배수의 합을 구해봐
		/*
		방법1 : 1부터 10까지 10번 반복해서 if문을 통해 2의 배수를 찾은 후 누적해서 더함
	     */
		int sum2 = 0;
		for(int i = 1 ; i <= 10 ; i++) {
			if(i%2 == 0) {
				sum2 += i;
			}
		}
		System.out.println("1부터 10 사이에서 2의 배수의 합 : " + sum2);
		
		/*
		방법2 : if문 없이 0부터 시작해서 2씩 증가시킴
		 */
		int sum3 = 0;
		for(int i = 0 ; i <= 10 ; i += 2) {
			sum3 += i;
		}
		System.out.println("1부터 10 사이에서 2의 배수의 합 : " + sum3);
		
		System.out.println("==========");

		// 일반적으로 무한루프를 만들 때는 while(true) 형태를 사용함
		// 하단처럼 for문으로 만들수도 있기는 하지만 일반적으로는 사용하지 않음 (for(;;))
//		int a = 1;
//		for(;;) {
//			System.out.println("for문으로 만든 무한루프" + a);
//			a++;
//		    if(a==1000) break; 등을 넣어서 중단시킬 수 있음
//		}
		
		System.out.println("==========");

		// for문의 끝에 ;를 사용하면 반복할 문장이 없는 것으로 간주되어 한 번만 실행됨
//		for(int j = 0 ; j <= 5 ; j++);
//		{
			// 변수 j는 현재 for문 내에서만 사용 가능
//			System.out.println("위 문장에서 ;로 종료해버려서 끝났음")
//		}
		
		System.out.println("==========");
		
		// 요건 지역 변수라서 다시 호출 불가능 위 문장 내부에서만 사용 가능
		// for문의 초기식에서 선언되는 변수는 for문이 종료되는 순간 메모리에서 소멸됨
		// 이미 소멸된 지역변수 j를 호출했으므로 에러 발생
//		System.out.println("위 for문에서 선언한 변수 j = " + j);
		System.out.println("위 main 함수 지역에서 선언한 변수 sum2 = " + sum2);
		
		// for문의 초기값을 외부에서 선언하면 해당 변수는 for문의 안쪽에서도 사용가능하고 바깥에서도 부를 수 있음
		int i = 0;
		for( ; i <= 5 ; i++) {
			System.out.println("for문 안에서의 i값 = " + i);
		}
		System.out.println("for문 밖에서의 i값 = " + i);
		
		// 자바에서는 중괄호가 나오면 하나의 지역이 만들어졌다고 생각하면 됨
		// if / while 등도 모두 동일함
		
		System.out.println("==========");
		
		System.out.println("연습문제 : 구구단을 출력하는 프로그램을 for문으로 작성하세요.");
		
		for(int dan = 2 ; dan <= 9 ; dan++) {
			for(int su = 1 ; su <= 9 ; su++) {
				System.out.print(dan + "*" + su + "=" + (dan*su) + " ");
			}
			System.out.println();
		}
		
		
		System.out.println("연습문제 : 다음 출력결과가 보이는 for문을 작성하세요.");
		// 출력결과
			// 0 0 0 1
			// 0 0 1 0
			// 0 1 0 0
			// 1 0 0 0
		
		for(int x = 1 ; x <= 4 ; x++) {
			for(int y = 1 ; y <= 4 ; y++) {
				// x와 y의 합이 5일 때만 1을 출력
				if(x + y == 5) {
					System.out.print("1 ");
				} else {
					System.out.print("0 ");
				}
			}
			System.out.println();
		}
		
			
	}

}
