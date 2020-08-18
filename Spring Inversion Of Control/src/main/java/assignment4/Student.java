package assignment4;

public class Student {
	private String studentId;
	private String studentName;
	private Test studentTest ;
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public Test getStudentTest() {
		return studentTest;
	}
	public void setStudentTest(Test studentTest) {
		this.studentTest = studentTest;
	}
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + "," + studentTest
				+ "]";
	}
}
