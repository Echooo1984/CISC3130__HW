package HW1;

import java.util.Vector;
import java.util.Scanner;

public class InventorySystemMain {
    private ProductInventory productInventory;
    private OrderManager orderManager;
    private Scanner scanner;
    
    public InventorySystemMain() {
        this.productInventory = new ProductInventory();
        this.orderManager = new OrderManager();
        this.scanner = new Scanner(System.in);
    }
    
    public void initSampleData() {
    	System.out.println("Initializing smaple Data: ");
    	productInventory.addProduct(new Product("P001", "Laptop", "Electronics", 999.99, 10, "TechCorp"));
        productInventory.addProduct(new Product("P002", "T-Shirt", "Clothing", 19.99, 50, "FashionInc"));
        productInventory.addProduct(new Product("P003", "Mouse", "Electronics", 29.99, 5, "TechCorp"));
        
        Order order1 = new Order("O001", "Alice", "2024-01-15");
        order1.addItem(new OrderItem("P001", "Laptop", 1, 999.99));
        order1.addItem(new OrderItem("P003", "Mouse", 2, 29.99));
        order1.updateStatus("Delivered");
        orderManager.addOrder(order1);
        
        Order order2 = new Order("O002", "Bob", "2024-01-16");
        order2.addItem(new OrderItem("P002", "T-Shirt", 3, 19.99));
        orderManager.addOrder(order2);
    }
    
    public void run() {
    	initSampleData();
    	
    	int choice;
    	
    	do {
            System.out.println("---------------Inventory System---------------");
            System.out.println("1. Add Product");
            System.out.println("2. Remove Product");
            System.out.println("3. Find Product");
            System.out.println("4. List All Products");
            System.out.println("5. Create Order");
            System.out.println("6. View Orders");
            System.out.println("7. Process Order");
            System.out.println("8. Generate Reports");
            System.out.println("9. Exit");
            System.out.print("Choice: ");
            
            choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    removeProduct();
                    break;
                case 3:
                    findProduct();
                    break;
                case 4:
                    productInventory.printAllProducts();
                    break;
                case 5:
                    createOrder();
                    break;
                case 6:
                    orderManager.printAllOrders();
                    break;
                case 7:
                    processOrder();
                    break;
                case 8:
                    generateReports();
                    break;
                case 9:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != 9);
        
        scanner.close();
    	
    }
    
    private void addProduct() {
        System.out.print("Enter ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Category: ");
        String cat = scanner.nextLine();
        System.out.print("Enter Price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter Stock: ");
        int stock = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Supplier: ");
        String sup = scanner.nextLine();
        
        Product p = new Product(id, name, cat, price, stock, sup);
        productInventory.addProduct(p);
    }
    
    private void removeProduct() {
        System.out.print("Enter Product ID: ");
        String id = scanner.nextLine();
        productInventory.removeProduct(id);
    }
    private void findProduct() {
        System.out.print("Enter Product ID: ");
        String id = scanner.nextLine();
        Product p = productInventory.findProduct(id);
        if (p != null) {
            System.out.println("Found: " + p.getProductId() + " - " + p.getName());
        } else {
            System.out.println("Not found");
        }
    }
    
    private void createOrder() {
        System.out.print("Enter Order ID: ");
        String oid = scanner.nextLine();
        System.out.print("Enter Customer: ");
        String cust = scanner.nextLine();
        System.out.print("Enter Date (YYYY-MM-DD): ");
        String date = scanner.nextLine();
        
        Order order = new Order(oid, cust, date);
        
        boolean adding = true;
        while (adding) {
            System.out.print("Enter Product ID (or 'done'): ");
            String pid = scanner.nextLine();
            if (pid.equals("done")) {
                adding = false;
                break;
            }
            
            Product p = productInventory.findProduct(pid);
            if (p == null) {
                System.out.println("Product not found");
                continue;
            }
            
            System.out.print("Enter Quantity: ");
            int qty = scanner.nextInt();
            scanner.nextLine();
            
            if (qty > p.getQuantityInStock()) {
                System.out.println("Insufficient stock");
                continue;
            }
            
            order.addItem(new OrderItem(pid, p.getName(), qty, p.getPrice()));
            productInventory.updateStock(pid, -qty);
        }
        
        if (order.getTotalItems() > 0) {
            orderManager.addOrder(order);
            System.out.println("Order created");
        }
    }
    
    private void processOrder() {
        System.out.print("Enter Order ID: ");
        String oid = scanner.nextLine();
        Order o = orderManager.findOrder(oid);
        if (o == null) {
            System.out.println("Order not found");
            return;
        }
    	
        System.out.println("Current status: " + o.getOrderStatus());
        System.out.println("1. Process");
        System.out.println("2. Ship");
        System.out.println("3. Deliver");
        System.out.println("4. Cancel");
        System.out.print("Choice: ");
        
        int c = scanner.nextInt();
        scanner.nextLine();
        
        switch (c) {
            case 1: o.updateStatus("Processing"); break;
            case 2: o.updateStatus("Shipped"); break;
            case 3: o.updateStatus("Delivered"); break;
            case 4: o.updateStatus("Cancelled"); break;
            default: System.out.println("Invalid");
        }
    }
    
    private void generateReports() {
        System.out.println("\n--- REPORTS ---");
        System.out.println("Total Products: " + productInventory.getTotalProducts());
        System.out.println("Total Orders: " + orderManager.getOrderCount());
        System.out.printf("Total Revenue: $%.2f\n", orderManager.getTotalRevenue());
        System.out.println("Low Stock (<10): " + 
            productInventory.getLowStockProducts(10).size());
    }
    
    public static void main(String[] args) {
		new InventorySystemMain().run();
	}
}

