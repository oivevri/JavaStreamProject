package streams.intermediate;

import java.util.Objects;

public class Student implements Comparable<Student>{ // 비교가 가능하도록
	String name;
	int score;
	public Student(String name, int score) {
		this.name = name;
		this.score = score;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", score=" + score + "]";
	}
	// hashcode 메소드
	@Override
	public int hashCode() {
//		return this.name.hashCode();
//		혹은 오브젝트 기준으로
		return Objects.hashCode(this.name) + this.score;
	}
	// equals 메소드
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Student) { // 스튜던트클래스의 인스턴스인 obj에서
			Student that = (Student) obj;
			return this.name.equals(that.name) && this.score == that.score;
		} else {
			return false;
		}
	}
	@Override
	public int compareTo(Student that) { // 기준이 that일때
		return this.score - that.score; // 음수값 : 오름차순, 양수값 : 내림차순
	}
}
