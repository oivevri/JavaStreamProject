package streams.intermediate.terminate;

import java.sql.SQLException;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import common.EmpDAO;
import common.Employee;

public class ReduceExample {
	public static void main(String[] args) throws SQLException {
		// 프로그래머 사원의 평균급여를 계산 -> salary 가져와서 average로 최종처리
		List<Employee> empList;
		// 전체 사원의 컬렉션을 통해 스트림을 생성
		empList = EmpDAO.getEmpList();
		Stream<Employee> stream = empList.stream();
		
		OptionalDouble ave
		= stream.filter(new Predicate<Employee>() {
			// 필터를 통해 프로그래머만 뽑아온다
			@Override
			public boolean test(Employee t) {
				return t.getJobId().equals("IT_PROG");
				// return t.getJobId() == Jobs.IT_PROG;
			} 
		}).flatMapToInt(new Function<Employee, IntStream>(){
			// 매핑작업을 통해 salary만 뽑아온다
			// 결과값을 더블로 받는거고 샐러리 끌어올때는 int로 해도되네 무슨차이지
			@Override
			public IntStream apply(Employee t) {
				return IntStream.of(t.getSalary());
			}
		}).average();
		System.out.println("평균급여는 : " + ave.getAsDouble());
		// 그냥 ave 하면 OptionalDouble[숫자] 뜨고,
		// .getAsDouble하면 숫자값만 뜸
	}

}
