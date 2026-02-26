package HW2;

public class Enrollment {
	private String enrollmentId;
	private String studentId;
	private String courseCode;
	private String grade; //"A,B,C,D,F,null
	private String semester; //Fall 2024, Spring 2024
	
	public Enrollment(String studentId, String courseCode, String semester) {
		this.studentId = studentId;
		this.courseCode = courseCode;
		this.semester = semester;
	}
	
	public Enrollment(String enrollmentId, String studentId, String courseCode, String grade, String semester) {
		this.enrollmentId = enrollmentId;
		this.studentId = studentId;
		this.courseCode = courseCode;
		this.grade = grade;
		this.semester = semester;
	}

	public String getEnrollmentId() {
		return enrollmentId;
	}

	public void setEnrollmentId(String enrollmentId) {
		this.enrollmentId = enrollmentId;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	@Override
	public String toString() {
		return "Enrollment [enrollmentId=" + enrollmentId + ", studentId=" + studentId + ", courseCode=" + courseCode
				+ ", grade=" + grade + ", semester=" + semester + "]";
	}
	
	public boolean isGraded() {
		return grade != null;
	}
	
	public double getGradePoints() {
		if(grade == null) {
			return 0.0;
		}
		
		switch(grade) {
			case"A":
				return 4.0;
			case"B":
				return 3.0;
			case"C":
				return 2.0;
			case"D":
				return 1.0;
			case"F":
				return 0.0;
			default:
				return 0.0;
		}
	}
	
	public boolean isPassing() {
		if(grade == null) {
			return false;
		}
		
		return grade.equals("A") || grade.equals("B") || grade.equals("C") || grade.equals("D");
	}
	
	
}














