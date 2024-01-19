package ex20io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*
직렬화 : Circle 클래스를 입출력의 대상으로 파일로 저장하기 위해 Serializable 인터페이스를 구현하여 정의
인스턴스가 파일의 형태로 저장되는 것을 직렬화라고 함
만약 상속되는 경우라면 부모쪽만 implements 하면 됨
 */

class Circle implements Serializable {
	// 원의 좌표와 반지름을 표현한 멤버변수
	int xPos, yPos;
	double radian;
	public Circle(int x, int y, double r) {
		xPos = x;
		yPos = y;
		radian = r;
	}
	// 원의 정보를 출력하는 멤버메서드
	public void showcircleInfo() {
		System.out.printf("좌표[%d, %d]", xPos, yPos);
		System.out.println("반지름 : " + radian);
	}
}

public class E11ObjectSerializable {

	public static void main(String[] args) {

		try {
			// 인스턴스를 파일로 저장하기 위해 출력스트림을 생성
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("src/ex20io/circle.obj"));
			
			// Circle 인스턴스를 생성한 후 파일에 저장
			out.writeObject(new Circle(1,1,2.4));
			out.writeObject(new Circle(2,2,4.8));
			// Java에서 제공하는 기본클래스는 별도의 처리없이 직렬화
			out.writeObject(new String("String 타입의 오브젝트"));
			out.close();
			
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("src/ex20io/circle.obj"));
			/*
			저장시 Object 기반으로 저장되므로 복원시에는 원래의 타입으로 강제형변환(다운캐스팅)해야 함
			 */
			Circle c1 = (Circle)in.readObject();
			Circle c2 = (Circle)in.readObject();
			String message = (String)in.readObject();
			// 스트림 소멸
			in.close();
			
			/*
			개발자가 정의한 클래스는 멤버메서드를 통해 정보 출력 가능
			 */
			c1.showcircleInfo();
			c2.showcircleInfo();
			// 기본 클래스는 이미 toString()이 오버라이딩 되어 있으므로 인스턴스만으로 내용 출력 가능
			System.out.println("String 오브젝트 : " + message);			
		} catch(ClassNotFoundException e) {
			System.out.println("클래스 없음");
		} catch(FileNotFoundException e) {
			System.out.println("파일 없음");
		} catch(IOException e) {
			System.out.println("뭔가 없음");
		}
	}

}
