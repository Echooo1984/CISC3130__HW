package HW2;

import java.util.ArrayList;
import java.util.Objects;

//Task 1.2
public class Course {
	private String courseCode;
	private String courseName;
	private int credits;
	private String instrutor;
	private int maxEnrollment;
	private ArrayList<String> prerequisites;
	
	public Course(String courseCode, String courseName, int credits, String instrutor, int maxEnrollment) {
		this.courseCode = courseCode;
		this.courseName = courseName;
		this.credits = credits;
		this.instrutor = instrutor;
		this.maxEnrollment = maxEnrollment;
		this.prerequisites = new ArrayList<>();
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public String getInstrutor() {
		return instrutor;
	}

	public void setInstrutor(String instrutor) {
		this.instrutor = instrutor;
	}

	public int getMaxEnrollment() {
		return maxEnrollment;
	}

	public void setMaxEnrollment(int maxEnrollment) {
		this.maxEnrollment = maxEnrollment;
	}

	public ArrayList<String> getPrerequisites() {
		return prerequisites;
	}

	public void setPrerequisites(ArrayList<String> prerequisites) {
		this.prerequisites = prerequisites;
	}
	
	@Override
	public String toString() {
		return "Course Name: " + courseName + ", Course Code: " + courseCode + ", Credits: " + credits + ", Instructor: " + instrutor + ", MAX Enrollment: " + maxEnrollment + ", Prerequisites: " + prerequisites;
	}
	
	public void addPrerequisite(String courseCode) {
		 if(!prerequisites.contains(courseCode)) {
			 prerequisites.add(courseCode);
			 System.out.println("Prerequisite " + courseCode + " added to " + this.courseCode);
		 }else {
			 System.out.println("Prerequisite " + courseCode + " already exists");
		 }
	}
	
	public boolean hasPrerequsite(String courseCode) {
		return prerequisites.contains(courseCode);
	}
	
	public ArrayList<String> getPrerequsites(){
		return new ArrayList<>(prerequisites);
	}
	
}







