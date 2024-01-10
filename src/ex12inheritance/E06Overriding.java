package ex12inheritance;

/*
오버라이딩(Overriding) : 클래스가 상속 관계에 있을 때 하위 클래스에서 상위 클래스의 멤버 메서드와 완전히 동일한 모양으로 메서드를 재정의 하는 것
 - 오버로딩과 다른 점은 매개 변수의 개수 및 타입, 반환 타입 등이 완전히 똑같은 형태로 정의한다는 것
 - 하위 클래스에서 오버라이딩한 메서드는 상위 클래스의 메서드를 가리게 되므로 항상 하위 클래스에서 오버라이딩한 메서드가 호출됨
 */
// 부모 클래스 : 일반적인 스피커를 추상화
class Speaker {
	// 멤버 변수 : 볼륨을 표현 / private으로 선언
	private int volumeRate;
	/*
	멤버 변수가 private이므로 외부에서 값을 설정할 수 있도록 setter를 정의
	 */
	public void setVolume(int vol) {
		volumeRate = vol;
	}
	// 상속관계에서 오버라이딩을 목적으로 정의한 메서드
	public void showState() {
		System.out.println("스피커의 볼륨크기 : " + volumeRate);
	}
}
// 자식 클래스 : 스피커의 기능에 베이스가 보강된 스피커를 추상화
class BaseSpeaker extends Speaker {
	// 베이스 기능의 확장을 위한 멤버 변수와 이를 설정하기 위한 setter 정의
	private int baseRate;
	public void setBase(int bass) {
		baseRate = bass;
	}
	// @Override : 어노테이션이라고 부름
	//  - 오버라이딩된 메서드에 추가하여 컴파일러에게 알려주는 역할
	//  - 필수 사항은 아니므로 생략 가능
	@Override
	public void showState() {
		// super를 통해 부모 클래스에 정의된 멤버 메서드를 호출
		// 특히 오버라이딩된 메서드를 호출할 때 super가 없으면 재귀호출이 되므로 주의!
		super.showState();
		System.out.println("스피커의 볼륨크기 : " + baseRate);
	}
}

public class E06Overriding {

	public static void main(String[] args) {

		// 자식 클래스를 통해 인스턴스를 생성
		BaseSpeaker baseSpeaker = new BaseSpeaker();
		// 자식 인스턴스를 생성했으므로 부모의 멤버와 자식의 멤버 모두 접근 가능
		baseSpeaker.setVolume(10);
		baseSpeaker.setBase(20);
		// 오버라이딩된 메서드를 ㅗ출하면 자식 쪽의 showState()가 호출됨
		// 부모쪽의 메서드는 자식에 의해 가려지게 됨
		// 윈도우 탐색기에서 같은 이름의 파일을 붙여넣기할 때 덮어쓸 지 물어보는 것과 동일한 형태
		baseSpeaker.showState();
		
		System.out.println();
		
		// 부모클래스의 참조변수로 자식 인스턴스를 참조 가능 : 상속관계이기 때문에 가능
		Speaker speaker = new BaseSpeaker();
		// 단 부모타입의 변수로 자식 인스턴스를 참조하면 접근할 수 있는 범위가 부모 인스턴스까지로 제한됨
		// 자식쪽에 정의된 setBase()는 호출할 수 없음
		speaker.setVolume(30);
		// speaker.setBase(40);
		// 접근 범위는 앞에서 설명한 바와 같이 부모까지로 제한되지만 오버라이딩된 메서드가 있다면 자식쪽의 메서드가 호출됨
		speaker.showState();
	}
}
