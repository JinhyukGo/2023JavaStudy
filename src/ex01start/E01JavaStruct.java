/*
자바 파일의 구조
1. 패키지 선언부 : 현재 작성 중인 자바 파일의 저장 위치를 결정
2. 임포트 선언부 : 프로그램에서 사용하는 클래스를 가져와서 사용할 때 기술
3. 클래스 선언부 : 프로그램의 주 내용을 입력
 */

package ex01start;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
상단의 패키지, 임포트 선언부는 자동완성(Content Assist)기능으로 자동 입력됨
하단의 클래스 선언부는 구현할 기능에 대한 코드를 직접 작성함
 */

public class E01JavaStruct {

	public static void main(String[] args) {

		// 시스템에서 현재 시각을 가져옴
		Date toDayOfDate = new Date();
		System.out.println("오늘 날짜 :" + toDayOfDate);
		
		// 한국식 표시형식으로 변경하여 출력
		SimpleDateFormat simple =
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String toDayString = simple.format(toDayOfDate);
		System.out.println("변형된 날짜 : " + toDayString);
	}

}
