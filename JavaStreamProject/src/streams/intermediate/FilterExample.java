package streams.intermediate;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.function.Predicate;

public class FilterExample {
	public static void main(String[] args) {
		List<Employee> list = Employee.employees();
		
		System.out.println("> Employee의 리스트에서 남자만");
		list.stream().filter(new Predicate<Employee>() {
			@Override
			public boolean test(Employee t) {
				return t.isMale(); // 필터를 통해 Employee의 리스트에서 남자만 뽑아서
			}
		}).peek(s -> { // 중간처리메소드
			s.setIncome(s.getIncome() * 0.9); // 월급(수입) 0.9%로 줄임
		}).forEach(System.out::println);;
	
		System.out.println("> Employee의 리스트에서 월급이 5000 초과만");
		list.stream().filter(new Predicate<Employee>() {
			@Override
			public boolean test(Employee t) {
				return t.getIncome() > 5000;
			}
		}).forEach(System.out::println);
	// 이거결과값에서 e3 빠진 이유 : 위에서 월급 * 0.9해줘서 4718 됨
		
		
		System.out.println("> Employee의 리스트에서 1993년 이전출생만");
		list.stream().filter(new Predicate<Employee>() {
			@Override
			public boolean test(Employee t) {
				return t.getDateOfBirth().isBefore(LocalDate.of(1993, Month.JANUARY, 1));
			}
		}).forEach(System.out::println);
	}
}
