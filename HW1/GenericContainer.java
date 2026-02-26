package HW1;

import java.util.Vector;

public class GenericContainer<T> {
	private Vector<T> items; //store items of type T
	
	//Empty container
	public GenericContainer(){
		this.items = new Vector<>();
	}
	
	//Container with nitial items
	public GenericContainer(Vector<T> initialItems){
		this.items = new Vector<>();
		if(initialItems != null) {
			this.items.addAll(initialItems);
		}
	}
	
	//Method 1: add item
	public void add(T itme) {
		if(itme == null) {
			System.out.println("Error, null item");
			return;
		}
		items.add(itme);
		System.out.println("Added: " + itme);
	}
	
	//Method 2: get itme
	public T get(int index) {
		if(index < 0 || index >= items.size()) {
			System.out.println("Error index");
			return null;
		}
		return items.get(index);
	}
	
	//Method 3: Remove item
    public boolean remove(T item) {
        if (item == null) {
            System.out.println("Error: Cannot remove null item");
            return false;
        }
        
        boolean removed = items.remove(item);
        if(removed) {
        	System.out.println("Removed: " + item);
        }else {
        	System.out.println("Item not found: " + item);
        }
        return removed;
    }
	
	//Method 4: return size
    public int size() {
    	return items.size();
    }
    
	//Method 5: returns copy of all items
    public Vector<T> getAll(){
    	return new Vector<>(items);
    }
    
	//Method 6: clears container
    public void clear() {
    	items.clear();
    	System.out.println("Container cleared");
    }
    
	//Method 7: checks if contains item
    public boolean contains(T item) {
    	if(item == null) {
    		return false;
    	}
    	return items.contains(item);
    }
  
	//Method 8: adds all from another Vector
    public void addAll(Vector<T> other) {
    	if(other == null) {
    		System.out.println("Error, other Vector is null");
    		return;
    	}
    	
    	int beforeSize = items.size();
    	items.addAll(other);
    	int added = items.size() - beforeSize;
    	
    	System.out.println("Added " + added + " itmes from another Vector");
    }
	
    public static void main(String[] args) {
    	GenericContainer<String> stringContainer = new GenericContainer<>();
    	stringContainer.add("Hello");
    	stringContainer.add("World");

    	GenericContainer<Integer> intContainer = new GenericContainer<>();
    	intContainer.add(10);
    	intContainer.add(20);

    	GenericContainer<Product> productContainer = new GenericContainer<>();
    	Product laptop = new Product("P001", "Laptop", "Electronics", 999.99, 10, "TechCorp");
    	Product tshirt = new Product("P002", "T-Shirt", "Clothing", 19.99, 50, "FashionInc");
    	productContainer.add(laptop);
    	productContainer.add(tshirt);
    	
    	Product p = productContainer.get(1);
    	System.out.println(p);
    	
    	System.out.println(productContainer.getAll());
    	productContainer.remove(tshirt);
    	System.out.println(productContainer.getAll());
	}
}







