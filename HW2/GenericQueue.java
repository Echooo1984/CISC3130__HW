package HW2;

import java.util.ArrayList;

//Task 5.2
public class GenericQueue<T> {
	private ArrayList<T> items;
	
	public GenericQueue() {
		this.items = new ArrayList<>();
		System.out.println("Created a new empty queue");
	}
	
	//1
	private void enqueue(T item) {
		items.add(item);
		System.out.println("Enqueued: " + item);
	}
	
	//2
	public T dequeue() {
		//Get the first elements
		T item = items.get(0);
		
		//Remove the first elements
		items.remove(0);
		
		System.out.println("Dequeue: " + item);
		return item;
	}
	
	//3
	public T peek() {
		T item = items.get(0);
		System.out.println("Peeked: " + item);
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
	
	public static void main(String[] args) {
		GenericQueue<Integer> queue = new GenericQueue<>();
		queue.enqueue(10);
		queue.enqueue(20);
		System.out.println(queue.dequeue());  // 10
	}
}









