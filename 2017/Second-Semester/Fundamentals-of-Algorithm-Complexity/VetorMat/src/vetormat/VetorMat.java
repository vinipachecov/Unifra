
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vetormat;

import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author vinipachecov
 */
public class VetorMat {

    public static int[] matvet(int vet[], int mat[][], int matcol){
        int res[] = new int[vet.length];
        int colunaatual = 0;
        for(int numerovezes = 0; numerovezes < matcol; numerovezes++){
            for (int i = 0; i < matcol; i++) {
                res[colunaatual]+= vet[i] * mat[i][numerovezes];
            }
            colunaatual++;
        }
        return res;
    }
    
     public static void bubbleSort(int v[]) {
        for (int i = v.length; i >= 1; i--) {
            for (int j = 1; j < i; j++) {
                if (v[j - 1] > v[j]) {
                    int aux = v[j];
                    v[j] = v[j - 1];
                    v[j - 1] = aux;
                }
            }
        }
     }
    

    public static void printMat(int mat [][], int dim){
        System.out.println("Printando Matriz --------------------");
        for (int i = 0; i < dim; i++) {
            System.out.println("Linha " + i + "--------------------------");
            for (int j = 0; j < dim; j++) {
                System.out.println(mat[i][j]);
            }
        }
    }

    public static void printVec(int vec[],int dim){
        System.out.println("Printando Vetor --------------------");
        for (int i = 0; i < dim; i++) {
            System.out.println(vec[i]);
        }
    }

    public static void main(String[] args) {
        int mat[][] = {{1,2},
               {3,5}};

         int vec [] = {5,2};
         System.out.println("RESULTADO DA MULTIPLICAÇÃO ----------");
         //printVec(matvet(vec, mat, 2), 2);
         //------ preenche vetor
         int vectest [] = new int[100];
         for (int i = 99; i > 0; i--) {
             vectest[i] = ThreadLocalRandom.current().nextInt(1, 20 +1);
        }
         //------
         System.out.println("Antes de ordenar");
         for (int i = 0; i < 100; i++) {
            System.out.println(vectest[i]);
        }
         
         System.out.println("------------ Depois de Ordenar");
         
        bubbleSort(vectest);
        for (int i = 0; i < 100; i++) {
            System.out.println(vectest[i]);
        }
         
         
    }

    // Complexidade de N² + 3
}
