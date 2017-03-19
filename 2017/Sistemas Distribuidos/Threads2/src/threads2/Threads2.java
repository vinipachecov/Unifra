/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads2;

import java.util.ArrayList;
import java.util.Random;
import java.util.TimerTask;

/**
 *
 * @author root
 */
public class Threads2 {

    
    public static void main(String[] args) {
        ArrayList<Threadaux> lt = new ArrayList<Threadaux>();   
        Random rint = new Random();
//        for (int i = 0; i < 5; i++) {
//            lt.add(new Threadaux(rint.nextInt(3 - 0 + 1) + 0));
//        }
//        while(true){
//                        
//        }
        int randtime = rint.nextInt(3 - 0 + 1) + 0;
        System.out.println("Tempo de inicio em segundos " + System.currentTimeMillis() / 1000 );
        Threadaux t = new Threadaux(4);        
        while (true) {            
            System.out.println(t.isInterrupted());            
        }
        

             
             
    }
    
}
