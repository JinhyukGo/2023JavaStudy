package ex17collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class Ex08AsList {
	
	// 컬렉션을 매개변수로 받은 후 전체항목을 출력함
	public static void listPrint(String title, List<String> list) {
		// 제목 출력
		System.out.println("# "+ title);
		/*
		확장 for문으로 전체를 출력
		출력할 인스턴스가 String이므로 별도의 오버라이딩없이도 내용 출력 가능
		만약 우리가 직접 정의한 클래스라면 toString()을 오버라이딩해야 함
		 */
		for(Object ob : list) {
			System.out.print(ob+" ");
		}
		System.out.println();
	}

	public static void main(String[] args) {

		// String 인스턴스 배열을 생성과 동시에 초기화함
		// 이 경우 초기 데이터를 통해 크기를 유추할 수 있으므로 크기는 생략해야 함
		String[] strArr = new String[] {"마린", "파이어뱃", "메딕", "마린"};
		/*
		Arrays.asList() : 일반적인 배열을 List<e> 컬렉션으로 변경한 후 반환
		단 값의 참조만 가능하고 입력이나 삭제는 할 수 없음
		 */
		List<String> list = Arrays.asList(strArr);
		listPrint("출력1", list);
		// 현재 상태에서는 데이터를 추가할 수 없음 - 런타임 에러 발생
		// list.add("탱크"); // 에러 발생
		
		/*
		ArrayList<E>의 생성자를 통해 앞에서 만든 인스턴스를 복사하면 데이터를 변경할 수 있음
		 */
		list = new ArrayList<String>(list);
		// 복사한 이후에는 데이터를 추가할 수 있음
		boolean isAdd = list.add("탱크");
		System.out.println("add 결과 : "+ isAdd);
		listPrint("출력2", list);
		
		/*
		이터레이터를 for문을 이용해서 출력함
		for(초기값 ; 조건식 ; 증감식) {
			실행문장 -> next()가 증감식을 대체하는 형식으로 작성
		}
		 */
		System.out.println("# 출력3");
		for(Iterator<String> itr = list.iterator(); itr.hasNext();) {
			System.out.print(itr.next()+" ");
		}
		System.out.println();
		
		/*
		Set<E> 컬렉션은 중복을 허용하지 않으므로 List에 저장된 중복값을 제거할 수 있음
		단 출력 순서는 변경될 수 있음
		 */
		HashSet<String> set = new HashSet<String>(list);
		list = new ArrayList<String>(set);
		listPrint("출력4(중복제거)", list);
	}
}