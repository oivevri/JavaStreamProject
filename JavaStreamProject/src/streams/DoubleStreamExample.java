package streams;

import java.util.Arrays;
import java.util.function.DoublePredicate;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class DoubleStreamExample {
	public static void main(String[] args) {
		double[] dAry = {2.3, 4.5, 8.3, 5.5, 4.6 };
		// 스트림을 생성하고 5보다 작은 반복요소를 필터하고 합을 구하세요
		double sum = Arrays.stream(dAry).filter(new DoublePredicate() {
		
			@Override
			public boolean test(double value) {
				return value<5;
			}
		}).sum();
		System.out.println("5보다 작은 수 합: " + sum);
		
// 스트림의 유형-기본형	
		LongStream lStream = Arrays.stream(new long[] {10, 29, 38});
		IntStream iStream = Arrays.stream(new int[] {1, 2, 3});
		DoubleStream dStream = Arrays.stream(new double[] {1.1, 2.2});
		
// 스트림의 유형-클래스		
		Stream<Integer> intStream; // 성격은 비슷한데 같은게 아님.
		Stream<String> sStream = Arrays.stream(new String[] {"Hong", "Park"});
		Stream<Student> tStream = Arrays.stream(new Student[] {new Student("홍길동",100), new Student("전우치", 50)});
		
	}
}
