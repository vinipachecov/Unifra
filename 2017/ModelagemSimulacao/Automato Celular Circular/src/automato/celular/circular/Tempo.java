/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automato.celular.circular;

/**
 *
 * @author vinipachecov
 */
public class Tempo {
    public enum Tipos{
    CHUVA,
    SOL,
    NUBLADO
    }
    
    private Tipos clima;
    
    public void setTempo(int val){
        switch(val){
            case 1:
                this.clima = Tipos.SOL;
                break;
            case 2:
                this.clima = Tipos.NUBLADO;
                break;
            case 3:
                this.clima = Tipos.CHUVA;
                break;
        }                
    }
    
    public void printTempo(){
        System.out.println(clima);
    }
    
    
    
}
