package streams.collect;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import common.EmpDAO;
import common.Employee;

public class CollectionDataBaseExample {
	public static void main(String[] args) {

			List<Employee> employees = EmpDAO.getEmpList();
// employee 테이블
// 입사일 hire_date이 1990년대인 사람들을 뽑아 list컬렉션에 저장
			List<Employee> empList = employees.stream().//
		            filter(f -> f.getHireDate().isBefore(LocalDate.of(2000, 1, 1))
		                  && f.getHireDate().isAfter(LocalDate.of(1989, 12, 31)))
		            .collect(Collectors.toList());
		      
		      for(Employee e : empList) {
		         System.out.println(e.getLastName() + ", " + e.getHireDate());
		      }
			System.out.println("-------------------------");
			
// JobId = ST_CLERK 인 사람들의 이름과 급여
//			List<Employee> clerk1 = employees.stream().filter(c -> c.getJobId().equals("ST_CLERK"))
//					.collect(Collectors.toList());
//			clerk1.stream().forEach(s -> System.out.println(s.getLastName() + ", " + s.getSalary()));
//
//			System.out.println("-------------------------");
			
// 그런 사람들을 컬렉션에 저장 -> map 이용
			Map<String, Integer> clerk = employees.stream().filter(c -> c.getJobId().equals("ST_CLERK"))
					.collect(Collectors.toMap(new Function<Employee, String>() {
						@Override
						public String apply(Employee t) {
							return t.getLastName();
						}
					}, new Function<Employee, Integer>() {
						@Override
						public Integer apply(Employee t) {
							return t.getSalary();
						}
					}));
			Set<String> keys = clerk.keySet();
			for (String k : keys) {
				System.out.println("이름: " + k + ", 나이: " + clerk.get(k));
			}

	}
}
