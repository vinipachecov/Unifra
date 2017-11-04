/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package questao3;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author root
 */
public class questao3 {
    
    
    
    public static void main(String[] args) throws InterruptedException {
        int numThreads = Integer.parseInt(JOptionPane.showInputDialog("Digite o número de Threads"));        
        ArrayList<Nthread> lnthreads = new ArrayList<Nthread>();
        for (int i = 0; i < numThreads; i++) {
            lnthreads.add(new Nthread(i));
            try {
                lnthreads.get(i).join();
            } catch (Exception e) {
            }
        }        
        for (int i = 0; i < lnthreads.size(); i++) {
            if(i == numThreads-1)
                lnthreads.get(i).recebeThreadnvio(lnthreads.get(0));
            else
                lnthreads.get(i).recebeThreadnvio(lnthreads.get(i+1));
            lnthreads.get(i).start();
        }
        while (Thread.activeCount() > 1) {       
            Thread.sleep(500);
            System.out.println("Threads vivas " + Thread.activeCount() );
        }
        System.out.println("Terminou");        
    }
    
}
