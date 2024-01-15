package ex15usefulclass;

import java.util.Random;

public class E07Random {

	public static void main(String[] args) {

		// Random 클래스는 인스턴스 생성시 전달되는 인수를 기반으로 난수를 생성함
		// Seed(씨앗)라고 표현
		// 만약 동일한 Seed를 사용하면 항상 동일한 패턴의 난수가 생성되는데 이를 가짜 난수(Pseudo-random number)라고 함
		System.out.println("# 가짜 난수 : 같은 패턴의 난수만 생성됨");
		Random random1 = new Random(32);
		for (int i=0 ; i<10; i++) {
			System.out.println(random1.nextInt(100)+" ");
		}
		
		/*
		Random 클래스의 nextInt(N) 메서드 : 0 ~ N-1까지의 난수가 생성됨
		 */
		System.out.println("\n# 난수 생성1 : 씨드 없음");
		Random random2 = new Random();
		for (int i = 0 ; i<10; i++) {
			System.out.println(random2.nextInt(100)+" ");
		}
		
		/*
		Seed를 부여하려면 setSeed()를 사용
		이때 현재 시간을 밀리세컨즈 단위로 반환하는 메서드를 사용하여 항상 변화하는 시간으로 새로운 Seed를 생성할 수 있음
		 */
		System.out.println("\n# 난수 생성2 : 변화하는 시간으로 씨드 지정");
		Random random3 = new Random();
		random3.setSeed(System.currentTimeMillis());
		for (int i = 0 ; i<10; i++ ) {
			System.out.println(random3.nextInt(100)+ " ");
		}
		
		/*
		nextInt()에 인수가 없는 경우에는 양수, 음수가 혼용된 난수가 생성됨
		이 경우에는 Math.abs()를 통해 양수로 변환하고 특정수를 나누는 형태로 원하는 구간의 난수를 구할 수 있음
		 */
		System.out.println("\n# 난수 생성3 : nextInt() 인수 없음");
		Random random4 = new Random();
		random3.setSeed(System.currentTimeMillis());
		for (int i = 0 ; i<10; i++ ) {
			System.out.println(random4.nextInt()+ " ");
		}
	}
}
