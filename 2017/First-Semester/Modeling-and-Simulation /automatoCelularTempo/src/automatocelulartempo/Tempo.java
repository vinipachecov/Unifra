/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automatocelulartempo;


import java.util.Random;

/**
 *
 * @author vinipachecov
 */
enum Estados{
    CHUVA,
    SOL,
    NUBLADO
    }


public class Tempo {
    
    
    private Estados clima;
    private int n_neighborsChuva = 0;
    private int n_neighborsSol = 0;
    private int n_neighborsNublado = 0;
    
    
    
    public Tempo(){
        
    }
    
    public Tempo(Estados novo){
        this.clima = novo;
    }
    
    public void randomTempo(){
        
        Random var = new Random();
        
        int ale = var.nextInt(3) + 1;
        switch(ale){
            case 1:
                setTempo(Estados.SOL);
                break;
            case 2:
                setTempo(Estados.NUBLADO);                
                break;
            case 3:
                setTempo(Estados.CHUVA);                
                break;
        }        
    }
    
    public void setTempo(int val){
        switch(val){
            case 1:
                this.clima = Estados.SOL;
                break;
            case 2:
                this.clima = Estados.NUBLADO;
                break;
            case 3:
                this.clima = Estados.CHUVA;
                break;
        }                
    }
    
    public void setTempo(Estados novo){
        this.clima = novo;     
    }
    
    public Estados getTempo(){
        return this.clima;        
    }
    
    public void printTempo(){
        System.out.println(clima);
    }
    
    public void updatevizinho(int n_neighborsChuva, int n_neighborsSol, int n_neighborsNublado){
        this.n_neighborsChuva = n_neighborsChuva;
        this.n_neighborsNublado = n_neighborsNublado;
        this.n_neighborsSol = n_neighborsSol;
    }
    
    public int getNNeighborsChuva(){
        return n_neighborsChuva;
    }
    
    public int getNNeighborsNublado(){
        return n_neighborsNublado;
    }
    
    public int getNNeighborsSol(){
        return n_neighborsSol;
    }
    
}
