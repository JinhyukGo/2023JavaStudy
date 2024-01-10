package ex08class;

class TriangleT {
	
	// 멤버 변수
	int width;
	int height;
	
	// 초기화를 위한 메서드
	void init(int width, int height) {
		// 멤버변수와 매개변수의 이름이 동일하면 구분하기 어려우므로 this를 붙여서 구분
		// this는 자신의 멤버를 가리키는 키워드로 사용
		this.width = width;
		this.height = height;	
	}
	// void로 적으면 에러로 보이는데, 0.5를 곱하면 double이 되기 때문 // 따라서 double로 적어주면 오류가 해결됨
	double getArea() {
		return width * width * height * 0.5;
	}
	
	// 밑변 및 높이를 설정하는 메서드
	void setBottom(int w) {
		//  this를 안 붙여도 되지만 멤버변수이며 자기 메서드 내부임을 표시하기 위해 this 사용
		this.width = w;
	}
	void setHeight(int h) {
		this.height = h;
	}
}

public class QuTriangleT {

	public static void main(String[] args)
	{
		TriangleT t = new TriangleT();
		t.init(10, 17); //밑변10, 높이17로 초기화
		System.out.println("삼각형의 넓이 : "+ t.getArea());
		t.setBottom(50);//밑변 50으로 변경
		t.setHeight(14);//높이 14로 변경
		System.out.println("삼각형의 넓이 : "+ t.getArea());
	}
}
