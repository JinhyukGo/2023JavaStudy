package ex04controlstatement;

public class E02Switch_Sce {

	public static void main(String[] args) {

		int kor = 100, eng = 100, math = 100;
		int avg = ((kor + eng + math) / 3) / 10;
		System.out.println("avg = " + avg*10);
		
		switch(avg) {
		case 10:case 9:
			System.out.println("A학점");
			break;
		case 8:
			System.out.println("B학점");
			break;
		case 7:
			System.out.println("C학점");
			break;
		case 6:
			System.out.println("D학점");
			break;
		default:
			System.out.println("F학점");		
		}
		
	}

}
