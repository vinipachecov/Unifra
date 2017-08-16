package com.example.vinipachecov.faketinder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

//3 - Crie uma aplicação Android para busca de relacionamentos, que possua três interfaces gráficas, uma sendo a principal e outras duas sendo as secundárias.
//
//        Na interface principal deverá ser solicitado ao usuário as seguintes informações:
// Nome, estado civil e gênero.
// Apos o preenchimento dos dados, o usuário clica em um botão e entra no sistema.
//        Se o estado civil do usuário for solteiro e o gênero masculino,
// a interface principal deverá passar essas informações por parâmetro para uma outra interface gráfica que exibirá os parâmetros recebidos e informará,
// aleatoriamente, um número de telefone de uma mulher solteria que também esta a procura de namoro.
// Se for do gênero feminino, exibirá um número de telefone de um homem.
//        Se o estado civil for casado, os parâmetros deverão ser compartilhados e a seguinte mensagem: "A aplicação só permite pessoas solteiras."



public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void signIn(View v){
        EditText nomeEditText = (EditText)findViewById(R.id.nomeeditText);

        RadioGroup sexo = (RadioGroup)findViewById(R.id.sexoRadioGroup);
        //getting data

        int radioButtonID = sexo.getCheckedRadioButtonId();
        RadioButton radioButtonSexo = (RadioButton) sexo.findViewById(radioButtonID);

        RadioGroup estadoCivilRadioGroup = (RadioGroup)findViewById(R.id.estadoCivil);
        //getting data

        int radioButtonIDestadoCivil = estadoCivilRadioGroup.getCheckedRadioButtonId();
        RadioButton radioButtonEstadoCivil = (RadioButton) estadoCivilRadioGroup.findViewById(radioButtonIDestadoCivil);

        String nome = nomeEditText.getText().toString();

        if(radioButtonEstadoCivil.getText().toString().equals("Casado")){
            Toast.makeText(this, "A aplicação só permite pessoas solteiras.", Toast.LENGTH_SHORT).show();
        }else{
            Intent intent = new Intent(this, home.class);

            intent.putExtra("Nome", nome);
            intent.putExtra("EstadoCivil", radioButtonEstadoCivil.getText().toString());
            intent.putExtra("Sexo",radioButtonSexo.getText().toString());

            startActivity(intent);
        }


    }

}
