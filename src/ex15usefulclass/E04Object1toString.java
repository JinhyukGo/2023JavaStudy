package ex15usefulclass;

/*
Object 클래스
- 자바에서 최상위 클래스
- 별도의 선언없이 Object 클래스에 정의된 모든 메서드 호출 가능
- 개발자가 정의한 모든 클래스는 Object의 참조변수로 참조 가능
ex) Object obj = new Person()
	혹은
	void myFunc(Object obj) {}
 */

/*
toString() 메서드
- Object에 정의된 메서드로 print()문이 문자열을 출력하기 전에 자동으로 호출하는 메서드
- 인스턴스 변수를 문자열 형태로 변환하여 반환
- 필요한 경우 클래스 정의시 적절히 오버라이딩하여 제정의하는 것이 좋으나 필수사항은 아님
 */

class MyFriends extends Object {
	String myName;
	public MyFriends(String name) {
		myName = name;
	}
	@Override
	public String toString() {
		return "이름 : " + myName;
	}
	// 자동생성 메뉴를 사용하여 작성하면 아래와 같이 작성됨
//	@Override
//	public String toString() {
//		return "MyFriends [myName=" + myName + "]";
//	}
	
}
// toString을 오버라이딩하지 않음
class YourFriends extends Object {
	String myName;
	public YourFriends(String name) {
		myName = name;
	}
}
public class E04Object1toString {
	
	public static void main(String[] args) {
		
		MyFriends fnd1 = new MyFriends("성유겸");
		YourFriends fnd2 = new YourFriends("헬로비너스");
		
		// toString을 오버라이딩했으므로 이름이 출력되지만, 두 번째는 오버라이딩하지 않았기 때문에 인스턴스의 참조값만 출력됨
		System.out.println(fnd1);
		System.out.println(fnd2);
	}

}
