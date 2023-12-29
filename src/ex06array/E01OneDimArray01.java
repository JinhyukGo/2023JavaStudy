package ex06array;

/*
배열(Array) : 순차적인 메모리의 공간이 할당되는 형태로써 하나가 아니라 여러 개의 변수가 필요한 경우에 사용함
- 자바에서는 배열을 인스턴스 형태로 생성하므로 new를 사용함
- 생성된 배열은 힙(Heap) 영역에 저장되고, 할당된 메모리의 주소값을 반환함
- 따라서 배열명(배열변수)은 주소값(참조값)을 할당받게 됨
- 해당 주소를 통해 배열에 접근할 수 있음
 */

public class E01OneDimArray01 {

	public static void main(String[] args) {

		// 정수형의 크기가 3인 배열을 생성
		int[] numArr = new int[3];
		// 인덱스는 0부터 2까지 접근하여 배열을 초기화함
		numArr[0] = 10;
		numArr[1] = 20;
		numArr[2] = 30;
		System.out.println("numArr의 0번 방의 값 : " + numArr[0]);
		System.out.println("numArr의 1번 방의 값 : " + numArr[1]);
		System.out.println("numArr의 2번 방의 값 : " + numArr[2]);
		// 정수형 배열이 Heap 영역에 생성된 후 반환된 주소값이 출력됨
		System.out.println("배열명(numArr)" + numArr);
		System.out.println("======================");
		
		/*
		배열의 선언 및 초기화 : 배열은 여러 개의 변수를 사용하기 위해 선언하므로 접근을 위해 일반적으로 반복문(for)을 사용함
		배열명.length : 해당 배열의 크기를 반환 / 크기가 변경되어도 유연하게 대처 가능한 장점
		 */
		int[] arrNumber = new int[40];
		// 배열의 각 원소를 10부터 1씩 증가시키며 초기화
		for(int i = 0 ; i < arrNumber.length ; i++) {
			arrNumber[i] = i + 10;
		}
		// 배열의 각 원소를 출력
		for(int i = 0 ; i < 40 ; i++) {
			System.out.println(i + "번 방의 값 = " + arrNumber[i]);
		}
		System.out.println("=====================");
		
		/*
		인스턴스 배열 : 기본 자료형을 저장하는 배열이 아닌 인스턴스의 참조값을 저장할 목적으로 생성한 배열
		- 사용법은 일반 배열과 동일
		 */
		String[] strArr = new String[3];
		strArr[0] = "java";
		strArr[1] = "jsp";
		strArr[2] = "spring";
		for(int j = 0 ; j < strArr.length ; j++) {
			System.out.println(strArr[j]);
		}
		System.out.println("=====================");
		
		System.out.println("배열의 선언과 초기화");
		// 가장 기본적인 배열 선언과 초기화 방법
		System.out.println("방법1 : 배열의 선언 이후 초기화");
		// 크기가 1인 배열을 생성한 후 인덱스로 접근하여 초기화
		int[] initArr = new int[1];
		initArr[0] = 100;
		System.out.println("initArr[0] = " + initArr[0]);
		
		// 배열을 선언과 동시에 초기화하는 경우, 자바 컴파일러는 초기값의 개수를 통해 배열의 크기를 결정할 수 있음
		// 따라서 이 경우에는 크기는 생략하도록 약속되어 있음
		// (앞이든 뒤든 한 군데에서만 개수를 선택하도록 하는 것 같음 / 중복으로 선택하면 에러 발생)
		System.out.println("방법2 : 배열의 선언과 동시에 초기화1");
		// int[] initArr2 = new int[3] {1, 20, 300};
		int[] initArray2 = new int[] {1, 20, 300};
		
		// 배열 원소의 개수를 통해 배열을 생성한 후 초기화까지 동시에 진행
		// 이 경우 new를 생략 가능
		System.out.println("방법3 : 배열의 선언과 동시에 초기화2");
		// 원소의 개수를 통해 크기가 5로 지정됨
		int[] initArr3 = {11, 13, 17, 19, 23};
		int arrSum = 0;
		// 배열의 크기만큼 반복해서 모든 원소를 누적해서 더함
		for(int x = 0 ; x < initArr3.length ; x++) {
			arrSum += initArr3[x];
		}
		System.out.println("배열요소의 합은 = " + arrSum);
	}

}
