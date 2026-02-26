package HW2;

import java.util.ArrayList;

//Task 6.2
public class ReportGenerator {
	
	private StudentManager studentManager;
	private CourseManager courseManager;
	private EnrollmentManager enrollmentManager;
	
	public ReportGenerator(StudentManager sm, CourseManager cm, EnrollmentManager em) {
		this.studentManager = sm;
		this.courseManager = cm;
		this.enrollmentManager = em;
		System.out.println("ReportGenerator initialized");
	}
	
	public void generateStudentReport(String studentId, StudentManager sm, EnrollmentManager em) {
		Student student = studentManager.findStudent(studentId);
		if(student == null) {
			System.out.println("Error, not found");
			return;
		}
		
		System.out.println("Student Information:");
        System.out.println("ID: " + student.getStudentId());
        System.out.println("Name: " + student.getFullName());
        System.out.println("Email: " + student.getEmail());
        System.out.println("Major: " + student.getMajor());
        System.out.println("Year: " + student.getYear());
        System.out.println("GPA: " + (student.getGpa()));
        
        ArrayList<Enrollment> enrollments = enrollmentManager.getEnrollmentsByStudent(studentId);
        System.out.println("Course Enrollments:");
        if (enrollments.isEmpty()) {
            System.out.println("No courses enrolled.");
        } else {
            System.out.printf("Course Code", "Course Name", "Semester", "Grade", "Points");
        }
        
        double totalPoints = 0.0;
        int gradedCount = 0;
        
        for (Enrollment e : enrollments) {
            Course course = courseManager.findCourse(e.getCourseCode());
            String courseName = (course != null) ? course.getCourseName() : "Unknown";
            String grade = e.getGrade() == null ? "Not Graded" : e.getGrade();
            double points = e.getGradePoints();
            
            System.out.printf("%-12s | %-12s | %-10s | %-8s | %-10.2f%n",
                             e.getCourseCode(),
                             truncateString(courseName, 12),
                             e.getSemester(),
                             grade,
                             points);
            if (e.isGraded()) {
                totalPoints += points;
                gradedCount++;
            }
        }
        
        if (gradedCount > 0) {
            double semesterGpa = totalPoints / gradedCount;
            System.out.printf("Semester GPA: %.2f (based on %d graded courses)%n", 
                             semesterGpa, gradedCount);
        } else {
            System.out.println("No grades available for GPA calculation.");
        }
    }
	
	public void generateCourseReport(String courseCode, CourseManager cm, EnrollmentManager em) {
        Course course = courseManager.findCourse(courseCode);
        if (course == null) {
            System.out.println("Error: Course with code " + courseCode + " not found!");
            return;
        }
        
        System.out.println("Course Information:");
        System.out.println("Code: " + course.getCourseCode());
        System.out.println("Name: " + course.getCourseName());
        System.out.println("Credits: " + course.getCredits());
        System.out.println("Max Enrollment: " + course.getMaxEnrollment());
        
        ArrayList<String> prerequisites = course.getPrerequisites();
        if (prerequisites.isEmpty()) {
            System.out.println("Prerequisites: None");
        } else {
            System.out.println("Prerequisites: " + String.join(", ", prerequisites));
        }
        
        ArrayList<Enrollment> enrollments = enrollmentManager.getEnrollmentsByCourse(courseCode);
        
        System.out.println("Enrolled Students:");
        if (enrollments.isEmpty()) {
            System.out.println("  No students enrolled.");
        } else {
            System.out.printf("Student ID", "Student Name", "Semester", "Grade", "Status");
            
            int totalEnrolled = enrollments.size();
            int gradedCount = 0;
            int passedCount = 0;   

            for (Enrollment e : enrollments) {
                Student student = studentManager.findStudent(e.getStudentId());
                String studentName = (student != null) ? student.getFullName() : "Unknown";
                
                String grade = e.getGrade() == null ? "Not Graded" : e.getGrade();
                String status = e.isPassing() ? "PASS" : (e.getGrade() == null ? "Pending" : "FAIL");
                
                System.out.printf("%-12s | %-20s | %-12s | %-8s | %-10s%n",
                        e.getStudentId(),
                        truncateString(studentName, 20),
                        e.getSemester(),
                        grade,
                        status);
                
                if (e.isGraded()) {
                    gradedCount++;
                    if (e.isPassing()) {
                        passedCount++;
                    }
                }
            }
            System.out.println("Enrollment Statistics:");
            System.out.println("Total Enrolled: " + totalEnrolled);
            System.out.println("Graded: " + gradedCount);
            System.out.println("Passed: " + passedCount);
            if (gradedCount > 0) {
                double passRate = (passedCount * 100.0) / gradedCount;
                System.out.printf("Pass Rate: " + passRate);
            }
        }
        
	}
	
	public void generateMajorReport(String major, StudentManager sm) {
		System.out.println("MAJOR REPORT: " + major);
		
		ArrayList<Student> students = sm.getStudentsByMajor(major);
		
        System.out.printf("ID", "Name", "Year", "GPA");
        
        double totalGpa = 0.0;
        
        for (Student s : students) {
            System.out.printf("%-8s | %-20s | %-4d | %-5.2f%n",
                             s.getStudentId(),
                             s.getFullName(),
                             s.getYear(),
                             s.getGpa());
            
            totalGpa += s.getGpa();
        }
        
        System.out.println("Total Students: " + students.size());
        
        double averageGpa = totalGpa / students.size();
        System.out.printf("Average GPA for " + major + ": " + averageGpa);
        
	}
	
	public void generateHonorRollReport(StudentManager sm, double minGpa) {
		 System.out.println("HONOR ROLL REPORT (GPA ≥ " + minGpa + ")");
		 ArrayList<Student> honorStudents = sm.getHonorStudents(minGpa);
		 
	     if (honorStudents.isEmpty()) {
	         System.out.println("No honor students found with GPA ≥ " + minGpa);
	         return;
	     }
	        
	     System.out.printf("ID", "Name", "Major", "Year", "GPA");
	    
	        for (Student s : honorStudents) {
	            System.out.printf(
	                             s.getStudentId(),
	                             s.getFullName(),
	                             s.getMajor(),
	                             s.getYear(),
	                             s.getGpa());
	        }
	        
	        System.out.println("Total Honor Students: " + honorStudents.size());
	        
	        int totalStudents = sm.getTotalStudents();
	        if (totalStudents > 0) {
	            double percentage = (honorStudents.size() * 100.0) / totalStudents;
	            System.out.printf("Percentage of total students: %.1f%%%n", percentage);
	        }
	        
	        System.out.println("Honor Students by Major:");
	        ArrayList<String> majors = new ArrayList<>();
	        ArrayList<Integer> honorCounts = new ArrayList<>();
	        
	        for (Student s : honorStudents) {
	            String major = s.getMajor();
	            int index = majors.indexOf(major);
	            if (index == -1) {
	                majors.add(major);
	                honorCounts.add(1);
	            } else {
	                honorCounts.set(index, honorCounts.get(index) + 1);
	            }
	        }
	        
	        for (int i = 0; i < majors.size(); i++) {
	            System.out.println("  " + majors.get(i) + ": " + honorCounts.get(i));
	        }
	               
	}
	
    private String truncateString(String str, int maxLength) {
        if (str == null) return "";
        if (str.length() <= maxLength) return str;
        return str.substring(0, maxLength - 3) + "...";
    }
}
