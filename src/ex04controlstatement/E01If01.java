package ex04controlstatement;

public class E01If01 {

	public static void main(String[] args) {
		
		/*
		If문 형식은
			if(조건문) {
				실행문장;
			} 의 형태여야만 함
		- if문의 조건문은 반드시 비교식 혹은 논리식이어야 함
		- 결과값이 boolean타입으로 ture/false를 반환해야 함
		- 실행할 문장이 하나라면 중괄호 생략이 가능함
		 */

		int num = 10;
		
		// Type mismatch: cannot convert from int to boolean
		// 조건문이 아닌 산술식이므로 에러 발생
//		if(num%2) { 
//			System.out.println("잘못된 조건식입니다.");
//		} 
//		if(num) {
//			System.out.println("이것도 잘못된 조건식입니다.");
//		} 
		// if문의 조건은 boolean값을 반환하는 조건식이어야 함
		if(num%2==0) {
			System.out.printf("%d은 짝수입니다.", num);
		} 
		// 2가지 조건 모두 만족하므로 print()문이 실행됨
		if(num%2==0 && num>=10) {
			System.out.printf("%n%d은 짝수이고 10보다 크거나 같다.%n", num);
		}
		// 무조건 실행되게 하기 위해 사용함
		if(true) {
			System.out.println("무조건 실행되는 if문입니다.");
		}
		// ;을 잘못 사용했기 때문에, if문과는 관계없이 무조건 실행됨
		// if문 이후로 실행문이 붙어 있지 않아도 오류라고 처리되지는 않음
		if(num%2 !=0);
		{
			System.out.printf("%d는 홀수입니다.", num);
		}
		// 실행문이 하나인 경우에는 중괄호 생략 가능
		if(num%2==0)
			System.out.println("\n"+ num +"은 짝수이다.");
		// 여러 개의 실행문을 동시에 실행도 가능
		if(num%2 !=0) {
			System.out.println("num은 "+ num +"입니다.");
			System.out.println(num +"은 홀수입니다.");
		}

	}

}
