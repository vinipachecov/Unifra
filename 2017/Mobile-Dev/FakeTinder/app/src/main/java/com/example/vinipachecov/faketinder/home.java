package com.example.vinipachecov.faketinder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //nome.setText(getIntent().getStringExtra("Nome").toString());

        TextView nome = (TextView) findViewById(R.id.nomeRecebidotextView);
        TextView sexo = (TextView)findViewById(R.id.SexotextView);
        TextView estadoCivil = (TextView)findViewById(R.id.estadoCiviltextView);
        TextView numerSolteiro = (TextView)findViewById(R.id.numPessoaSolteiratextView);

        nome.setText(getIntent().getStringExtra("Nome").toString());
        sexo.setText(getIntent().getStringExtra("Sexo").toString());
        estadoCivil.setText(getIntent().getStringExtra("EstadoCivil").toString());

        if(sexo.equals("Feminino")){
            numerSolteiro.setText("Numero Homem Solteiro: (55) 3025-2020");
        }
    }
}
