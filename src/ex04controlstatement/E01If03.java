package ex04controlstatement;

public class E01If03 {
	
	public static void main(String[] args) {
	
	/*
	if문 형식 3
	if(조건1)
		조건1이 참일 때;
	else if(조건2)
		조건2가 참일 때;
	else
		위 조건 모두에 만족하지 않을 때;
	else문에는 조건식이 들어가면 에러가 발생하므로 주의해야 함
	 */
		
		
	// 국영수 점수의 평균값을 구하여 학점을 출력하는 프로그램 작성하기 / 점수는 정수타입
	int kor=99, eng=70, math=64;
	// 평균값은 소수점이 나올 수 있으므로 실수형으로 선언해야 함 -> double / 그래서 나누는 값도 3이 아니라 3.0
	double avg = (kor+eng+math) / 3.0;
	System.out.println("평균점수는(그대로):"+ avg);
	System.out.printf("평균점수는(소수2자리):%.2f\n", avg);

	if(avg>=90) {
		System.out.println("A학점");	
	}
	else if(avg>=80) {
		System.out.println("B학점");	
	}
	else if(avg>=70) {
		System.out.println("C학점");	
	}
	else if(avg>=60) {
		System.out.println("D학점");	
	}
	else {
		System.out.println("F학점 + 학사경고!");
	}
	
	// 아래의 경우는 이미 첫 번째 문장에서 60 이상 조건이 맞기 때문에, 아래의 문장까지 내려가지 못함 / D학점으로 나옴
	System.out.println("잘못된 조건식의 if문");
	
	if(avg>=60) {
		System.out.println("D학점");	
	}
	else if(avg>=70) {
		System.out.println("C학점");	
	}
	else if(avg>=80) {
		System.out.println("B학점");	
	}
	else if(avg>=90) {
		System.out.println("A학점");	
	}
	else {
		System.out.println("F학점 + 학사경고!");
	}
	}
}
