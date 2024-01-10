package ex11static;

class X {
	public x() {
		System.out.println("X의 생성자");
	}
}
class Y extends X {
	public Y() {
		super();
		System.out.println("Y의 생성자");
	}	
}

public class test {

	public static void main(String[] args) {
		Y y = new Y();
	}
}
