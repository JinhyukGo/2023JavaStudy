package ex19thread;

class SumMulti2 {
	long num;
	
	public SumMulti2() {
		num=0;
	}

	/*
	쓰레드의 동기화 방법1 : 메서드 전체를 동기화하는 "동기화 메서드"
	 */
//	synchronized public void addNum(int n) {
//		num += n;
//	}
	/*
	동기화 방법2 : "동기화 블럭"을 사용함
	동기화가 필요한 코드에만 적용하는 방법
	해당 프로그램은 실행코드가 1줄밖에 없으므로 동기화 방법에 대한 성능차이가 없음
	하지만 실행코드가 많은 경우에는 메서드 전체를 동기화하는 것보다는 필요한 코드만 동기화하는 "동기화블럭"이 훨씬 더 좋은 성능을 보이게 됨
	 */
	public void addNum(int n) {
		synchronized(this) {
			num += n;
		}
	}
	public int getNum() {
		return num;
	}
}
class MultiAdderThread2 extends Thread {
	SumMulti sumInst;
	int start, end;
	
	public MultiAdderThread2(SumMulti sum, int s, int e) {
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

public class Ex05Sync2Error {

	public static void main(String[] args) {

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