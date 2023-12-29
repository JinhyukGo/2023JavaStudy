package ex02variable;

public class E05ConstantVar {

	public static void main(String[] args) {
		
		/*
		상수 : 저장된 값이 변하지 않는 메모리의 종류로 변수를 선언한 후 앞에 final을 붙여줌
		- 상수는 한 번만 초기화되고, 그 이후에는 값을 변경할 수 없음
		- 선언 시 전체를 대문자로 기술함 / 연결되는 단어기 있다면 가독성을 위해 언더바를 사용
		- 주로 프로그램에서 코드의 가독성을 높여주는 역할
		 */
		
		// 상수 선언과 동시에 초기화
		final double PI = 3.14;
		System.out.println("PR(원주율)="+ PI);
		
		// 에러 발생 : 위에서 final로 선언을 했기 때문에 변경할 수 없음
		// PI = 3.141592;
		
		// 상수는 초기화하지 않은 상태로 출력(사용)하면 에러 발생
		final String NICK_NAME;
//		System.out.println("우리는 " + NICK_NAME);
		NICK_NAME = "개발자";
		System.out.println("우리는 " + NICK_NAME);
		
		/*
		가위 바위 보 게임 제작
		 */
		final int SCISSOR = 1;
		final int ROCK = 2;
		final int PAPER = 3;
		
		int computer, user;
		
		// 1과 3은 개발자만 알 수 있는 내용이므로, 전체적인 가독성은 떨어짐
		computer = 1;
		user = 3;
		System.out.println("컴퓨터가 이겼습니다.");
		
		// 가위와 보는 모두가 이해하기 쉬우므로 가독성이 좋은 코드
		computer = SCISSOR;
		user = PAPER;
		System.out.println("Computer Win");

	}

}
