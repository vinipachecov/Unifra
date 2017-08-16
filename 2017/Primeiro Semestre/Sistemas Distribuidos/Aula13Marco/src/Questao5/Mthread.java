/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Questao5;

import java.util.Random;

/**
 *
 * @author root
 */
public class Mthread extends Thread{
    
    public Mthread(){
        this.start();
    }
    
    public void run(){
        System.out.println("Thread id " + this.getId());
        Random rint = new Random();
        try {
            sleep(rint.nextInt(5000 - 0 + 1) + 0);
        } catch (Exception e) {
        }
        System.out.println("Thread id" + this.getId() + " terminou");
    }
}
