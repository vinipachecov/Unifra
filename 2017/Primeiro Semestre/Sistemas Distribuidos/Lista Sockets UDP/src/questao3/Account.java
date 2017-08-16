/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package questao3;

import java.util.ArrayList;

/**
 *
 * @author root
 */
public class Account {
    
    public Double total;    
    public ArrayList<String> operations;
    
    public Account(){
        operations = new ArrayList<String>();
        total = 0.0;
    }
    
    public void addsaleProductToTotal(String product, Double price,int quant){
        //save operation realized for future check
        Double totalaux = total;
        total = total + (quant * price) ;
        System.out.println("Total is " + total);
        String operation = "Operation add sale of + " + product + " quantity " +
                quant + "  with price " + price +'\n'+
                "Total before :" + totalaux+
                "Total now: total" + total;        
                operations.add(operation);                
    }    
    
    public Double getTotal(){
        return total;
    }
}
