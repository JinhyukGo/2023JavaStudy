package ex14innerclass;

/*
내부클래스(Inner class) : 클래스 안에 정의된 클래스로 static이 없는 클래스를 말함
 - 외부 클래스의 모든 멤버(정적 혹은 인스턴스형)를 사용할 수 있음
 - 정적 멤버를 가질 수 없음 / 단 상수는 가질 수 있음
 - 컴파일시 외부클래스명$내부클래스명.class 파일이 생성됨
 - 이벤트 기반의 프로그래밍에서 많이 사용됨
 */

// 외부 클래스 정의
class Unit {
	// 멤버변수
	private String name;
	private int healthPoint;
	
	// 인스턴스형 멤버변수 : 사용시 new를 통해 인스턴스를 생성
	Marine marine;
	Medic medic;

	public Unit(String name, int healthPoint) {
		// 멤버변수 초기화
		this.name = name;
		this.healthPoint = healthPoint;
		
		// 인스턴스형 멤버변수 초기화
		marine = new Marine();
		// Medic 클래스는 외부에서 인스턴스를 생성해보기 위해 주석처리
		// medic = new Medic();
	}
	public String infoStr() {
		return "유닛정보 [이름 : "+name+", 체력 : "+healthPoint+"]";
	}
	// 내부 클래스 정의(내부 멤버 클래스)
	class Marine {
		// 내부 클래스도 일반적인 클래스와 동일하게 멤버 정의 가능
		int attackPower;
		// 내부 클래스에서는 외부 클래스의 모든 멤버에 접근 가능 (외부 클래스가 더 넓은 지역이기 때문)
		public void attack() {
			System.out.println(infoStr()+"\n마린이 공격한다.");
		}
	}
	class Medic {
		int attackPower;
		public void heal() {
			System.out.println(infoStr()+"\n메딕이 치료한다.");
		}
	}
}

public class E01InnerClassMain {

	public static void main(String[] args) {

		// 외부 클래스의 인스턴스를 먼저 생성
		Unit unit = new Unit("커맨드센터", 1000);
		System.out.println(unit.infoStr());
		
		/*
		외부 클래스가 아닌 다른 클래스에서는 내부 멤버 클래스가 보이지 않으므로 직접 인스턴스를 생성할 수 없음
		 */
		// Marine m = new Marine(); 에러 발생
		
		// 외부 클래스의 인스턴스를 먼저 생성한 후 내부 클래스의 인스턴스를 생성해야 함
		// Marine은 Unit 클래스의 생성자에서 이미 인스턴스가 생성되어 있으므로 아래와 같이 사용 가능
		Unit.Marine marine = new Unit("마린", 50).marine;
		marine.attack();
		
		// Medic의 경우 Unit의 생성자에서 인스턴스 생성이 되지 ㅇ낳았으므로 아래와 같이 new를 통해 생성해야 함
		// 이때에도 인스턴스를 통해 생성해야 하므로 new를 두 번 사용해서 인스턴스를 생성
		Unit.Medic medic = new Unit("메딕", 30).new Medic();
		medic.heal();
	}
}
