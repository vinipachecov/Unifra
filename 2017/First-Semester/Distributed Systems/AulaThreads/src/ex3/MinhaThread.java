package ex3;

public class MinhaThread extends Thread{
    
    public void run(){
        while(true){
            System.out.println("Fluxo secundário, identificador = "+getId());
        }
    }
    
}
