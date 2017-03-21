/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads2;

/**
 *
 * @author root
 */
public class testThread extends Thread{
    private int contador;
    
    public testThread(){
        contador = 0;                
    }
    
    @Override
    public void run(){
        while(contador < 100){
            contador++;
        }
        this.interrupt();
        System.out.println("AI AI AI SAIU DO INTERRUPT");        
    }
    
}
