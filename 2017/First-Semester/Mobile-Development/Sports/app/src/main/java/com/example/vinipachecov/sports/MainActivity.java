package com.example.vinipachecov.sports;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

// Escreva um programa para Android em que o usuário irá iniciar a digitação do nome de um esporte
// (Natação, ciclismo, futebol, vôlei, caminhada) e o sistema irá autocomplementar a digitação a partir do segundo caractere inserido pelo usuário.
// Após, o usuário ira clicar em um ImageButton (que possui uma imagem que lembre esportes)
// e o sistema irá imprimir uma mensagem rápida na tela apresentando qual o esporte foi selecionado e apresentando também, na mesma mensagem, uma informação relevante sobre esse esporte escolhido.
// Observação: crie uma classe chamada Esportes que recebe o nome do esporte selecionado pelo usuário e retorna a mensagem relevante referente ao esporte escolhido.

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Esporte> sports;
    AutoCompleteTextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        ArrayAdapter<Esporte> adapter = new ArrayAdapter<Esporte>(this,
                android.R.layout.simple_dropdown_item_1line,sports);
        textView = (AutoCompleteTextView)findViewById(R.id.sportsautoCompleteTextView);
        textView.setAdapter(adapter);
    }

    public void showSportMessage(View v){
        findMessage();
    }

    public void findMessage(){

        String esporte = textView.getText().toString();

        for (Esporte sport : sports){
            if(esporte.equals(sport.getNome())){
                Toast.makeText(this, "Esporte selecionado "+ sport.getNome() + ". "+ sport.getMensagem(), Toast.LENGTH_SHORT).show();
            }
        }
    }


    public void init(){
        sports = new ArrayList<>();
        sports.add(new Esporte("Natação","Cesar Cielo é um grande nadador"));
        sports.add(new Esporte("Ciclismo", "Ciclismo exige muita resistência física"));
        sports.add(new Esporte("Vôlei", "Giba é um grande jogador de Vôlei"));
        sports.add(new Esporte("Caminhada" , "Em caminhada é preciso ter paciência"));
        sports.add(new Esporte("Futebol", "Pelé é o melhor jogador de futebol de todos os tempos."));
    }
}
