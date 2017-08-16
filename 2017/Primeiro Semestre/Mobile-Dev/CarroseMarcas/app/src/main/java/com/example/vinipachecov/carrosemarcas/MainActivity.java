package com.example.vinipachecov.carrosemarcas;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import java.util.ArrayList;


//Enunciado
//2-
//Crie uma aplicação para Android em que o usuário irá iniciar a digitação do nome de um veículo e
// o sistema irá autocompletar esse nome.
//Além disso, após o complemento e o pressionar de um botão, deverá ser apresentada na tela o nome
// do veículo selecionado e o nome do fabricante.
//Tanto as informações de nome do veículo quanto de fabricante deverão estar em uma classe chamada
// Veiculo que é utilizada pela classe Principal.


public class MainActivity extends AppCompatActivity {

    private static final String[] CARROS = new String[] {
            "Celta", "Chevette", "Mustang", "F250", "Golf"
    };

    public ArrayList<Veiculo> carros;

    AutoCompleteTextView textView;

    public void showFac(View v){

        String nomecarro = textView.getText().toString();

        for (Veiculo aux : carros){
            if(aux.toString().equals(nomecarro)){
                Toast.makeText(this, "O fabricante é " + aux.getFabricante(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();


        ArrayAdapter<Veiculo> adapter = new ArrayAdapter<Veiculo>(this,
                android.R.layout.simple_dropdown_item_1line,carros);
        textView = (AutoCompleteTextView)findViewById(R.id.carrosList);
        textView.setAdapter(adapter);
    }

    public void init(){
        carros = new ArrayList<>();
        carros.add(new Veiculo("Celta", "GM"));
        carros.add(new Veiculo("Chevette", "GM"));
        carros.add(new Veiculo("Mustang", "Mustang"));
        carros.add(new Veiculo("Golf", "Volkswagen"));
        carros.add(new Veiculo("F250", "Ford"));
    }
}

