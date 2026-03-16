package HW4;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {
	public static void moveMiddleToFront(Queue<Integer> queue, int target) {
		int size = queue.size();
		boolean found = false;
		
		for(int i = 0; i < size; i++) {
			int current = queue.poll(); //remove and return this element
			if(current == target && !found) {
				found = true;
			}else {
				queue.offer(current); //insert this element
			}
		}
		
		if(found) {
			queue.offer(target);
		}
		
		/*
		 * Reorder: Move all elements preceding the target element 
		 * to the end of the queue.
		 */
		Queue<Integer> temp = new LinkedList<>();
		temp.offer(target);
		while(!queue.isEmpty()) {
			int value = queue.poll();
			if(value != target) {
				temp.offer(value);
			}
		}
		queue.addAll(temp);
	}
	
	//Test
	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(10);
		queue.offer(20);
		queue.offer(30);
		queue.offer(40);
		queue.offer(50);
		
		System.out.println("Before: " + queue);
		moveMiddleToFront(queue, 30);
		System.out.println("After:  " + queue);
	}
}

/*
 * Queue is FIFO Structure(First in First out)
 * so that only insert at the tail and delete at the head 
 */

