package common;

public class Student extends Person {
	
	// 학번 : 자식에서 확장한 멤버변수
	private String stNumber;
	// 생성자
	public Student(String name, int age, String stNumber) {
		// 자식 인스턴스를 생성하기 전 부모 생성자를 먼저 호출해야 함
		super(name, age);
		this.stNumber = stNumber;
	}
	// 객체의 저장된 내용을 문자열의 형태로 반환
	@Override
	public String toString() {
		// 부모의 toString()을 먼저 호출한 후 자식쪽의 멤버를 출력
		return super.toString() + ", 학번 : " + stNumber;
	}
}
