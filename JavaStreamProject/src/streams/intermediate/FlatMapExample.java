package streams.intermediate;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.function.BinaryOperator;
import java.util.function.DoubleBinaryOperator;
import java.util.function.Function;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class FlatMapExample {
	public static void main(String[] args) {
		System.out.println("> Employee의 income을 doubleStream에 넣어봐라");

// Optional~~타입 : 에러 발생안시킬려고 하는거??? 만약 값이 없더라도 에러뜨지않게하려고??
		System.out.println("> sum의 예시");
		OptionalDouble result1 = Employee.employees().stream()
				.flatMapToDouble(t -> DoubleStream.of(t.getIncome())
		).reduce((left, right) -> {
				System.out.println(left + ", " + right);
				return left + right;
		});

		// isPresent() : 결과값이 존재함
		if (result1.isPresent())
			System.out.println("result: " + result1);
		else
			System.out.println("결과없음");
		
		
		
		
		
		System.out.println("> LocalDate 통해 날짜비교");
		Optional<LocalDate> result2 = Employee.employees().stream()
				.flatMap(t -> Stream.of(t.getDateOfBirth())
		).reduce((t,  u) -> {
				System.out.println(t + ", " + u); 
				return t.isBefore(u) ? t : u;
		});
	}
}