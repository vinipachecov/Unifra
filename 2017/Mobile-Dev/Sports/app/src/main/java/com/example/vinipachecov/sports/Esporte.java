package com.example.vinipachecov.sports;

/**
 * Created by vinipachecov on 5/31/17.
 */

public class Esporte {

    String nome;
    String mensagem;

    public Esporte(String nome, String mensagem){
        this.nome = nome;
        this.mensagem = mensagem;
    }

    @Override
    public String toString() {
        return nome;
    }

    public String getNome(){
        return nome;
    }

    public String getMensagem(){
        return mensagem;
    }
}
