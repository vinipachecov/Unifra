/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automatocelulartempo;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.TextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author root
 */
public class Automaton extends TextField{
    private gameofLife view;
    private int lin,col;
    private boolean vivo;
    MouseAdapter listener;
    private ConfigMatrix config;
    
    public Automaton(ConfigMatrix configs, int lin, int col, boolean estado,
            int height, int width,  int x, int y){        
        config = configs;
        this.lin = lin;
        this.col = col;
        vivo = estado;
        if(vivo){
            this.setBackground(Color.black);
        }else
            this.setBackground(Color.white);
        initTextField(height, width, x, y);
       
    }
   
    public Automaton(int lin, int col, boolean estado,
            int height, int width,  int x, int y){        
        this.lin = lin;
        this.col = col;
        vivo = estado;
        if(vivo){
            this.setBackground(Color.black);
        }else
            this.setBackground(Color.white);
        initTextField(height, width, x, y);
       
    }
    
    public Automaton(int lin, int col, boolean estado, gameofLife view, ConfigMatrix configs){
        this.config = configs;
        this.view = view;
        this.lin = lin;
        this.col = col;
        vivo = estado;
        if(vivo){
            this.setBackground(Color.black);
        }else
            this.setBackground(Color.white);
        initTextField(20, 40,20 +(col*40) ,40 + (lin*40) );        
    }
    
    
    public Automaton(int lin, int col, boolean estado, gameofLife view){
        this.view = view;
        this.lin = lin;
        this.col = col;
        vivo = estado;
        updateColor();
        initTextField(40, 40,40 +(col*40) ,40 + (lin*40) );        
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
        this.setEditable(false);        
        this.addMouseListener(new MouseAdapter() {
                @Override
            public void mouseClicked(MouseEvent evt){
                    //System.out.println("Celula i=" + lin + " j =" + col);                    
                    //view.newGenerationInserted(lin,col);
                    if(!vivo){
                        vivo = true;
                    }else
                        vivo = false;                    
                    updateColor();
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
    
}
