package automato.celular.circular;

import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vinipachecov
 */
  
 


public class Estado {
    
    private Tempo atual;
    
    public Estado(Tempo tipo){
        atual = tipo;
    }
    
    public Estado(){
          Random var = new Random();
        
        int ale = 0;
        
        ale = var.nextInt(3) + 1;
        atual.setTempo(ale);        
                
    }
    
    public void getEstado(){
        atual.printTempo();
    }    
    
}
