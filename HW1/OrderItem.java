package HW1;

public class OrderItem {
	private String productId;
	private String productName;
	private int quantity;
	private double unitPrice;
	private double subtotal; //calculated as quantity × unitPrice
	
	public OrderItem(String p1, String p2, int q, double u) {
		this.productId = p1;
		this.productName = p2;
		this.quantity = q;
		this.unitPrice = u;
		this.subtotal = q * u;
	}
	
	public OrderItem(String p1, String p2, int q, double u, double s) {
		this.productId = p1;
		this.productName = p2;
		this.quantity = q;
		this.unitPrice = u;
		this.subtotal = s;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	
	@Override
	public String toString() {
		return "Id: " + productId + ", Name: " + productName + ", Quantity: + " + quantity + ", Unit Price: " + unitPrice + ", Subtotal: " + subtotal;
	}
	
	public double calculateSubtotal() {
		return quantity * unitPrice;
	}
}
