Student.java              - Student class with fields and methods
Course.java               - Course class with prerequisites
StudentManager.java       - Manages students using ArrayList
CourseManager.java        - Manages courses using ArrayList
Enrollment.java           - Enrollment class for student-course links
EnrollmentManager.java    - Manages enrollments using ArrayList
ArrayListOperationsDemo.java - Shows ArrayList operations
ArrayListVsArrayDemo.java    - Compares ArrayList and Array
ArrayListUtils.java          - Generic utility methods
GenericList.java             - Generic container class
ArrayListUtilsBounded.java   - Bounded generics examples
ArrayListUtilsWildcards.java - Wildcard examples
GenericStack.java            - Generic stack implementation
GenericQueue.java            - Generic queue implementation
Pair.java                    - Generic pair class
ReportGenerator.java         - Generates reports
StudentManagementSystemMain.java - Main program with menu

------------
TASK 1: ARRAYLIST BASICS
------------
Files:
  Student.java        - Student entity with fields (ID, name, email, GPA, major, year)
  Course.java         - Course entity with code, name, credits, instructor, prerequisites
  StudentManager.java - Manages students using ArrayList

Features:
  - Add/remove/find students
  - Filter by major, year, GPA
  - Calculate average GPA
  - Get unique majors list
  
  ------------
TASK 2: ENROLLMENT MANAGEMENT
------------
Files:
  Enrollment.java        - Links students and courses with grades
  EnrollmentManager.java - Manages enrollments using ArrayList
  CourseManager.java     - Manages courses using ArrayList

Features:
  - Enroll/drop courses
  - Assign grades (A, B, C, D, F)
  - Calculate student GPA
  - Check course capacity
  - Check prerequisites
  - Auto-generate enrollment IDs (E001, E002...)
  
  ------------
TASK 3: ARRAYLIST OPERATIONS
------------
Files:
  ArrayListOperationsDemo.java - Shows ArrayList methods
  ArrayListVsArrayDemo.java    - Compares ArrayList and Array

Features:
  - Array to ArrayList conversion
  - ArrayList to Array conversion
  - subList() operations
  - Sorting with Comparator
  - Searching (indexOf, contains, binarySearch)
  - Performance comparison (add, access)
  
  ------------
TASK 4: GENERICS
------------
Files:
  ArrayListUtils.java          - Generic utility methods
  GenericList.java             - Generic container class
  ArrayListUtilsBounded.java   - Bounded generics examples
  ArrayListUtilsWildcards.java - Wildcard examples

Generic Methods:
  - swap() - swap two elements
  - findMax() - find maximum (requires Comparable)
  - filter() - filter with Predicate
  - reverse() - reverse list
  - merge() - merge two lists
  - sum() - sum numbers
  - average() - average numbers
  - filterAbove() - filter numbers above threshold

Wildcards:
  - Upper Bounded (? extends Number)
  - Lower Bounded (? super Integer)
  - Unbounded (?)
  
  ------------
TASK 5: GENERIC DATA STRUCTURES
------------
Files:
  GenericStack.java - LIFO stack using ArrayList
  GenericQueue.java - FIFO queue using ArrayList
  Pair.java         - Generic pair (K, V)

Methods:
  Stack: push, pop, peek, isEmpty, size
  Queue: enqueue, dequeue, peek, isEmpty, size
  Pair: getFirst, getSecond, setBoth, swap, equals, hashCode

------------
TASK 6: MAIN APPLICATION
------------
Files:
  StudentManagementSystemMain.java - Main program with menu
  ReportGenerator.java             - Generates various reports

Menu Options:
  1. Add Student
  2. Remove Student
  3. Find Student
  4. List All Students
  5. Add Course
  6. Enroll Student
  7. Assign Grade
  8. Calculate GPA
  9. Generate Reports
  10. Exit

Reports:
  - Student Report (by ID)
  - Course Report (by Code)
  - Major Report
  - Honor Roll Report (GPA ≥ 3.5)

Sample Data:
  - 10 students
  - 5 courses
  - Multiple enrollments
  
  ------------
NOTES
------------
- All classes use ArrayList for storage
- equals() and hashCode() based on ID fields
- Defensive copying used in getter methods
- Input validation for grades, GPA, year
- Prevents duplicate IDs and enrollments
- Auto-generates enrollment IDs
  
  
  
  
  