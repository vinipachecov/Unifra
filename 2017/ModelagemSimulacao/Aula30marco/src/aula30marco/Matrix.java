/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula30marco;

import javax.swing.JOptionPane;

/**
 *
 * @author root
 */
public class Matrix {
    Automaton [][] mat;
    int lins, cols;
    gameofLife view;
    
    public Matrix(){
        
    }
    
    public Matrix(Matrix mat){
        this.lins = mat.getLins() ;
        this.cols = mat.getCols();        
        this.mat = new Automaton[this.lins][this.cols];
        //setup matrix
        for (int i = 0; i < lins; i++) {
            for (int j = 0; j < cols; j++) {
               this.mat[i][j] = new Automaton(lins, cols, false, 40 , 40 , 40 + (j * 40), 40 + (i * 40));
            }
            
        }
    }
    
    
    

    public Matrix(int lins,int cols, gameofLife view) {
        this.view = view;
        this.lins = lins;
        this.cols = cols;
        this.mat = new Automaton[lins][cols];
        //initialize automaton matrix
        for (int i = 0; i < lins; i++) {
            for (int j = 0; j < cols; j++) {
                this.mat[i][j] = new Automaton(i,j,false, view);
                //this.mat[i][j] = new Automaton(lins, cols, false, 40 , 40 , 40 + (i * 40), 40 + (j * 40));
            }            
        }
        //teste
//        for (int i = 0; i < lins; i++) {
//            for (int j = 0; j < cols; j++) {
//                System.out.println("Celula i =" +i+" j ="+j+" estado =" + mat[i][j].getState() );                
//            }            
//        }                
        
    }
    
    public void patternMatrix(int tipo){     
        for (int k = 0; k < lins ; k++) {
            for (int l = 0; l < cols; l++) {
                if(k == tipo){
                    this.mat[k][l] = new Automaton(k,l,true,view);                    
                }else
                    this.mat[k][l] = new Automaton(k,l,false,view);                                    
            }            
        }        
    }
    
    public void printStates(){
        for (int i = 0; i < this.lins; i++) {
            for (int s = 0; s < this.cols; s++) {
                System.out.println("Valor do estado i = "+i+" j = "+s+" estado = " + this.mat[i][s].getState() + '\n');                                
            }            
        }        
        System.out.println("----------------------------------------");
        System.out.println("----------------------------------------");
        System.out.println("----------------------------------------");        
        System.out.println();        
    }
    
    
    public int checkNeighbors(int i, int j){
        int n_neighborsAlive = 0;        
        //check top and bottom neighbors
        
                
        //top
        
        
        if( i -1 >= 0){
            if(this.mat[i-1][j].getState()){
                n_neighborsAlive++;
            }
        }
        //bottom neighbor
   
        if( i + 1 < lins){
            if(this.mat[i+1][j].getState()){
                n_neighborsAlive++;
            }            
        }
        
        //check left and right neighbors
        //left neighbor
        
        if(j -1 >= 0){
            if(this.mat[i][ j -1 ].getState()){
                n_neighborsAlive++;
            }            
        }
        //right neighbor
        if(j +1 < cols){
            if(this.mat[i][ j +1 ].getState()){
                n_neighborsAlive++;
            }            
        }
        System.out.println("Celula i = " + i + " j = " + j);
        System.out.println("Numeros de vizinhos vivos = "+n_neighborsAlive);
        return n_neighborsAlive;
        
    }
    
    public Automaton newCell(int i, int j, int n_neighborsAlive){
        //verifica estados da vizinhanca e aplica regra        
        Automaton novo;
        if(n_neighborsAlive > 2){
            novo = new Automaton(i, j, false,view);
        }
        else if(n_neighborsAlive == 0){
            novo = new Automaton(i, j, false,view);
        }else
            novo = new Automaton(i, j, true,view);        
        
        return novo;        
    }    
        
    
    public Matrix newGenaration(){
        Matrix nova = new Matrix(this);
        int n_neighborsAlive = 0;                
        for (int i = 0; i < lins; i++) {
            for (int j = 0; j < cols; j++) {
                try {
                    n_neighborsAlive = checkNeighbors(i, j);                
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Celula de teste i ="+i+ "j = " + j);
                }                
                nova.setCell(i, j, newCell(i, j, n_neighborsAlive));
            }
        }          
        nova.printStates();        
        return nova;
    }
    
    public void setCell(int i, int j , Automaton n_cell){
        this.mat[i][j] = n_cell;        
    }    
    
    
    public int getLins(){
        return this.lins;
    }
    
    public int getCols(){
        return this.cols;
    }
    
    public Automaton getCell(int i, int j){
        return this.mat[i][j];
    }
    
    
}
