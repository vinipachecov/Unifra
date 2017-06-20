package com.example.vinipachecov.trabalhofinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MoodleList extends AppCompatActivity {
    ArrayList<String> cadeiras;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.moodle_list_layout);
        final ListView disciplinas = (ListView)findViewById(R.id.disciplinasListView);
        cadeiras = new ArrayList<>();

        cadeiras.add("Disciplina 1");
        cadeiras.add("Disciplina 2");
        cadeiras.add("Disciplina 3");
        cadeiras.add("Disciplina 4");
        cadeiras.add("Disciplina 5");
        cadeiras.add("Disciplina 6");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, cadeiras);
        disciplinas.setAdapter(arrayAdapter);

        disciplinas.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String disciplina = disciplinas.getChildAt(position).toString();
                Intent intent = new Intent(getApplicationContext(), disciplinaView.class);
                startActivity(intent);
            }
        });


    }
}
