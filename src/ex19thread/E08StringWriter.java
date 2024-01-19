package ex19thread;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class E08StringWriter {

	public static void main(String[] args) {

		try {
			/*
			문자열을 저장하기 위한 출력스트림을 생성
			문자열의 입력은 버퍼에 따라 성능의 차이가 크기 때문에 버퍼 필터 스트림을 추가로 연결하여 사용
			 */
			BufferedWriter out = new BufferedWriter(new FileWriter("src/ex20io/string.txt"));
			
			/*
			write()를 통해 문자열을 저장하고, 줄바꿈은 newLine()을 통해 처리
			각 OS별로 개행문자가 다르기 때문에 메서드를 이용해야 함
			 */
			out.write("나는 공부한다.");
			out.newLine();
			out.write("너네는 취업이나 해라.");
			out.newLine();
			
			out.close();
			System.out.println("입력 완료");
		} catch(FileNotFoundException e) {
			System.out.println("파일 없음");
		} catch(IOException e) {
			System.out.println("IO 오류");
		}
	}
}