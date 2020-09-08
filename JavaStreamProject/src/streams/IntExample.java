package streams;

import java.util.Arrays;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class IntExample {
	public static void main(String[] args) {
// 1~10까지 정수형 배열 만들어서, 배열로부터 스트림을 생성하는 방법이 있었다
// 스트림을 만들고, 필터filter(조건에 맞는값만 걸러냄)를 통해 짝수값만 가져와서
		// 최종집계 sum()을 통해 구현하자
		
		int[] intAry = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		IntStream iStream = Arrays.stream(intAry);
		int sum = iStream.filter(new IntPredicate() {
			
			@Override
			public boolean test(int value) {
				return value%2==0;
			}
		}).sum();
		System.out.println("짝수 합: " + sum);
	}
}
