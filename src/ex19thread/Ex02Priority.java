package ex19thread;

/*
쓰레드의 우선순위
	setPriority(우선순위) : 
 */
class MessageSendingThread extends Thread {
	// 생성자1 : 이름만 지정	- 우선순위 5
	String message;
	
	public MessageSendingThread(String str) {
		message = str;
	}
	
	// 생성자2 : 이름과 우선순위를 지정	
	public MessageSendingThread(String str, int pri) {
		message = str;
		setPriority(pri);
	}
	public void run() {
		for(int i=1 ; i<=1000 ; i++) {
			// 각 쓰레드는 부여받은 우선순위를 출력함
			System.out.println(message + i + "(" + getPriority() + ")");
			// 기본적으로 우선순위가 높은 쓰레드가 먼저 실행되지만 sleep()을 호출하면 실행 중 잠깐씩 블럭상태로 전환되어 우선순위가 낮은 쓰레드도 실행될 수 있는 기회가 생기게 됨
			try {
				sleep(1);
			} catch(InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}

public class Ex02Priority {

	public static void main(String[] args) {
		
		/*
		1단계 실행 : 우선순위를 부여하지 않은 상태로 쓰레드 인스턴스를 생성하면 동일한 우선순위 5를 부여받게 됨
		이때는 CPU가 알아서 작업을 분배
		 */
//		MessageSendingThread tr1 = new MessageSendingThread("첫 번째");
//		MessageSendingThread tr2 = new MessageSendingThread("두 번째");
//		MessageSendingThread tr3 = new MessageSendingThread("세 번째");
		
		/*
		2단계 실행 : 오버로딩하여 정의한 생성자를 통해 우선순위를 부여한 상태로 인스턴스를 생성
		Thread 클래스의 정적상수를 통해 10, 5, 1의 우선순위를 부여할 수 있음
		상수 대신 정수로 부여해도 됨
		 */
		MessageSendingThread tr1 = new MessageSendingThread("첫 번째", Thread.MAX_PRIORITY);
		MessageSendingThread tr2 = new MessageSendingThread("두 번째", Thread.NORM_PRIORITY);
		MessageSendingThread tr3 = new MessageSendingThread("세 번째", Thread.MIN_PRIORITY);
		
		tr1.start();
		tr2.start();
		tr3.start();
	}
}