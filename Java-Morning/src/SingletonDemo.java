class Singleton 
{ 
    
    private static Singleton single_instance = null; 
  
     
    public String s; 
  
    
    private Singleton() 
    { 
        s = "This is a part of Singleton class"; 
    } 
  
    
    public static Singleton getInstance() 
    { 
        if (single_instance == null) 
            single_instance = new Singleton(); 
  
        return single_instance; 
    } 
} 

class SingletonDemo 
{ 
    public static void main(String args[]) 
    { 
        
        Singleton x = Singleton.getInstance(); 
  
        System.out.println("String from x is " + x.s); 
  
        x.s = (x.s).toUpperCase(); 
  
         System.out.println("String from x is " + x.s); 
       
    } 
} 