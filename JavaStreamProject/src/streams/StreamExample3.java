package streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class StreamExample3 {
	static int sum = 0, cnt = 0;
	// 왜 굳이 여기 밖에 해야하고 static 이어야하는지?
	// 평균은 (sum / cnt) 하면 되니까 굳이 안만들어준다
	
	public static void main(String[] args) {
		List<Student> list = Arrays.asList(new Student("홍길동", 90), new Student("김유신", 88),
				new Student("전우치", 83), new Student("이순신", 86));
		
// forEach(consumer 사용해서 총 점수, 평균 가지고오는 기능 구현);
		Stream<Student> student = list.stream(); // Stream에 위의 리스트컬렉션 list를 넣어줌
		student.forEach(new Consumer<Student>() {

			@Override
			public void accept(Student t) {
				sum += t.score;
				cnt++;
			}
		});
		System.out.println("총점: " + sum);
		System.out.println("평균: " + (sum / (double)cnt));
	}
}
