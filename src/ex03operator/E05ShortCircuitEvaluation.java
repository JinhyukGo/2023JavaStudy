package ex03operator;

public class E05ShortCircuitEvaluation {

	public static void main(String[] args) {

		/*
		SCE(Short-Cirsute Evaluation) : 하나의 조건 검사만으로 결과를 알 수 있는 경우, 뒤의 조건은 확인하지 않고 건너뜀
		- 변수의 값이 변경되어야 하는 등의 경우에는 실행되지 않으므로 주의해야 함	
		 */
		int num1=0, num2=0;
		boolean result;
		
		// 논리 And의 경우, 둘 중 하나가 false인 경우, 무조건 false이기 때문에, 첫 번째 조건이 false인 경우, 두 번째 조건은 실행하지 않음
		result = (num1+=10)<0 && (num2+=10)>0;
		System.out.println("result="+ result);
		// 이 경우, num2는 초기값인 0을 그대로 유지함
		System.out.println("num1="+ num1 +", num2="+ num2);
		
		// 논리 Or의 경우, 둘 중 하나가 true면 무조건 true이므로, 첫 번째 조건이 true인 경우, 두 번째 조건을 실행하지 않음
		
		result = (num1+=10)>0 || (num2+=10)>0;
		// 위의 문장을 하단처럼 바꾸게 되면, num2 = 10으로 증가함
		// result = (num1+=10)<0 || (num2+=10)>0;
		System.out.println("result="+ result);
		// num2는 여전히 증가하지 못해서 0을 그대로 유지함
		System.out.println("num1="+ num1 +", num2="+ num2);
	}
}
