package ex04controlstatement;

public class E01If02 {

	public static void main(String[] args) {
//		홀짝을 판단 후 100이상인지를 다시 판단하는 if문 작성하기
		
		int num2 = 120;
		if(num2%2 == 0) {
			if(num2 >= 100) {
				System.out.println("짝수 & 100 이상");
			} else {
				System.out.println("짝수 & 100 미만");
			}
		} else {
			if(num2 >= 100) {
				System.out.println("홀수 & 100 이상");
			} else {
				System.out.println("홀수 & 100 미만");
			}
		}

		
		/*
		삼항연산자(조건 연산자) : if else문과 동일하지만 더 짧은 코드로 사용 가능함
			(조건문) ? 실행문장1 : 실행문장2;
			
		 */
		
		String numberResult = (num2%2 == 0) ? "짝수" : "홀수";
		System.out.println("숫자 "+ num2 +"은 "+ numberResult);

	}

}
