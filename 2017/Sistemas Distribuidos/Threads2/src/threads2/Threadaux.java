/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads2;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author root
 */
public class Threadaux extends Thread{
    int time;
    long tStart, tEnd;
    boolean running;

    public Threadaux(int tempo) {
        running = true;
        System.out.println("Thread vai ficar " + tempo + "segundos");
        tStart = System.currentTimeMillis();
        tEnd = tStart + tempo*1000;
        this.start();
    }   
    
    @Override
    public void run(){
            while(!this.isInterrupted()){
                
                System.out.println("segue executando");
                tStart = System.currentTimeMillis();                
                if(tEnd < tStart){
                    System.out.println("Thread " + this.getId() +"Vai dormir");

                }
            System.out.println("Terminou Thread em " + tStart / 1000);
        }                        
    }
            
    public void keepRunning(int keeprun){                 
        tEnd = System.currentTimeMillis() + keeprun;
    }        
    
}
