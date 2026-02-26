package HW2;

import java.util.ArrayList;
import java.util.HashSet;

public class StudentManager {
	private ArrayList<Student> students;
	
	public StudentManager() {
		this.students = new ArrayList<>();
	}
	
	public void addStudent(Student student) {
		if(findStudent(student.getStudentId()) != null) {
			System.out.println("Error, Student Id: " + student.getStudentId() + " already exists.");
			return;
		}
		
		students.add(student);
		System.out.println("Student: " + student.getFullName() + " added successfully.");
	}
	
	public boolean removeStudent(String studentId) {
		if(studentId == null || studentId.trim().isEmpty()) {
			System.out.println("Error, Student ID cannot be null or empty.");
			return false;
		}
		
		Student student = findStudent(studentId);
		if(student == null) {
			System.out.println("Error, Student Id: " + studentId + " not found.");
			return false;
		}
		
		boolean removed = students.remove(student);
		if(removed) {
			System.out.println("Student: " + student.getFullName() + " removed successfully.");
		}
		return removed;
	}
	
	public Student findStudent(String studentId) {
		if(studentId == null || studentId.trim().isEmpty()) {
			System.out.println("Error, Student ID cannot be null or empty.");
			return null;
		}
		
		for(Student student : students) {
			if(student.getStudentId().equals(studentId)) {
				return student;
			}
		}
		return null;
	}
	
	public ArrayList<Student> getStudentsByMajor(String major){
		ArrayList<Student> result = new ArrayList<>();
		
		if(major == null || major.trim().isEmpty()) {
			System.out.println("Error, Major cannot be null or empty.");
			return result;
		}
		
		for(Student student : students) {
			if(student.getMajor().equalsIgnoreCase(major)) {
				result.add(student);
			}
		}
		
		return result;
	}
	
	public ArrayList<Student> getStudentsByYear(int year) {
		ArrayList<Student> result = new ArrayList<>();
		
		if(year < 1 || year > 4) {
			System.out.println("Error, Year must be 1-4.");
			return result;
		}
		
		for(Student student : students) {
			if(student.getYear() == year) {
				result.add(student);
			}
		}
		return result;
	}
	
	public ArrayList<Student> getHonorStudents(double minGpa) {
		ArrayList<Student> result = new ArrayList<>();
		
		if(minGpa < 0.0 || minGpa > 4.0) {
			System.out.println("Error, Gpa must be 0-4.");
			return result;
		}
		
		for(Student student : students) {
			if(student.getGpa() >= minGpa) {
				result.add(student);
			}
		}
		return result;
	}
	
	public double getAverageGpa() {
		if(students.isEmpty()) {
			System.out.println("Error, no students");
			return 0.0;
		}
		
		double sum = 0.0;
		for(Student student : students) {
			sum += student.getGpa();
		}
		
		double result = sum / students.size();
		return result;
	}
	
	private double getAverageGpaByMajor(String major) {
		if(major == null || major.trim().isEmpty()) {
			System.out.println("Error, Major cannot be null or empty.");
			return 0.0;
		}
		
		double sum = 0.0;
		int count = 0;
		
		for(Student student : students) {
			if(student.getMajor().equalsIgnoreCase(major)) {
				sum += student.getGpa();
				count++;
			}
		}
		
		return sum/count;
	}
	
	public void printAllStudents() {
		if(students.isEmpty()) {
			System.out.println("Error, no students to display.");
			return;
		}
		
		for(Student student : students) {
			System.out.println(student); //no need .toString()
		}
		
		System.out.println("Total Students: " + students.size());
	}
	
	public int getTotalStudents() {
		return students.size();
	}
	
	public ArrayList<String> getAllMajors() {
		HashSet<String> majorSet = new HashSet<>();
		
		for(Student student : students) {
			majorSet.add(student.getMajor());
		}
		
		return new ArrayList<>(majorSet);
	}
	
	public static void main(String[] args) {
		StudentManager manager = new StudentManager();

		manager.addStudent(new Student("S001", "Alice", "Smith", "alice@university.edu", 3.8, "Computer Science", 2));
		manager.addStudent(new Student("S002", "Bob", "Jones", "bob@university.edu", 3.5, "Mathematics", 3));
		manager.addStudent(new Student("S003", "Charlie", "Brown", "charlie@university.edu", 3.9, "Computer Science", 2));

		manager.printAllStudents();
		System.out.println("Average GPA: " + manager.getAverageGpa());
		System.out.println("CS Students: " + manager.getStudentsByMajor("Computer Science").size());
	}
}












