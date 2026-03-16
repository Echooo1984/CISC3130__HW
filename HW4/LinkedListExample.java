package HW4;

import java.util.LinkedList;

public class LinkedListExample {
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		
		list.add(10); //[10]
		list.add(20); //[10, 20]
		list.add(30); //[10, 20, 30]
		list.add(40); //[10, 20, 30, 40]
		list.add(50); //[10, 20, 30, 40, 50]
		
		System.out.println("Before: " + list);
		
		//if want put '30' to the front
		int target = 30;
		
		int index = list.indexOf(target);
		System.out.println("Target number: " + target + " in index: " + index);
		
		//Remove it
		Integer removed = list.remove(index); //[10, 20, 40, 50]
		System.out.println("Removed element: " + removed);
		
		//Put removed value to the front
		list.addFirst(removed); //[30, 10, 20, 40, 50]
		
		System.out.println("After:  " + list); 
	}
}





