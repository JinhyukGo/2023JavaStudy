package ex17collection;

import java.util.Iterator;
import java.util.TreeSet;

/*
TreeSet<T> 컬렉션 : 트리라는 자료구조를 기반으로 한 Set계열의 컬렉션
- Set의 기본적인 특성은 동일함
- 따라서 중복은 허용되지 않고, 입력된 순서도 보장하지 않음
- 단 인스턴스가 정렬되어 저장됨 / 정렬의 기준은 개발자가 직접 정의할 수 있음
 */

/*
클래스 생성시 정렬의 기준을 만들어주기 위해서는 Comparable<T> 인터페이스를 구현해야 함
 */
class MyString implements Comparable<MyString> {
	String str;
	public MyString(String str) {
		this.str = str;
	}
	public int getLength() {
		return str.length();
	}
	@Override
	public int compareTo(MyString paramStr) {
//		if(getLength() > paramStr.getLength())
//			return 1;
//	 else if(getLength() < paramStr.getLength())
//		 return -1;
//	 else
//		 return 0;
		
	// 문자열의 첫 문자를 기준으로 하는 오름차순 정렬로 변경
	if(this.str.charAt(0) > paramStr.str.charAt(0))
		return 1;
	else
		return -1;
	}	
	@Override
	public String toString() {
		return str;
	}
}

public class Ex05TreeSetMain {

	public static void main(String[] args) {

		TreeSet<Integer> tree1 = new TreeSet<Integer>();
		tree1.add(1);
		tree1.add(4);
		tree1.add(2);
		tree1.add(3);
		tree1.add(2);
		// Set이므로 중복저장은 허용되지 않음
		
		System.out.println("저장된 데이터 수 : " + tree1.size() + "개"); // 4개
		
		Iterator<Integer> itr = tree1.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		//////////////////////////////////////////////
		
		// 문자열의 길이를 기준으로 오름차순 정렬하여 저장
		TreeSet<MyString> tree2 = new TreeSet<MyString>();
		tree2.add(new MyString("Orange"));
		tree2.add(new MyString("Apple"));
		tree2.add(new MyString("Moon"));
		tree2.add(new MyString("JavaWeb"));
		
		Iterator<MyString> it = tree2.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
}