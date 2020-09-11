package streams.collect;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import streams.intermediate.Student;

public class CollectionExample {
	public static void main(String[] args) {
		// HashSet : 하나의 요소만?
		Set<String> setStr = new HashSet<>();
		setStr.add(new String("홍길동"));
		setStr.add(new String("이순신"));
		setStr.add(new String("전우치"));
		
		// Set 반복자
		Iterator<String> iter = setStr.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		System.out.println("-----------------------");
		// ArrayList 리스트컬렉션
		List<Student> studentm = new ArrayList<>();
		studentm.add(new Student("허성준", 80));
		studentm.add(new Student("최형준", 90));

		List<Student> studentw = new ArrayList<>();
		studentw.add(new Student("김다희", 90));
		studentw.add(new Student("김도은", 100));
		
		List<Student> studentr = new ArrayList<>();
		studentr.add(new Student("가나다", 20));
		studentr.add(new Student("라마바", 30));
		
		// List 반복자
		for(Student male : studentm) {
			System.out.println(male);
		}
		System.out.println("-----------------------");
		// Map : key와 value형식
		Map<String, Integer> map = new HashMap<>();
		map.put("가나다", 35); // 키 "김유신"에 해당하는 밸류 값이 35
		map.put("라마바", 50);
		
		// Set 반복자
		Set<String> key = map.keySet(); // String이 키를 담고있는 set 컬렉션이다?
		Iterator<String> itr = key.iterator();
		while(itr.hasNext()) {
			String k = itr.next(); // key에 해당하는 값을 가지고오고
			System.out.println(map.get(k)); // k를 넣으면 value가 뜸(value 가져오기)
		}
		
		System.out.println("-----------------------");
		Map<String, List<Student>> sMap = new HashMap<>();
		//
		sMap.put("남자", studentm);
		sMap.put("여자", studentw);
		sMap.put("재평가대상", studentr);
		Set<String> setk = sMap.keySet(); // keySet : 키 값만 가지고오는 메소드
		
		for(String s : setk) {
			System.out.println(s);
			List<Student> valueList = sMap.get(s); // key에 해당하는 value 가져와서
			for(Student st : valueList) {
				System.out.println(st); // 또 중복자 돌림
			}
		}
	}
}
