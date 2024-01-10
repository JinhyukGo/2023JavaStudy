package ex12inheritance;

// 부모 클래스
class Account {
	
	// 멤버 변수가 상속 관계에 있다 하더라도 private로 선언되면 클래스 내부에서만 접근 가능
	// 상속받은 하위 클래스에서는 직접 접근 불가
	private int money;
	// 이와 같이 개발자가 생성자를 직접 정의하면 디폴트 생성자는 추가되지 않음
	// 디폴트 생성자는 개발자가 생성자를 정의하지 않았을 때만 컴파일러에 의해 자동 추가함
	public Account(int init) {
		money = init;
	}
	// 입금처리 : protected로 선언되었으므로 상속관계에서 접근 가능
	protected void depositMoney(int _money) {
		// 마이너스 금액은 입금 불가 처리
		if(_money<0) {
			System.out.println("마이너스 금액은 입금처리 불가합니다.");
			return;
		}
		// 금액이 양수일 때만 입금처리
		money += _money;
	}
	// 현재는 부모와 자식 클래스가 동일한 패키지에 정의되어 있으므로 접근 지정자가 default더라도 접근은 허용됨
	// 즉 protected를 지워도 상관없음
	protected int getAccMoney() {
		return money;
	}
}

class SavingAccount extends Account {
	
	// 인자 생성자에서 부모의 생성자를 호출하기 위한 super(xx)를 사용함
	// 이때 매개변수가 하나인 부모클래스의 생성자가 호출됨
	// 현재 부모 클래스에는 매개변수가 하나인 생성자가 유일하므로 만약 아래와 같이 호출하지 않으면 에러 발생
	public SavingAccount(int initVal) {
		// 만약 아래 문장을 삭제하면 즉시 에러가 발생함
		// 삭제하는 경우 super()라는 문장, 즉 매개변수가 없는 디폴트 생성자를 호출하는 문장이 자동으로 추가되는데, 부모클래스에는 이런 형태의 생성자가 없으므로 아래와 같이 명시해야 함
		super(initVal);
	}
	// 부모 클래스에 정의된 멤버 변수 money는 private이므로 자식 쪽에서는 아래와 같이 직접 접근할 수 없음
	// 보이지 않으므로 에러 발생
	// 따라서 부모 클래스에 protected로 선언된 메서드를 통해 입금처리를 해야 함
	public void SaveMoney(int money) {
		depositMoney(money);
	}
	public void showAccountMoney() {
		System.out.println("지금까지의 누적금액 : " + getAccMoney());
	}
}

public class E02PrivateInheritanceMain {

	public static void main(String[] args) {

		// 
		SavingAccount sa = new SavingAccount(10000);
		// private 멤버이므로 상속받은 하위 클래스의 참조변수를 통해서는 접근할 수 없음
		// 은닉된 정보이므로 Not Visible 에러 발생
		// sa.money = 100000;
		sa.SaveMoney(5000);
		sa.showAccountMoney();
		sa.SaveMoney(-1000);
		sa.showAccountMoney();
		
		// 부모 클래스를 통해 인스턴스를 생성함
		// 하지만 해당 인스턴스 변수를 통해서도 멤버 변수 money에 접근할 수 없음
		// 현재 접근하려는 위치가 클래스 외부이기 때문
		// 즉 private 멤버는 무조건 클래스 내부에서만 접근 허용
		Account account = new Account(1000);
		// account.money = 1000;

	}
}
