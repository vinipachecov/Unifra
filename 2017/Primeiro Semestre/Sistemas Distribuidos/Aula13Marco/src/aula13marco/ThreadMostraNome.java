/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula13marco;

/**
 *
 * @author root
 */
public class ThreadMostraNome extends Thread{
   String nome;

    public ThreadMostraNome(String nome){
        this.nome = nome;
        this.start(); 
    }    
    
   @Override
   public void run(){
        while (true) {
            System.out.println(nome);
            try {
                    sleep(1000);
                } catch (Exception e) {
                        //trata-se falha
            }               
        }
    }
    
}
