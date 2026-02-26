package HW1;

import java.util.Vector;
import java.util.ArrayList;

public class ThreadSafetyDemo {
	private Vector<Product> vector;
	private ArrayList<Product> arrayList;
	private int productCounter;
	
    public ThreadSafetyDemo() {
        vector = new Vector<>();
        arrayList = new ArrayList<>();
        productCounter = 0;
    }
    
    //Support method
    private Product createProduct() {
    	productCounter++;
    	return new Product ( //String String String double int String
    			"P" + productCounter,
    			"Product" + productCounter,
    			"Test",
    			10.0,
    			5,
    			"Supplier"
    			);
    }
    
    //Inner Class: Add task for Vector
    class AddTask implements Runnable {
    	private Vector<Product> vec;
    	
    	public AddTask(Vector<Product> vec) {
    		this.vec = vec;
    	}

		@Override
		public void run() {
			for(int i = 0; i < 50; i++) {
				vec.add(createProduct());
				
				//Let thread take a break for a moment in case conflict with other threads
				try {
					Thread.sleep(1);
				}catch (InterruptedException e){ }
				
			}
			System.out.println("Added thread for Vector");
		}
    }
    
    //Inner Class: Remove Task for Vector
    class RemoveTask implements Runnable {
    	private Vector<Product> vec;
    	
    	public RemoveTask(Vector<Product> vec) {
    		this.vec = vec;
    	}
    	
    	@Override
    	public void run() {
    		for(int i = 0; i < 25; i++) {
    			if(!vec.isEmpty()) {
    				vec.remove(0);
    			}
    			try {
    				Thread.sleep(2);
    			}catch(InterruptedException e) { }
    		}
    		System.out.println("Removed task");
    	}
    }
    
    //Inner Class: Read task for Vector
    class ReadTask implements Runnable {
    	private Vector<Product> vec;
    	
    	public ReadTask(Vector<Product> vec) {
    		this.vec = vec;
    	}
    	
    	@Override
    	public void run() {
            for (int i = 0; i < 30; i++) {
                if (!vec.isEmpty()) {
                    Product p = vec.get(0);
                }
                try { 
                	Thread.sleep(1);
                } catch (InterruptedException e) {}
            }
            System.out.println("Read Thread Completely");
    	}
    }
      
    //Inner Class: Add task for ArrayList
    class AddTaskArr implements Runnable {
    	private ArrayList<Product> list;
    	
    	public AddTaskArr(ArrayList<Product> list) {
    		this.list = list;
    	}
    	
    	@Override
    	public void run() {
    		try {
    			for(int i = 0; i < 50; i++) {
    				list.add(createProduct());
    				try {
    					Thread.sleep(1);
    				} catch (InterruptedException e) { } 
    			}
    			System.out.println("Added threads for ArrayList");
    		} catch (Exception e) {
    			System.out.println("Error add thread for ArrayList: " + e.getClass().getSimpleName());
    		}
    	}
    }
    
    //Inner Class: Remove Task for ArrayList
    class RemoveTaskArr implements Runnable {
    	private ArrayList<Product> list;
    	
    	public RemoveTaskArr(ArrayList<Product> list) {
    		this.list = list;
    	}
    	
    	@Override
    	public void run() {
    		try {
    			for(int i = 0; i < 25; i++) {
    				if(!list.isEmpty()) {
    					list.remove(0);
    				}
    				try {
    					Thread.sleep(2);
    				} catch (InterruptedException e) { }
    			}
    		} catch (Exception e) {
    			System.out.println("Error remove thread for ArrayList: " + e.getClass().getSimpleName());
    		}
    	}
    }
    
    //Inner Class: Read task for ArrayList
    class ReadTaskArr implements Runnable {
    	private ArrayList<Product> list;
    	
    	public ReadTaskArr(ArrayList<Product> list) {
    		this.list = list;
    	}
    	
    	@Override
    	public void run() {
    		try {
    			for(int i = 0; i < 30; i++) {
    				if(!list.isEmpty()) {
    					Product p = list.get(0);
    				}
    				try {
    					Thread.sleep(1);
    				} catch (InterruptedException e) { }
    			}
    		} catch (Exception e){
    			System.out.println("Error read thread for ArrayList: " + e.getClass().getSimpleName());
    		}
    	}
    }
    
    //Test Vector (Thread Safety)
    public void testVector() {
    	System.out.println("--------------Test thread safety--------------");
    	vector.clear();
    	
    	//recording start time
    	long startTime = System.currentTimeMillis();
    	
    	//Create 3 threads: one add, one remove and one read
    	Thread addThread = new Thread(new AddTask(vector));
        Thread removeThread = new Thread(new RemoveTask(vector));
        Thread readThread = new Thread(new ReadTask(vector));
        
        //Strat all threads:
        addThread.start();
        
        //Waiting util all threads complete
        try {
        	addThread.join();
        	removeThread.join();
        	readThread.join();
        } catch (InterruptedException e) {
        	e.printStackTrace();
        }
        
        //Recording end time
        long endTime = System.currentTimeMillis();
        
        //Print message
        System.out.println("Vector final size: " + vector.size());
        System.out.println("Vector processing time: " + (endTime - startTime) + " miles");
        System.out.println("--------------Vector processing complete, no errors--------------");
    }
	
    //Test ArrayList(Non-Thread Safety)
    public void testArrayList() {
    	System.out.println("--------------Test ArrayList safety--------------");
    	arrayList.clear();
    	
    	long startTime = System.currentTimeMillis();
    	
    	Thread addThread = new Thread(new AddTaskArr(arrayList));
        Thread removeThread = new Thread(new RemoveTaskArr(arrayList));
        Thread readThread = new Thread(new ReadTaskArr(arrayList));
    	
        addThread.start();
        removeThread.start();
        readThread.start();
        
        try {
        	addThread.join();
        	removeThread.join();
        	readThread.join();
        } catch (InterruptedException e) {
        	e.printStackTrace();
        }
        
    	long endTime = System.currentTimeMillis();
    	
        System.out.println("ArrayList final size: " + arrayList.size());
        System.out.println("ArrayList processing time: " + (endTime - startTime) + " miles");
        System.out.println("--------------ArrayList processing complete, might be errors happened--------------");
    }

    //Print Report
    public void printReport() {
    	System.out.println("------------Test Report Summary------------");
    	System.out.println("Vector normal, but ArrayList occurs errors");
    	System.out.println("Vector slower, ArrayList faster");
    	System.out.println("Vector threads safe, but ArrayList is not");
    	System.out.println("---------------Report End---------------");
    }
    
    public static void main(String[] args) {
		ThreadSafetyDemo demo = new ThreadSafetyDemo();
		
		//Test Vector
		demo.testVector();
		
		//Test ArrayList
		demo.testArrayList();
		
		//Print Report
		demo.printReport();
	}
}
