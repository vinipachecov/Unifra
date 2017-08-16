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
public class ActiveUsers {
    public ArrayList<User> users;
    
    public ActiveUsers(){
        users = new ArrayList<User>();
    }
    
    public Boolean contains(String id){
        for (User user : users) {
            if(user.ID.equals(id)){
                return true;
            }            
        }            
        return false;
    }
    
    public void addUser(String id){
        users.add(new User(id));
    }
    
    public void removeUser(String id){
        for (int i = 0; i < users.size(); i++) {
            if(users.get(i).ID == id){
                users.remove(i);
            }            
        }
    }    
    
    
    public void requestAddSale(String id, String product, int quant, Double price){
        for (int i = 0; i < users.size(); i++) {            
            if(users.get(i).ID.equals(id)){
                users.get(i).account.addsaleProductToTotal(product, price, quant);
                System.out.println(users.get(i).account.total);
            }
        }        
    }    
    
    public Double requestTotal(String id){
        for (User user : users) {
            if(user.ID.equals(id)){
                return user.account.getTotal();
            }            
        }
        return 0.0;
    }
    
    public String printUsers(){
        String pusers = new String();
        for (User user : users) {
            pusers += user.ID + '\n';                                    
        }
        return pusers;
    }
}
