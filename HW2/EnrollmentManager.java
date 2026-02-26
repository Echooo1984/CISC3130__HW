package HW2;

import java.util.ArrayList;

public class EnrollmentManager {
	private ArrayList<Enrollment> enrollments;
	private int nextId;
	
	public EnrollmentManager() {
		this.enrollments = new ArrayList<>();
		this.nextId = 1;
	}
	
	//Helper method
	private String generateEnrollmentId() {
		String id = "E" + String.format("%03d", nextId);
		nextId++;
		return id;
	}
	
	public String enrollStudent(String studentId, String courseCode, String semester) {
		String enrollmentId = generateEnrollmentId();
		
		Enrollment enrollment = new Enrollment(enrollmentId, studentId, courseCode, null, semester);
		enrollments.add(enrollment);
		
        System.out.println("Student " + studentId + " enrolled in " + courseCode + " successfully.");
        
        return enrollmentId;
	}
	
	public boolean dropEnrollment(String enrollmentId) {
        Enrollment enrollment = findEnrollment(enrollmentId);
        if (enrollment == null) {
            System.out.println("Error: Enrollment with ID " + enrollmentId + " not found.");
            return false;
        }
        
        boolean removed = enrollments.remove(enrollment);
        if(removed) {
        	System.out.println("Enrollment " + enrollmentId + " dropped successfully.");
        }
        return removed;
	}
	
	public Enrollment findEnrollment(String enrollmentId) {
		if(enrollments == null) {
			return null;
		}
		 for(Enrollment enrollment : enrollments) {
			 if(enrollment.getEnrollmentId().equals(enrollmentId)) {
				 return enrollment;
			 }
		 }
		 return null;
	}
	
	public ArrayList<Enrollment> getEnrollmentsByStudent(String studentId) {
		ArrayList<Enrollment> result = new ArrayList<>();
		
		for(Enrollment enrollment : enrollments) {
			if(enrollment.getStudentId().equals(studentId)) {
				result.add(enrollment);
			}
		}
		return result;
	}
	
	public ArrayList<Enrollment> getEnrollmentsByCourse(String courseCode){
		ArrayList<Enrollment> result = new ArrayList<>();
		
		for(Enrollment enrollment : enrollments) {
			if(enrollment.getCourseCode().equals(courseCode)) {
				result.add(enrollment);
			}
		}
		
		return result;
	}
	
	public int getEnrollmentCountBySemester(String courseCode, String semester) {
		int count = 0;
		for(Enrollment enrollment : enrollments) {
			if(enrollment.getCourseCode().equals(courseCode) && enrollment.getSemester().equals(semester)) {
				count++;
			}
		}
		return count;
	}
	
	public void assignGrade(String enrollmentId, String grade) {
		if(grade == null) {
			System.out.println("Grade is null.");
			return;
		}
		
		Enrollment enrollment = findEnrollment(enrollmentId);
		enrollment.setGrade(grade.toUpperCase());
		
		System.out.println("Grade " + grade + " assigned to enrollment " + enrollmentId + ".");
	}
	
	public double calculateStudentGpa(String studentId) {
		double avgGpa = 0.0;
		int count = 0;
		for(Enrollment enrollment : enrollments) {
			avgGpa += enrollment.getGradePoints();
			count++;
		}
		
		return avgGpa / count;
	}
	
	public ArrayList<String> getStudentsInCourse(String courseCode) {
		ArrayList<String> result = new ArrayList<>();
		
		if(courseCode == null | courseCode.trim().isEmpty()) {
			return result;
		}
		
		for(Enrollment enrollment : enrollments) {
			if(enrollment.getCourseCode().equals(courseCode)) {
				//In case add one more time the student
				if(!result.contains(enrollment.getStudentId())) {
					result.add(enrollment.getStudentId());
				}
			}
		}
		
		return result;
	}
	
	public int getEnrollmentCount(String courseCode) {
		int count = 0;
		for(Enrollment enrollment : enrollments) {
			if(enrollment.getCourseCode().equals(courseCode)) {
				count++;
			}
		}
		
		return count;
	}
	
	public void printAllEnrollments() {
		for(Enrollment enrollment : enrollments) {
			System.out.println(enrollment);
		}
	}
	
	public int getTotalEnrollment() {
		return enrollments.size();
	}
}








