/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Questao4;

import java.util.Random;
import java.util.Scanner;
import java.util.UUID;

/**
 *
 * @author root
 */
public class Principal {
    
    public static void main(String[] args) {
        Random rn = new Random();
        Scanner rint = new Scanner(System.in);
        System.out.println("Digite a quantidade de threads que voce"
                + " deseja instanciar:");
        int nthreads = rint.nextInt();
        Mthread mt;              
        for (int i = 0; i < nthreads; i++) {
            mt = new Mthread(UUID.randomUUID().toString(),rn.nextInt(100000 - 0 + 1) + 0);
        }
    }    
}
