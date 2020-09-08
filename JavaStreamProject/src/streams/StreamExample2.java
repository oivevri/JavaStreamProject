package streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

class Student {
	String name;
	int score;
	public Student(String name, int score) {
		this.name = name;
		this.score = score;
	}
	public String getName() { return name; }
	public int getScore() { return score; }
}
public class StreamExample2 {
	public static void main(String[] args) {
		// 홍길동, 90 / 김유신, 88 / 전우치, 83 / 이순신, 86 -> 리스트컬렉션에 넣어주자
		// 그중에 score >= 85 인 사람이 몇명인지 rCnt 변수에 담자
		// 리스트 출력
//		List<Student> list = new ArrayList<Student>(); 해도 되고
		List<Student> list = Arrays.asList(new Student("홍길동", 90), new Student("김유신", 88),
						new Student("전우치", 83), new Student("이순신", 86));
		
// 이걸 내부반복자 Stream 으로도 해보자
//		Stream<Student> stream = list.stream();
//		long iCnt = stream.filter(new Predicate<Student>() { // 스트림의 필터 메소드
//			//Predicate 는 매개값 Student t 받고, 리던타입은 불린boolean타입
//			@Override
//			public boolean test(Student t) {
//				return t.score >= 85; // 참인 요소들만 모으자 
//			}
//		}).peek(new Consumer<Student>() {  // peek 중간처리메소드
//			@Override
//			public void accept(Student t) {
//				System.out.println(t.name + ", " + t.score);
//			}
//		}).count(); // 이게 .count 붙어서 위에 iCnt에 long 이라는 타입을 쓸수있는거
//		// count 메소드 : 필터, 피크 라는 메소드를 타고지나온 요소들을 하나하나씩 집계하는 최종처리메소드
//		System.out.println("총 인원: " + iCnt);
		
// 람다식으로
		Stream<Student> stream = list.stream();
		long iCnt = 0;
		stream.filter((Student t) -> t.score >= 85)
			  .peek((t) -> System.out.println("peek => " + t.name + ", " + t.score))
			  .filter(t -> t.name.startsWith("이"))
			  .forEach(new Consumer<Student>() {

				@Override
				public void accept(Student t) {
					System.out.println("forEach => " + t.name + ", " + t.score);
				}
				  
			});
				
		System.out.println("총 인원: " + iCnt);
	}
}
