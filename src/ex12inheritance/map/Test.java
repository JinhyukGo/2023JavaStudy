package ex12inheritance.map;

public class Test {
	// 보통의 경우 멤버 변수의 접근 지정자는 private으로 선언
	private int age;
	private String name;
	boolean isMarried;
	
	// 생성자 (디폴트 생성자 및 인수 생성자)
	public Test() {}
	public Test(int age, String name) {
		this.age = age;
		this.name = name;
	}

	public Test(int age, String name, boolean isMarried) {
		this.age = age;
		this.name = name;
		this.isMarried = isMarried;
	}
	
	// getters / setters 메서드 : private 멤버 변수를 외부 클래스에서 접근하여 값을 반환하거나 설정하는 메서드
	// 외부에서 접근 가능해야 하므로 반드시 public으로 선언해야 함
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isMarried() {
		return isMarried;
	}
	public void setMarried(boolean isMarried) {
		this.isMarried = isMarried;
	}
	
	
	
	
}

