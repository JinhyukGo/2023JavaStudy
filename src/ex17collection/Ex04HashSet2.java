package ex17collection;

import java.util.HashSet;

import common.Teacher;

public class Ex04HashSet2 {

	public static void main(String[] args) {

		// Teacjer 인스턴스를 저장할 수 있는 Set컬렉션 생성
		HashSet<Teacher> hashSet = new HashSet<Teacher>();
		
		Teacher t1 = new Teacher("정우성", 40, "국어");
		Teacher t2 = new Teacher("황정민", 42, "영어");
		Teacher t3 = new Teacher("최민식", 44, "수학");
		
		// 인스턴스 3개 추가
		hashSet.add(t1);
		hashSet.add(t2);
		hashSet.add(t3);
		
		System.out.println("hashSet의 크기 : " + hashSet.size());
		
		// 4번째 인스턴스를 생성 : t1과 동일한 형태로 작성
		// Teacher t1Same = new Teacher("정우성", 40, "국어");
		// teacher 클래스의 시나리오에서 나이와 과목이 같을 때 동일한 인스턴스로 판단하겠다고 했으므로 t1과 t1same은 동일한 인스턴스임
		Teacher t1Same = new Teacher("이정재", 40, "국어");
		
		/*
		오버라이딩 전 : Teacher 클래스에 별도의 오버라이딩이 없으면 동일한 인스턴스인지 판단할 수 있는 기준이 없으므로 정상적으로 입력됨
		즉, 중복이 제거되지 않음
		 */
		System.out.println("t1Same 저장 여부 : " + hashSet.add(t1Same));
		System.out.println("hashSet의 크기 : " + hashSet.size());	
	}
}
