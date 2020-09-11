package streams.collect;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import common.EmpDAO;
import common.Employee;

public class CollectionDataBaseGroupby {
	public static void main(String[] args) {
		List<Employee> employees = EmpDAO.getEmpList();
// 직무별(JobId) - 사원이름 그룹으로 묶기
		Map<String, List<Employee>> jobMap = employees.stream().collect(Collectors.groupingBy(new Function<Employee, String>() {
			@Override
			public String apply(Employee t) {
				return t.getJobId();
			}
		}));
// 직업을 key값으로 해서 set에 담고 출력하자
		Set<String> set = jobMap.keySet();
		for (String job : set) {
			System.out.println("> " + job); // 직무 먼저 출력해주고
			List<Employee> empList = jobMap.get(job);
			for (Employee emp : empList) { // 해당직무에서 일하는 사원들 이름, salary 출력
				System.out.println(emp.getLastName() + ", " + emp.getSalary());
			}
			System.out.println("------------------------");
		}
	}
}
