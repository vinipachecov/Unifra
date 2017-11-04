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
public class Threadaux extends Thread {

    int time;
    long tStart, tEnd;
    boolean running;
    public int id;

    public Threadaux(int tempo, int id) {
        this.id = id;
        running = true;
        System.out.println("Thread + "+ this.id + " vai ficar rodando " + tempo + "segundos");
        tStart = System.currentTimeMillis();
        tEnd = tStart + tempo * 1000;
        this.start();
    }

    @Override
    public void run() {
        while (running) {

            tStart = System.currentTimeMillis();
            if (tEnd < tStart) {
                System.out.println("Thread " + this.id+ "Vai perguntar se vai seguir (tempo [" + tStart +"])");
                if(!Threads2.possoContinuar())
                    break;
                else
                   this.keepRunning(5);
                System.out.println("Thread " + this.id+ "Vai continuar por mais 5 segundos");
            }            
            
        }
        System.out.println("Thread id " + this.id + "começou em " + tStart);
        System.out.println("Terminou Thread "+ this.id+" em " + tStart / 1000);
        
        
    }

    public void keepRunning(int keeprun) {
        tEnd = System.currentTimeMillis() + keeprun *1000;
    }

}
