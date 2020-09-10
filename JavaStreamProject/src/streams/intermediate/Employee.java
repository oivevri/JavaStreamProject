package streams.intermediate;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;
enum Gender { // enum : 열거형타입. 여기서 정의했는 데이터중 하나만 선택가능함 
	MALE, FEMALE;
}

public class Employee {
	String name;
	Gender gender;
	LocalDate dateOfBirth;
	double income;
	
	public Employee(String name, Gender gender, LocalDate dateOfBirth, double income) {
		super();
		this.name = name;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.income = income;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public double getIncome() {
		return income;
	}
	public void setIncome(double income) {
		this.income = income;
	}
	
// Gender에 대해 메소드 만들어준거 : 지금만든 인스턴스의 gender 값이 기준(Gender enum의 요소)과 같다면
	public boolean isMale() {
		return this.gender == Gender.MALE;
	}
	public boolean isFemale() {
		return this.gender == Gender.MALE;
	}
// toString
	@Override
	public String toString() { // name, gender, dateOfBirth, income 순으로 아래 포맷으로 보여주겠다. 수입은 double타입이라서 f로.. 뭐지.. 왜지..
		String str = String.format("(%s, %s, %s, %.2f)", name, gender, dateOfBirth, income);
		return str;
	}
// 리스트 메소드
	public static List<Employee> employees(){
		Employee e1 =
			new Employee("홍", Gender.MALE, LocalDate.of(1991, Month.JANUARY, 1),2343.0); 
							// 열거형 쓸때는 열거형타입의 이름.요소 로 써야한다
		Employee e2 =
				new Employee("김", Gender.FEMALE, LocalDate.of(1992, Month.MARCH, 1),4288.1); 
		Employee e3 =
				new Employee("이", Gender.MALE, LocalDate.of(1993, Month.MAY, 1),5243.2); 
		Employee e4 =
				new Employee("최", Gender.FEMALE, LocalDate.of(1994, Month.JULY, 1),8654.3); 
		Employee e5 =
				new Employee("박", Gender.MALE, LocalDate.of(1995, Month.SEPTEMBER, 1),6722.5); 
		Employee e6 =
				new Employee("윤", Gender.FEMALE, LocalDate.of(1996, Month.NOVEMBER, 1),9014.9); 
		List<Employee> employees = Arrays.asList(e1, e2, e3, e4, e5, e6);
		return employees;
	}
}
