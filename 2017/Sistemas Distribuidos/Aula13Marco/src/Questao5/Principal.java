/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Questao5;

/**
 *
 * @author root
 */

// Não consegui uma solução precisa
public class Principal {
    
    public static void main(String[] args) {
        Mthread t[] = new Mthread[10];
        int totalThreads = 10;
        for (int i = 0; i < totalThreads; i++) {
                  t[i] = new Mthread();
        }
        while(true){            
            for (int i = 0; i < totalThreads; i++) {                                
                if(t[i].isAlive()){
                    t[i] = new Mthread();
                }
            }                                        
            System.out.println("Numero de threads ativas = "+ Thread.activeCount());            
        }
        
    }            
}
