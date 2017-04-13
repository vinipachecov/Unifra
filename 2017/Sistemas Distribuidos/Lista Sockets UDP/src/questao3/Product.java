/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package questao3;

/**
 *
 * @author root
 */
public class Product {
    public String name;
    public Double price;
    
    public Product(String name, Double price){
        this.name = name;
        this.price = price;
    }
    
    
    Double getPrice(){
        return price;
    }
    
    String getName(){
        return name;
    }
}
