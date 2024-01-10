package ex12inheritance;

/*
구성 관계로 표현하기에 적합한 Has - A 관계 : X has a Y => X가 Y를 소유(포함)
 - 여기서는 권총을 소유한 경찰을 표현
 
Has - A와 같이 소유의 관계를 상속으로 표현하면 클래스 간의 강한 연결고리가 형성되어 권총이 없는 경찰을 표현하기 힘들어짐
따라서 이 경우에는 구성(Composition) 관계로 표현하는 것이 적합
구성관계란 클래스의 멤버로 또 다른 클래스를 사용하는 것을 의미
 */
// 권총을 추상화한 클래스
class Gun {
	// 멤버 변수 : 총알
	int bullet;
	public Gun(int bNum) {
		bullet = bNum;
	}
	// 총을 발사한 후 총알이 감소하는 것을 표현한 멤버 메서드
	public void shootGun() {
		System.out.println("Boom");
		bullet--;
	}
}
class Police {
	// 권총과 총알을 보유한 경찰을 표현하기 위해 상속을 사용하지 않고 멤버 변수로 정의
	// 수갑 : 일반적인 멤버 변수 (기본 자료형)
	int handCuffs;
	// 권총 : 인스턴스형 멤버 변수 (다른 클래스를 통해 생성)
	Gun gun;
	
	// 생성자
	public Police(int bNum, int hCuff) {
		// 수갑은 단순한 정수값을 통해 보유 여부를 설정
		handCuffs = hCuff;
		// 권총의 보유 여부는 총알 여부를 통해 확인
		// 총알이 없는 상태라면 권총이 없는 것으로 간주하여 null로 초기화
		// 참조 변수가 null을 할당받았다는 것은 참조할 인스턴스가 없는 것을 의미
		// 즉 힙 영역에 생성된 인스턴스가 아예 없으므로 소유하지 않은 것으로 표현
		if(bNum<=0) {
			gun = null;
		} else {
			gun = new Gun(bNum);
		}		
	}
	
	// 수갑을 채우는 것을 표현
	public void putHandcuff() {
		System.out.println("수갑 채움");
		handCuffs--;
	}
	// 권총을 발사하는 것을 표현
	public void shoot() {
		// 조건문을 통해 소유한 총이 있을 때만 발사할 수 있음
		if(gun==null) {
			System.out.println("보유한 총알 없음");
		} else {
			gun.shootGun();
		}
	}
}

public class E05HasAComposite {

	public static void main(String[] args) {
		// 권총을 소유한 경찰
		System.out.println("==경찰1==");
		// 총알 5발, 수갑 3개로 인스턴스 초기화
		Police police1 = new Police(5, 3);
		police1.shoot(); // 발사 가능
		police1.putHandcuff();
		
		// 권총을 소유하지 않은 경찰
		System.out.println("==경찰2==");
		// 총알은 없고 수갑은 3개로 초기화
		Police police2 = new Police(0, 3);
		police2.shoot(); // 발사 불가능
		police2.putHandcuff();
	}
}
