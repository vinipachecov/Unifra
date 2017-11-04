package aula16marco;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author usrlab01
 */
public class Cliente {
    
    private int valor;
    public String id;
    public int prioridade;
    /**
     * @return the valor
     */
    public int getValor() {
        return valor;
    }
    
    public int getPrioridade(){
        return prioridade;        
    }
    
    public String getID(){
        return this.id;
    }

    
    
    /**
     * @param valor the valor to set
     */
    public void setValor(int valor) {
        this.valor = valor;
    }
    
    public Cliente(int peso){
        this.setValor(peso);
    }
    
    public Cliente(){
        int randomico;
        Random random = new Random();
        randomico = random.nextInt(100);
        this.setValor(randomico);
        this.id = UUID.randomUUID().toString();
        this.prioridade =  ThreadLocalRandom.current().nextInt(1, 3 + 1);
    }
    

}