import java.util.*;

public class ProducerConsumer {
	
    LinkedList<Integer> queue = new LinkedList<>(); 
    int capacity = 5; 

    
    public void produce() throws InterruptedException 
    { 
        int value = 4; 
        while (true) { 
            synchronized (this) 
            { 
                
                while (queue.size() == capacity) 
                    wait(); 

                System.out.println("Producer produced-" + value); 

                
                queue.add(value++); 

                
                notify(); 

                
                Thread.sleep(1200); 
            } 
        } 
    } 

    
    public void consume() throws InterruptedException 
    { 
        while (true) { 
            synchronized (this) 
            { 
                 
                while (queue.size() == 0) 
                    wait(); 

                
                int val = queue.removeFirst(); 

                System.out.println("Consumer consumed-" + val); 

               
                notify(); 

                
                Thread.sleep(1200); 
            } 
        } 
    } 
}


class Threadexample { 
    public static void main(String[] args) 
        throws InterruptedException 
    { 
        
        final ProducerConsumer pc = new ProducerConsumer(); 
  
        pc.queue.add(1);
        pc.queue.add(2);
        pc.queue.add(3);
        
         
        Thread t1 = new Thread(new Runnable() { 
            @Override
            public void run() 
            { 
                try { 
                    pc.produce(); 
                } 
                catch (InterruptedException e) { 
                    e.printStackTrace(); 
                } 
            } 
        }); 
  
         
        Thread t2 = new Thread(new Runnable() { 
            @Override
            public void run() 
            { 
                try { 
                    pc.consume(); 
                } 
                catch (InterruptedException e) { 
                    e.printStackTrace(); 
                } 
            } 
        }); 
  
        
        t1.start(); 
        t2.start(); 
  
       
        t1.join(); 
        t2.join(); 
    } 
}

