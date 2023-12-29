package ex04controlstatement;

public class E06BreakContinue {

	public static void main(String[] args) {
		
		/*
		break문 : 반복문이나 switch문에서 주로 사용되며 블럭 내에서 탈출할 때 사용함
		- 만약 중첩된 반복문이라면 가장 가까운 블럭 하나만 탈출
		continue문 : 반복문의 처음으로 돌아갈 때 사용함
		- while문에서는 조건을 확인함
		- for문에서는 증감식이 실행됨
		- 따라서 continue 아래의 문장은 실행되지 않음
		 */

		int i = 0;
		// 무한루프 조건으로 while문 작성
		while(true) {
			/*
			반복문 내에서 break, continue문을 사용할 때는 반드시 조건문과 함께 사용해야 함
			그렇지 않는 경우 아래의 코드는 실행되지 않는 쓰레기 코드가 됨
			 */
			i++;
			System.out.printf("[i가 %d일 때]\n", i);
			
			System.out.printf("continue 이전 출력문");
			
			// i가 짝수인 경우 반복문의 처음으로 돌아감
			if(i%2==0) continue;
			System.out.printf("continue 이전 출력문");

			System.out.println("break 이전 출력문");
			// i가 3일 때 반복문을 탈출함
			if(i==3) break;
			System.out.println("break 이전 출력문");
		}
		
		/*
		중첩된 반복문 안에서 break문을 만나면 가장 가까운 반복문 하나만 탈출함
		 */
		for(int x=1 ; x <= 5 ; x++) {
			System.out.println("x = " + x);
			for(int y = 1 ; y <= 5 ; y++) {
				// y는 3까지만 출력됨
				System.out.println("y = " + y);
				if(y == 3) break;
			}
		}
	}

}
