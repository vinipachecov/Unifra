package com.example.vinipachecov.trabalhofinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Notas extends AppCompatActivity {

    ArrayList<String> disciplinas;
    ListView listaDisciplinas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notas);

        disciplinas = new ArrayList<>();

        disciplinas.add("Disciplina 1");
        disciplinas.add("Disciplina 2");
        disciplinas.add("Disciplina 3");
        disciplinas.add("Disciplina 4");
        disciplinas.add("Disciplina 5");
        disciplinas.add("Disciplina 6");

        listaDisciplinas = (ListView)findViewById(R.id.listaDisciplinas);

        ArrayAdapter arrayAdapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1,disciplinas);
        listaDisciplinas.setAdapter(arrayAdapter);

        listaDisciplinas.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String disciplina = listaDisciplinas.getChildAt(position).toString();
                Intent intent = new Intent(getApplicationContext(), NotasDetalhes.class);
                startActivity(intent);
            }
        });
    }
}
