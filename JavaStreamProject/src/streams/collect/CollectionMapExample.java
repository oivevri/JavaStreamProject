package streams.collect;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectionMapExample {
	public static void main(String[] args) {
		Student s1 = new Student("가나다", 50, Gender.FEMALE);
		Student s2 = new Student("라마바", 40, Gender.MALE);
		Student s3 = new Student("사아자", 30, Gender.FEMALE);
		List<Student> students = Arrays.asList(s1, s2, s3);
		
		Map<String, Integer> map = students.stream().filter(s -> s.age > 20)
		//toMap 이랑 랑 차이없음(___가 병렬). 쓰는방식은 같다
		.collect(Collectors.toMap(new Function<Student, String>(){
			// map 타입은 key와 value가 정해져있어야함
			
			@Override
			public String apply(Student t) { // key
				return t.name;
			}
		}, new Function<Student, Integer>(){

			@Override
			public Integer apply(Student t) { // value
				return t.age;
			}
		}));
		Set<String> keys = map.keySet();
		for (String s : keys) {
			System.out.println("이름: " + s + ", 나이: " + map.get(s));
			// map에서! get이라는 
		}
	}
}
