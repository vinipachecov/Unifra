/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package questao3;

import java.util.ArrayList;

/**
 *
 * @author root
 */
public class Nthread extends Thread {
    public Nthread threadEnvio;
    public boolean recebeumensagem;
    public int id;
    
    public Nthread(int id){
        this.id = id;        
        recebeumensagem = false;
    }
    
    @Override
    public void run(){
        System.out.println("Thread " + id + " Começou " + "recebeu Mensagem = " + recebeumensagem);            
        sendMessage(threadEnvio);        
        while(!recebeumensagem){
            
        }        
        System.out.println("Thread "+ this.id+ " Recebeu Mensagem " + recebeumensagem);
        System.out.println("Numero de Threads vivas = " + Thread.activeCount());
    }
    
    public void recebeThreadnvio(Nthread envio){
        
        threadEnvio = envio;        
    }
    
    
    public void sendMessage(Nthread alvo){
        System.out.println("Thread id " + id + "Vai enviar mensagem para Thread id" + threadEnvio.id);
        alvo.receiveMessage();        
    }
    
    public void receiveMessage(){
        this.recebeumensagem = true;
    }
    
    
}
