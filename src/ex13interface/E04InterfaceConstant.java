package ex13interface;

/*
인터페이스에 변수를 선언하면 무조건 상수가 되므로 주로 "인터페이스형 상수"라고 표현
 - 프로그램에서의 설정값이나 명시적인 코드를 위해 사용됨
 
 해당 인터페이스의 접근지정자는 default이므로 해당 패키지를 벗어나면 사용할 수 없음
 만약 프로젝트 전체에서 사용하고 싶다면 public으로 선언해야 하므로 별도의 java 파일로 만들어야 함 -> 
 */
import java.util.Scanner;

//interface Game {
//	int SCISSORS = 1, ROCK = 2, PAPER = 3;
//}

public class E04InterfaceConstant {

	public static void main(String[] args) {

		System.out.println("가위(1) 바위(2) 보(3) 게임입니다.");
		System.out.println("선택하세요(정수 입력) : ");
		
		Scanner sc = new Scanner(System.in);
		int sel = sc.nextInt();
		
		switch(sel) {
		// 가위 바위 보를 1, 2, 3으로 설정했지만 설정값이 많은 경우에는 모두 기억하기 어려우므로 명시적인 단어를 상수로 사용하는 것이 좋음
		case Game.SCISSORS:
			System.out.println("가위를 냈습니다.");
			break;
		case Game.ROCK:
			System.out.println("바위를 냈습니다.");
			break;
		case Game.PAPER:
			System.out.println("보자기를 냈습니다.");
			break;
		default:
			System.out.println("잘못 냈습니다.");
		}
	}
}
