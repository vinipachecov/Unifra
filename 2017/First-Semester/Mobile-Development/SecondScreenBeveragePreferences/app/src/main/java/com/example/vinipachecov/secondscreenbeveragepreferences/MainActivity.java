package com.example.vinipachecov.secondscreenbeveragepreferences;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;

//2 - Crie uma aplicação para Android que solicite ao usuário o nome e telefone (EditText), sexo M/F (RadioButton)
//e qual(is) tipo(s) de bebida ele prefere (CheckBox): Vinho, Cerveja ou Refrigerante.
//As informações devem ser coletadas em uma tela principal e enviadas, por parâmetro, para uma outra tela,
//onde deverão ser exibidos todos os parâmetros recebidos, além de apresentadas na tela as imagens das bebidas selecionadas.

public class MainActivity extends AppCompatActivity {
    ArrayList<String> bebidas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bebidas = new ArrayList<>();
    }

    public void SendData(View view){
        //getIntent().getStringArrayListExtra()

        EditText nome = (EditText)findViewById(R.id.nomeeditText);
        EditText telefone = (EditText)findViewById(R.id.telefoneeditText);
        RadioGroup sexo = (RadioGroup)findViewById(R.id.sexo);
        //getting data

        int radioButtonID = sexo.getCheckedRadioButtonId();
        RadioButton radioButton = (RadioButton) sexo.findViewById(radioButtonID);


        Intent intent = new Intent(this, SecondScreen.class);


        intent.putExtra("Nome", nome.getText().toString());
        intent.putExtra("Telefone",telefone.getText().toString());
        intent.putExtra("Sexo",radioButton.getText().toString());
        intent.putExtra("Bebidas",bebidas);

        startActivity(intent);


    }

    public void checkItem(View v){
        CheckBox checkBox = (CheckBox) v;
        if(!bebidas.contains(checkBox.getText().toString())){
                bebidas.add(checkBox.getText().toString());
        }else
                bebidas.remove(checkBox.getText().toString());
    }





}
