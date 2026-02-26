package HW2;

import java.util.ArrayList;
import java.util.Scanner;

//Task 6.1
public class StudentManagementSystemMain {
	
	private static StudentManager studentManager;
	private static CourseManager courseManager;
	private static EnrollmentManager enrollmentManager;
	
	private static Scanner scanner;
	
	public static void main(String[] args) {
		initializeSystem();
		addSampleData();
		
		boolean running = true;
		while(running) {
			showMainMenu();
			int choice = getUserChoice(1, 10);
			
			switch(choice) {
			case 1:
                addStudentMenu();
                break;
            case 2:
                removeStudentMenu();
                break;
            case 3:
                findStudentMenu();
                break;
            case 4:
                listAllStudents();
                break;
            case 5:
                addCourseMenu();
                break;
            case 6:
                enrollStudentMenu();
                break;
            case 7:
                assignGradeMenu();
                break;
            case 8:
                calculateStudentGpaMenu();
                break;
            case 9:
                generateReportsMenu();
                break;
            case 10:
            	System.out.println("Thank you for using the system!");
            	System.out.println("GoodBye!");
            	running = false;
            	break;
			}
			
			if(running) {
				System.out.println("Press Enter to continue...");
				scanner.nextLine();
			}
		}
		scanner.close();
	}
	
	//Initialize System
	private static void initializeSystem() {
        studentManager = new StudentManager();
        courseManager = new CourseManager();
        enrollmentManager = new EnrollmentManager();
        scanner = new Scanner(System.in);
	}
	
	//Add Sample Data
	private static void addSampleData() {
		//Add 10 Students
		System.out.println("Adding 10 students...");
		studentManager.addStudent(new Student("S001", "Alice", "Smith", "alice@university.edu", 3.8, "Computer Science", 2));
	    studentManager.addStudent(new Student("S002", "Bob", "Jones", "bob@university.edu", 3.5, "Mathematics", 3));
	    studentManager.addStudent(new Student("S003", "Charlie", "Brown", "charlie@university.edu", 3.9, "Computer Science", 2));
	    studentManager.addStudent(new Student("S004", "Diana", "Prince", "diana@university.edu", 4.0, "Physics", 4));
	    studentManager.addStudent(new Student("S005", "Edward", "Norton", "edward@university.edu", 3.2, "Mathematics", 1));
	    studentManager.addStudent(new Student("S006", "Fiona", "Garcia", "fiona@university.edu", 3.7, "Computer Science", 3));
	    studentManager.addStudent(new Student("S007", "George", "Washington", "george@university.edu", 3.4, "History", 2));
	    studentManager.addStudent(new Student("S008", "Hannah", "Montana", "hannah@university.edu", 3.6, "Music", 1));
	    studentManager.addStudent(new Student("S009", "Ian", "Wright", "ian@university.edu", 3.1, "Engineering", 4));
	    studentManager.addStudent(new Student("S010", "Julia", "Roberts", "julia@university.edu", 3.8, "Computer Science", 3));
	    
	    //Add 5 courses
	    System.out.println("Adding 5 courses");
	    Course cisc3130 = new Course("CISC3130", "Data Structures", 3, "Dr. Smith", 30);
        cisc3130.addPrerequisite("CISC1110");
        cisc3130.addPrerequisite("MATH101");
        courseManager.addCourse(cisc3130);
        
        Course math101 = new Course("MATH101", "Calculus I", 4, "Dr. Johnson", 25);
        courseManager.addCourse(math101);
        
        Course phys101 = new Course("PHYS101", "Physics I", 4, "Dr. Brown", 20);
        phys101.addPrerequisite("MATH101");
        courseManager.addCourse(phys101);
        
        Course cisc1110 = new Course("CISC1110", "Intro to Programming", 3, "Dr. Smith", 35);
        courseManager.addCourse(cisc1110);
        
        Course engl101 = new Course("ENGL101", "English Composition", 3, "Prof. Wilson", 30);
        courseManager.addCourse(engl101);
        
        //Enrollments
        System.out.println("Adding Enrollments");
        
        //Alice(S001)
        String e1 = enrollmentManager.enrollStudent("S001", "CISC1110", "Fall 2024");
        String e2 = enrollmentManager.enrollStudent("S001", "MATH101", "Fall 2024");
        String e3 = enrollmentManager.enrollStudent("S001", "ENGL101", "Fall 2024");
        
        //Bob(S002)
        String e4 = enrollmentManager.enrollStudent("S002", "MATH101", "Fall 2024");
        String e5 = enrollmentManager.enrollStudent("S002", "PHYS101", "Fall 2024");
        
        //Charlie (S003)
        String e6 = enrollmentManager.enrollStudent("S003", "CISC1110", "Fall 2024");
        String e7 = enrollmentManager.enrollStudent("S003", "CISC3130", "Fall 2024");
        
        //Diana (S004)
        String e8 = enrollmentManager.enrollStudent("S004", "PHYS101", "Fall 2024");

        //Fiona (S006)
        String e9 = enrollmentManager.enrollStudent("S006", "CISC1110", "Fall 2024");
        String e10 = enrollmentManager.enrollStudent("S006", "MATH101", "Fall 2024");
        
        //Assigned Grades
        System.out.println("Assigning Grades:");
        enrollmentManager.assignGrade(e1, "A");
        enrollmentManager.assignGrade(e2, "B+");
        enrollmentManager.assignGrade(e4, "A-");
        enrollmentManager.assignGrade(e6, "A");
        enrollmentManager.assignGrade(e8, "A");
        enrollmentManager.assignGrade(e9, "B");
        
        System.out.println("Sample data loaded successfully!");
        System.out.println("Press Enter to continue...");
        scanner.nextLine();
	}
	
	//Menu
	private static void showMainMenu() {
		System.out.println("----------------MAIN MENU----------------");
        System.out.println("1. Add Student");
        System.out.println("2. Remove Student");
        System.out.println("3. Find Student");
        System.out.println("4. List All Students");
        System.out.println("5. Add Course");
        System.out.println("6. Enroll Student in Course");
        System.out.println("7. Assign Grade");
        System.out.println("8. Calculate Student GPA");
        System.out.println("9. Generate Reports");
        System.out.println("10. Exit");
        System.out.print("Enter your choice (1-10): ");
	}
	
	//Asking user
	private static int getUserChoice(int min, int max) {
		int choice = -1;
		while(true) {
			try {
				choice = Integer.parseInt(scanner.nextLine());
				if(choice >= min && choice <= max) {
					break;
				}else {
					System.out.println("Please enter a number between " + min + " and " + max + ": ");
				}
			} catch(NumberFormatException e) {
				System.out.println("Invalid Input. Please Enter a number: ");
			}
		}
		return choice;
	}
	
	//Choice 1
	private static void addStudentMenu() {
        System.out.print("Enter Student ID (e.g., S011): ");
        String id = scanner.nextLine();
        
        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();
        
        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();
        
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        
        System.out.print("Enter GPA (0.0-4.0): ");
        double gpa = Double.parseDouble(scanner.nextLine());
        
        System.out.print("Enter Major: ");
        String major = scanner.nextLine();
        
        System.out.print("Enter Year (1-4): ");
        int year = Integer.parseInt(scanner.nextLine());
        
        Student student = new Student(id, firstName, lastName, email, gpa, major, year);
        studentManager.addStudent(student);
	}
	
	//Choice 2
	private static void removeStudentMenu() {
        System.out.print("Enter Student ID to remove: ");
        String id = scanner.nextLine();
        
        studentManager.removeStudent(id);
	}
	
	//Choice 3
	private static void findStudentMenu() {
        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();
        
        Student student = studentManager.findStudent(id);
        if (student != null) {
            System.out.println("Student found:");
            System.out.println("  " + student);
        }
        
        ArrayList<Enrollment> enrollments = enrollmentManager.getEnrollmentsByStudent(id);
        if (!enrollments.isEmpty()) {
            System.out.println("Enrollments:");
            for (Enrollment e : enrollments) { 
            	System.out.println("  - " + e.getCourseCode() + " (" + e.getSemester() + "): " + (e.getGrade() == null ? "Not Graded" : e.getGrade()));
            }
        } else {
        	System.out.println("Student not found.");
        }	
        
	}

	//Choice 4
	private static void listAllStudents() {
		studentManager.printAllStudents();
	}
	
	//Choice 5
	private static void addCourseMenu() {
		System.out.print("Enter Course Code (e.g., CISC3130): ");
        String code = scanner.nextLine();
        
        System.out.print("Enter Course Name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter Credits: ");
        int credits = Integer.parseInt(scanner.nextLine());
        
        System.out.print("Enter Instructor: ");
        String instructor = scanner.nextLine();
        
        System.out.print("Enter Max Enrollment: ");
        int maxEnroll = Integer.parseInt(scanner.nextLine());
        
        Course course = new Course(code, name, credits, instructor, maxEnroll);
		
        System.out.print("Add prerequisites? (y/n): ");
        if (scanner.nextLine().equalsIgnoreCase("y")) {
            while (true) {
                System.out.print("Enter prerequisite course code (or 'done' to finish): ");
                String prereq = scanner.nextLine();
                if (prereq.equalsIgnoreCase("done")) {
                    break;
                }
                course.addPrerequisite(prereq);
            }
        }
        
        courseManager.addCourse(course);
	}

	//Choice 6
	private static void enrollStudentMenu() {
		System.out.print("Enter Student ID: ");
        String studentId = scanner.nextLine();
        
        Student student = studentManager.findStudent(studentId);
        if (student == null) {
            System.out.println("Error: Student not found!");
            return;
        }
        
        System.out.print("Enter Course Code: ");
        String courseCode = scanner.nextLine();
        
        Course course = courseManager.findCourse(courseCode);
        if (course == null) {
            System.out.println("Error: Course not found!");
            return;
        }
        
        System.out.print("Enter Semester (e.g., Fall 2024): ");
        String semester = scanner.nextLine();
        
        ArrayList<Enrollment> existing = enrollmentManager.getEnrollmentsByStudent(studentId);
        for (Enrollment e : existing) {
            if (e.getCourseCode().equals(courseCode) && e.getSemester().equals(semester)) {
                System.out.println("Error: Student already enrolled in this course for " + semester);
                return;
            }
        }
        
        int currentEnroll = enrollmentManager.getEnrollmentCountBySemester(courseCode, semester);
        if (currentEnroll >= course.getMaxEnrollment()) {
            System.out.println("Error: Course is full! (Max: " + course.getMaxEnrollment() + ")");
            return;
        }
        
        enrollmentManager.enrollStudent(studentId, courseCode, semester);
	}
	
	//Choice 7
	private static void assignGradeMenu() {
		System.out.print("Enter Enrollment ID: ");
        String enrollmentId = scanner.nextLine();
        
        Enrollment enrollment = enrollmentManager.findEnrollment(enrollmentId);
        if (enrollment == null) {
            System.out.println("Error: Enrollment not found!");
            return;
        }
        
        Student student = studentManager.findStudent(enrollment.getStudentId());
        Course course = courseManager.findCourse(enrollment.getCourseCode());
        
        System.out.println("Student: " + (student != null ? student.getFullName() : "Unknown"));
        System.out.println("Course: " + (course != null ? course.getCourseName() : "Unknown"));
        System.out.println("Current Grade: " + (enrollment.getGrade() == null ? "Not Graded" : enrollment.getGrade()));
        
        System.out.print("Enter Grade (A, B, C, D, F): ");
        String grade = scanner.nextLine().toUpperCase();
        
        enrollmentManager.assignGrade(enrollmentId, grade);
	}

	//Choice 8
	private static void calculateStudentGpaMenu() {
		System.out.print("Enter Student ID: ");
        String studentId = scanner.nextLine();
        
        Student student = studentManager.findStudent(studentId);
        if (student == null) {
            System.out.println("Error: Student not found!");
            return;
        }
        
        System.out.println("Student: " + student.getFullName());
        enrollmentManager.calculateStudentGpa(studentId);
	}

	//Choice 9
	private static void generateReportsMenu() {
		System.out.println("1. All Students Report");
        System.out.println("2. All Courses Report");
        System.out.println("3. All Enrollments Report");
        System.out.println("4. Students by Major");
        System.out.println("5. Courses by Instructor");
        System.out.println("6. Student GPA Report");
        System.out.println("7. Back to Main Menu");
        System.out.print("Enter your choice (1-7): ");
        
        int choice = getUserChoice(1, 7);
        
        switch (choice) {
        case 1:
            studentManager.printAllStudents();
            break;
        case 2:
            courseManager.printAllCourses();
            break;
        case 3:
            enrollmentManager.printAllEnrollments();
            break;
        case 4:
            return;
        }
	}

}

















