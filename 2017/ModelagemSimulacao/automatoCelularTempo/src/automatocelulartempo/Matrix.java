/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automatocelulartempo;

import javax.swing.JOptionPane;

/**
 *
 * @author root
 */
public class Matrix {
    Automaton [][] mat;
    int lins, cols;
    View view;
    ConfigMatrix config;
    
    int n_neighborsChuva = 0;
    int n_neighborsSol = 0;
    int n_neighborsNublado = 0;
    
    MatrixEstados mEstados;
   
    public Matrix(){
        
    }
    
    public Matrix(Matrix mat, View view, ConfigMatrix configs){
        this.config = configs;
        this.view = view;
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
    
    public Matrix(Matrix mat, View view){
        this.view = view;
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
    
    public Matrix(int lins,int cols, View view, ConfigMatrix configs) {
        this.config = configs;
        this.view = view;
        this.lins = lins;
        this.cols = cols;
        this.mat = new Automaton[lins][cols];
        //initialize automaton matrix
        for (int i = 0; i < lins; i++) {
            for (int j = 0; j < cols; j++) {
                this.mat[i][j] = new Automaton(i,j,false, view, configs);
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
    
    
    
    //Método de instanciação inicial
    public Matrix(int lins,int cols, View view) {
        this.view = view;
        this.lins = lins;
        this.cols = cols;
        this.mat = new Automaton[lins][cols];
        //initialize automaton matrix
        for (int i = 0; i < lins; i++) {
            for (int j = 0; j < cols; j++) {
               // this.mat[i][j] = new Automaton(i,j,false, view);               
                this.mat[i][j] = new Automaton(i, j, false, 20 , 20 , 0 + (j * 22), 0 + (i * 22));
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
                System.out.println("Valor do estado i = "+i+" j = "+s+" estado = " + this.mat[i][s].getTempo()+ '\n');                                
            }            
        }        
        System.out.println("----------------------------------------");
        System.out.println("----------------------------------------");
        System.out.println("----------------------------------------");        
        System.out.println();        
    }
    
    
    public void contNeighbors(Estados estadoCelula){
        switch(estadoCelula){
            case CHUVA:
                n_neighborsChuva+=1;                    
                return;                   
            case NUBLADO:
                n_neighborsNublado+=1;
                return;
            case SOL:
                n_neighborsSol+=1;
                return;                
        }        
    }
    
    public void checkNeighbors(int i, int j){
              
        //variaveis contadores do tempo
        n_neighborsChuva = 0; 
        n_neighborsNublado= 0;
        n_neighborsSol = 0;
        //check top and bottom neighbors                
        //top
        
        
        
        if( i -1 >= 0){
            contNeighbors(this.mat[i-1][j].getTempo());
//            if(this.mat[i-1][j].getTempo()){
//                n_neighborsAlive++;
//            }
        }
        //bottom neighbor
   
        if( i + 1 < lins){
            contNeighbors(this.mat[i+1][j].getTempo());                        
        }
        
        //check left and right neighbors
        //left neighbor
        
        if(j -1 >= 0){            
            contNeighbors(this.mat[i][j - 1].getTempo());                                                    
        }            
        
        //right neighbor
        if(j +1 < cols){            
            contNeighbors(this.mat[i][j + 1].getTempo());                                                                            
        }
        
        // diagonal esquerda superior
        if(i - 1 >= 0 && j - 1 >= 0){
            contNeighbors(this.mat[i - 1][j - 1].getTempo());
        }
        
        //diagonal superior direita
        if(i - 1 >= 0 && j + 1 < cols){
            contNeighbors(this.mat[i - 1][j + 1].getTempo());
        }
        
        //diagonal inferior esquerdo
        if(i + 1 <lins && j - 1 >= 0){
            contNeighbors(this.mat[i + 1][j - 1].getTempo());
        }
        
        // diagonal inferior esquerda
        if(i + 1 <lins && j + 1 < cols){
            contNeighbors(this.mat[i + 1][j + 1].getTempo());
        }

        
        System.out.println("Celula i = " + i + " j = " + j);
        System.out.println("Numeros de vizinhos com chuva = "+n_neighborsChuva);
         System.out.println("Numeros de vizinhos com nublado = "+n_neighborsNublado);
          System.out.println("Numeros de vizinhos com sol = "+n_neighborsSol);
          
         this.mEstados.matrix[i][j].updatevizinho(n_neighborsChuva, n_neighborsSol, n_neighborsNublado);
    }
    
//    public Automaton newCell(int i, int j, int n_neighborsAlive){
//        //verifica estados da vizinhanca e aplica regra        
//        Automaton novo;
//        if(n_neighborsAlive > 2){
//            novo = new Automaton(i, j, false,view);
//        }
//        else if(n_neighborsAlive == 0){            
//            novo = new Automaton(i, j, mat[i][j].getState(),view);
//        }else
//            novo = new Automaton(i, j, true,view);        
//        
//        return novo;        
//    }    
    
    public void newCell(int i, int j){
        boolean mudoutempo = false;
        //verifica estados da vizinhanca e aplica regra        

        //Regras de contagem de dias
        
        if(mEstados.matrix[i][j].getTempo() == Estados.NUBLADO && this.mat[i][j].contDays() > 1){
            this.mat[i][j].setTempo(Estados.CHUVA);
            mudoutempo = true;
        }
        
        if(mEstados.matrix[i][j].getTempo() == Estados.CHUVA && this.mat[i][j].contDays() > 0){
            this.mat[i][j].setTempo(Estados.SOL);
            mudoutempo = true;
        }
        
        if(mEstados.matrix[i][j].getTempo() == Estados.SOL && this.mat[i][j].contDays() > 2){
            this.mat[i][j].setTempo(Estados.NUBLADO);
            mudoutempo = true;
        }
        
        //--------------------------------------------------------------------------
        // regras de vizinhanças
        
        // se o estado for nublado e tiver mais que 4 vizinhos  
        // o clima da celula muda para chuva
        if(mEstados.matrix[i][j].getTempo() == Estados.NUBLADO && mEstados.matrix[i][j].getNNeighborsChuva() >= 4 ){
           this.mat[i][j].setTempo(Estados.CHUVA);
           mudoutempo = true;
        }
       //Se for Sol e tiver >= 4 vizinhos nublados -> nublado
        if(mEstados.matrix[i][j].getTempo() == Estados.SOL && mEstados.matrix[i][j].getNNeighborsNublado() >= 4 ){
           this.mat[i][j].setTempo(Estados.NUBLADO);
           mudoutempo = true;
        }
        //Se for Sol e tiver >=5 vizinhos com chuva -> chuva
        if(mEstados.matrix[i][j].getTempo() == Estados.SOL && mEstados.matrix[i][j].getNNeighborsChuva()>= 5 ){
           this.mat[i][j].setTempo(Estados.CHUVA);
           mudoutempo = true;
        }        
        
        if(!mudoutempo){
            this.mat[i][j].incDays();
        }
        this.mat[i][j].initColor();        
    }    
      
     
    public void newGeneration(){
        mEstados = new MatrixEstados(this);
                       
        for (int i = 0; i < lins; i++) {
            for (int j = 0; j < cols; j++) {
                try {
                    checkNeighbors(i, j);                
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Celula de teste i ="+i+ "j = " + j);
                }                
                newCell(i, j);
            }
        }          
        this.printStates();        
       
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
    
    public void teste(){
        for (int i = 0; i < lins; i++) {
            for (int j = 0; j < cols; j++) {
                checkNeighbors(i, j);
            }
        }
    }
            
}
