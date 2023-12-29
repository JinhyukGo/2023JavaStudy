package ex05method;

public class E08RecursiveError {

	public static void main(String[] args) {
		showHi(3);
	}
	
	/*
	재귀메서드에서의 오류코드
	1. 감소 연산자로 인해 cnt의 값은 차감되지만
	2. 조건식의 위치가 잘못되어
	3. 재귀호출을 하기 전에 종료 체크를 할 수 있도록 수정해야 함
	 */

		public static void showHi(int cnt) {
			System.out.println("Hi~!");
			System.out.println("cnt = " + cnt);
			// showHi(--cnt);
			// 위에서 재귀호출 되므로 if문의 블럭은 실행할 찬스가 없어짐
			// 따라서 if문 블럭 아래쪽으로 호출 문장을 이동해야 함
			if(cnt == 1) {
				return;
			}
			showHi(--cnt); // 여기가 정상적인 위치
	}

}
/*
StackOverflow : 스택 오버플로우 : 스택은 함수가 종료되기 전까지의 모든 정보를 저장하는 메모리
- 무한한 공간이 아니므로 무한루프에 빠지게 되면 저장능력을 초과하면서 해당 에러가 발생함
 */
