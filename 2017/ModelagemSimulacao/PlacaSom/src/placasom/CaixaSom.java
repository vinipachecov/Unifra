/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placasom;

import java.util.ArrayList;

/**
 *
 * @author root
 */
public class CaixaSom {
    public int id;
    public int som;
    
    public CaixaSom(int id){
        this.id = id;
    }
    
    public void receiveData(int som){
        this.som = som;                
    }
    
}
