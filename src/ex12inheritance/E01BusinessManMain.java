package ex12inheritance;

/*
상속(Inheritance) : 기존에 정의된 클래스에 메서드와 변수를 추가하여 새로운 클래스를 정의하는 것
 - 부모 클래스를 자식 클래스가 상속할 때는 extends 키워드를 사용
 */

// 부모(상위) 클래스 : 사람의 일반적인 형태를 추상화함
class Man {
	
	// 멤버 변수는 private이므로 클래스 내부에서만 접근 가능
	private String name;
	
	// 생성자는 오버로딩으로 2개를 정의 (호출 여부는 print를 통해 확인)
	public Man() {
		System.out.println("Man클래스 디폴트 생성자 호출됨");
	}
	public Man(String name) {
		this.name = name;
		System.out.println("Man 클래스 인자 생성자 호출됨");
	}
	// 멤버 메서드에서는 private 멤버라도 동일 클래스 내부이므로 접근 가능
	public void tellYourName() {
		System.out.println("내 이름은 " + name + " 입니다.");
	}
}

// 자식(하위) 클래스 : Man 클래스를 상속 받아 회사원을 추상화함
class BusinessMan extends Man {
	
	// 멤버 변수로 회사명, 직급을 선언
	private String company;
	private String position;
	
	// 상속받은 자식 클래스는 부모 클래스의 생성자를 호출하여 부모 인스턴스가 메모리에 먼저 생성되도록 해야 함
	// super()는 부모 클래스의 생성자를 호출하는 역할
	// 만약 super()를 기술하지 않으면 컴파일러에 의해 자동으로 삽입되어 디폴트 생성자가 호출됨
	public BusinessMan(String name, String company, String position) {
		
		// 부모 클래스의 매개 변수 1개인 생성자를 호출함
		super(name);
		// 남은 2개를 통해 자식쪽의 멤버 변수를 초기화
		this.company = company;
		this.position = position;
		System.out.println("BusinessMan 생성자 호출");
	}
	
	public void tellYourInfo() {
		// 자식 클래스의 멤버이므로 접근할 수 있음
		System.out.println("회사명은 " + company + " 입니다.");
		System.out.println("직급은 " + position + " 입니다.");
		// The field Man.name is not visible
		// 부모 클래스의 멤버 변수 name은 private로 선언되어 있으므로 상속받은 자식 클래스에서는 접근 불가
		// System.out.println("이름은 " + name + " 입니다.");
		// 부모 클래스에 public으로 선언된 메서드를 통해 간접적으로 접근
		tellYourName();
	}
}

public class E01BusinessManMain {

	public static void main(String[] args) {

		// 자식 클래스를 통해 2개의 인스턴스를 생성
		BusinessMan man1 = new BusinessMan("김천국", "Naver", "팀장");
		BusinessMan man2 = new BusinessMan("이낙원", "Daum", "부장");

		// 회사 정보와 이름을 출력
		man1.tellYourInfo();
		man1.tellYourName();

		man2.tellYourInfo();
		man2.tellYourName();
	}
}
