package streams.collect;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectionMapGoupbyExample {
	public static void main(String[] args) {
		// 부서별 - 사원정보
		Student s1 = new Student("가나다", 20, Gender.FEMALE);
		Student s2 = new Student("라마바", 20, Gender.MALE);
		Student s3 = new Student("사아자", 20, Gender.FEMALE);
		Student s4 = new Student("차카타", 20, Gender.MALE);
		List<Student> students = Arrays.asList(s1, s2, s3, s4);
		
		Map<Gender, List<Student>> map;
		
//		Gender.MALE - Student1, Student2;
//		Gender.FEMALE - Student3, Student4;
		// 이 키(Gender.XX)에 컬렉션 2씩 담겠다..???
		
		Map<Gender, List<Student>> gMap = students.stream() // Gender를 기준으로 요소들을 담겠다
			.collect(Collectors.groupingBy(new Function<Student, Gender>() {
				//groupingBy : 뒤에오는 매개값(new~)의 조건에 따라 기본적으로 list collection에 담아줌.
				@Override
				public Gender apply(Student t) {
					return t.gender;
				} // 그룹짓겠다 기준지어주면 자동으로 toList()로 하는거라서 생략됨
		}));
		
// 만약 Set이었다면 이렇게되었을것
//		Map<Gender, Set<Student>> gMap = students.stream() // Gender를 기준으로 요소들을 담겠다
//				.collect(Collectors.groupingBy(new Function<Student, Gender>() {
//					//groupingBy : 뒤에오는 매개값(new~)의 조건에 따라 기본적으로 list collection에 담아줌.
//					@Override
//					public Gender apply(Student t) {
//						return t.gender;
//			}, Collectors.toSet()));
		
		Set<Gender> set = gMap.keySet(); // 젠더를 다 가져와서 set에 담았다
		for (Gender g : set) { // g : 키값. for문을 루핑돌면서 담겠다
			System.out.println(g);
			List<Student> list = gMap.get(g); // 밸류는 List<~~>였으니까
			for (Student s : list) {
				System.out.println(s.name + ", " + s.age);
			}
		}
	}
}
