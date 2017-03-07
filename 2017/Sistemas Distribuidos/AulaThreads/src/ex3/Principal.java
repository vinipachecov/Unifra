package ex3;

public class Principal {
    
    public static void main(String[] args) {
        
        MinhaThread t1 = new MinhaThread();
        MinhaThread t2 = new MinhaThread();
        MinhaThread t3 = new MinhaThread();
        MinhaThread t4 = new MinhaThread();
        MinhaThread t5 = new MinhaThread();
        
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        
    }
}
