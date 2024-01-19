package ex20io;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

class Friend implements Serializable {
	String name;
	String phone;
	String addr;
	
	public Friend(String name, String phone, String addr) {
		this.name = name;
		this.phone = phone;
		this.addr = addr;
	}
	public void showAllData() {
		System.out.println("이름 : " + name);
		System.out.println("전화번호 : " + phone);
		System.out.println("주소 : " + addr);
	}
	public void showBasicInfo() {}
}

class HighFriend extends Friend {
	
	String nickname;
	
	public HighFriend(String name, String phone, String addr, String nickname) {
		super(name, phone, addr);
		this.nickname = nickname;
	}
	@Override
	public void showAllData() {
		System.out.println("== 고등학교 친구(전체 정보) ==");
		super.showAllData();
		System.out.println("별명 : " + nickname);
	}
	@Override
	public void showBasicInfo() {
		System.out.println("== 고등학교 친구 ==");
		System.out.println("별명 : " + nickname);
		System.out.println("전화번호 : " + phone);
	}
}

class UnivFriend extends Friend {
	String major;
	
	public UnivFriend(String name, String phone, String addr, String major) {
		super(name, phone, addr);
		this.major = major;
	}
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

public class E12MyFriendInfoList {

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

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		// 컬렉션은 최초 생성시 크기를 지정하지 않음
		// 입력 혹은 삭제되는 인스턴스에 따라 크기가 자동으로 설정됨 - 그래서 new FriendInfoHandler(100)에서 100 삭제
		FriendInfoHandler handler = new FriendInfoHandler();

		/*
		프로그램 시작시 직렬화된 파일이 있다면 즉시 복원하여 List 컬렉션에 저장한다
		 */
		handler.readFriendInfo();
		
		while(true) {
			menuShow();
			
			int choice = scan.nextInt();
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
				/*
				프로그램을 종료할 때 List 컬렉션에 저장되었던 전체 정보를 '직렬화'해서 파일에 저장
				파일명 : friend_info.obj
				 */
				handler.saveFriendInfo();
				System.out.println("프로그램 종료");
				return;
			} // switch 끝
		} // while 끝
	} // main 끝
} // class 끝

class FriendInfoHandler {
	// 멤버변수 : 기존 인스턴스 배열을 변경 후 List컬렉션으로
//	private Friend[] myFriends;
//	private int numOfFriends;
	/*
	기존에는 카운트를 위한 별도의 변수가 필요했지만 컬렉션은 자동인덱싱을 지원하므로 필요하지 않음
	즉 컬렉션 인스턴스만 필요함
	 */
	ArrayList<Friend> lists;
	
	/*
	멤버변수가 변경되었으므로 생성자에서도 아래와 같이 수정해야 함
	컬렉션 초기화
	카운트가 필요없으므로 매개변수 num도 삭제
	 */
	public FriendInfoHandler() {
//		myFriends = new Friend[num];
//		numOfFriends = 0;
		lists = new ArrayList<Friend>();
	}
	// 친구 연락처 정보 추가
	public void addFriend(int choice) {
		Scanner scan = new Scanner(System.in);
		String iName, iPhone, iAddr, iNickname, iMajor;
		System.out.println("이름 : "); iName = scan.nextLine();
		System.out.println("전화번호 : "); iPhone = scan.nextLine();
		System.out.println("주소 : "); iAddr = scan.nextLine();
		
		if(choice==1) {
			// 고등학교 친구를 선택한 경우 별명을 추가로 입력받음
			System.out.println("별명 : "); iNickname = scan.nextLine();
			HighFriend high = new HighFriend(iName, iPhone, iAddr, iNickname);
//			myFriends[numOfFriends++] = high;
			/*
			기존 인스턴스 배열에서는 인덱스를 위한 카운트가 필요했지만 컬렉션에서는 필요하지 않음
			자동인덱싱이 지원되므로 add()를 통해 추가하기만 하면 됨
			 */
			lists.add(high);
		} else if(choice==2) {
			// 대학생 친구를 선택한 경우 전공을 추가로 입력받음
			System.out.println("전공 : "); iMajor = scan.nextLine();
//			myFriends[numOfFriends++] = 
					lists.add(new UnivFriend(iName, iPhone, iAddr, iMajor));
		}
		
		System.out.println("친구정보 입력이 완료되었습니다.");
	}

	// 전체정보를 출력하기 위한 메서드
	public void showAllData() {
//		for(int i = 0 ; i<numOfFriends ; i++) {
//			myFriends[i].showAllData();
//		}
		// 일반 for문을 통해 반복 출력
		for(int i=0 ; i<lists.size() ; i++) {
			lists.get(i).showAllData();
		}
		System.out.println("== 전체 정보가 출력되었습니다. ==");
	}
	// 간략정보를 출력하기 위한 메서드
	public void showSimpleData() { // 전체 정보 출력용 메서드
//		for(int i = 0 ; i<numOfFriends ; i++) {
//
//			myFriends[i].showBasicInfo();
//		}	
		// 확장 for문으로 반복 출력
		for(Friend fr : lists) {
			fr.showBasicInfo();
		}
		
		System.out.println("== 간단 정보가 출력되었습니다. ==");
	}
	
	public void searchInfo() {
		// 검색 여부 확인을 위한 변수
		boolean isFind = false;
		Scanner scan = new Scanner(System.in);
		System.out.print("검색할 이름을 입력하세요 : ");
		String searchName = scan.nextLine();
		
//		for(int i = 0 ; i<numOfFriends ; i++) {
//			if(searchName.compareTo(myFriends[i].name)==0) {
//				myFriends[i].showAllData();
//				System.out.println("** 요청하는 정보를 찾았습니다. **");
//				isFind = true;
//			}
//		}
//		if(isFind==false) {
//			System.out.println("** 찾는 정보가 없습니다. **");
//		} // end of searchInfo
		
		// 이터레이터를 통해 검색 기능 구현
		Iterator<Friend> itr = lists.iterator();
		// List컬렉션 전체를 대상으로 반복
		while(itr.hasNext()) {
			Friend fr = itr.next();
			// 검색할 이름과 인스턴스에 저장된 이름이 같은지 확인
			if(searchName.compareTo(fr.name)==0) {
				fr.showAllData();
				System.out.println("** 귀하가 요청하는 정보를 찾았습니다. **");
				isFind = true;
			}
		}
		// 초기값을 유지하고 있다면 정보는 없는 경우임
		if(isFind==false)
			System.out.println("** 찾는 정보가 없습니다. **");
	} // end of searchInfo
	
	/*
	퀴즈1] 검색 기능의 메서드 searchInfo()를 일반 for문을 통해 기능을 구현하시오.
	public void searchInfo() {
		// 검색한 이름이 있는지 확인용
		boolean isFind = false;
		// 스캐너 인스턴스 생성
		Scanner scan = new Scanner(System.in);
		System.out.print("검색할 이름을 입력하세요 : ");
		String searchName = scan.nextLine();
		
		// size()를 통해 컬렉션에 저장된 인스턴스의 개수만큼 반복
		for(int i=0 ; i < lists.size() ; i++) {
		
			// i번째 인덱스의 인스턴스를 접근한 후 name을 얻어와서 입력한 이름과 동일한지 확인함
			if(searchName.equals(lists.get(i).name)) {
			// 객체의 비교는 equals / 값에 대한 비교는 compareTo (값 자체에 대한 비교만 가능)
			// 만약 compareTo를 쓰고 싶다면 아래처럼
			if(searchName.comparTo(lists.get(i).name)==0)) {
				// 이름이 일치하면 정보를 출력
				lists.get(i).showAllData();
				System.out.println("** 요청하는 정보를 찾았습니다. **");
				// 확인용 변수는 true로 변경
				isFind = true;
			}
		}
		if(isFind==false) {
			System.out.println("** 찾는 정보가 없습니다. **");
		} // end of searchInfo			
	
			
	퀴즈2] 삭제 기능의 메서드 deleteInfo()를 이터레어터를 통해 기능을 구현하시오.
	public void deleteInfo() {
		// 검색한 이름이 있는지 확인용
		boolean isFind = false;
		// 스캐너 인스턴스 생성
		Scanner scan = new Scanner(System.in);
		System.out.print("삭제할 이름을 입력하세요 : ");
		String deleteName = scan.nextLine();
		
		// List 컬렉션에 저장된 인스턴스를 기반으로 Iterator 인스턴스를 생성
		// 이때 타입매개변수는 List와 동일하게 정의
 		Iterator<Friend> itr = lists.iterator();
 		// 저장된 인스턴스의 개수만큼 반복
		while(itr.hasNext()) {
			// 컬렉션에 저장된 참조값을 순서대로 인출
			Friend fr = itr.next();
			// 인스턴스의 이름과 삭제할 이름을 비교
			if(deleeteName.equals(fr.name)) {
			// 일치하면 삭제
				lists.remove(fr);
				isFind = true;
				System.out.println("** 요청하는 정보를 삭제했습니다. **");
				// 삭제 후 즉시 탈출
				break;
			}
		}
		if(isFind==false)
			System.out.println("** 찾는 정보가 없습니다. **");
		}	
	}	
	 */
	
	public void deleteInfo() {
		Scanner scan = new Scanner(System.in);
		System.out.print("삭제할 이름을 입력하세요 : ");
		String deleteName = scan.nextLine();

		// 인덱스는 음수가 없으므로 초기값은 -1로 지정
		int deleteIndex = -1;
		
//		for(int i = 0 ; i<numOfFriends ; i++) {
//			if(deleteName.compareTo(myFriends[i].name)==0) {
//				myFriends[i] = null;
//				deleteIndex = i;
//				numOfFriends--;
//				break;
//		}
//	}
		for(Friend fr : lists) {
			if(deleteName.compareTo(fr.name)==0) {
				// 정보가 일치하면 참조값을 통해 인스턴스 삭제
				lists.remove(fr);
				// 삭제가 완료됨녀 1로 변경
				deleteIndex = 1;
				// 반복문을 즉시 탈출
				break;
			}
		}
	
		// 삭제 여부에 따라 메시지를 출력
		if(deleteIndex==-1) {
			System.out.println("== 삭제된 데이터가 없습니다. ==");
		} else {
//			for(int i=deleteIndex ; i<numOfFriends ; i++) {
//				myFriends[i] = myFriends[i+1];
//			}
//			System.out.println("== 데이터(" + deleteIndex + "번)가 삭제되었습니다. ==");
//		}
			System.out.println("== 데이터가 삭제되었습니다. ");
		}
	} // end of deleteInfo
	
/*
현재 추가되는 정보는 List에 저장된다. 프로그램을 종료하면 저장된 내용이
소멸되므로, 재시작시 정보를 처음부터 다시 입력해야하는 불편함이 있다.
Serializable 인터페이스를 이용한 직렬화로 친구들의 정보를 파일로 저장해보자.   

퀴즈1] 친구의 정보를 파일로 직렬화하기 위한 메서드를 정의하시오.
	-메서드명 : saveFriendInfo()
	-저장할 파일명 : myfriend_info.obj
	-메뉴 '7.프로그램종료'을 선택한 경우 실행하면 된다. 
	※ 해당 메서드는 FriendInfoHandler 클래스에 추가하면 된다. 

퀴즈2] 프로그램을 다시 시작하면 문제1에서 직렬화 했던 파일을 
	역직렬화해서 복원하시오. 만약 3명의 정보가 저장되었다면 다시 
	시작한 직후 정보출력을 하면 3명의 정보가 출력되어야 한다. 
	메서드명 : readFriendInfo()
	※ 해당 메서드는 FriendInfoHandler 클래스에 추가하면 된다.
 */
	public void saveFriendInfo() {
		try {
			// 직렬화(파일 저장)를 위한 출력스트림을 생성
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("src/ex20io/myfriend_info.obj"));
			
			// List 컬렉션에 저장된 친구의 정보의 개수만큼 반복
			for(Friend fr : lists) {
				// 파일에 인스턴스를 하나씩 저장
				out.writeObject(fr);
			}
			// 스트림 소멸
			out.close();
		
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void readFriendInfo() {
		ObjectInputStream in = null;
		try {
			// 파일을 복원(역직렬화)하기 위한 스트림을 생성
			in = new ObjectInputStream(new FileInputStream("src/ex20io/myfriend_info.obj"));
			/*
			파일에 몇 개의 정보가 저장되었는지 알 수 없으므로 무한루프로 구성
			 */
			while(true) {
				/*
				직렬화될 때 Object 타입으로 업캐스팅되어 저장되므로 역직렬화할 때는 반드시 다운캐스팅을 해야 함
				 */
				Friend fr = (Friend)in.readObject();
				// List 컬렉션에 정보를 추가
				lists.add(fr);
				// 더이상 복원한 정보가 없다면 EOF(End of File) 예외가 발생하여 while문을 탈출한 후 catch절로 이동
			}
		} catch(FileNotFoundException e) {
			System.out.println("obj파일이 없습니다.");
		} catch(EOFException e) {
			System.out.println("파일의 끝까지 모두 복원했습니다.");
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("복원 중 예외 발생");
		} finally {
			/*
			try절에서 예외가 발생하더라도 finally절은 무조건 실행되므로 스트림은 정상적으로 닫을 수 있음
			 */
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
