package ex19thread;

class SumMulti {
	// 멤버변수와 생성자 정의
	int num;
	
	public SumMulti() {
		num=0;
	}
	/*
	쓰레드의 run()에서 호출하는 메서드로 매개변수로 전달되는 정수를 누적해서 더해줌
	여기서는 2개의 쓰레드가 5000번씩 각각 호출하게 됨
	 */
	public void addNum(int n) {
		num += n;
	}
	public int getNum() {
		return num;
	}
}
// 쓰레드로 정의한 클래스
class MultiAdderThread extends Thread {
	// 앞에서 정의한 공유객체를 멤버변수로 선언
	SumMulti sumInst;
	int start, end;
	
	// 생성자에서 멤버변수 초기화
	public MultiAdderThread(SumMulti sum, int s, int e) {
		sumInst = sum;
		start = s;
		end = e;
	}
	/*
	
	 */
	public void run() {
		for(int i=start ; i<=end ; i++) {
			sumInst.addNum(i);
		}
	}
}

public class Ex05Sync1Error {

	public static void main(String[] args) {

		/*
		하나의 객체를 2개의 쓰레드가 공유해서 사용하는 형태로 동작시킴
		각각의 쓰레드가 5000번씩 반복해서 호출하게 됨
		 */
		SumMulti s = new SumMulti();
		MultiAdderThread mat1 = new MultiAdderThread(s, 1, 5000);
		MultiAdderThread mat2 = new MultiAdderThread(s, 5001, 10000);
		mat1.start();
		mat2.start();
		
		try {
			mat1.join();
			mat2.join();
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("1부터 10000까지의 합 : " + s.getNum());
	}
}