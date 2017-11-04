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
public class Questao2 {
    
    public static void main(String[] args) {
        Contador c1;
        for (int i = 0; i < 2; i++) {
            c1 = new Contador("Thread"+i,10);
        }
    }
    
}
