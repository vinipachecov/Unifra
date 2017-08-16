/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automatocelulartempo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;

/**
 *
 * @author root
 */
public class Automaton extends JPanel{
    private View view;
    private int lin,col;
    private boolean vivo;
    private Tempo tempoAtual;
    MouseAdapter listener;
    private ConfigMatrix config;
    private Integer dias;
    int n_neighborsChuva = 0;
    int n_neighborsSol = 0;
    int n_neighborsNublado = 0;
    
    public Automaton(ConfigMatrix configs, int lin, int col, boolean estado,
            int height, int width,  int x, int y, Estados tipo){        
        this.dias = 0;
        config = configs;
        this.lin = lin;
        this.col = col;
        vivo = estado;
        if(vivo){
            this.setBackground(Color.black);
        }else
            this.setBackground(Color.white);        
        initTextField(height, width, x, y);
        this.setBackground(new Color(0f,0f,1f,0.1f));
        this.tempoAtual = new Tempo();
        this.tempoAtual.setTempo(tipo);
    }
   
    
    //método de instanciação inicial
    public Automaton(int lin, int col, boolean estado,
            int height, int width,  int x, int y){        
        this.lin = lin;
        this.col = col;        
        this.tempoAtual = new Tempo();
        tempoAtual.randomTempo();
               
        
//        vivo = estado;
//        if(vivo){
//            this.setBackground(Color.black);
//        }else
//            this.setBackground(Color.white);
        //test de cor
        initTextField(height, width, x, y);
        this.dias = 0;
        initColor(); 
        
    }
    
    public Automaton(int height, int width, int x, int y){
        //this.setBackground(new Color(0f,0f,0.2f,0.1f));
        this.setBackground(new Color(0f,0f,1f,0.1f));        
        
        this.setSize(width, height);
        this.setPreferredSize(new Dimension(width,height));        
        
        this.setLocation(x, y);                      
        initColor();
    }
    
    public Automaton(int lin, int col, boolean estado, View view, ConfigMatrix configs){
        this.config = configs;
        this.view = view;
        this.lin = lin;
        this.col = col;
        vivo = estado;
//        if(vivo){
//            this.setBackground(Color.black);
//        }else
//            this.setBackground(Color.white);
//        initTextField(20, 40,20 +(col*40) ,40 + (lin*40) );        
        initColor();
    }
    
    
    public Automaton(int lin, int col, boolean estado, View view){
        this.view = view;
        this.lin = lin;
        this.col = col;
        vivo = estado;
        updateColor();
        initTextField(40, 40,40 +(col*40) ,40 + (lin*40) );  
        initColor();
    }
    
    public void updateColor(){
        if(vivo){
            this.setBackground(Color.black);
        }else
            this.setBackground(Color.white);                        
    }
    
    public void initTextField(int height, int width, int x, int y){        
        this.setSize(width, height);
        this.setPreferredSize(new Dimension(width,height));        
        this.setLocation(x, y);                      
        this.addMouseListener(new MouseAdapter() {
                @Override
            public void mouseClicked(MouseEvent evt){
                    //System.out.println("Celula i=" + lin + " j =" + col);                    
                    //view.newGenerationInserted(lin,col);
//                    if(!vivo){
//                        vivo = true;
//                    }else
//                        vivo = false;                    
//                    updateColor();
                    config.updateMatrix();
            }                               
        });
    }
    
        
    public Automaton(boolean estado){
        vivo = estado;
    }
    
    public boolean getState(){
        return this.vivo;        
    }
    
    public Estados getTempo(){
        return tempoAtual.getTempo();        
    }
    
   public void setTempo(Estados novo){
       this.tempoAtual.setTempo(novo);
       this.dias = 0;
   }
    
   public Integer contDays(){
       return this.dias;
   }
   
   public void incDays(){
       this.dias++;
   }
   
    public int getLin(){
        return lin;
    }
    
    public int getCol(){
        return col;
    }
    
    private void TextFieldClicked(java.awt.event.MouseEvent evt) {                                         
        System.out.println("CLICOU AQUI");        
    }  
    
    
    private Automaton getAutomaton(){
        return this;        
    }
    /*
    Regras de vizinhança
    Exemplo a11
    A (l,c) = a(l-1,c), a(l-1,c), a(l,c-1), a(l,c+1)
    */
    
    public void initColor(){
        switch(tempoAtual.getTempo()){
            case CHUVA:
                //Azul
                this.setBackground(new Color(0f,0f,1f,0.35f));
                break;
            case SOL:
                //Amarelo
                this.setBackground(new Color(1f,1f,0f,0.4f));
                break;
            case NUBLADO:
                //Cinza
                this.setBackground(new Color(0.7f,0.7f,0.7f,0.5f));
                break;                
        }
        
    }
    
    public void updatevizinho(int n_neighborsChuva, int n_neighborsSol, int n_neighborsNublado){
        this.n_neighborsChuva = n_neighborsChuva;
        this.n_neighborsNublado = n_neighborsNublado;
        this.n_neighborsSol = n_neighborsSol;
    }
    
}
