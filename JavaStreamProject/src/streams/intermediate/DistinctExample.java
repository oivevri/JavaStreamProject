package streams.intermediate;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class DistinctExample {
	public static void main(String[] args) {
		String[] strAry = {"Hong", "Park", "Choi", "Hong"};
		Stream<String> sStream = Arrays.stream(strAry);
		
		System.out.println("> sorted() : 정렬");
		sStream = Arrays.stream(strAry);
		sStream.sorted().forEach(System.out::println);

//		sStream.sorted().peek(System.out::println) // 소트 후 중간 출력
//				.distinct().forEach(System.out::println); // 디스팅트 후 최종 출력
		
		Student[] students = {new Student("홍길동",50), new Student("전우치",70),
							new Student("이순신", 70), new Student("김유신", 80),
							new Student("홍길동",50), new Student("홍길동",55) };
		
		
		Stream<Student> tStream = Arrays.stream(students);
//		tStream.distinct().forEach(System.out::println);
		
//		System.out.println("> Student에 comparable 구현해서 정렬");
//		tStream.sorted().forEach(System.out::println);
		
		System.out.println("> 만약 구현이 안되어있다면");
		tStream.sorted(new Comparator<Student>() {

			@Override // compare 이거 오버라이딩이라서 형태 무너뜨리면 안됨
			public int compare(Student o1, Student o2) {
				return o2.score - o1.score; // 뒤에있는게 기준임
			}
		}).forEach(System.out::println);
		
	}
}
