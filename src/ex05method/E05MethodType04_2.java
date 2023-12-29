package ex05method;

import java.util.Scanner;

// Scenario : 여러 개의 숫자를 입력받은 후 최대값을 구하는 메서드 정의
// 단 숫자의 개수는 매개변수로 전달받고, 숫자의 개수만큼 Scanner 클래스를 통해 입력받음
// 입력받은 숫자 중 최대값을 찾아서 반환하도록 정의함

public class E05MethodType04_2 {

	public static void main(String[] args) {

		int maxValue1 = returnMaxNumber(4);
		System.out.println("최대값1 : " + maxValue1);

		int maxValue2 = returnMaxNumber(6);
		System.out.println("최대값2 : " + maxValue2);		
	}
	
	// main에서 전달한 인수의 크기만큼 반복해서 정수를 입력받음
	// 그 중 최대값을 찾아 반환함
	static int returnMaxNumber(int numberCnt) {
		
		Scanner scanner = new Scanner(System.in);
		int maxVal = 0;
		// 매개변수로 전달한 인수의 크기만큼 반복
		for(int i = 1 ; i <= numberCnt ; i++) {
			System.out.print("정수를 입력하세요 : ");
			int inputNum = scanner.nextInt();
			
			if(i==1) {
				// 입력받은 정수 중에서 최대값을 찾아야 함
				// 첫 번째 입력값을 비교를 위한 기준값으로 설정
				// 즉 비교의 대상이 없으므로 무조건 최대값이 됨
				maxVal = inputNum;
			} else {
				// 두 번째 입력값부터는 기존의 최대값과 비교하여 더 큰값을 찾게 되면 교체하는 방식
				if(maxVal < inputNum) {
					maxVal = inputNum;
				}
			}
		}
		// 즉 새로운 입력값이 기존값보다 크다면 지속적으로 교체하여 가장 큰값을 호출한 지점으로 반환함
		return maxVal;
	}
}
