package com.example.vinipachecov.carrosemarcas;

/**
 * Created by vinipachecov on 5/29/17.
 */

public class Veiculo {
    private String nome;
    private String fabricante;


    public Veiculo(String nnome, String ffabricante){
        nome = nnome;
        fabricante = ffabricante;
    }

    @Override
    public String toString(){
        return this.nome;
    }

    public String getFabricante(){
        return fabricante;
    }


}
