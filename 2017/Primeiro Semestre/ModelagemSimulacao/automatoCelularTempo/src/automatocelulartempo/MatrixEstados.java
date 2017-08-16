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
public class MatrixEstados {
    int lins;
    int cols;
    Tempo [][] matrix;
    
    public MatrixEstados(Matrix original){
        
        lins = original.getLins();
        cols = original.getCols();
        
        matrix = new Tempo[lins][cols];
        for (int i = 0; i < lins; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = new Tempo((original.getCell(i, j)).getTempo()); 
            }            
        }        
    }
    
    public void printStates(){
        for (int i = 0; i < lins; i++) {            
            for (int j = 0; j < cols; j++) {
                System.out.println(" i = "+ i + " j = " + j +" " + "Estado = " + matrix[i][j].getTempo());                
            }            
            System.out.println("-----------------");
        }
    } 
    
    
    
}
