package ex03operator;

public class E04LogicOperator {

	public static void main(String[] args) {
		
		/*
		논리연산자
		- && : 논리 And : 양쪽 모두 True일 때만 True
		- || : 논리 OR : 양쪽 중 하나라도 True일 때는 True
		- ! : 논리 NOT : 항상 False
		 */

		int num1=10, num2=20;
		
		boolean result1 = (num1==100 && num2==20);
		boolean result2 = (num1<12 || num2>30);
		
		System.out.println("result1의 결과:"+ result1);
		System.out.println("result2의 결과:"+ result2);

		// !(false) : ture이므로, true
		if(!(num1==num2)) {
			System.out.println("num1과 num2는 다르다");
		} else {
			System.out.println("num1과 num2는 같다");
		}
	}

}
