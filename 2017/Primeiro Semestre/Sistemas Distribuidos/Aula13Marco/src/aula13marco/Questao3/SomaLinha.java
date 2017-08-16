/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula13marco.Questao3;

/**
 *
 * @author root
 */
public class SomaLinha extends Thread{
    Integer res = 0;

    public SomaLinha(int linha [][], int length, int l){
        for (int i = 0; i < length-1; i++) {
            res += linha[l][i];
        }
        System.out.println("Thread " +this.getId() + " Somatorio = " + res);
    }    
    
}
