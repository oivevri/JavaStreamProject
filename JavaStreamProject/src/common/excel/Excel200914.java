package common.excel;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import common.EmpDAO;
import common.Employee;

public class Excel200914 {
	public static void main(String[] args) {
		Excel200914Writer writer = new Excel200914Writer();
		List<Employee> list= EmpDAO.getEmpList();
		List<Employee> stream = list.stream().filter(new Predicate<Employee>() {

			@Override
			public boolean test(Employee t) {
				return t.getJobId().equals("IT_PROG");
			}
			
		}).collect(Collectors.toList()); // List형식은 Collectors의 toList를 통해 자료를 가져올수있음
//		System.out.println(stream);
		writer.xlsWriter(stream);
		System.out.println("엑셀 완료.");
		
	}
}
