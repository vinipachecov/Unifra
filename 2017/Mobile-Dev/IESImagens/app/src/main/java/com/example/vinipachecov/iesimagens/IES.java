package com.example.vinipachecov.iesimagens;

import android.media.Image;

/**
 * Created by vinipachecov on 5/31/17.
 */

public class IES {
    private String nome;
    private String cidade;
    private int imagem;

    public IES(String nome, String cidade, int imagem){
        this.nome = nome;
        this.cidade = cidade;
        this.imagem = imagem;
    }

    @Override
    public String toString(){
        return nome;
    }

    public String getCidade(){
        return cidade;
    }
    public int getImagem(){
        return imagem;
    }
}
