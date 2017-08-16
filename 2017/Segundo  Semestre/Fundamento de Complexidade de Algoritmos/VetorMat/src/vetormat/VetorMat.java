/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vetormat;

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
         printVec(matvet(vec, mat, 2), 2);      
         
        
    }
    
}
