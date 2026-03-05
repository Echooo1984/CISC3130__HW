package HW3P;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LambdaExamples {
	//Method 1: Using lambda with forEach() method
	public static void printWithLambda(List<String> list) {
		list.forEach(item -> System.out.println("Item:" + item));
	}
	
	//Method 2: Using lambda with Runnable (multi-threading)
	public static void runWithLambda() {
		Runnable lambdaWay = () -> System.out.println("Running");
		lambdaWay.run();
	}
	
	//Method 3: Sort with lambda
	public static void sortWithLambda(List<Integer> numbers) {
		System.out.println("Original: " + numbers);
		
		//Decending order
		numbers.sort((a,b) -> b - a);
		System.out.println("Sorted (Decending): " + numbers);
		
		//Ascending order
		numbers.sort((a,b) -> a - b);
		System.out.println("Sorted (Ascending): " + numbers);
	}
	
	//Method 4: Make everything uppercase
	public static void makeUppercase(List<String> words) {
		System.out.println("Before: " + words);
		
		words.replaceAll(word -> word.toUpperCase());
		
		System.out.println("After: " + words);
	}
	
	//Method 5: Remove short words
	public static void removeShortWords(List<String> words, int minLength) {
		System.out.println("Before: " + words);
		
		words.removeIf(word -> word.length() < minLength);
		
		System.out.println("After: " + words);
	}
	
	public static void main(String[] args) {
		List<String> list = new ArrayList<>(Arrays.asList("nihao","llllllll","hi"));
		LambdaExamples.makeUppercase(list);
		LambdaExamples.removeShortWords(list, 6);
		
	}
}











