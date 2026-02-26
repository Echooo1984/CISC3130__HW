package HW1;
import java.util.Vector;

public class OrderManager {
	private Vector<Order> orders;
	
	public OrderManager() {
		this.orders = new Vector<>();
	}
	
	//Method 1
	public void addOrder(Order order) {
		orders.add(order);
		System.out.println("Order added: " + order.getOrderId());
	}
	
	//Method 2
	public Order findOrder(String orderId) {
		if(orderId == null || orderId.trim().isEmpty()) {
			return null;
		}
		
		for(Order o : orders) {
			if(o.getOrderId().equals(orderId)) {
				return o;
			}
		}
		
		return null;
	}
	
	//Method 3
	 public Vector<Order> getOrdersByStatus(String status) {
		 Vector<Order> result = new Vector<Order>();
		 
		 if(status == null || status.trim().isEmpty()) {
			 return result;
		 }
		 
		 for(Order o : orders) {
			 if(o.getOrderStatus().equalsIgnoreCase(status)){
				 result.add(o);
			 }
		 }
		 
		 return result;
	 }
	
	//Method 4
	 public Vector<Order> getOrdersByCustomer(String customerName) {
		 Vector<Order> result = new Vector<Order>();
		 
		 if(customerName == null || customerName.trim().isEmpty()) {
			 return result;
		 }
		 
		 for(Order o : orders) {
			 if(o.getCustomerName().equalsIgnoreCase(customerName)) {
				 result.add(o);
			 }
		 }
		 
		 return result;
	 }
	 
	//Method 5
	 public double getTotalRevenue() {
		 double total = 0.0;
		 
		 for(Order o : orders) {
			 if(o.getOrderStatus() != null && o.getOrderStatus().equalsIgnoreCase("Delivered")) {
				 total += o.calculateTotal();
			 }
		 }
		 
		 return total;
	 }
	 
	//Method 6
	 public void cancelOrder(String orderId) {
		 Order order = findOrder(orderId);
		 
		 if(order == null) {
			 System.out.println(orderId + " not found");
			 return;
		 }
		 
		 String currentStatus = order.getOrderStatus();
		 if(currentStatus.equals("Delivered") || currentStatus.equals("Cancelled")) {
			 System.out.println("Error: " + currentStatus);
			 return;
		 }
		 
		 order.updateStatus("Cancelled");
		 System.out.println("Order: " + orderId + " has been cancelled");
	 }
	 
	//Method 7
	 public void printAllOrders() {
		 if(orders.isEmpty()){
			 System.out.println("No orders");
			 return;
		 }
		 
		 System.out.println("Total orders: " + orders.size());
	     for (int i = 0; i < orders.size(); i++) {
	         Order order = orders.get(i);
	         System.out.println((i + 1) + ". " + order.toString());
	     }
	     
	     System.out.println("Pending: " + getOrdersByStatus("Pending").size());
	     System.out.println("Processing: " + getOrdersByStatus("Processing").size());
	     System.out.println("Shipped: " + getOrdersByStatus("Shipped").size());
	     System.out.println("Delivered: " + getOrdersByStatus("Delivered").size());
	     System.out.println("Cancelled: " + getOrdersByStatus("Cancelled").size());
	     System.out.println("Total Revenue (Delivered only): " + getTotalRevenue());
	 }
	 
	//Method 8
	 public Vector<Order> getPendingOrders(){
		 return getOrdersByStatus("Pending");
	 }
	 
	//Method 9
	 public int getOrderCount() {
		 return orders.size();
	 }

	 public static void main(String[] args) {
		 OrderManager orderManager = new OrderManager();

		 Order order1 = new Order("O001", "Alice", "2024-01-15");
		 order1.addItem(new OrderItem("P001", "Laptop", 1, 999.99));
		 order1.addItem(new OrderItem("P003", "Mouse", 2, 29.99));
		 orderManager.addOrder(order1);

		 Order order2 = new Order("O002", "Bob", "2024-01-16");
		 order2.addItem(new OrderItem("P002", "T-Shirt", 3, 19.99));
		 orderManager.addOrder(order2);

		 orderManager.printAllOrders();
		 System.out.println("Total revenue: $" + orderManager.getTotalRevenue());
	}
}









