package HW1;

import java.util.Vector;
import java.util.Enumeration;

public class ProductInventory {
	private Vector<Product> products = new Vector<>();
	
	//Method 1
	public void addProduct(Product product) {
		if(product == null) {
			System.out.println("Cannot add null product");
			return;
		}
		
		if(findProduct(product.getProductId()) != null) {
			System.out.println(product.getProductId() + " already exists");
			return;
		}
		
		products.add(product);
		System.out.println("Product added: " + product.getProductId());
	}
	
	//Method 2
	public boolean removeProduct(String productId) {
		if(productId == null || productId.trim().isEmpty()) {
			System.out.println("Error, Invalid ID");
			return false;
		}
		
		for(int i = 0; i < products.size(); i++) {
			if(products.get(i).getProductId().equals(productId)) {
				products.remove(i);
				System.out.println("Product: " + productId + " removed");
				return true;
			}
		}
		
		return false;
	}
	
	//Method 3
	public Product findProduct(String productId) {
		if(productId == null || productId.trim().isEmpty()) {
			return null;
		}
		
		for(Product p : products) {
			if(p.getProductId().equals(productId)) {
				return p;
			}
		}
		
		return null;
	}
	
	//Method 4
	public Vector<Product> getProductsByCategory(String category) {
		Vector<Product> result = new Vector<>();
		if(category == null || category.trim().isEmpty()) {
			return result;
		}
		
		for(Product p : products) {
			if(p.getCategory().equalsIgnoreCase(category)) {
				result.add(p);
			}
		}
		
		return result;
	}
	
	//Method 5
	public Vector<Product> getLowStockProducts(int threshold) {
		Vector<Product> result = new Vector<>();
		
		for(Product p : products) {
			if(p.getQuantityInStock() < threshold) {
				result.add(p);
			}
		}
		
		return result;
	}
	
	//Method 6
	public double getTotalInventoryValue() {
		double total = 0.0;
		
		for(Product p : products) {
			total += p.getPrice() * p.getQuantityInStock();
		}
		
		return total;
	}
	
	//Method 7
	public void updateStock(String productId, int quantityChange) {
		Product product = findProduct(productId);
		
		if(product == null) {
			System.out.println("Not found");
			return;
		}
		
		int newQuantity = product.getQuantityInStock() + quantityChange;
		if(newQuantity < 0) {
			System.out.println("Error: " + product.getQuantityInStock() + ", Requested change: " + quantityChange);
			return;
		}
		
		product.setQuantityInStock(newQuantity);
		System.out.println("Stock updated for: " + productId + ". New quantity: " + newQuantity);
		
	}
	
	//Method 8
	public void printAllProducts() {
		if(products.isEmpty()) {
			System.out.println("Inventory is Empty");
			return;
		}
		
		System.out.println("Inventory: ");
		for(Product p : products) {
			System.out.println(p.toString());
		}
		
		System.out.println("Total products: " + products.size());
	}
	
	//Method 9
	public int getTotalProducts() {
		return products.size();
	}
	
	//Method 10
	public void printCapacityInfo() {
		System.out.println("Vector Capacity Info:");
		System.out.println("Size: " + products.size());
		System.out.println("Capacity: " + products.capacity());
	}
	
	//Task 3.1 methods
	//Method 1
	public void optimizeCapacity() {
		int beforeSize = products.size();
		int beforeCapacity = products.capacity();
		int excessCapacity = beforeCapacity - beforeSize;
		
		products.trimToSize();
		
		int afterCapacity = products.capacity();
		
		System.out.println("Optimize Capacity:");
		System.out.println("Before Optimize: ");
		System.out.println("Size: " + beforeSize);
		System.out.println("Capacity: " + beforeCapacity);
		System.out.println("Excess capacity: " + excessCapacity);
		
		System.out.println("After Optimize: ");
		System.out.println("After Optimize: ");
		System.out.println("Capacity: " + afterCapacity);
		System.out.println("Excess capacity: " + (afterCapacity - beforeSize));	
	}
	
	//Method 2
	public void ensureCapacity(int minCapacity) {
		int beforeCapacity = products.capacity();
		int beforeSize = products.size();
		
		//ensure capacity at least is minCapacity
		products.ensureCapacity(minCapacity);
		
		int afterCapacity = products.capacity();
		
		System.out.println("Ensure capacity: ");
		System.out.println("Requested minimum capacity: " + minCapacity);
		System.out.println("Current size: " + beforeSize);
		System.out.println("Before Capacity: " + beforeCapacity);
		
		if(afterCapacity > beforeCapacity) {
			System.out.println("After Capacity: " + afterCapacity);
			System.out.println("Added " + (afterCapacity - beforeCapacity) + " extra slots");
		}else if(afterCapacity == beforeCapacity) {
			if(beforeCapacity >= minCapacity) {
				System.out.println("After Capacity: " + afterCapacity + "(already sufficient)");
			}else{
				System.out.println("After Capacity: " + afterCapacity + "(unable to increase)");
			}
		}
	}
	
	//Method 3
	public void printCapacityReport() {
		int size = products.size();
		int capacity = products.capacity();
		
		double utilizationPercentage;
		if(capacity == 0) {
			utilizationPercentage = 0.0;
		}else {
			utilizationPercentage = size * 100.0 / capacity;
		} 
		//double utilizationPercentage = (capacity == 0)?0 : (size * 100.0 / capacity)
		
		int canAddBeforeResize = capacity - size;
		
		System.out.println("Report: ");
		System.out.println("Current Size: " + size);
		System.out.println("Current Capacity: " + capacity);
		System.out.println("Utilization Percentage: " + utilizationPercentage + "%");
		System.out.println("Can add before resize: " + canAddBeforeResize);
	}
	
	//Task 3.2 methods
	//Method 1
	public void printProductsUsingEnumeration() {
		System.out.println("Print Products Using Enumeration:");
		
		if(products.isEmpty()) {
			System.out.println("Empty, nothing to display");
			return;
		}
		
		//枚举接口: 用于遍历
		Enumeration<Product> enumeration = products.elements();
		System.out.println("Product List (Using Enumeration):");
		
		int count = 0;
		while(enumeration.hasMoreElements()) {
			Product p = enumeration.nextElement();
			count++;
			System.out.println(count + ". " + p.getProductId() + " - " + p.getName() + ", price: " + p.getPrice() + ", Stock: " + p.getQuantityInStock());
		}
		System.out.println("Total products displayed: " + count);
	}
	
	
	//Main method for Test
	public static void main(String[] args) {
		ProductInventory inventory = new ProductInventory();

		inventory.addProduct(new Product("P001", "Laptop", "Electronics", 999.99, 10, "TechCorp"));
		inventory.addProduct(new Product("P002", "T-Shirt", "Clothing", 19.99, 50, "FashionInc"));
		inventory.addProduct(new Product("P003", "Mouse", "Electronics", 29.99, 5, "TechCorp"));

		inventory.printAllProducts();
		inventory.printCapacityInfo();

		Vector<Product> electronics = inventory.getProductsByCategory("Electronics");
		System.out.println("Electronics: " + electronics.size());

		Vector<Product> lowStock = inventory.getLowStockProducts(10);
		System.out.println("Low stock items: " + lowStock.size());

		System.out.println("Total inventory value: $" + inventory.getTotalInventoryValue());
	}
}
