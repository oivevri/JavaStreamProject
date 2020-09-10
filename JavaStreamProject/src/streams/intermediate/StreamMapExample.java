package streams.intermediate;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import common.Employee;
import common.DBConnection;
import common.EmpDAO;

public class StreamMapExample {
	public static void main(String[] args) {
		List<Employee> employees;
		try {
			employees = EmpDAO.getEmpList();
			System.out.println("> salary가 10000 이상인 사원들을 출력 :");
			employees.stream().filter(e -> e.getSalary() >= 10000)
			.forEach(s -> System.out.println(s.getEmployeeId() + ", " + s.getLastName() + ", " + s.getSalary()));
			
			System.out.println("---------------------");
			
			LocalDate date = LocalDate.of(2020, 5, 1);
			//2020-05-01 이라는 데이트 타입을 문자열로 가져오자
			System.out.println("date -> String : " + date.format(DateTimeFormatter.ISO_DATE));
		
			//String을 date타입으로 바꾸는것
			System.out.print("String -> date : ");
			System.out.println(LocalDate.parse("2020-05-05", DateTimeFormatter.ISO_DATE));
			
			System.out.println("---------------------");
			System.out.println("");
			PreparedStatement pstmt;
			try {
				System.out.println("> rownum : 테이블이나 집합에서 원하는 만큼의 행만 가져오고 싶을 때");
				pstmt = DBConnection.getConnection().prepareStatement("select hire_date from employees where rownum=1");
				ResultSet rs = pstmt.executeQuery();
				if (rs.next()) {
					Employee emp = new Employee();
					LocalDate hireDate = rs.getDate("hire_date").toLocalDate();
					
					System.out.println(hireDate);
					emp.setHireDate(date);
				}
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("---------------------");
			for(Employee emp : employees) {
				System.out.println(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 

	}
}
