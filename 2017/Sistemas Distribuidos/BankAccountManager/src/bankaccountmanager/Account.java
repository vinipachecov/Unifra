/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankaccountmanager;

import java.util.UUID;

/**
 *
 * @author root
 */
public class Account {
    
    private String ID;
    private Double ammount_available;
    
    public Account(Double ammount){
        ID = UUID.randomUUID().toString();
        if(ammount <= 0)
            this.ammount_available = 0.0;
        else
            this.ammount_available = ammount;        
    }
    
    public Double ammountCheck(){
        return ammount_available;
    }
    
    public void Withdraw(Double minus){        
        if(ammount_available - minus <= 0)
            ammount_available = 0.0;
        else 
            ammount_available -=  minus;
    }
    
    public void Deposit(Double deposit){
        if(deposit >= 0)
            ammount_available += deposit;                    
    }
    
    
}
