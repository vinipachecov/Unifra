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
public class Contador extends Thread{
    String nome;
    int contador;
    
    public Contador(String nome, int cont){
        this.nome = nome;
        this.contador = cont;        
        this.start();
    }
    
    @Override    
    public void run(){
        for (int i = 0; i < contador; i++) {
            System.out.println("Thread "+nome+" Valor de i "+i);                        
        }        
    }
}
