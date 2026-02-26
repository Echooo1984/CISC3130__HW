package HW2;

import java.util.Arrays;
import java.util.ArrayList;

public class ArrayListVsArrayDemo {
	//1. Create Array vs. ArrayList
	private static void demonstrateCreation() {
		System.out.println("----------------1. Createion ----------------");
	
		//Create arrays (Specify size)
		System.out.println("Array: Must specify size at creation");
		Student[] studentArray = new Student[3];
        studentArray[0] = new Student("S001", "Alice", "Smith", "alice@uni.edu", 3.8, "CS", 2);
        studentArray[1] = new Student("S002", "Bob", "Jones", "bob@uni.edu", 3.5, "Math", 3);
        studentArray[2] = new Student("S003", "Charlie", "Brown", "charlie@uni.edu", 3.9, "CS", 2);
        System.out.println("Array created with size: " + studentArray.length);
        System.out.println("Array elements: " + Arrays.toString(getStudentIds(studentArray)));
        System.out.println();
        
        //Create arrayList (no need Specify size)
		System.out.println("ArrayList: No need specify size at creation");
		ArrayList<Student> studentList = new ArrayList<>();
        studentList.add(new Student("S001", "Alice", "Smith", "alice@uni.edu", 3.8, "CS", 2));
        studentList.add(new Student("S002", "Bob", "Jones", "bob@uni.edu", 3.5, "Math", 3));
        studentList.add(new Student("S003", "Charlie", "Brown", "charlie@uni.edu", 3.9, "CS", 2));
        System.out.println("ArrayList created with size: " + studentList.size());
        System.out.println("ArrayList elements: " + getStudentIds(studentList));
        System.out.println();

	}
	
	//Helped method 1
	private static String[] getStudentIds(Student[] studnets) {
		String[] ids = new String[studnets.length];
		for(int i = 0; i < studnets.length; i++) {
			if(studnets[i] != null) {
				ids[i] = studnets[i].getStudentId();
			}else {
				ids[i] = "null";
			}
		}
		return ids;
	}
	
	//Helper method 2
	private static ArrayList<String> getStudentIds(ArrayList<Student> students) {
		ArrayList<String> ids = new ArrayList<>();
		for(Student student : students) {
			ids.add(student.getStudentId());
		}
		return ids;
	}
	
	//2.(1): Add elements
	private static void demonstrateAddOperation(Student[] studentArray, ArrayList<Student> studentList) {
		System.out.println("----------------2.1 Add elements ----------------");
		
		//Array
		System.out.println("Initial array size: " + studentArray.length);
        System.out.println("Array elements: " + Arrays.toString(getStudentIds(studentArray)));
        
        //trying to add a 4th elements: size is full, and it will be error
        System.out.println("Trying to add a 4th student");
        try {
            studentArray[3] = new Student("S004", "David", "Lee", "david@uni.edu", 3.7, "Physics", 1);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ERROR: " + e.getClass().getSimpleName() + 
                             " - Cannot add beyond array size (size is fixed at creation)");
        }
        
        //Must create a new array with larger size
        System.out.println("Solution: Must create a new array with larger size:");
        Student[] newArray = Arrays.copyOf(studentArray, studentArray.length + 1);
        newArray[3] = new Student("S004", "David", "Lee", "david@uni.edu", 3.7, "Physics", 1);
        System.out.println("New array created with size: " + newArray.length);
        System.out.println("New array elements: " + Arrays.toString(getStudentIds(newArray)));
        System.out.println("(Original array remains unchanged)");
        
        //ArrayList
        System.out.println("Initial ArrayList size: " + studentList.size());
        System.out.println("ArrayList elements: " + getStudentIds(studentList));
        System.out.println("Adding a 4th student (David)...");
        studentList.add(new Student("S004", "David", "Lee", "david@uni.edu", 3.7, "Physics", 1));
        System.out.println("Success! New ArrayList size: " + studentList.size());
        System.out.println("Elements: " + getStudentIds(studentList));
        System.out.println("(ArrayList automatically resized itself - no new array needed)");
        System.out.println();
	}
	
	//2.(2): Remove elements
	   private static void demonstrateRemoveOperation(Student[] studentArray, ArrayList<Student> studentList) {
			System.out.println("----------------2.2 Remove elements ----------------");
			
	        studentArray = createArray();
	        studentList = createArrayList();
		   
	        //Array:
	        System.out.println("Initial array size: " + studentArray.length);
	        System.out.println("Elements: " + Arrays.toString(getStudentIds(studentArray)));
	        
	        System.out.println("Trying to remove Bob (S002)...");
	        
	        //Must create new array and copy all elements except the one to remove
	        Student[] newArray = new Student[studentArray.length - 1];
	        int newIndex = 0;
	        for (int i = 0; i < studentArray.length; i++) {
	            if (!studentArray[i].getStudentId().equals("S002")) {
	                newArray[newIndex++] = studentArray[i];
	            }
	        }
	        System.out.println("Result: Remove(Actually create a new copy without the element)");
	        System.out.println();
	        
	        //ArrayList:
	        System.out.println("Initial ArrayList size: " + studentList.size());
	        System.out.println("Elements: " + getStudentIds(studentList));
	        
	        System.out.println("Removing Bob (S002)...");
	        for (int i = 0; i < studentList.size(); i++) {
	            if (studentList.get(i).getStudentId().equals("S002")) {
	                studentList.remove(i);
	                System.out.println("Removed at index " + i);
	                break;
	            }
	        }
	        System.out.println("Result: Remove it directly from the arrayList");
	        
	   }
	
	 //Helper method 3:
	   private static Student[] createArray() {
		   Student[] array = new Student[3];
		    array[0] = new Student("S001", "Alice", "Smith", "alice@uni.edu", 3.8, "CS", 2);
		    array[1] = new Student("S002", "Bob", "Jones", "bob@uni.edu", 3.5, "Math", 3);
		    array[2] = new Student("S003", "Charlie", "Brown", "charlie@uni.edu", 3.9, "CS", 2);
		    return array;
	   }
	   
	 //Helper method 4:
	   private static ArrayList<Student> createArrayList() {
		   ArrayList<Student> list = new ArrayList<>();
		    list.add(new Student("S001", "Alice", "Smith", "alice@uni.edu", 3.8, "CS", 2));
		    list.add(new Student("S002", "Bob", "Jones", "bob@uni.edu", 3.5, "Math", 3));
		    list.add(new Student("S003", "Charlie", "Brown", "charlie@uni.edu", 3.9, "CS", 2));
		    return list;
	   }
	
	 //2.(3): Resize()
	    private static void demonstrateResizeOperation() {
			System.out.println("----------------2.3 Resize ----------------");
			
			//Array
	        System.out.println("【ARRAY - Cannot automatically resize】:");
	        Student[] studentArray = new Student[3];
	        studentArray[0] = new Student("S001", "Alice", "Smith", "alice@uni.edu", 3.8, "CS", 2);
	        studentArray[1] = new Student("S002", "Bob", "Jones", "bob@uni.edu", 3.5, "Math", 3);
	        studentArray[2] = new Student("S003", "Charlie", "Brown", "charlie@uni.edu", 3.9, "CS", 2);
	        System.out.println("Array initial size: " + studentArray.length);
	        System.out.println("Elements: " + Arrays.toString(getStudentIds(studentArray)));
			
	        //Increasing size
	        System.out.println("Need to increase size to 5...");
	        Student[] largerArray = Arrays.copyOf(studentArray, 5);
	        System.out.println("Created new array with size: " + largerArray.length);
	        System.out.println("New array elements: " + Arrays.toString(getStudentIds(largerArray)));
	        System.out.println("(Empty positions are null)");
	        
	        //Decreasing size
	        System.out.println("Need to decrease size to 2...");
	        Student[] smallerArray = Arrays.copyOf(studentArray, 2);
	        System.out.println("Created new array with size: " + smallerArray.length);
	        System.out.println("New array elements: " + Arrays.toString(getStudentIds(smallerArray)));
	        System.out.println("(Charlie was lost in the process)");
	        
	        //ArrayList
	        System.out.println("【ARRAYLIST - Advantage】Automatically resizes:");
	        ArrayList<Student> studentList = new ArrayList<>(3);
	        studentList.add(new Student("S001", "Alice", "Smith", "alice@uni.edu", 3.8, "CS", 2));
	        studentList.add(new Student("S002", "Bob", "Jones", "bob@uni.edu", 3.5, "Math", 3));
	        studentList.add(new Student("S003", "Charlie", "Brown", "charlie@uni.edu", 3.9, "CS", 2));
	        System.out.println("ArrayList initial size: " + studentList.size());
	        System.out.println("Elements: " + getStudentIds(studentList));
	        
	        //Auto Increasing or decreasing size
	        System.out.println("Adding two more students...");
	        studentList.add(new Student("S004", "David", "Lee", "david@uni.edu", 3.7, "Physics", 1));
	        studentList.add(new Student("S005", "Eva", "Green", "eva@uni.edu", 3.6, "Math", 2));
	        System.out.println("After adding: size = " + studentList.size());
	        System.out.println("Elements: " + getStudentIds(studentList));
	        System.out.println("(ArrayList automatically expanded to accommodate new elements)");
	        
	        System.out.println("Can optimize memory with trimToSize():");
	        studentList.trimToSize();
	        System.out.println("After trimToSize(): size = " + studentList.size() + 
	                         " (internal array trimmed to exactly fit elements)");
	        System.out.println();
	    }
	    
	 //3. Measure performance
	    private static void demonstratePerformance() {
			System.out.println("----------------5. Performance ----------------");

			final int ADD_COUNT = 10000;
			final int ACCESS_COUNT = 1000;
			
			//Testing ArrayList add Performance:
	        System.out.println("Testing ArrayList add performance...");
	        ArrayList<Student> arrayList = new ArrayList<>();
	        
	        long startTime = System.nanoTime();
	        for (int i = 0; i < ADD_COUNT; i++) {
	            String id = String.format("S%05d", i + 1);
	            arrayList.add(new Student(id, "First" + i, "Last" + i, 
	                                     "email" + i + "@uni.edu", 3.0, "Test", 1));
	        }
	        long endTime = System.nanoTime();
	        long arrayListAddTime = endTime - startTime;
	        System.out.println("ArrayList add " + ADD_COUNT + " students: " + 
	                          formatTime(arrayListAddTime));
			
			//Testing ArrayList access Performance:
	        System.out.println("Testing ArrayList access performance...");
	        Student[] studentArray = new Student[ADD_COUNT];
	        
	        startTime = System.nanoTime();
	        for (int i = 0; i < ACCESS_COUNT; i++) {
	            int randomIndex = (int)(Math.random() * ADD_COUNT);
	            Student s = arrayList.get(randomIndex);
	        }
	        endTime = System.nanoTime();
	        long arrayListAccessTime = endTime - startTime;
	        System.out.println("ArrayList access " + ACCESS_COUNT + " random students: " + formatTime(arrayListAccessTime));
	        
	        
			//Testing Array access Performance:
	        System.out.println("Testing Array random access performance...");
	        startTime = System.nanoTime();
	        for (int i = 0; i < ACCESS_COUNT; i++) {
	            int randomIndex = (int)(Math.random() * ADD_COUNT);
	            Student s = studentArray[randomIndex];
	        }
	        endTime = System.nanoTime();
	        long arrayAccessTime = endTime - startTime;
	        System.out.println("Array access " + ACCESS_COUNT + " random students: " + formatTime(arrayAccessTime));
	       
	        System.out.println();
	    }
	    
	    //Helper method 5:
	    private static String formatTime(long nanos) {
	        if (nanos < 1000) {
	            return nanos + " ns";
	        } else if (nanos < 1000000) {
	            return String.format("%.2f µs", nanos / 1000.0);
	        } else if (nanos < 1000000000) {
	            return String.format("%.2f ms", nanos / 1000000.0);
	        } else {
	            return String.format("%.2f s", nanos / 1000000000.0);
	        }
	    }
	    
	    //4. Printing Report
	    private static void printSummaryReport() {
			System.out.println("----------------4. Printing Report ----------------");

	        System.out.println("USE ARRAY WHEN:");
	        System.out.println("You know the exact size in advance");
	        System.out.println("Size will not change (fixed collection)");
	        System.out.println("Performance is critical (slightly faster access)");
	        System.out.println("Working with primitive types (int[], double[], etc.)");
	        System.out.println("Need multidimensional collections");
	        System.out.println("Examples:");
	        System.out.println("Days of the week (always 7)");
	        System.out.println("Monthly sales data for a specific year");
	        System.out.println("Matrix operations");
	        
	        System.out.println("USE ARRAYLIST WHEN:");
	        System.out.println("Size may change (add/remove elements)");
	        System.out.println("ou don't know the exact size in advance");
	        System.out.println("Need built-in methods (add, remove, contains, etc.)");
	        System.out.println("Need to easily sort or search");
	        System.out.println("Working with Collections Framework");
	        System.out.println("Examples:");
	        System.out.println("Student roster (students can add/drop)");
	        System.out.println("Shopping cart items");
	        System.out.println("Any dynamic list where size changes");
	        
	        System.out.println("--- Key Takeaways ---");
	        System.out.println("Array: Fixed size, faster access, manual resize");
	        System.out.println("ArrayList: Dynamic size, easier modifications, automatic resize");
	        System.out.println("Choose based on your needs: flexibility vs performance");
	    }
	    
	    public static void main(String[] args) {
	        Student[] studentArray = createArray();
	        ArrayList<Student> studentList = createArrayList();
	        
	        demonstrateAddOperation(studentArray, studentList);
	        
	        demonstrateRemoveOperation(studentArray, studentList);
	        
	        demonstrateResizeOperation();
	        
	        demonstratePerformance();
	        
	        printSummaryReport();
		}
}
 