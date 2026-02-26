package HW1;
import java.util.Vector;

public class Order {
	private String orderId;
	private String customerName;
	private String orderDate;
	private Vector<OrderItem> items = new Vector<>();
	private String orderStatus;
	
	public Order(String o, String c, String o2) {
		this.orderId = o;
		this.customerName = c;
		this.orderDate = o2;
		
		if(o.equals("O001")) {
			this.orderStatus = "Delivered";
		}else {
			this.orderStatus = "Pending";
		}
	}
	
	//get/set method
	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public void setItems(Vector<OrderItem> items) {
		this.items = items;
	}

	
	//Method 1
	public void addItem(OrderItem item) {
		items.add(item);
	}
	
	//Method 2
	public boolean removeItem(String productId) {
		if(productId == null || productId.trim().isEmpty()) {
			System.out.println("Invalid ID");
			return false;
		}
		
		for(int i = 0; i < items.size(); i++) {
			if(items.get(i).getProductId().equals(productId)) {
				OrderItem removed = items.remove(i);
				System.out.println("Order " + orderId + ": " + removed.getProductName() + " removed");
				return true;
			}
		}
		
		System.out.println("Id: " + productId + " not found");
		return false;
	}
	
	//Method 3
	public OrderItem findItem(String productId) {
		if(productId == null || productId.trim().isEmpty()) {
			return null;
		}
		
		for(OrderItem item : items) {
			if(item.getProductId().equals(productId)) {
				return item;
			}
		}
		
		return null;
	}
	
	//Method 4
	public double calculateTotal() {
		double total = 0.0;
		
		for(OrderItem item : items) {
			total += item.getQuantity() * item.getUnitPrice();
		}
		
		return total;
	}
	
	////Method 5
	public int getTotalItems() {
		int total = 0;
		
		for(OrderItem item : items) {
			total += item.getQuantity();
		}
		
		return total;
	}
	
	//Method 6
	public void updateStatus(String newStatus) {
        String[] validStatuses = {"Pending", "Processing", "Shipped", "Delivered", "Cancelled"};
        boolean isValid = false;
        
        for(String status : validStatuses) {
        	if(status.equals(newStatus)) {
        		isValid = true;
        		break;
        	}
        }
        
        if(!isValid) {
        	System.out.println("Invalid Status: " + newStatus);
        	return;
        }
        
        String oldStatus = this.orderStatus;
        this.orderStatus = newStatus;
        System.out.println("Order " + orderId + " status updated: " + oldStatus + "-> " + newStatus);
	}
	
	//Method 7
	public void printOrder() {
		System.out.println("Order Id: " + orderId);
		System.out.println("Customer: " + customerName);
		System.out.println("Date: " + orderDate);
		System.out.println("Status: " + orderStatus);
		
		if(items.isEmpty()) {
			System.out.println("No items in this order");
		}else {
			for(OrderItem item : items) {
				System.out.println(" " + item.toString());
			}
		}
		
		System.out.println("Total: " + calculateTotal());
		System.out.println("Total Quantity: " + getTotalItems());
	}
	
	//Method 8
	public Vector<OrderItem> getItems(){
		return new Vector<>(items);
	}
	
	@Override
	public String toString() {
		return "Id: " + orderId +", name: " + customerName + ", Date: " + orderDate + ", Status: " + orderStatus + ", size: " + items.size() + ", Total: " + calculateTotal();
	}
	
}









