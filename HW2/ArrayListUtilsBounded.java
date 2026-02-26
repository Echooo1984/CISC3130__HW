package HW2;

import java.util.ArrayList;

//Task 4.3
public class ArrayListUtilsBounded {
    public static <T extends Number> double sum(ArrayList<T> numbers) {
    	System.out.println("List has " + numbers.size() + " numbers");
    	System.out.println("Numbers: ");
    	for(int i = 0; i < numbers.size(); i++) {
    		System.out.println(numbers.get(i));
    		if(i < numbers.size() - 1) {
    			System.out.println(" + ");
    		}
    	}
    	
    	double total = 0.0;
    	for(int i = 0; i < numbers.size(); i++) {
    		T num = numbers.get(i);
    		total += num.doubleValue();
    	}
    	
    	System.out.println(" = " + total);
    	System.out.println("Total sum: " + total);
    	
    	return total;
    }
    
    public static <T extends Number> double average(ArrayList<T> numbers) {
        double sum = 0.0;
        for (int i = 0; i < numbers.size(); i++) {
            sum += numbers.get(i).doubleValue();
        }
        
        double avg = sum / numbers.size();
        
        System.out.println("\n--- Calculating Average ---");
        System.out.println("List has " + numbers.size() + " numbers");
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + avg);
        System.out.println("Formula: " + sum + " / " + numbers.size() + " = " + avg);
        
        return avg;
    	
    }
    
    public static <T extends Number & Comparable<T>> ArrayList<T> filterAbove(ArrayList<T> numbers, T threshold) {
    	ArrayList<T> result = new ArrayList<>();
    	
        System.out.println("Original list has " + numbers.size() + " numbers");
        System.out.print("Original: ");
        printList(numbers);
    	
        int count = 0;
        for (int i = 0; i < numbers.size(); i++) {
            T num = numbers.get(i);
            
            if (num.compareTo(threshold) > 0) {
                result.add(num);
                count++;
                System.out.println("  ✓ " + num + " > " + threshold + " -> keep");
            } else {
                System.out.println("  ✗ " + num + " <= " + threshold + " -> remove");
            }
        }
        
        printList(result);
        System.out.println("Found " + count + " numbers above " + threshold);
        
        return result;
    }
    
    //Helper method
    private static <T> void printList(ArrayList<T> list) {
        System.out.print("[");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            if (i < list.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
    
    public static void main(String[] args) {
    	ArrayList<Integer> ints = new ArrayList<>();
    	ints.add(10);
    	ints.add(20);
    	ints.add(30);
    	System.out.println("Sum: " + ArrayListUtilsBounded.sum(ints));
    	System.out.println("Average: " + ArrayListUtilsBounded.average(ints));
	}
  	
}
