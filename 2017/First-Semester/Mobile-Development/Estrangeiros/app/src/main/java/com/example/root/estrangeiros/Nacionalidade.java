package com.example.root.estrangeiros;

/**
 * Created by root on 3/27/17.
 */

public class Nacionalidade {
    String nacionalidade;

    public Nacionalidade(String nacio){
        nacionalidade = nacio;
    }

    public String mensagem(){
        if(nacionalidade == "brasileiro")
            return "Rumo ao Desenvolvimento!";
        else
            return "Estrangeiros são bem-vindos.";
    }
}
