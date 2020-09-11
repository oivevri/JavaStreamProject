package streams.intermediate;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.function.BinaryOperator;
import java.util.function.DoubleBinaryOperator;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.Predicate;
import java.util.function.ToDoubleFunction;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import common.Employee;
import common.DBConnection;
import common.EmpDAO;

public class StreamMapExample {
	public static void main(String[] args) throws SQLException {
		List<Employee> employees = null;
		employees = EmpDAO.getEmpList();
		System.out.println("---------------------");
		System.out.println("> salary가 가장큰사람의 정보 : ");		
		Optional<Employee> sal = employees.stream()
				.reduce((left, right) -> left.getSalary() > right.getSalary() ? left : right);
		System.out.println(sal);
	}
}
