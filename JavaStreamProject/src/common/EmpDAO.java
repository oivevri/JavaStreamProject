package common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class EmpDAO {
// List<Employee> getEmpList(); 메소드에 DB 연결해라
	public static List<Employee> getEmpList() throws SQLException{
		
		List<Employee> getEmpList = new ArrayList<>();
		Connection conn = DBConnection.getConnection();

			String sql = "select * from employees";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
		
			while (rs.next()) {
				Employee emp = new Employee(rs.getInt("employee_id"),
						rs.getString("first_name"),
						rs.getString("last_name"),
						rs.getString("email"),
						rs.getDate("hire_date").toLocalDate(),
						rs.getString("job_id"),
						rs.getInt("salary"));
				getEmpList.add(emp);
			}
			System.out.println(" -- edn of data --");
		return getEmpList;
	} 
}
