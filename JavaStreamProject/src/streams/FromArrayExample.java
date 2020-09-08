package streams;

import java.util.Arrays;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

// p791 배열로부터 스트림얻기
public class FromArrayExample {
	public static void main(String[] args) {
		int[] intAry = {3,6,4,9,7};
		IntStream iStream = Arrays.stream(intAry);
		iStream.filter(value -> value>5)
		.forEach(value -> System.out.println(value));
	// 모든 처리 다해서 반복자가 남아있지 않다

	// sum : 합계(최종처리) : intAry 요소들을 더한값
		iStream = Arrays.stream(intAry);
		long sum = iStream.sum();
		System.out.println("sum: " + sum); 
		
	// count : 갯수. 집계(최종처리)
	// peek : 요소 하나씩 가져와서 출력함 (최종단계 오기전에 해당 요소들을 중간단계에서 확인할때 사용)
		iStream = Arrays.stream(intAry, 0, 4);
		long cnt = iStream.peek(t -> System.out.println(t)).count();
		System.out.println("cnt: " + cnt);
	}
}
