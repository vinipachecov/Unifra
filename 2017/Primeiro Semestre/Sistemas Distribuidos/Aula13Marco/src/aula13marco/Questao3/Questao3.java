/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula13marco.Questao3;

import static java.lang.Math.random;
import static java.lang.StrictMath.random;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author root
 */
public class Questao3 {
    int[][] mat;
    int lin;
    int col;
    Thread t;
        
    public Questao3(int L, int C){
        Random rn = new Random();
        int aux;
        SomaLinha sl;
        this.lin = L;
        this.col = C;        
        mat = new int[L][C];
        for (int i = 0; i < L; i++) {
            for (int j = 0; j < C; j++) {
                mat[i][j] = 0;

            }            
        }        
        // fill matrix random numbers
        for (int i = 0; i < L; i++) {
            for (int j = 0; j < C; j++) {                
                aux = rn.nextInt(100 - 0 + 1) + 0;                
                mat[i][j] = aux;                
            }            
        }
       

        for (int i = 0; i < lin; i++) {
            sl = new SomaLinha(mat, col, i);
        }
    }
    
    
    
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int lin,col;
        
        System.out.println("Digite o valor de linhas da matrix");
        lin = reader.nextInt();
        System.out.println("Digite o valor de colunas da matrix");
        col = reader.nextInt();
        Questao3 q1 = new   Questao3(lin,col);
    }
}
