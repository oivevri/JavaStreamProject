package streams.collect;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

enum Gender { // 열거형 타입(enum) Gender 선언
	MALE,
	FEMALE;
}
class Student{
	String name;
	int age;
	Gender gender; // Gender이 열거형 타입이라서 gender 값으로는 male, female 둘밖에 못옴
	
	public Student(String name, int age, Gender gender) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
	}

}

public class CollectToListExample {
	public static void main(String[] args) {
		Student s1 = new Student("가나다", 50, Gender.FEMALE);
		Student s2 = new Student("라마바", 40, Gender.MALE);
		Student s3 = new Student("사아자", 30, Gender.FEMALE);
		List<Student> students = Arrays.asList(s1, s2, s3);
		
		Collector<Student, ?, List<Student>> collector = Collectors.toList();
		// Collector는 컬렉션. 어떤 데이터를 어떤방식으로 저장할지
		// Student라는 클래스를 '?' 라는 방식으로 리스트컬렉션 List<Student>에 저장하자
		// Collectors.toList() : Collectors 클래스에 저장되어있는 형태??가 toList메소드에 있는데 그걸 쓰겠다??

//남자만 담자
		System.out.println("> 남자");
		List<Student> newList = students.stream()
				.filter(s -> s.gender == Gender.MALE)
				.collect(collector);
		// collect 메소드는 collector(매개값)라는 방식대로 컬렉션을 만들겠다
		// 그걸 newList 라는 새로운 컬렉션에 담겠다
		newList.stream().forEach(s -> System.out.println(s.name + ", " + s.age));
		
//나이가 30이 넘는 사람들만 set에 담자 (30 초과) : set에 담자
		System.out.println("> 나이 30 초과");
		Set<Student> over30 = students.stream()
				.filter(s -> s.age > 30)
				.collect(Collectors.toSet());
		
		Iterator<Student> iter = over30.iterator();
		while (iter.hasNext()) {
			Student s = iter.next();
			System.out.println(s.name + ", " + s.gender + ", " + s.age);
		}
	}
}
