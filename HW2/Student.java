package HW2;

import java.util.Objects;

//Task 1.1
public class Student {
	private String studentId;
	private String firstName;
	private String lastName;
	private String email;
	private double gpa;
	private String major;
	private int year;
	
	public Student(String studentId,String firstName,String lastName,String email,double gpa,String major,int year) {
		this.studentId = studentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.gpa = gpa; //Assume gpa = 0.0-4.0
		this.major = major;
		this.year = year; //Assume year = 1-4
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
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

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	//Helper name
	public String getFullName() {
		return lastName + " " + firstName;
	}
	
	@Override
	public String toString() {
		String yearName = "";
		if(year == 1) {
			yearName = "Freshman";
		}else if(year == 2) {
			yearName = "Sophomore";
		}else if(year == 3) {
			yearName = "Junior";
		}else if(year == 4) {
			yearName = "Senior";
		}
		return "Student Id: " + studentId + ", Name: " + getFullName() + ", email: " + email + ", Major: " + major + ", GPA: " + gpa + ", Year: " + yearName + "(Year=" + year + ")";
	}
	
	@Override
	public boolean equals(Object obj) {
		//Check if same object
		if(this == obj) {
			return true;
		}
		
		//check if object is null or not match with obj
		if(obj == null || getClass() != obj.getClass()) {
			return false;
		}
		
		//Conver object type to call .studentId method
		Student student = (Student) obj;
		
		//Compare
		return Objects.equals(studentId, student.studentId);
		}
	@Override
	public int hashCode() {
		return Objects.hash(studentId);
	}
}






