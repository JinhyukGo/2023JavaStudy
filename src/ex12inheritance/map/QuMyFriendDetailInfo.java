package ex12inheritance.map;

//친구의 정보를 저장할 기본클래스
class MyFriendInfo{
	private String name;
	int age;
	
	public void showMyFriendInfo() {
		System.out.println("이름: "+ name);
		System.out.println("나이: "+ age);
	}
}
//친구의 기본정보 외 상세정보를 저장할 클래스
class MyFriendDetailInfo extends MyFriendInfo {
	private String addr;
  	private String phone;

  	// 생성자
	public void showMyFriendDetailInfo(String name, int age, String addr, String phone){
		super(name, age);
		this.addr;
		this.phone;
		
		showMyFriendInfo();
		System.out.println("주소: "+ addr);
		System.out.println("전화: "+ phone);
	}
}
class QuMyFriendDetailInfo {
	public static void main(String[] args) {
		//이름, 나이, 주소, 전화번호를 인자로 객체를 생성…
		MyFriendEdtailInfo info = new MyFriendDetailInfo("이순신", 99, )
		//정보Print
	}
}
