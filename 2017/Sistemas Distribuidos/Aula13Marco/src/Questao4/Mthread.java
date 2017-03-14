/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Questao4;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author root
 */
public class Mthread extends Thread{    
    String id;
    int aleatorio;

    public Mthread(String id , int aleatorio){
        this.id = id;
        this.aleatorio = aleatorio;
        System.out.println("Thread "+this.id+" criada");
        this.start();
    }
    
    public void run(){
        for (int i = 0; i < aleatorio; i++) {
            System.out.println(" Thread" + this.id + " Vals " + i);            
        }
        System.out.println("Thread " + this.id + " entrando em espera ");
        Random rn = new Random();
        int randsleep = rn.nextInt(5000 - 0 + 1) + 0;             
        try {
            sleep(randsleep);
        } catch (InterruptedException ex) {
            System.out.println("Excessão = " + ex.getMessage());
        }
        System.out.println("Thread id="+ this.id+ "saindo do tempo de espera");
        System.out.println("Thread id="+ this.id+ "execucao finalizada  ");
    }
    
}
