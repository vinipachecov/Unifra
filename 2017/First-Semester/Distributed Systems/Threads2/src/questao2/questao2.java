/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package questao2;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import threads2.testThread;

/**
 *
 * @author root
 */
public class questao2 {
    public static void main(String[] args) {
         
        
//        //INSTANCIAR OS CAVALOS
        ArrayList<Cavalo> lcavalos = new ArrayList<Cavalo>();        
        int ncavalos = Integer.parseInt(JOptionPane.showInputDialog("Digite o número de cavalos"));
        int corridatam = Integer.parseInt(JOptionPane.showInputDialog("Valor da corrida [Ex: 4000]"));
        int campeao = 0;
        boolean terminou = false;
        for (int i = 0; i < ncavalos; i++) {
            lcavalos.add(new Cavalo(i,corridatam));                
        }
        while(Thread.activeCount() > 1){
            
        }        
        System.out.println("Principal terminou");
    }
    
    
    
}
