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
public class User {
    public Account account;
    public String ID;
    
    public User(String id){
        ID = id;
        account = new Account();
    }    
}
