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
public class PlacaSom {
    
    public int data;
    public CaixaSom device;
    public Microfone mic;
    
    public PlacaSom(){
        mic = new Microfone();
        data = 10;        
        device = new CaixaSom(1);
    }

    public static void main(String[] args) {
        
    }
    
    public void sendData(int Data){
        device.receiveData(Data);                
    }
    
    public void receiveData(int data){
        mic.Listen();
    }
    
}
