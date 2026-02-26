package HW2;

import java.util.ArrayList;

//Task 4.2
public class GenericList<T> {
	private ArrayList<T> items;
	
	public GenericList() {
		this.items = new ArrayList<>();
	}
	
	//1
	public void add(T item) {
		items.add(item);
		System.out.println("Added: " + item);
	}
	
	//2
	public T get(int index) {
		return items.get(index);
	}
	
	//3
	public boolean remove(T item) {
		boolean removed = items.remove(item);
		if(removed) {
			System.out.println("Removed: " + item);
		}else {
			System.out.println("Item not found: " + item);
		}
		
		return removed;
	}
	
	//4
	public int size() {
		return items.size();
	}
	
	//5
	public boolean isEmpty() {
		return items.isEmpty();
	}
	
	//6
	public void clear() {
		items.clear();
		System.out.println("List cleared");
	}
	
	//7
	public boolean contains(T item) {
		return items.contains(item);
	}
	
	//8
	public ArrayList<T> getAll() {
		return new ArrayList<>(items);
	}
	
	//9
	public void addAll(ArrayList<T> other) {
		int beforeSize = items.size();
		items.addAll(other);
		int addCount = items.size() - beforeSize;
		System.out.println("Added " + addCount + " elements from another list");
	}
	
	//10
	public <U extends T> void addAllFrom(GenericList<U> other) {
		ArrayList<U> itemsToAdd = other.getAll();
		
		int beforeSize = items.size();
		
		for(U element : itemsToAdd) {
			items.add(element);
			System.out.println("Added: " + element);
		}
		
		int afterSize = items.size();
		int added = afterSize - beforeSize;
		System.out.println("Added " + added + " elements");
		System.out.println("Now list have " + afterSize + " elements");
	}
	
	@SuppressWarnings("unchecked")
	private void sort() {
		int n = items.size();
		
		for(int i = 0; i < n - 1; i++) {
			for(int j = 0; j < n - 1 - i; j++) {
				T current = items.get(j);
				T next = items.get(j + 1);
				
				Comparable<T> comparableCurrent = (Comparable<T>) current;
				
				if(comparableCurrent.compareTo(next) > 0) {
					items.set(j, next);
					items.set(j + 1, current);
				}
			}
		}
	}
	
	public T findMax() {
		Object first = items.get(0);
		if(!(first instanceof Comparable)) {
	        System.out.println("Elements cannot be compared");
	        return null;
		}
		
	    T max = items.get(0);
	    System.out.println("Start with: " + max);
	    
	    for (int i = 1; i < items.size(); i++) {
	        T current = items.get(i);
	        
	        @SuppressWarnings("unchecked")
	        Comparable<T> comp = (Comparable<T>) max;
	        
	        if (comp.compareTo(current) < 0) {
	            max = current;
	            System.out.println("New max at index " + i + ": " + current);
	        }
	    }
	    
	    System.out.println("Final maximum: " + max);
	    return max;
	}
	
	public static void main(String[] args) {
		
		GenericList<String> strings = new GenericList<>();
		strings.add("Hello");

		GenericList<Integer> numbers = new GenericList<>();
		numbers.add(42);
		
	}
}


















