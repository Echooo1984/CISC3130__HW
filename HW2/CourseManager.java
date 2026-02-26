package HW2;

import java.util.ArrayList;

public class CourseManager {
	private ArrayList<Course> courses;
	
	public CourseManager() {
		this.courses = new ArrayList<>();
	}
	
	public void addCourse(Course course) {
		courses.add(course);
		System.out.println("Course: " + course.getCourseCode() + "-" + course.getCourseName() + " added.");
	}
	
	public Course findCourse(String courseCode) {
		for(Course course : courses) {
			if(course.getCourseCode().equals(courseCode)) {
				return course;
			}
		}
		return null; //if not found
	}
	
	public ArrayList<Course> getCoursesByInstructor(String instructor) {
		ArrayList<Course> result = new ArrayList<>();
		
		for(Course course : courses) {
			if(course.getInstrutor().equals(instructor)) {
				result.add(course);
			}
		}
		
		return result;
		
	}
	
	//Helper method
	private boolean hasMetPrerequisites(Student student, Course course, StudentManager studentManager) {
		ArrayList<String> prerequisites = course.getPrerequisites();
		
		if(prerequisites.isEmpty()) {
			return true;
		}
		
		for(String prereqCode : prerequisites) {
			Course prereqCourse = findCourse(prereqCode);
			if(prereqCourse == null) {
				System.out.println(prereqCode + " not found");
				return false;
			}
		}
		
		return true;
	}
	
	public ArrayList<Course> getAvailableCourses(String studentId, StudentManager studentManager, EnrollmentManager enrollmentManager){
		ArrayList<Course> availableCourses = new ArrayList<>();
		
		//check
		if(studentId == null || studentId.trim().isEmpty()) {
			System.out.println("Error, student is null or empty.");
			return availableCourses;
		}
		if(studentManager == null || enrollmentManager == null) {
			System.out.println("Error, studentManager or enrollmentManager is null.");
			return availableCourses;
		}
		
		Student student = studentManager.findStudent(studentId);
		
		ArrayList<String> enrolledCourseCodes = new ArrayList<>();
		ArrayList<Enrollment> studentEnrollments = enrollmentManager.getEnrollmentsByStudent(studentId);
		for(Enrollment enrollment : studentEnrollments) {
			enrolledCourseCodes.add(enrollment.getCourseCode());
		}
		
		for(Course course : courses) {
			String courseCode = course.getCourseCode();
			
			//check 1(Task requirment):picked?
			if(enrolledCourseCodes.contains(courseCode)) {
				continue;
			}
			
			//check 2(Task requirment):prerequisite?
			if(!hasMetPrerequisites(student, course, studentManager)) {
				continue;
			}
			
			availableCourses.add(course);
		}
		return availableCourses;
	}
	
	public void printAllCourses() {
		for(Course course : courses) {
			System.out.println(course);
		}
	}
	
	public int getTotalCourses() {
		return courses.size();
	}
	
	public static void main(String[] args) {
		CourseManager courseManager = new CourseManager();
		courseManager.addCourse(new Course("CISC3130", "Data Structures", 3, "Dr. Smith", 30));
		courseManager.addCourse(new Course("MATH101", "Calculus I", 4, "Dr. Johnson", 25));

		EnrollmentManager enrollmentManager = new EnrollmentManager();
		enrollmentManager.enrollStudent("S001", "CISC3130", "Fall 2024");
		enrollmentManager.assignGrade("E001", "A");
		System.out.println("Student GPA: " + enrollmentManager.calculateStudentGpa("S001"));
	}
}















