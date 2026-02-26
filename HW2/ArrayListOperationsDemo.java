package HW2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ArrayListOperationsDemo {
	
	//Method 1: Array -> ArrayList
	private static void demonstrateArrayToArrayList() {
		System.out.println("-------------- 1. Array to ArrayList--------------");
		
		//Create an Array of Student[]
		Student[] studentArray = {
			new Student("S001", "Alice", "Smith", "alice@university.edu", 3.8, "Computer Science", 2),
			new Student("S002", "Bob", "Jones", "bob@university.edu", 3.5, "Mathematics", 3),
			new Student("S003", "Charlie", "Brown", "charlie@university.edu", 3.9, "Computer Science", 2)
		};
		//Print:
		System.out.println("Original Array:");
		for(Student s : studentArray) {
			System.out.println(" " + s);
		}
		System.out.println();
		
		//(1):Using Arrays.asList() to convert:
		System.out.println("Using Arrays.asList(): ");
		List<Student> list1 = Arrays.asList(studentArray);
		
		//List cant not add() or remove() because its  a fixed size:
        try {
            list1.add(new Student("S004", "Test", "Student", "test@uni.edu", 3.0, "Test", 1));
        } catch (UnsupportedOperationException e) {
            System.out.println("  Cannot add to Arrays.asList() result - fixed size list");
        }
		
		
		//(2):Using new ArrayList<>() to convert:
		System.out.println("Using ArrayList<>(Arrays.asList()): ");
		ArrayList<Student> list2 = new ArrayList<>(Arrays.asList());
		System.out.println("ArrayList created, size: " + list2.size());
		
		//now it can add() or remove(), because it is changed ArrayList:
		list2.add(new Student("S004", "David", "Lee", "david@uni.edu", 3.7, "Physics", 1));
		System.out.println("After adding new student, new size: " + list2.size());
        list2.remove(0);
        System.out.println("After removing first student, size: " + list2.size());
        System.out.println();
				
	}
	
	//Method 2: ArrayList -> Array
	private static void demonstrateArrayListToArray() {
		System.out.println("-------------- 1. ArrayList to Array--------------");

		//Create an ArrayList of Student
        ArrayList<Student> studentList = new ArrayList<>();
        studentList.add(new Student("S001", "Alice", "Smith", "alice@uni.edu", 3.8, "CS", 2));
        studentList.add(new Student("S002", "Bob", "Jones", "bob@uni.edu", 3.5, "Math", 3));
        studentList.add(new Student("S003", "Charlie", "Brown", "charlie@uni.edu", 3.9, "CS", 2));
        
        System.out.println("Original ArrayList:");
        for (Student s : studentList) {
            System.out.println("  " + s);
        }
        System.out.println("ArrayList size: " + studentList.size());
        System.out.println();
        
        //Convert to Array:
        Student[] studentArray = studentList.toArray(new Student[0]);
        
        System.out.println("Converted Array:");
        for (Student s : studentArray) {
            System.out.println("  " + s);
        }
        System.out.println("Array length: " + studentArray.length);
        System.out.println();
	}
	
	//Method 3: Sublist
	private static void demonstrateSublist() {
		System.out.println("-------------- 3. Sublist Operations--------------");

		//Create an ArrayList of Student
        ArrayList<Student> studentList = new ArrayList<>();
        studentList.add(new Student("S001", "Alice", "Smith", "alice@uni.edu", 3.8, "CS", 2));
        studentList.add(new Student("S002", "Bob", "Jones", "bob@uni.edu", 3.5, "Math", 3));
        studentList.add(new Student("S003", "Charlie", "Brown", "charlie@uni.edu", 3.9, "CS", 2));
        studentList.add(new Student("S004", "Diana", "Prince", "diana@uni.edu", 4.0, "Physics", 4));
        studentList.add(new Student("S005", "Edward", "Norton", "edward@uni.edu", 3.2, "Math", 1));
        
        System.out.println("Original ArrayList:");
        for (int i = 0; i < studentList.size(); i++) {
            System.out.println("  [" + i + "] " + studentList.get(i).getFullName());
        }
        System.out.println();
        
        //get sublist (index 1-3, incloud 1, but not incloud 4
        List<Student> subList = studentList.subList(1, 4);
        System.out.println("Sublist: index of [1] to [3], incloud [1], but not incloud [4]");
        for (int i = 0; i < subList.size(); i++) {
            System.out.println("  [" + i + "] " + subList.get(i).getFullName());
        }
        System.out.println();
        
        //Modifying sublist
		System.out.println("Modifying sublist index of [1]: GPA form 3.5 to 4.0");
		Student index1 = subList.get(0); //subList[0] = ArrayList[1] ([1] to [3])
		double oldGpa = index1.getGpa();
		index1.setGpa(4.0);
		
		System.out.println("After modifying:");
		System.out.println("Original GPA: " + studentList.get(1).getGpa());
		System.out.println("After modifying: " + subList.get(0).getGpa());
		System.out.println("They are same, that means sublist affects original");
		
		//subList.remove(1) is the same.
		
	}
	
	//Method 4: ArrayList Sorting
	private static void demonstrateSorting() {
		System.out.println("-------------- 4. ArrayList Sorting--------------");
			
		//Create an ArrayList of Student
        ArrayList<Student> studentList = new ArrayList<>();
        studentList.add(new Student("S001", "Alice", "Smith", "alice@uni.edu", 3.8, "CS", 2));
        studentList.add(new Student("S002", "Bob", "Jones", "bob@uni.edu", 3.5, "Math", 3));
        studentList.add(new Student("S003", "Charlie", "Brown", "charlie@uni.edu", 3.9, "CS", 2));
        studentList.add(new Student("S004", "Diana", "Prince", "diana@uni.edu", 4.0, "Physics", 4));
        studentList.add(new Student("S005", "Edward", "Norton", "edward@uni.edu", 3.2, "Math", 1));
        
        System.out.println("Original list (insertion order):");
        printStudentsSimple(studentList);
        System.out.println();
        
        //descending order:
        System.out.println("Sort by GPA (Descending): ");
        Collections.sort(studentList, new Comparator<Student>() {
        	@Override
        	public int compare(Student s1, Student s2) {
        		return Double.compare(s2.getGpa(), s1.getGpa());
        	}
		});
        printStudentsSimple(studentList);
        System.out.println();
        
        //Sort students by last name (alphabetical)
        Collections.sort(studentList, new Comparator<Student>() {
        	@Override
        	public int compare(Student s1, Student s2) {
        		return s1.getLastName().compareTo(s2.getLastName());
        	}
		});
        printStudentsSimple(studentList);
        System.out.println();
        //Note: 1比2，升序， 2比1，降序
	}
	
	//Helper method: Print student infor
	private static void printStudentsSimple(ArrayList<Student> list) {
		for(int i = 0; i < list.size(); i++) {
			Student s = list.get(i);
			System.out.println(" [" + i + "] " + s.getFullName() + " (GPA: " + s.getGpa() + ")");
		}
	}
	
	//Method 5: ArrayList Searching
	private static void demonstrateSearching() {
		System.out.println("-------------- 5. ArrayList Searching--------------");
			
		//Create an ArrayList of Student
        ArrayList<Student> studentList = new ArrayList<>();
        studentList.add(new Student("S001", "Alice", "Smith", "alice@uni.edu", 3.8, "CS", 2));
        studentList.add(new Student("S002", "Bob", "Jones", "bob@uni.edu", 3.5, "Math", 3));
        studentList.add(new Student("S003", "Charlie", "Brown", "charlie@uni.edu", 3.9, "CS", 2));
	
        System.out.println("Studnet list: ");
        for(Student s : studentList) {
        	System.out.println(" " + s.getStudentId() + ": " + s.getFullName());
        }
        System.out.println();
        
        //(1): indexOf
        Student alice = studentList.get(0);
        int index = studentList.indexOf(alice);
        System.out.println("(1): Using indexOf(): " );
        System.out.println(" Index of Alice: " + index);
        
        Student nonExistent = new Student("S999", "Test", "Test", "test@uni.edu", 0.0, "Test", 1);
        index = studentList.indexOf(nonExistent);
        System.out.println("   Index of non-existent student: " + index + " (returns -1)");
        System.out.println();
        
        //(2): contains()
        System.out.println("(2): Using contains():");
        boolean hasAlice = studentList.contains(alice);
        System.out.println(" Contains Alice? " + hasAlice);
        
        boolean hasNonExistent = studentList.contains(nonExistent);
        System.out.println(" Contains non-existent student? " + hasNonExistent);
        System.out.println();
        
        //(3): binarySearch()
        System.out.println("(3): Using binarySearch() (Must sort first)");
        
        //Sort by ID
        Collections.sort(studentList, new Comparator<Student>() {
        	@Override
        	public int compare(Student s1, Student s2) {
        		return s1.getStudentId().compareTo(s2.getStudentId());
        	}
		});
        
        System.out.println("List sorted by ID:");        
        for (Student s : studentList) {
            System.out.println("     " + s.getStudentId() + ": " + s.getFullName());
        }
        
        //Searching S002
        Student searchTarget = new Student("S002","","","",0.0,"",0);
        int binaryIndex = Collections.binarySearch(studentList, searchTarget, new Comparator<Student>() {
        	@Override
        	public int compare(Student s1, Student s2) {
        		return s1.getStudentId().compareTo(s2.getStudentId());
        	}
		});
        
        System.out.println("Binary search for S002: found at idnex " + binaryIndex);
        if(binaryIndex >= 0) {
        	System.out.println("Found Studeng: " + studentList.get(binaryIndex).getFullName());
        }
        System.out.println();
	}
	
	public static void main(String[] args) {
		//Method 1:
        demonstrateArrayToArrayList();

		//Method 2:
        demonstrateArrayToArrayList();
        
		//Method 3:
        demonstrateSublist();
        
		//Method 4:
        demonstrateSorting();
        
		//Method 5:
        demonstrateSearching();
	}
}
