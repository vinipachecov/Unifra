package com.example.vinipachecov.userauthinview;

/**
 * Created by vinipachecov on 5/31/17.
 */

public class Usuario {

    private String username;
    private String password;

    public Usuario(String username, String password){
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString(){
        return username;
    }

    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }
}
