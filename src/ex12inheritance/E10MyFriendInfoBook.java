package ex12inheritance;

import java.util.Scanner;

// 친구를 추상화한 최상위 클래스로 해당 프로그램에서는 Friend클래스로 인스턴스 생성은 하지 않음
// 단지 기본 정보의 저장 및 상속을 목적으로 하는 클래스
// 이와 같이 데이터를 저장하기 위한 용도의 클래스를 가리켜 VO(Value Object)라고 함 (값만 가진 객체)
class Friend {
	// 멤버변수 : 이름, 전화번호, 주소 3가지를 저장
	String name;
	String phone;
	String addr;
	
	// 생성자 : 멤버변수 초기화 / 변수 구분을 위해 this 사용
	public Friend(String name, String phone, String addr) {
		this.name = name;
		this.phone = phone;
		this.addr = addr;
	}
	// 멤버변수 전체를 출력하기 위한 멤버 메서드
	public void showAllData() {
		System.out.println("이름 : " + name);
		System.out.println("전화번호 : " + phone);
		System.out.println("주소 : " + addr);
	}
	// 간략 정보를 출력하기 위한 메서드로 실행부가 없는 상태로 정의
	// 해당 프로그램에서는 오버라이딩의 목적으로만 사용하기 위해 정의
	public void showBasicInfo() {}
}

// 고등학교 친구의 정보를 저장하기 위한 자식 클래스
class HighFriend extends Friend {
	
	// 확장한 멤버변수 : 별명
	String nickname;
	
	// 생성자 : 부모의 생성자를 먼저 호출한 후 멤버변수를 초기화
	public HighFriend(String name, String phone, String addr, String nickname) {
		super(name, phone, addr);
		this.nickname = nickname;
	}
	// 오버라이딩1 : 고등학교 친구의 전체 정보를 출력하기 위해 부모에서 정의한 메서드를 super를 통해 먼저 호출하고, 자식에서 확장한 변수를 추가해서 출력
	@Override
	public void showAllData() {
		System.out.println("== 고등학교 친구(전체 정보) ==");
		super.showAllData();
		System.out.println("별명 : " + nickname);
	}
	// 오버라이딩2 : 자식 클래스에서 오버라이딩하여 재정의한 메서드로 고등학교 친구의 간략한 정보를 출력 / 부모 클래스에서는 실행부가 없는 상태로 정의되었음
	@Override
	public void showBasicInfo() {
		System.out.println("== 고등학교 친구 ==");
		System.out.println("별명 : " + nickname);
		System.out.println("전화번호 : " + phone);
	}
}

// 대학교 친구 정보 저장을 위한 자식 클래스
class UnivFriend extends Friend {
	// 확장한 멤버변수로 전공과목을 표현
	String major;
	
	// 생성자
	public UnivFriend(String name, String phone, String addr, String major) {
		super(name, phone, addr);
		this.major = major;
	}
	// 오버라이딩 1, 2 역시 HighFriend클래스와 동일한 패턴으로 정의됨
	@Override
	public void showAllData() {
		System.out.println("== 대학교 친구(전체 정보) ==");
		super.showAllData();
		System.out.println("전공 : " + major);
	}
	@Override
	public void showBasicInfo() {
		System.out.println("== 대학교 친구 ==");
		System.out.println("이름 : " + name);
		System.out.println("전화번호 : " + phone);
	}
}

// 메인클래스
public class E10MyFriendInfoBook {

	// 메뉴를 출력하는 용도의 메서드로 매개변수, 반환타입이 없는 형태로 정의함
	// main 메서드에서 직접 호출하기 위해 static으로 선언되어 있음
	public static void menuShow() {
		System.out.println("### 메뉴를 입력하세요. ###");
		System.out.print("1.고등학교 친구 입력");
		System.out.println(" 2.대학교 친구 입력");
		System.out.print("3.전체 정보 출력");
		System.out.println(" 4.간단 정보 출력");
		System.out.print("5.검색");
		System.out.print(" 6.삭제");
		System.out.println(" 7.프로그램 종료");
		System.out.print("메뉴 선택");
	}

	// 메인 메서드는 해당 프로그램의 시작점(Entry point)이므로 복잡한 로직의 구성보다는 프로그램의 전반적인 흐름에 대해서만 기술하는 것이 좋음
	// 따라서 선택한 메뉴에 따라 핸들러 클래스의 메서드만 호출하는 형태로 구현되어 있음
	public static void main(String[] args) {
		// 사용자 입력을 위한 인스턴스 생성
		Scanner scan = new Scanner(System.in);
		// 기능을 담당하는 핸들러 클래스의 인스턴스 생성
		FriendInfoHandler handler = new FriendInfoHandler(100);
		
		// 무한루프 조건으로 사용자가 원할 때 종료할 수 있는 구조를 만들어 줌
		// break문은 반복문을 탈출시키는 기능이 있으므로 이와같은 무한루프에서 자주 사용
		// for( ; ; )문을 통해 무한루프를 구현할 수 있으나 반복의 횟수가 명확하지 않은 경우에는 주로 while문을 사용
		while(true) {
			// 1. 메뉴 출력
			menuShow();
			
			// 2. 사용자로부터 메뉴를 입력받음
			int choice = scan.nextInt();
			// 3. 선택한 번호에 따른 메서드 출력
			switch(choice) {
			case 1: case 2:
				handler.addFriend(choice);
				break;
			case 3:
				handler.showAllData();
				break;
			case 4:
				handler.showSimpleData();
				break;
			case 5:
				handler.searchInfo();
				break;
			case 6:
				handler.deleteInfo();
				break;
			case 7:
				System.out.println("프로그램 종료");
				return;
			} // switch 끝
		} // while 끝
	} // main 끝
} // class 끝

// 해당 프로그램에서 기능을 담당하는 클래스로 핸들러 혹은 매니저 클래스라고 부름
class FriendInfoHandler {

	// 멤버변수
	// 상속관계에서 부모클래스로 인스턴스 배열을 생성
	// 부모로 자식을 참조할 수 있으므로, 부모타입의 인스턴스를 모두 저장 가능 
	private Friend[] myFriends;
	// 배열에 저장된 연락처 정보를 카운트하기 위한 변수로 추가할 때마다 1씩 증가
	private int numOfFriends;
	
	// 생성자 : 인스턴스 배열의 크기를 인수로 받은 후 초기화
	public FriendInfoHandler(int num) {
		myFriends = new Friend[num];
		numOfFriends = 0;
	}
	// 친구 정보 연락처 추가
	public void addFriend(int choice) {
		// 고등학생이나 대학생 모두 기본 정보가 있으므로 먼저 입력받음
		Scanner scan = new Scanner(System.in);
		String iName, iPhone, iAddr, iNickname, iMajor;
		System.out.println("이름 : "); iName = scan.nextLine();
		System.out.println("전화번호 : "); iPhone = scan.nextLine();
		System.out.println("주소 : "); iAddr = scan.nextLine();
		// 입력선택에 따라 고등학생 혹은 대학생으로 분기하여 입력받음
		if(choice==1) {
			// 고등학생을 선택한 경우 별명을 추가로 입력
			System.out.println("별명 : "); iNickname = scan.nextLine();
			// High 인스턴스 생성 후 참조변수에 저장
			HighFriend high = new HighFriend(iName, iPhone, iAddr, iNickname);
			// 참조변수를 인스턴스 배열에 추가
			// 인덱스로 사용된 변수의 초기값이 0이므로 0번 인덱스에 추가된 뒤 1 증가됨 -> 후위증가
			myFriends[numOfFriends++] = high;
		} else if(choice==2) {
			// 대학생을 선택한 경우, 닉네임 대신 전공을 입력받음
			System.out.println("전공 : "); iMajor = scan.nextLine();
			// 인스턴스 생성과 동시에 배열에 추가함
			myFriends[numOfFriends++] = new UnivFriend(iName, iPhone, iAddr, iMajor);
		}
		
		System.out.println("친구정보 입력이 완료되었습니다.");
	}
	
	// 저장된 친구의 정보를 출력하기 위한 멤버 메서드
	// 1. 친구 정보를 추가할 때 High 혹은 Univ 인스턴스를 배열에 저장
	// 2. 이때 인스턴스는 Friend로 자동형변환(업캐스팅)되어 저장됨
	// 3. 정보 출력시 배열에 입력된 개체수만큼 반복하여 각 원소를 통해 정보를 출력
	// 4. 출력을 위한 멤버메서드는 상속관계에서 오버라이딩되어 있으므로 참조변수의 영향없이 항상 자식클래스에 오버라이딩된 메서드가 호출됨
	// 5. 즉 저장된 인스턴스는 Friend 타입이지만 오버라이딩을 통해 별도의 형변환이 필요하지 않음 / 항상 원하는 정보를 간단히 출력할 수 있음
	public void showAllData() {
		for(int i = 0 ; i<numOfFriends ; i++) {
			myFriends[i].showAllData();
		}
		System.out.println("== 전체 정보가 출력되었습니다. ==");
	}
	public void showSimpleData() {
		for(int i = 0 ; i<numOfFriends ; i++) {

			// 오버라이딩 없이 사용하려면 요렇게 가능함
			// 만약 부모클래스인 Friend에 showBasicInfo() 메서드를 정의하지 않았다면, 자식클래스에서는 오버라이딩을 할 수 없으므로 개별적인 멤버메서드 정의가 필요함
			// 정보가 저장되는 배열은 Friend 타입이므로 자식인스턴스를 저장하면 자동으로 형변환(업캐스팅)이 됨
			// 이때 자식의 정보를 출력하는 메서드는 바로 호출할 수 없으므로 아래와 같이 일일이 강제형변환(다운캐스팅)을 해줘야 함
			// 또한 상속의 구조가 복잡해질수록 조건을 추가해야 함
//			if(myFriends[i] instanceof UnivFriend) {
//				((UnivFriend)myFriends[i]).showBasicInfo();
//			} else if(myFriends[i] instanceof HighFriend) {
//				((HighFriend)myFriends[i]).showBasicInfo();
//			}
			
			// 오버라이딩을 이용하면 상속의 구조가 복잡해지더라도 아래와 같이 한줄이면 정보 출력이 가능해짐
			myFriends[i].showBasicInfo();
		}
		System.out.println("== 간단 정보가 출력되었습니다. ==");
	}
	
	// 연락처 정보 검색
	public void searchInfo() {
		boolean isFind = false;
		Scanner scan = new Scanner(System.in);
		System.out.print("검색할 이름을 입력하세요 : ");
		String searchName = scan.nextLine();
		
		// 배열에 저장된 연락처의 개수만큼 반복
		for(int i = 0 ; i<numOfFriends ; i++) {
			// 배열의 각 인덱스에 저장된 인스턴스의 참조값을 통해 멤버변수에 접근
			// 검색을 위해 입력한 이름과 비교해서 일치하는 경우에만 정보를 출력
			// 이때 equals()를 사용해도 결과값은 동일함
			if(searchName.compareTo(myFriends[i].name)==0) {
				// 연락처의 전체 정보를 출력
				myFriends[i].showAllData();
				System.out.println("** 요청하는 정보를 찾았습니다. **");
				// 확인용 변수를 true로 변경
				isFind = true;
			}
		}
		// 만약 검색결과가 없다면 아래와 같이 출력
		if(isFind==false) {
			System.out.println("** 찾는 정보가 없습니다. **");
		} // end of searchInfo
	}
	
	public void deleteInfo() {
		Scanner scan = new Scanner(System.in);
		System.out.print("삭제할 이름을 입력하세요 : ");
		String deleteName = scan.nextLine();
		// 배열의 원소 중 삭제된 원소의 인덱스값을 저장하기 위한 변수로 삭제한 후 빈자리를 채워넣을 때 사용함
		// 인덱스는 0부터 시작이므로 -1을 초기값으로 설정
		int deleteIndex = -1;
		
		// 삭제할 인스턴스를 찾기 위해 저장된 개수만큼 반복
		for(int i = 0 ; i<numOfFriends ; i++) {
			// 입력된 이름과 일치하는지 확인
			if(deleteName.compareTo(myFriends[i].name)==0) {
				// 인스턴스 배열에서 삭제는 null값으로 변경하면 됨
				// 참조값이 null이라는 것은 참조할 인스턴스가 없다는 의미이므로 삭제한 것과 동일한 결과
				// 실제로 참조되지 않는 인스턴스는 차후 가비지 컬렉션에 의해 자동으로 삭제됨
				myFriends[i] = null;
				// 삭제된 원소의 index를 저장
				deleteIndex = i;
				// 전체 카운트를 1 차감
				numOfFriends--;
				// 하나의 인스턴스 삭제 후 즉시 for문을 탈출
				break;
		}
	}
	
		if(deleteIndex==-1) {
			System.out.println("== 삭제된 데이터가 없습니다. ==");
		} else {
			// 인스턴스 배열에서 원소를 삭제한 후 바로 뒤에 있는 원소를 앞으로 하나씩 복사함
			// 해당 처리가 되지 않는다면 차후 검색이나 삭제시 NullPointerException이 발생할 수 있음
			for(int i=deleteIndex ; i<numOfFriends ; i++) {
				myFriends[i] = myFriends[i+1];
			}
			// 삭제 결과를 출력
			System.out.println("== 데이터(" + deleteIndex + "번)가 삭제되었습니다. ==");
		}
	}
}
