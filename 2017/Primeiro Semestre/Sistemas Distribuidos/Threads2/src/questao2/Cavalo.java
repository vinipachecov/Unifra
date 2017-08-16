/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package questao2;

import java.util.Random;

/**
 *
 * @author root
 */
public class Cavalo extends Thread{
    long total;
    long percorrido;
    int velocidade;
    int variacao;
    int id;
    Random ale;
    
    public Cavalo(int id, long tcorrida){
        this.id = id;
        total = tcorrida;   
        percorrido = 0;
        velocidade = 16;        
        ale = new Random();
        this.start();
    }
    
    public void run(){
        while (percorrido < total) {      
            variacao = ale.nextInt(20 - (0) + 1) + (0);
            percorrido = percorrido + velocidade + variacao;
            //System.out.println("Cavalo " + getId() + "Percorreu " + percorrido);
        }
        System.out.println("Cavalo " + this.id + "terminou a corrida");
    }
    
}
