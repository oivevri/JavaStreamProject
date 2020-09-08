package streams;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class StreamExample {
	public static void main(String[] args) {
// 여러건의 데이터에 대한 처리
		List<String> users = Arrays.asList("홍길동", "김유신", "전우치", "이순신");
		
		// 컬렉션 => 외부반복자
		System.out.println("외부반복자 사용");
		Iterator<String> iter = users.iterator(); // 반복자 Iterator 생성
		while(iter.hasNext()) { // iter이 다음next이 있다면has
			String str = iter.next(); // str은 다음next iter이다
			System.out.println(str.toString());
		}
		
		// 스트림 => 내부반복자
		System.out.println("내부반복자 사용");
		Stream<String> streams = users.stream(); // 내부반복자 Stream 생성
		
//		streams.forEach(new Consumer<String>() {
//		// 각 요소 하나하나에 대해서 반복된 요소 처리를 위해 stream 메소드의 forEach 사용
//		// Consumer : 매개값을 받아서 리턴은 안해주는..? 그래서 void타입의 메소드로 오버라이드?
//			@Override
//			public void accept(String t) {
//				System.out.println(t.toString());
//			}
//		}); // 이 Consumer 메소드? 부분은 람다식으로 표현가능
		streams.forEach((t) -> System.out.println(t.toString()));
		// 스트림의 모든 요소들 하나하나에 대해서 뒤에올 내용을 모두 다 처리하겠다
	}
}
