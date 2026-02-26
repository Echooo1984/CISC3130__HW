package HW1;

import java.util.Vector;
import java.util.ArrayList;

public class VectorComparisonDemo {
	Vector<Product> vec;
	ArrayList<Product> arr;
	
	public VectorComparisonDemo() {
		this.vec = new Vector<>();
		this.arr = new ArrayList<>();
	}
	
	//Create the prodcut for test
	private Product makeProduct(int i) {
		return new Product(
				"P" + i,
				"Product" + i,
				"Cat",
				i * 10.0,
				i,
				"Sup");
	} 
	
	
	//Test 1: add 10000 products
	public void testAddPerformance() {
		System.out.println("Test 1: add 10000 products");
		
		//clear
		vec.clear();
		arr.clear();
		
		//Vec Time
		long vecStart = System.currentTimeMillis();
		for(int i = 0; i < 10000; i++) {
			vec.add(makeProduct(i));
		}
		long vecEnd = System.currentTimeMillis();
		long vecTime = vecEnd - vecStart;
		
		//Arr Time
		long arrStart = System.currentTimeMillis();
		for(int i = 0; i < 10000; i++) {
			arr.add(makeProduct(i));
		}
		long arrEnd = System.currentTimeMillis();
		long arrTime = arrEnd - arrStart;
		
		//Pring Result
		System.out.println("Vector add time: " + vecTime + " mills");
		System.out.println("ArrayList add time: " + arrTime + " mills");
		
		if(vecTime < arrTime) {
			System.out.println("Vector faster");
		}else if(arrTime < vecTime) {
			System.out.println("ArrayList faster");
		}else {
			System.out.println("Same speed");
		}
	}
	
	//Test 2: random access 1000 times
	public void testRandomAccess() {
		System.out.println("Test 2: random access 1000 times");
		
		//Ready 10000 products
		for(int i = 0; i < 10000; i++) {
			Product p = makeProduct(i);
			vec.add(p);
			arr.add(p);
		}
		
		//Vector random access
		long vecStart = System.currentTimeMillis();
		for(int i = 0; i < 1000; i++) {
			int index = (int)(Math.random() * 10000);
			vec.get(index);
		}
		long vecEnd = System.currentTimeMillis();
		long vecTime = vecEnd - vecStart;
		
		//ArrayList random access
		long arrStart = System.currentTimeMillis();
		for(int i = 0; i < 1000; i++) {
			int index = (int)(Math.random() * 10000);
			arr.get(index);
		}
		long arrEnd = System.currentTimeMillis();
		long arrTime = arrEnd - arrStart;
		
		System.out.println("Vector access time: " + vecTime + " mills");
		System.out.println("ArrayList access time: " + arrTime + " mills");
		
		if(vecTime < arrTime) {
			System.out.println("Vector faster");
		}else if(arrTime < vecTime) {
			System.out.println("ArrayList faster");
		}else {
			System.out.println("Same speed");
		}
	}
	
	//Test 3: Memory usage
	public void testMemory() {
		System.out.println("Test 3: Memory usage");
		
		//clear
		vec.clear();
		arr.clear();
		
		//Add 1000 products for test
        for (int i = 0; i < 1000; i++) {
            Product p = makeProduct(i);
            vec.add(p);
            arr.add(p);
        }
        
        //Compare with their size and capacity
        System.out.println("Vector size: " + vec.size() + ", Capacity: " + vec.capacity());
        System.out.println("ArrayList size: " + arr.size() + ", Capacity: (N/A)");
	}
	
	//Print Report
	public void printReport() {
		System.out.println("Print Report: ");
		System.out.println("Vector has synchronized methods (thread-safe)");
		System.out.println("ArrayList has no synchronization (better performance)");
		
		System.out.println();
		
		System.out.println("When to choose:");
		System.out.println("Vector--Need thread safety, ArrayList--Need Single-threaded or better performance");
		
		System.out.println();
		System.out.println("SUMMARY");
		System.out.println("Vector thread-safe but slower");
		System.out.println("ArrayList faster but no thread-safe");		
	}
}

