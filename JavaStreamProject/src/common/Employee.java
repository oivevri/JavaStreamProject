package common;

import java.time.LocalDate;

public class Employee {
// 필드	
	int employeeId;
	String firstName;
	String lastName;
	String email;
	LocalDate hireDate;
	String jobId;
	int salary;
// 생성자	
	public Employee(int employeeId, String firstName, String lastName, String email, LocalDate hireDate, String jobId,
			int salary) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.hireDate = hireDate;
		this.jobId = jobId;
		this.salary = salary;
	}	
public Employee() {
	}

// 겟셋메소드	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getHireDate() {
		return hireDate;
	}
	public String getHireDateString() {
		return this.hireDate.toString();
	}
	public void setHireDate(LocalDate hireDate) {
		this.hireDate = hireDate;
	}
	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", hireDate=" + hireDate + ", jobId=" + jobId + ", salary=" + salary + "]";
	}
	
	
	
}
