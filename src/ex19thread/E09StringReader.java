package ex19thread;

import java.io.BufferedReader;
import java.io.FileReader;

public class E09StringReader {

	public static void main(String[] args) {

		try {
			BufferedReader in = new BufferedReader(new FileReader("src/ex20io/string.txt"));
		
			String str;
			
			while(true) {
				/*
				개행(줄바꿈)이 등장하기 전까지의 데이터를 한 번에 읽어옴
				즉 한줄씩 읽음
				 */
				str = in.readLine();
				
				// 더 이상 읽을 내용이 없다면 while 루프를 탈출
				if(str==null) {
					break;
				}
				/*
				입력이 newLine()을 통해 개행정보가 입력되지만 읽어들인 문자열에는 개행정보가 포함되지 않음
				입력시 개행정보를 문자열을 라인별로 구분하는 용도로만 사용하기 때문
				따라서 출력시 별도로 줄바꿈 처리를 해줘야 함
				 */
				System.out.println(str);
			}
			// 스트림 소멸
			in.close();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}