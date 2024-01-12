package ex12inheritance.map;

//직사각형을 표현한 클래스
class Rectangle {
	// 멤버변수 : width, height 
	int width;
	int height;
	
	// 생성자 : 멤버변수를 초기화
	public rectangle()
	
	public void showAreaInfo() {
		System.out.println("직사각형 넓이 : " + (width*height));
	}
} 
//정사각형을 표현한 클래스(정사각형은 직사각형의 일종)
class Square extends Rectangle {
	// 직사각형은 가로, 세로 두 변의 길이가 서로 다르기 때문에 2개의 멤버변수가 필요함
	// 정사각형은 가로와 세로의 길이가 동일하므로, 1개의 값으로 2개의 멤버변수를 초기화할 수 있음
	// 즉 해당 크래스는 멤버변수의 확장이 필요하지 않음
	public Square(int w) {
		super(w, w);		
	}
	@Override
	public void showAreaInfo() {
		System.out.println("정사각형 넓이 : " + (super.width*super.height));
	}
} 
class QuRectangleMain {
	public static void main(String[] args) {
		// 직사각형을 표현
       	Rectangle rec = new Rectangle(4, 3);
       	rec.showAreaInfo();

 		Square sqr = new Square(7);
       	sqr.showAreaInfo();
 	}
}
