package ex04controlstatement;

public class QuIfElseChange {

	public static void main(String[] args) {

		int num1=50, num2=100;
		int big, diff;

		big = (num1>num2)? num1:num2; //조건?참:거짓;
		System.out.println(big);

		diff = (num1>num2)? num1-num2: num2-num1;
		System.out.println(diff); 

		System.out.println("=========="); 

		int num3=50, num4=100;

		if(num3 > num4) {
			System.out.println("big = " + num3);
		} else {
			System.out.println("big = " + num4);
		}

		if(num3 > num4) {
			System.out.println("diff = " + (num3 - num4));
		} else {
			System.out.println("diff = " + (num4 - num3));
		}
		
	}

}
