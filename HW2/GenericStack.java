package HW2;

import java.util.ArrayList;

//Task 5.1
public class GenericStack<T> {
	private ArrayList<T> items;
	
	//Constructor: Creates an empty stack.
	public GenericStack() {
		items = new ArrayList<>();
		System.out.println("Created a new empty stack.");
	}
	
	//1
	public void push(T item) {
		if(item == null) {
			System.out.println("Cannot push null to stack");
			return;
		}
		
		items.add(item);
		System.out.println("Pushed: " + item);
	}
	
	//2
	public T pop() {
		//get last one elements
		int lastIndex = items.size() - 1;
		T item = items.get(lastIndex);
		
		//Remove last one elements
		items.remove(lastIndex);
		
		System.out.println("Popped: " + item);
		return item;
	}
	
	//3
	public T peek() {
		int lastIndex = items.size() - 1;
		T item = items.get(lastIndex);
		System.out.println("Peek: " + item);
		return item;
	}
	
	//4
	public boolean isEmpty() {
		return items.isEmpty();
	}
	
	//5
	public int size() {
		return items.size();
	}
	
	//6
	public void clear() {
		items.clear();
		System.out.println("Stack cleared");
	}
	
	public static void main(String[] args) {
		GenericStack<String> stack = new GenericStack<>();
		stack.push("First");
		stack.push("Second");
		System.out.println(stack.pop());
	}
	
}




















