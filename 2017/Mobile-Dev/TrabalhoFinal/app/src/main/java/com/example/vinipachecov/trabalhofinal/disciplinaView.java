package com.example.vinipachecov.trabalhofinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TabHost;

import java.util.ArrayList;

public class disciplinaView extends AppCompatActivity {

    ArrayList<String> topicos;
    ArrayList<String> links;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disciplina_view);

        topicos = new ArrayList<>();
        links = new ArrayList<>();
        topicos.add("Tópico 1");
        topicos.add("Tópico 2");
        topicos.add("Tópico 3");
        topicos.add("Tópico 4");
        topicos.add("Tópico 5");

        ListView listaTopicos = (ListView)findViewById(R.id.listaTopicos);
        ListView listaLinks = (ListView)findViewById(R.id.listaLinks);

        ArrayAdapter arrayAdapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, topicos);
        listaTopicos.setAdapter(arrayAdapter);

        TabHost tabHost = (TabHost)findViewById(R.id.abasDisciplina);

        tabHost.setup();
        //Aba Tópicos
        TabHost.TabSpec aba1 = tabHost.newTabSpec("Tópicos");
        aba1.setContent(R.id.listaTopicos);
        aba1.setIndicator(getString(R.string.Tópicos));
        tabHost.addTab(aba1);

        //---------------------------------
        links.add("Link 1");
        links.add("Link 2");
        links.add("Link 3");
        links.add("Link 4");
        links.add("Link 5");

        ArrayAdapter arrayAdapterLinks = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, links);
        listaLinks.setAdapter(arrayAdapterLinks);


        //Aba Tópicos
        TabHost.TabSpec aba2 = tabHost.newTabSpec("Conteúdo");
        aba2.setContent(R.id.listaLinks);
        aba2.setIndicator(getString(R.string.Conteúdo));
        tabHost.addTab(aba2);
    }
}
