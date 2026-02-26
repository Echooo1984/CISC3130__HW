package HW2;

import java.util.ArrayList;

//Task 4.4 
public class ArrayListUtilsWildcards { //? -> wildcards
	//Method 1
	public static double sumNumbers(ArrayList<? extends Number> numbers) {
		Number first = numbers.get(0);
		System.out.println("Received: ArrayList<" + first.getClass().getSimpleName() + ">");
		
		//counting total
	    double total = 0.0;
	    System.out.print("Numbers: ");
	    
	    for(int i = 0; i < numbers.size(); i++) {
	    	Number num = numbers.get(i);
	    	
	    	//Every subclass of Number can convert to double
	    	total += num.doubleValue();
	    	
	    	System.out.print(num);
	    	if(i < numbers.size() - 1) {
	    		System.out.print(" + ");
	    	}
	    }
	    System.out.println(" = " + total);
	    return total;
	}
	
	//Method 2
	private static void printList(ArrayList<?> list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i));
			if(i < list.size() - 1) {
				System.out.print(", ");
			}
		}
		System.out.println();
	}
	
	//Method 3
	public static void addNumbers(ArrayList<? super Integer> list) {
		String listType = "Unknown";
		if(!list.isEmpty()) {
			listType = list.get(0).getClass().getSimpleName();
		}else {
			listType = "? super Integer (Empty)";
		}
		System.out.println("Received: ArrayList<" + listType + ">");
		
		System.out.print("Before adding: ");
		printList(list); 
		
		System.out.println("Adding integers: 100,200,300");
		list.add(100);
		list.add(200);
		list.add(300);
		
		System.out.print("After adding: ");
		printList(list);
	}
	
	
	
	public static void main(String[] args) {
		//Test method 1
		//Integer
        ArrayList<Integer> ints = new ArrayList<>();
        ints.add(5);
        ints.add(10);
        ints.add(15);
        
        System.out.println("Sum of integers:");
        double sum1 = sumNumbers(ints);
        System.out.println("Result: " + sum1);
        System.out.println();
        
        //Double
        ArrayList<Double> doubles = new ArrayList<>();
        doubles.add(2.5);
        doubles.add(4.7);
        doubles.add(6.3);
        
        System.out.println("Sum of doubles:");
        double sum2 = sumNumbers(doubles);
        System.out.println("Result: " + sum2);
        System.out.println();
		
		
		//Test method 2 (While test method 3)
		//Integer
        System.out.println("1. Calling with ArrayList<Integer>:");
        ArrayList<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(2);
        intList.add(3);
        addNumbers(intList);
        
        //Double
        System.out.println("\n2. Calling with ArrayList<Number>:");
        ArrayList<Number> numList = new ArrayList<>();
        numList.add(1.5);
        numList.add(2.5);
        numList.add(3.5);
        addNumbers(numList);
	}
}








