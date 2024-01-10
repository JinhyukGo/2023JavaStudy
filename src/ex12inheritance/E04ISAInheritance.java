package ex12inheritance;

/*
Is - A 관계 : X is a Y => X는 Y의 일종이다로 표현가능한 관계
 - 노트북은 컴퓨터의 일종이다.
 - 휴대폰은 전화기의 일종이다.
 이와 같이 Is - A의 관계가 성립하는 객체를 상속으로 표현하기에 적합함
 따라서 실제 업무에서도 유사한 기능의 클래스들을 묶어서 정의함
 */

// 컴퓨터 : 기본적인 컴퓨팅 환경을 제공하여 입력된 내용을 계산
class Computer {
	
	// 멤버 변수 : 컴퓨터의 소유주
	String owner;
	
	/*
	개발자가 생성자를 정의하면 디폴트 생성자는 자동으로 추가되지 않음
	즉 생성자는 아래와 같이 필요한 상황에 따라 정의하면 됨
	 */
	// public Computer() {}
	public Computer(String name) {
		owner = name;
	}
	// private 접근 지정자로 선언된 멤버 메서드는 외부 클래스 혹은 상속받은 클래스에서 접근 가능
	// public으로 선언된 메서드를 통해 간접적으로 호출해야 함
	private void keyboardTouch() {
		System.out.println("키보드를 통해서 입력한 ");
	}
	private void calculate() {
		System.out.println("요청된 내용을 계산한다.");
	}
	// private으로 선언된 멤버 메서드를 외부에서 호출할 수 있게 public으로 지정하여 선언한 메서드로 캡슐화되어 있음
	// 처음부터 public으로 선언해서 실행해도 관계는 없으나, 각각의 함수들의 순서 등을 지정해서 한 번에 실행시키기 위함
	public void calculateFunc() {
		keyboardTouch(); // 입력 후
		calculate(); // 계산을 수행
	}
}

/*
컴퓨터를 상속한 노트북컴퓨터 : 컴퓨터가 가진 기본 연산 기능에 휴대성을 확장하여 정의
 - 노트북은 전원이 없어도 사용할 수 있어야 하므로 배터리를 추가하여 정의
 */
class NotebookComputer extends Computer {
	
	// 자식 클래스에서 확장한 멤버 변수
	int battery;
	
	// 생성자 정의
	public NotebookComputer(String name, int initCharge) {
		// 부모클래스의 생성자를 호출하기 위해 사용하는 super()는 생략할 수 있지만, 앞에 다른 문장이 먼저 기술되면 에러 발생
		// 여기서는 부모 클래스에 디폴트 생성자가 없는 상태이므로 생략하는 즉시 에러 발생
		super(name);
		// 멤버변수 초기화
		battery = initCharge;
	}
	// 배터리 충전을 표현한 멤버 메서드
	public void charging() {
		battery += 5;
	}
	// 휴대하면서 컴퓨터를 사용하는 것을 표현한 메서드
	public void movigCal() {
		// 사용 전 배터리의 잔량을 확인 후 사용 여부를 판단
		if(battery < 1) {
			System.out.println("배터리가 방전되어 사용불가");
			// 메서드에서 아래와 같이 return을 만나면 실행이 종료됨(중지)
			return;
		}
		System.out.print("이동하면서 ");
		// 아래 2개의 메서드는 private으로 선언되었으므로 상속을 받은 자식 클래스에서도 접근할 수 없어 에러가 발생
		// 이 경우 public으로 선언된 메서드를 통해 호출해야 함
		// keyboardTouch();
		// calculate();
		calculateFunc();
		
		battery -= 1; // 배터리 차감
	}
}

class TabletNotebook extends NotebookComputer {
	
	// 태블릿 사용을 위한 펜슬을 표현한 멤버 변수
	String registPencil;
	// 생성자
	public TabletNotebook(String name, int initCharge, String pen) {
		// 부모 인스턴스 생성을 위해 매개변수 2개를 전달
		super(name, initCharge);
		registPencil = pen;
	}
	// 태블릿 사용을 위한 배터리량 체크 및 등록된 펜 여부 확인
	public void write(String penInfo) {
		// 배터리 잔량을 확인
		if(battery < 1) {
			System.out.println("배터리가 방전되어 사용 불가");
			return;
		}
		// 등록된 펜이 맞는 지 문자열 비교를 통해 확인
		// A.compareTo(B) : 문자열 A와 B를 비교하여 0이 반환되면 동일한 문자열, -1 혹은 1이 반환되면 다른 문자열로 판단
		if(registPencil.compareTo(penInfo)!=0) {
			System.out.println("등록된 펜이 아닙니다.");
			return;
		}
		// 부모 클래스에 정의된 메서드를 호출
		// 상속받은 자식 클래스에서는 이와 같이 부모의 멤버 메서드를 호출하여 자신의 멤버처럼 사용 가능
		// 단 접근이 가능한 접근 지정자로 선언되어 있어야 함 (super는 생략 가능) - 단 식별을 위해 사용
		super.movigCal();
		System.out.println("스크린에 펜으로 그림을 그린다.");
		battery -= 1;
	}
}

public class E04ISAInheritance {

	public static void main(String[] args) {

		// 노트북과 태블릿 인스턴스 생성
		NotebookComputer noteBook = new NotebookComputer("공유", 5);
		TabletNotebook tablet = new TabletNotebook("이동욱", 5, "ISE-1234");
		
		System.out.println("==노트북컴퓨터 사용==");
		noteBook.movigCal();
		noteBook.movigCal();
		noteBook.movigCal();
		noteBook.movigCal();
		noteBook.movigCal(); // 배터리가 1씩 차감되므로 여기까지 사용 가능
		noteBook.movigCal(); // 배터리가 모두 소모되어 사용 불가
		noteBook.movigCal();
		noteBook.movigCal();
		
		// 등록된 펜이므로 사용 가능
		System.out.println("==ISE-1234 펜으로 태블릿 사용==");
		tablet.write("ISE-1234");
		
		// 등록되지 않은 펜이므로 사용 불가
		System.out.println("==XYZ-9876 펜으로 태블릿 사용");
		tablet.write("XYZ-9876");
	}
}
