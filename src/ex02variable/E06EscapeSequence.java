package ex02variable;

public class E06EscapeSequence {

	public static void main(String[] args) {
		
		// tab(탭) 기능이 들어가면 스페이스 4칸만큼 띄워짐
		System.out.println("4월엔 벚꽃~~!");
		System.out.println("4월엔\t벚꽃~~!");
		
		// 줄바꿈 기능
		System.out.println("Java World에 오신걸 환영합니다.\n");
		System.out.println("열심히\n해봅시다.\n");
		
		// "" 내부에 ""를 사용하려면 \"사용해야 함
		// System.out.println("나는 "개발자"가 되고 싶어요.");
		System.out.println("나는 \"개발자\"가 되고 싶어요.");
		
		// 문자열을 서식에 맞춰서 출력할 때 사용
		int kor=81, eng=97, math=79;
		// 정수 : %d / 줄바꿈 : %n
		// 동일한 출력이 나오는 문장이지만 printf문이 조금 더 간단함
		System.out.printf("국어:%d, 영어:%d, 수학:%d%n", kor, eng, math);
		System.out.println("\n국어:" + kor + ", 영어:"+ eng +", 수학:"+ math);
		
		// 실수는 %f를 사용함 / 정수와 실수의 연산에서는 실수가 반환되어 double 타입의 변수에 대입해야 함
		double avg = (kor+eng+math) / 3.0;
		System.out.printf("평균점수:%f%n", avg);
		
		/*
		자리수 지정하기
		- %4d : 정수 출력 시 전체 자리수를 4자리로 표현
		- %6.2f : 실수 출력 시 전체 자리수는 6자리, 소수 이하 2자리로 표현
		- 양수는 우측 정렬 / 음수는 좌측 정렬
		 */
		System.out.printf("국어:%d, 영어:%d, 수학:%d," + " 평균:%f %n", kor, eng, math, avg);
		System.out.printf("국어:%6d, 영어:%6d, 수학:%6d," + " 평균:%7.4f %n", kor, eng, math, avg);
		System.out.printf("국어:%-6d, 영어:%-6d, 수학:%-6d," + " 평균:%-7.2f %n", kor, eng, math, avg);			

	}

}
