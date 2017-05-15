/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automatocelulartempo;

/**
 *
 * @author vinipachecov
 */
public class Timer extends Thread{
    View view;
    
    public Timer(View view){
        this.view = view;        
        this.start();        
    }
    
    public void run(){
        while (true) {            
            try {
                this.sleep(2000);
                view.mudaGeracao();
                
            } catch (Exception e) {
            }
            
        }
    }
    
}
