package HW1;

import java.util.Vector;
import java.util.function.Predicate;

//泛型

public class VectorUtils {
	//Method 1
	public static <T> void swap(Vector<T> vec, int index1, int index2) {
		if(index1 == index2) {
			return; //dont need swap if same position
		} 
		
		T temp = vec.get(index1);
		vec.set(index1, vec.get(index2));
		vec.set(index2, temp);
		
		System.out.println("Swapped positions " + index1 + " and " + index2);
	}
	
	//Method 2
	public static <T extends Comparable<T>> T findMax(Vector<T> vec) {
		//Check empty?
		if(vec == null || vec.isEmpty()){
			System.out.println("Error, empty");
			return null;
		}
		T max = vec.get(0);
		for(int i = 0; i < vec.size(); i++) {
			T current = vec.get(i);
			if(current.compareTo(max) > 0) { //current - max ? 0?
				max = current;
			}
		}
		return max;
	}
	
	//Method 3
	public static <T> int countMatches(Vector<T> vec, T target) {
		int count = 0;
		for(T elements : vec) {
			if(target.equals(elements)) {
				count++;
			}
		}
		return count;
	}
	
	//Method 4
	public static <T> Vector<T> filter(Vector<T> vec, Predicate<T> condition){
		Vector<T> result = new Vector<>();
		
		if(vec == null || condition == null) {
			System.out.println("Error,null");
			return result;
		}
		
		for(T elements : vec) {
			if(condition.test(elements)) {
				result.add(elements);
			}
		}
		
		return result;
	}
	
	//Tool for print elements in Vector
	public static <T> void printVector(String name, Vector<T> vec) {
		System.out.print(name + ": [");
		if(vec!=null) {
			for(int i = 0; i < vec.size(); i++) {
				System.out.print(vec.get(i));
				if(i < vec.size() - 1) {
					System.out.print(", ");
				}
			}
		}
		System.out.println("]");
	}
	
	//Task 4.3 method 1: 
	public static <T extends Number> double sumNumbers(Vector<T> numbers) {
		 double sum = 0.0;
		 for(T num : numbers) {
			 sum += num.doubleValue();
		 }
		 return sum;
	 }
	
	//Task 4.3 method 2:
	public static <T extends Number> double averageNumbers(Vector<T> numbers) {
		double sum = sumNumbers(numbers);
		return sum / numbers.size();
	}
	
	
	public static void main(String[] args) {
		//Test 1
		System.out.println("Test method 1:");
		
		//Test String
		Vector<String> stringVec = new Vector<>();
		stringVec.add("a");
		stringVec.add("b");
		stringVec.add("c");
		
		System.out.println("Before swap:");
		printVector("String Vector", stringVec);
		
		System.out.println("After swap:");
		swap(stringVec, 0, 2);//swap "a" and "c"
		printVector("String Vector", stringVec);
		
		//Test Integer
		Vector<Integer> intVec = new Vector<>();
		intVec.add(10);
		intVec.add(20);
		intVec.add(100);
		intVec.add(520);
		intVec.add(0);
		
		System.out.println("Before swap:");
		printVector("Integer Vector", intVec);
		
		System.out.println("After swap:");
		swap(intVec, 1, 3);//swap "20" and "520"
		printVector("Integer Vector", intVec);
		
		System.out.println("---------------------Test 1 END---------------------");
		
		//Test 2
		System.out.println("Test method 2:");

		//Test Integer
		Integer maxNum = findMax(intVec);
		System.out.println("Numbers: " + intVec);
		System.out.println("Maximum: " + maxNum);
		
		//Test String
		String maxString = findMax(stringVec);
		System.out.println("String: " + stringVec);
		System.out.println("Maxinum: " + maxString);
		
		//Test Product
		Vector<Product> products = new Vector<>();
        products.add(new Product("P003", "Mouse", "Electronics", 29.99, 5, "TechCorp"));
        products.add(new Product("P001", "Laptop", "Electronics", 999.99, 10, "TechCorp"));
        products.add(new Product("P002", "T-Shirt", "Clothing", 19.99, 50, "FashionInc"));
		
//        Product maxProduct = findMax(products);
//        System.out.println("Max product: " + maxProduct);
        
		System.out.println("---------------------Test 2 END---------------------");

        
        //Test 3
		System.out.println("Test method 3:");
        Vector<String> fruits = new Vector<>();
        fruits.add("apple");
        fruits.add("banana");
        fruits.add("apple");
        fruits.add("orange");
        fruits.add("apple");
        
        System.out.println("Fruits: " + fruits);
        int appleCount = countMatches(fruits, "apple");
        int bananaCount = countMatches(fruits, "banana");
        int orangeCount = countMatches(fruits, "orange");
        
        System.out.println("Count of apple: " + appleCount);
        System.out.println("Count of banana: " + bananaCount);
        System.out.println("Count of orange: " + orangeCount);
        
		System.out.println("---------------------Test 3 END---------------------");

        //Test 4
		System.out.println("Test method 4:");
		
        Vector<Integer> testNumbers = new Vector<>();
        testNumbers.add(7);
        testNumbers.add(3);
        testNumbers.add(4);
        testNumbers.add(8);
        testNumbers.add(12);
        
        Vector<Integer> greaterThanSix = filter(testNumbers, n -> n > 6);
        printVector("Numbers > 6", greaterThanSix);
        
		System.out.println("---------------------Test 4 END---------------------");
		
		//Test 5: Test task 4.3
		Vector<Integer> ints = new Vector<>();
		ints.add(10);
		ints.add(20);
		ints.add(30);
		System.out.println("Sum: " + VectorUtils.sumNumbers(ints));  // 60.0
		System.out.println("Average: " + VectorUtils.averageNumbers(ints));
		System.out.println("---------------------Test 5 END---------------------");

	}
	
}



