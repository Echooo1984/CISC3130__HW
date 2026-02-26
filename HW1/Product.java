package HW1;

import java.util.Objects;

public class Product {
	private String productId;
	private String name;
	private String category;
	private double price;
	private int quantityInStock;
	private String supplier;
	
	public Product(String productId, String name, String category, double price, int quantityInStock, String supplier) {
		this.price = price;
		this.productId = productId;
		this.name = name;
		this.category = category;
		this.quantityInStock = quantityInStock;
		this.supplier = supplier;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantityInStock() {
		return quantityInStock;
	}

	public void setQuantityInStock(int quantityInStock) {
		this.quantityInStock = quantityInStock;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	
	public String toString() {
		return "Product Id: " + productId + ", name: " + name + ", Category: " + category + ", Price: " + price + ", Quantity In Stock: " + quantityInStock + ", Supplier: " + supplier;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		Product other = (Product) obj;
		return productId.equals(other.productId);
	}
	
	@Override
	public int hashCode() {
		return productId.hashCode();
	}
	
}
