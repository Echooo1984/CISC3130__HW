package HW3P;

import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Arrays;

public class IteratorExamples {
	//Method 1: Print all elements using iterator
	public static void printAllElements(List<String> list) {
		Iterator<String> iterator = list.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
	
	//Method 2: Remove specific elements
	public static void removeElements(List<String> list, String prefix) {
		Iterator<String> itertor = list.iterator();
		while(itertor.hasNext()) {
			String element = itertor.next();
			if(element.startsWith(prefix)) {
				itertor.remove();
				System.out.println("Remove: " + element);
			}
		}
	}
	
	//Method 3: Find maximum number using iterator
	public static int findMax(List<Integer> numbers) {
		Iterator<Integer> iterator = numbers.iterator();
		
		int max = iterator.next();
		while(iterator.hasNext()) {
			int current = iterator.next();
			if(current > max) {
				max = current;
			}
		}
		
		System.out.println("Maximum value: " + max);
		return max;
	}
	
	//Method 4: Count elements that satisfy a condition
	public static int countEvenNumbers(List<Integer> numbers) {
		Iterator<Integer> iterator = numbers.iterator();
		int count = 0;
		
		while(iterator.hasNext()) {
			if(iterator.next() % 2 == 0) {
				count++;
			}
		}
		
		System.out.println("Even numbers count: " + count);
		return count;
	}
	
	//Method 5: Combine two lists using iterator
	public static List<String> combineLists(List<String> list1, List<String> list2){
		List<String> combined = new ArrayList<>();
		
		Iterator<String> iterator1 = list1.iterator();
		Iterator<String> iterator2 = list2.iterator();
		
		while(iterator1.hasNext()) {
			combined.add(iterator1.next());
		}
		
		while(iterator2.hasNext()) {
			combined.add(iterator2.next());
		}
		
		System.out.println("Combined list: " + combined);
		return combined;
	}
	
	public static void main(String[] args) {
		List<String> fruits = new ArrayList<>(Arrays.asList("Apple","Banana","Orange"));
		List<String> people = new ArrayList<>(Arrays.asList("Wang","Chen","Li"));
		List<Integer> numbers = new ArrayList<>(Arrays.asList(1,10,2,3));
		
		IteratorExamples.findMax(numbers);
		IteratorExamples.combineLists(fruits, people);
	}
}








