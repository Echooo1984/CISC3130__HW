package HW2;

import java.util.ArrayList;
import java.util.Comparator;

//Task 4.1
public class ArrayListUtils {
	
	public static <T> void swap(ArrayList<T> list, int index1, int index2) {
		T temp = list.get(index1);
		list.set(index1, list.get(index2));
		list.set(index2, temp);
		System.out.println("Swapped elements at index " + index1 + " and " + index2);
	}
	
	public static <T extends Comparable<T>> T findMax(ArrayList<T> list) {
		T max = list.get(0);
		
		for(int i = 0; i < list.size(); i++) {
			T current = list.get(i);
			if(current.compareTo(max) > 0) {
				max = current;
			}
		}
		
		return max;
	}
	
	//Helper interface
	interface Predicate<T> {
		boolean test(T t);
	}
	
	public static <T> ArrayList<T> filter(ArrayList<T> list, Predicate<T> condition) {
		ArrayList<T> result = new ArrayList<>();
		
		for(T item : list) {
			if(condition.test(item)) {
				result.add(item);
			}
		}
		
		return result;
	}
	
	public static <T> void reverse(ArrayList<T> list) {
		int left = 0;
		int right = list.size() - 1;
		
		while(left < right) {
			T temp = list.get(left);
			list.set(left, list.get(right));
			list.set(right, temp);
			
			left++;
			right--;
		}
		
		System.out.println("List reversed successfully");
	}
	
	public static <T> ArrayList<T> merge(ArrayList<T> list1, ArrayList<T> list2) {
		ArrayList<T> result = new ArrayList<>();
		
		int size1 = 0;
		int size2 = 0;
		
		//first list
		if(list1 != null) {
			size1 = list1.size();
			
			//Add all elements from list1 to result.
			for(int i = 0; i < list1.size(); i++) {
				T item = list1.get(i);
				result.add(item);
			}
		}
		
		//second list
		if(list2 != null) {
			size2 = list2.size();
			
			//Add all elements from list1 to result.
			for(int i = 0; i < list2.size(); i++) {
				T item = list2.get(i);
				result.add(item);
			}
		}
		
		System.out.println("Merged " + size1 + " and " + size2 + " elements. Total: " + result.size());
		
		return result;
	}
	
	
}

