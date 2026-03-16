package HW4;

import java.util.Stack;

public class StackExample {
	
	public static void moveToFront(Stack<Integer> stack, int target) {
		Stack<Integer> tempStack = new Stack<>();
		
		//First step:
		while(!stack.isEmpty() && stack.peek() != target) {
			int element = stack.pop(); // remove the top and return
			tempStack.push(element); // Add to the tempStack
			System.out.println(element + " move to the temp stack");
		}
		
		//Second step:
		System.out.println("Target element found: " + target + ", pop it");
		int targetElement = stack.pop();
		
		//Third step:
		System.out.println("Put back elements from temp stack to original stack");
		while(!tempStack.isEmpty()) {
			int element = tempStack.pop();
			stack.push(element);
			System.out.println("Move element: " + element + " to the stack");
		}
		
		//Fourth step:
		System.out.println("Move target element: " + targetElement + " to the top");
		stack.push(targetElement);
		
	}
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		
		stack.push(10); //Bottom
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.push(50); //Top -> [10, 20, 30, 40, 50]
		
		System.out.println("Before: " + stack);
		System.out.println("The top of the Stack: " + stack.peek());
		
		moveToFront(stack, 30); //[10, 20, 40, 50, 30]
		
		System.out.println("After:  " + stack);
		System.out.println("The new top of the Stack: " + stack.peek());
	}
}
