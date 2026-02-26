package HW2;

import java.util.ArrayList;
import java.util.Objects;

//Task 5.3
public class Pair<K,V> {
	private K first; //First elements (Key)
	private V second; //Second elements (Value)
	
	//1: Constructor
	public Pair(K first, V second) {
		this.first = first;
		this.second = second;
		System.out.println("Created Pair: <" + first + ", " + second + ">");
	}
	
	//Empty Constructor
	public Pair() {
		this.first = null;
		this.second = null;
		System.out.println("Created an empty Pair");
	}
	
	//2: getter/setter
	public K getFirst() {
		return first;
	}
	public void setFirst(K first) {
		this.first = first;
		System.out.println("Set first to: " + first);
	}
	
	public V getSecond() {
		return second;
	}
	public void setSecond(V second) {
		this.second = second;
		System.out.println("Set second to: " + second);
	}
	
	public void setBoth(K first, V second) {
		this.first = first;
		this.second = second;
		System.out.println("Set both to: <" + first + ", " + second + ">");
	}
	
	//3
	@Override
	public String toString() {
		return "First element: " + first + ", Second element: " + second;
	}
	
	//4
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(obj == null || getClass() != obj.getClass()) {
			return false;
		}
		
		Pair<?, ?> pair = (Pair<?, ?>) obj;
		return Objects.equals(first, pair.first) && Objects.equals(second, pair.second);
	}
	
	//5 HashCode
	@Override
	public int hashCode() {
		return Objects.hash(first, second);
	}
	
	public static void main(String[] args) {
		//1:Create ArrayList<Pair<String, Double>> to store course codes and grades
		System.out.println("---------------- Test1 Start: ----------------");
		ArrayList<Pair<String, Double>> courseGrades = new ArrayList<>();
		
        courseGrades.add(new Pair<>("CISC3130", 4.0));  // A
        courseGrades.add(new Pair<>("MATH101", 3.7));  // A-
        courseGrades.add(new Pair<>("PHYS101", 3.3));  // B+
        courseGrades.add(new Pair<>("ENGL101", 4.0));  // A
        
        System.out.println("Course Grade Points: ");
        for(Pair<String, Double> grade : courseGrades) {
        	System.out.println(grade.getFirst() + ": " + grade.getSecond());
        }
		System.out.println("---------------- Test1 End ----------------");
		System.out.println();
        
		//2: Create ArrayList<Pair<Student, Course>> to represent enrollments (alternative approach)
		System.out.println("---------------- Test2 Start: ----------------");
		
		ArrayList<Pair<Student, Course>> enrollments = new ArrayList<>();
		
		//Idea: Student + Course = Enrollments
		Student s1 = new Student("S001", "Alice", "Smith", "alice@uni.edu", 3.8, "CS", 2);
		Course c1 = new Course("CISC3130", "Data Structures", 3, "Dr. Smith", 30);
		enrollments.add(new Pair<>(s1, c1));
		
        Student s2 = new Student("S002", "Bob", "Jones", "bob@uni.edu", 3.5, "Math", 3);
        Course c2 = new Course("MATH101", "Calculus I", 4, "Dr. Johnson", 25);
		enrollments.add(new Pair<>(s2, c2));
		
		for(Pair<Student, Course> enrollment : enrollments) {
			Student student = enrollment.getFirst();
			Course course = enrollment.getSecond();
			System.out.println(student.getFullName() + " (" + student.getStudentId() + ") -> " + course.getCourseCode());
		}
		
		System.out.println("---------------- Test2 End ----------------");

	}
}




